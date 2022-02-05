package com.systemdesign.notificationservice;

public class Whatsapp implements NotificationSender{

    @Override
    public void sendNotification() {
        System.out.println("Sending whatsapp message");
    }
}
