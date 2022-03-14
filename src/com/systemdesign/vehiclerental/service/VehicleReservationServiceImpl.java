package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.model.vehicle.VehicleType;
import com.systemdesign.vehiclerental.repository.VehicleInventoryRepository;
import com.systemdesign.vehiclerental.repository.VehicleReservationRepository;

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
