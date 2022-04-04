package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.vehicle.HireableVehicle;
import com.lld.vehiclerental.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleSearchService {

    List<HireableVehicle> searchByType(VehicleType vehicleType, String city, LocalDateTime fromDate,LocalDateTime toDate);

    List<HireableVehicle> searchByModel(String make,String city,String model , LocalDateTime fromDate,LocalDateTime toDate);

    List<HireableVehicle> searchBySeat(int seats,String city,LocalDateTime fromDate,LocalDateTime toDate);
}
