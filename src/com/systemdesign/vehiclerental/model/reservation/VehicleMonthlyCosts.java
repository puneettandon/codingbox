package com.systemdesign.vehiclerental.model.reservation;

import com.systemdesign.vehiclerental.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleMonthlyCosts {

    public static Map<VehicleType,Double> vehicleMonthlyCosts = new HashMap<>();

    static {

        vehicleMonthlyCosts.put(VehicleType.BICYCLE,800.0);
        vehicleMonthlyCosts.put(VehicleType.MOTORCYCLE,4000.0);
        vehicleMonthlyCosts.put(VehicleType.HATCHBACK,10000.0);
        vehicleMonthlyCosts.put(VehicleType.SEDAN,15000.0);
        vehicleMonthlyCosts.put(VehicleType.SUV,20000.0);
        vehicleMonthlyCosts.put(VehicleType.TRUCK,40000.0);
        vehicleMonthlyCosts.put(VehicleType.THREEWHEELER,20000.0);
        vehicleMonthlyCosts.put(VehicleType.VAN,20000.0);

    }
}
