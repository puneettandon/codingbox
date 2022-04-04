package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.account.User;
import com.lld.vehiclerental.model.common.NotificationStatus;
import com.lld.vehiclerental.model.reservation.ReservationReminder;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.repository.UserRepository;
import com.lld.vehiclerental.repository.VehicleReservationRepository;

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
