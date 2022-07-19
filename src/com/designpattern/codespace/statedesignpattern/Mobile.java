package com.designpattern.codespace.statedesignpattern;

public class Mobile {

    public static void main(String[] args) {

        MobileContext mobileContext = new MobileContext();
        mobileContext.alert();

        mobileContext.setState(new Silent());
        mobileContext.alert();

        mobileContext.setState(new Ringing());
        mobileContext.alert();
    }
}