package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.reservation.InvoiceNotification;

public interface InvoiceNotificationService {

    void notifyUser(InvoiceNotification invoice);
}
