package com.designpattern.codingsimplified.bridgedesignpattern;

public abstract class TV {

    Remote remote;

    TV(Remote remote){
        this.remote = remote;
    }

    abstract void on();
    abstract void off();
}





