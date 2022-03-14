package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleReservationService {

    List<VehicleReservation> getReservations(VehicleType vehicleType);

    boolean isVehicleBooked(String qrCode, LocalDateTime fromDate,LocalDateTime toDate);
}
