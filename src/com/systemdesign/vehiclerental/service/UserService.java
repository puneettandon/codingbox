package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.exceptions.InvalidVehicleIdException;
import com.systemdesign.vehiclerental.exceptions.ReservationNotFoundException;
import com.systemdesign.vehiclerental.exceptions.VehicleBookedException;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.model.vehicle.HireableVehicle;
import com.systemdesign.vehiclerental.model.vehicle.VehicleLocation;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    VehicleReservation scanToReserve(String qrcode,String userId) throws InvalidVehicleIdException, VehicleBookedException;

    VehicleReservation remoteReserve(VehicleReservation vehicleReservation);

    VehicleReservation cancel(String reservationId);

    HireableVehicle pickupVehicle(VehicleReservation vehicleReservation);

    void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException;

    List<HireableVehicle> getHiredVehicles(String userId);

    List<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate,LocalDateTime endDate);
}
