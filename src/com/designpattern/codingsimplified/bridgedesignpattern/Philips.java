package com.designpattern.codingsimplified.bridgedesignpattern;

class Philips extends TV{

    Remote remoteType;

    Philips(Remote remote){
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Philip TV ON");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Philips TV Off");
        remoteType.off();
    }
}