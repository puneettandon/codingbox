package com.designpattern.codespace.statedesignpattern;

public class Ringing implements MobileAlertState {

    @Override
    public void alert() {
        System.out.println("Mobile is Ringing");
    }
}
