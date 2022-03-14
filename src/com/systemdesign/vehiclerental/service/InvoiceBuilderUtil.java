package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.account.User;
import com.systemdesign.vehiclerental.model.reservation.Invoice;
import com.systemdesign.vehiclerental.model.reservation.VehicleFixedCosts;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.model.vehicle.HireableVehicle;
import com.systemdesign.vehiclerental.repository.UserRepository;
import com.systemdesign.vehiclerental.repository.VehicleRepository;

import java.util.UUID;

public class InvoiceBuilderUtil{
    public static Invoice buildCancelledInvoice(VehicleReservation vehicleReservation) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUserId());
        invoice.setUserId(user.getEmail());
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap
                .get(vehicleReservation.getAllocatedVehicleId());
        double fixedCost = VehicleFixedCosts
                .vehicleFixedCost.get(hireableVehicle.getVehicleType());
        double taxes = fixedCost * .18;
        invoice.setUsageCharges(fixedCost);
        invoice.setTax(taxes);
        invoice.setTotal(fixedCost + taxes);
        return invoice;
    }
}
