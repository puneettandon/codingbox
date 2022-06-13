package com.designpattern.codingsimplified.bridgedesignpattern;

class Sony extends TV{

    Remote remoteType;

    Sony(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }


    @Override
    void on() {
        System.out.println("Sony TV ON");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Sony TV OFF");
        remoteType.off();
    }
}