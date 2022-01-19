package com.solid.kudvenkat.lsp;

public class LiskovSubstitutionEx1 {

    public static void main(String[] args) {
        testDrive(new Vehicle());
        testDrive(new Bike());
        testDrive(new Car());
    }

    static void testDrive(Vehicle vehicle){
        vehicle.start();
        vehicle.stop();
    }
}
