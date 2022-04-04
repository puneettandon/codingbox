package com.lld.vehiclerental.service;

import com.lld.vehiclerental.exceptions.InvalidVehicleIdException;
import com.lld.vehiclerental.exceptions.ReservationNotFoundException;
import com.lld.vehiclerental.exceptions.VehicleBookedException;
import com.lld.vehiclerental.model.common.NotificationStatus;
import com.lld.vehiclerental.model.reservation.*;
import com.lld.vehiclerental.model.vehicle.HireableVehicle;
import com.lld.vehiclerental.model.vehicle.VehicleLocation;
import com.lld.vehiclerental.model.vehicle.VehicleStatus;
import com.lld.vehiclerental.repository.UserRepository;
import com.lld.vehiclerental.repository.VehicleInventoryRepository;
import com.lld.vehiclerental.repository.VehicleRepository;
import com.lld.vehiclerental.repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();
    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

    VehicleReservationService vehicleReservationService = new VehicleReservationServiceImpl();
    InvoiceService invoiceService = new InvoiceServiceImpl();
    InvoiceNotificationService invoiceNotificationService = new InvoiceNotificationServiceImpl();

    VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();


    @Override
    public VehicleReservation scanToReserve(String qrcode, String userId) throws InvalidVehicleIdException, VehicleBookedException {
        if(VehicleRepository.vehicleMap.get(qrcode) == null){
            throw  new InvalidVehicleIdException("Invalid vehicle id");
        }
        if(vehicleReservationService.isVehicleBooked(qrcode,LocalDateTime.now(),LocalDateTime.now().plusHours(2))){
            throw new VehicleBookedException("Vehicle booked.Try another vehicle.");
        }
        VehicleReservation vehicleReservation = buildQuickReservation(qrcode,userId);
        vehicleReservation = vehicleReservationRepository.reserve(vehicleReservation);
        updateVehicleInventory(vehicleReservation);
        return vehicleReservation;
    }



    private void updateVehicleInventory(VehicleReservation vehicleReservation) {
        VehicleInventory vehicleInventory = buildVehicleInventory(vehicleReservation);
        vehicleInventoryRepository.addToInventory(vehicleInventory);
    }

    private VehicleInventory buildVehicleInventory(VehicleReservation vehicleReservation) {
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(vehicleReservation.getAllocatedVehicleId());
        VehicleInventory vehicleInventory = new VehicleInventory(vehicleReservation,hireableVehicle);
        return vehicleInventory;
    }

    private VehicleReservation buildQuickReservation(String qrcode, String userId) {
        HireableVehicle vehicle = VehicleRepository.vehicleMap.get(qrcode);
        vehicle.setVehicleStatus(VehicleStatus.BOOKED);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUserId(userId);
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusHours(2));
        vehicleReservation.setReservationStatus(ReservationStatus.ACTIVE);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(vehicle.getParkedLocation().getAddress());

        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(qrcode);
        vehicleReservation.setAllocatedVehicleId(hireableVehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);

        return vehicleReservation;
    }

    @Override
    public VehicleReservation remoteReserve(VehicleReservation vehicleReservation) {
        vehicleReservation.setReservationStatus(ReservationStatus.CONFIRMED);
        vehicleReservation.setReservationDate(LocalDateTime.now());
        vehicleReservation = vehicleReservationRepository.reserve(vehicleReservation);
        Invoice invoice = invoiceService.computeInvoice(vehicleReservation);
        invoiceNotificationService.notifyUser(buildInvoiceNotification(invoice));
        // Notify vehicle inventory
        updateVehicleInventory(vehicleReservation);
        return vehicleReservation;
    }

    private InvoiceNotification buildInvoiceNotification(Invoice invoice) {
        InvoiceNotification invoiceNotification = new InvoiceNotification();
        invoiceNotification.setReservationId(invoice.getReservationId());
        invoiceNotification.setUserId(invoice.getUserId());
        invoiceNotification.setCreatedDate(LocalDateTime.now());
        invoiceNotification.setNotificationStatus(NotificationStatus.PENDING);
        return invoiceNotification;
    }

    @Override
    public VehicleReservation cancel(String reservationId) {
        VehicleReservation vehicleReservation = VehicleReservationRepository.vehicleReservationMap.get(reservationId);
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(vehicleReservation.getAllocatedVehicleId());
        vehicleReservation.setReservationStatus(ReservationStatus.CANCELLED);
        // Notify vehicle inventory
        updateVehicleInventory(vehicleReservation);
        vehicleReservation.setDropLocation(hireableVehicle.getParkedLocation().getAddress());
        vehicleReservation.setReturnDate(LocalDateTime.now());
        vehicleReservation.setEndMileage(hireableVehicle.getMileage());
        Invoice invoice = invoiceService.computeInvoice(vehicleReservation);
        invoiceNotificationService.notifyUser(buildInvoiceNotification(invoice));
        return vehicleReservation;
    }

    @Override
    public HireableVehicle pickupVehicle(VehicleReservation vehicleReservation) {
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap.get(vehicleReservation.getAllocatedVehicleId());
        vehicleReservation.setStartMileage(hireableVehicle.getMileage());
        vehicleReservation.setReservationStatus(ReservationStatus.ACTIVE);
        hireableVehicle.setVehicleStatus(VehicleStatus.INUSE);
        return hireableVehicle;
    }

    @Override
    public void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException {
        VehicleReservation vehicleReservation = vehicleReservationRepository.getVehicleReservation(reservationId);
        if(vehicleReservation == null){
            throw  new ReservationNotFoundException("Could not find reservation with id"+reservationId);
        }

        HireableVehicle vehicle = VehicleRepository.vehicleMap.get(vehicleReservation.getAllocatedVehicleId());
        vehicle.setParkedLocation(vehicleLocation);
        vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
        vehicleReservation.setReservationStatus(ReservationStatus.COMPLETED);
        vehicleReservation.setDropLocation(vehicleLocation.getAddress());
        vehicleReservation.setReturnDate(LocalDateTime.now());
        vehicleReservation.setEndMileage(vehicle.getMileage());
        Invoice invoice = invoiceService.computeInvoice(vehicleReservation);
        updateVehicleInventory(vehicleReservation);
        invoiceNotificationService.notifyUser(buildInvoiceNotification(invoice));
    }

    @Override
    public List<HireableVehicle> getHiredVehicles(String userId) {
        return userRepository.getHiredVehicles(userId);
    }

    @Override
    public List<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        return userRepository.getHiredVehicles(userId,startDate,endDate);
    }
}
