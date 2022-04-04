package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.account.User;
import com.lld.vehiclerental.model.reservation.Invoice;
import com.lld.vehiclerental.model.reservation.VehicleFixedCosts;
import com.lld.vehiclerental.model.reservation.VehicleMonthlyCosts;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.model.vehicle.HireableVehicle;
import com.lld.vehiclerental.repository.UserRepository;
import com.lld.vehiclerental.repository.VehicleRepository;

import java.time.Duration;
import java.util.UUID;

import static com.lld.vehiclerental.service.DayInvoiceService.getInvoice;

public class MonthInvoiceService implements InvoiceService {

    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());

        User user = UserRepository.userMap.get(vehicleReservation.getUserId());
        invoice.setUserId(user.getEmail());
        Duration rentedDuration;
        if (vehicleReservation.getReturnDate() == null)
            rentedDuration =
                    Duration.between(vehicleReservation.getFromDate(),
                            vehicleReservation.getFromDate().plusMonths(1));
        else
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),
                    vehicleReservation.getReturnDate());

        double hours = Math.ceil(rentedDuration.toHours());

        double days = Math.ceil(hours / 24) + hours % 24;

        double months = Math.ceil(days / 30);

        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap
                .get(vehicleReservation.getAllocatedVehicleId());

        double monthlyCost = VehicleMonthlyCosts.
                vehicleMonthlyCosts.get(hireableVehicle.getVehicleType());
        double fixedCost = VehicleFixedCosts
                .vehicleFixedCost.get(hireableVehicle.getVehicleType());

        double vehicleAddonCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        double addonServiceCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        invoice.setAddonCost(vehicleAddonCost);
        return getInvoice(invoice, months, monthlyCost, fixedCost, vehicleAddonCost, addonServiceCost);

    }
}
