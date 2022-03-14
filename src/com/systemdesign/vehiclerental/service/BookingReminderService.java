package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.ReservationReminder;

public interface BookingReminderService {

    void notifyUser(ReservationReminder reservationReminder);

}
