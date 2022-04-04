package com.lld.notificationservice;

public class BridgeMain {

    public static void main(String[] args) {

        TextMessage textMessageEmail = new TextMessage(new Email());
        textMessageEmail.sendMessage();

        System.out.println();
        TextMessage textMessageSms= new TextMessage(new SMS());
        textMessageSms.sendMessage();

        System.out.println();
        QRMessage qrMessageEmail = new QRMessage(new Email());
        qrMessageEmail.sendMessage();

        System.out.println();
        QRMessage qrMessageSms = new QRMessage(new SMS());
        qrMessageSms.sendMessage();

        System.out.println();
        TextMessage textMessageWhatsapp = new TextMessage(new Whatsapp());
        textMessageWhatsapp.sendMessage();

    }
}
