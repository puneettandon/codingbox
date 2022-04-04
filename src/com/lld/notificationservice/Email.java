package com.lld.notificationservice;

public class Email  implements NotificationSender{

    @Override
    public void sendNotification() {
        System.out.println("Sending an email");
    }
}
