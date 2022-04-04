package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.account.User;
import com.lld.vehiclerental.model.common.NotificationStatus;
import com.lld.vehiclerental.model.reservation.InvoiceNotification;
import com.lld.vehiclerental.model.reservation.VehicleReservation;
import com.lld.vehiclerental.repository.UserRepository;
import com.lld.vehiclerental.repository.VehicleReservationRepository;

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
