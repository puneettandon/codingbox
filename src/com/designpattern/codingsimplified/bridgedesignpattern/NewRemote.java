package com.designpattern.codingsimplified.bridgedesignpattern;


class NewRemote implements Remote{
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}