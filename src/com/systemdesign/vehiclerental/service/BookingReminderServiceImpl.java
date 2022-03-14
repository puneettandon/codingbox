package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.account.User;
import com.systemdesign.vehiclerental.model.common.NotificationStatus;
import com.systemdesign.vehiclerental.model.reservation.ReservationReminder;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.repository.UserRepository;
import com.systemdesign.vehiclerental.repository.VehicleReservationRepository;

public class BookingReminderServiceImpl implements BookingReminderService{

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

    @Override
    public void notifyUser(ReservationReminder reservationReminder) {

        VehicleReservation vehicleReservation = vehicleReservationRepository.getVehicleReservation(reservationReminder.getReservationId());
        User user = UserRepository.userMap.get(vehicleReservation.getUserId());
        System.out.println("Notified User "+user.getContact().getEmail());
        reservationReminder.setNotificationStatus(NotificationStatus.SENT);
    }
}
