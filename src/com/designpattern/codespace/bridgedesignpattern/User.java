package com.designpattern.codespace.bridgedesignpattern;

public class User {

    public static void main(String[] args) {

        Automobile bus = new Bus(new Produce(),new Assemble());
        bus.manufacture();

        Automobile taxi = new Taxi(new Produce(),new Assemble());
        taxi.manufacture();

    }
}
