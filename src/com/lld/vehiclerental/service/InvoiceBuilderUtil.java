package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.account.User;
import com.lld.vehiclerental.model.reservation.Invoice;
import com.lld.vehiclerental.model.reservation.VehicleFixedCosts;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.model.vehicle.HireableVehicle;
import com.lld.vehiclerental.repository.UserRepository;
import com.lld.vehiclerental.repository.VehicleRepository;

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
