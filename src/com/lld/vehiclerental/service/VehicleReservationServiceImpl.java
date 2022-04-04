package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.model.vehicle.VehicleType;
import com.lld.vehiclerental.repository.VehicleInventoryRepository;
import com.lld.vehiclerental.repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleReservationServiceImpl implements VehicleReservationService {

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();


    @Override
    public List<VehicleReservation> getReservations(VehicleType vehicleType) {
        return vehicleReservationRepository.getVehicleReservations(vehicleType);
    }

    @Override
    public boolean isVehicleBooked(String qrCode, LocalDateTime fromDate, LocalDateTime toDate) {
        return VehicleInventoryRepository.vehicleInventoryList
                .stream().anyMatch(vehicleInventory ->
                        vehicleInventory.getVehicle().getId().equalsIgnoreCase(qrCode) &&
                                ((vehicleInventory.getDueDate() != null &&
                                        fromDate.isBefore(vehicleInventory.getFromDate())))
                &&(vehicleInventory.getFromDate() != null
                        && toDate.isAfter(vehicleInventory.getFromDate())));
    }
}
