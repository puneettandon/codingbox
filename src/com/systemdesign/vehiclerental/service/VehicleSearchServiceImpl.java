package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.VehicleInventory;
import com.systemdesign.vehiclerental.model.vehicle.HireableVehicle;
import com.systemdesign.vehiclerental.model.vehicle.VehicleType;
import com.systemdesign.vehiclerental.repository.VehicleInventoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleSearchServiceImpl implements VehicleSearchService {

    @Override
    public List<HireableVehicle> searchByType(VehicleType vehicleType, String city, LocalDateTime fromDate, LocalDateTime toDate) {
        return VehicleInventoryRepository.vehicleInventoryList
                .stream()
                .filter(vehicleInventory ->
                        vehicleInventory.getVehicle().getVehicleType() == vehicleType
                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                && ! (
                                (vehicleInventory.getDueDate() != null &&
                                        fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null
                                && toDate.isAfter(vehicleInventory.getFromDate()))
                                )).map(VehicleInventory::getVehicle)
                .collect(Collectors.toList());
    }

    @Override
    public List<HireableVehicle> searchByModel(String make, String city, String model, LocalDateTime fromDate, LocalDateTime toDate) {
        return VehicleInventoryRepository.vehicleInventoryList
                .stream()
                .filter(vehicleInventory ->
                        vehicleInventory.getVehicle().getMake().equalsIgnoreCase(make)
                && vehicleInventory.getVehicle().getModel().equalsIgnoreCase(model)
                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                && !(
                                (vehicleInventory.getDueDate() != null &&
                                        fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null
                                && toDate.isAfter(vehicleInventory.getFromDate()))
                                )).map(VehicleInventory::getVehicle)
                .collect(Collectors.toList());
    }

    @Override
    public List<HireableVehicle> searchBySeat(int seats, String city, LocalDateTime fromDate, LocalDateTime toDate) {
        return VehicleInventoryRepository.vehicleInventoryList
                .stream()
                .filter(vehicleInventory ->
                        vehicleInventory.getVehicle().getNumberOfSeats() >= seats
                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                && !(
                                (vehicleInventory.getDueDate() != null &&
                                        fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null
                                && toDate.isBefore(vehicleInventory.getFromDate()))
                                )).map(VehicleInventory::getVehicle)
                .collect(Collectors.toList());
    }
}
