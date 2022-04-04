package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.reservation.ReservationReminder;

public interface BookingReminderService {

    void notifyUser(ReservationReminder reservationReminder);

}
