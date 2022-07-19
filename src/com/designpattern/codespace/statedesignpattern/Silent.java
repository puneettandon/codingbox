package com.designpattern.codespace.statedesignpattern;

public class Silent implements MobileAlertState{

    @Override
    public void alert() {
        System.out.println("Mobile is on Silent");
    }
}
