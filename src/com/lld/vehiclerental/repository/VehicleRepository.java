package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.vehicle.HireableVehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {

    public static Map<String, HireableVehicle> vehicleMap = new HashMap<>();
    public static List<HireableVehicle> vehicles = new ArrayList<>();

    public HireableVehicle addVehicle(HireableVehicle hireableVehicle){
        vehicleMap.putIfAbsent(hireableVehicle.getId(),hireableVehicle);
        vehicles.add(hireableVehicle);
        return hireableVehicle;
    }
}
