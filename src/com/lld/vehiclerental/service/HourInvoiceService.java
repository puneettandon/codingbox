package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.account.User;
import com.lld.vehiclerental.model.reservation.Invoice;
import com.lld.vehiclerental.model.reservation.VehicleFixedCosts;
import com.lld.vehiclerental.model.reservation.VehicleHourlyCosts;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.repository.UserRepository;

import java.time.Duration;
import java.util.UUID;

public class HourInvoiceService implements InvoiceService {
    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return buildVoice(vehicleReservation);
    }

    private Invoice buildVoice(VehicleReservation vehicleReservation) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());

        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUserId());
        invoice.setUserId(user.getEmail());

        Duration rentedDuration;
        if(vehicleReservation.getReturnDate() == null){
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),vehicleReservation.getToDate().plusHours(1));
        }else{
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),vehicleReservation.getToDate());
        }

        double hours = Math.ceil(rentedDuration.toHours());

        if(hours == 0)
            hours = 1;

        double hourlyCost = VehicleHourlyCosts.vehicleHourlyCost.get(vehicleReservation.getVehicleType());
        double fixedCost = VehicleFixedCosts.vehicleFixedCost.get(vehicleReservation.getVehicleType());

        double vehicleAddonCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        invoice.setAddonCost(vehicleAddonCost);
        double addonServiceCost = AddonCostUtil.computeServiceCost(vehicleReservation);
        invoice.setAddonCost(addonServiceCost);
        double rentalCost = hours * hourlyCost + fixedCost + vehicleAddonCost + addonServiceCost;
        double taxes = rentalCost * .18;
        invoice.setTax(taxes);
        invoice.setUsageCharges(rentalCost);
        invoice.setTotal(rentalCost + taxes);
        return  invoice;
    }
}
