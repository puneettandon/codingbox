package com.lld.vehiclerental.service;

import com.lld.vehiclerental.exceptions.InvalidVehicleIdException;
import com.lld.vehiclerental.exceptions.ReservationNotFoundException;
import com.lld.vehiclerental.exceptions.VehicleBookedException;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.model.vehicle.HireableVehicle;
import com.lld.vehiclerental.model.vehicle.VehicleLocation;

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
