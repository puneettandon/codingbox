package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.model.reservation.InvoiceNotification;

public interface InvoiceNotificationService {

    void notifyUser(InvoiceNotification invoice);
}
