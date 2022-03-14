package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.account.User;
import com.systemdesign.vehiclerental.model.common.NotificationStatus;
import com.systemdesign.vehiclerental.model.reservation.InvoiceNotification;
import com.systemdesign.vehiclerental.model.reservation.VehicleReservation;
import com.systemdesign.vehiclerental.repository.UserRepository;
import com.systemdesign.vehiclerental.repository.VehicleReservationRepository;

public class InvoiceNotificationServiceImpl implements InvoiceNotificationService {

    @Override
    public void notifyUser(InvoiceNotification invoiceNotification) {

        VehicleReservation vehicleReservation = VehicleReservationRepository.vehicleReservationMap
                .get(invoiceNotification.getReservationId());
        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUserId());
        System.out.printf("Notification sent "+user.getContact().getEmail());
        invoiceNotification.setNotificationStatus(NotificationStatus.SENT);

    }
}
