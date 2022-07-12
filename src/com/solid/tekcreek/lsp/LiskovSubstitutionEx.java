package com.solid.tekcreek.lsp;

public class LiskovSubstitutionEx {

    // L - Liskov Substitution Principle
    // Objects of super class shall be replaced with objects of subclasses
    public static void main(String[] args) {
        testDrive(new Vehicle());
        testDrive(new Car());
        testDrive(new Bike());
    }

    static void testDrive(Vehicle vehicle){
        vehicle.start();
        vehicle.stop();
    }
}

// Problem
class Vehicle{
    public void start(){
        System.out.println("Starting a vehicle");
    }

    public  void stop(){
        System.out.println("Stopping a vehicle");
    }
}

class Bike extends Vehicle{

    @Override
    public void start() {
        System.out.println("Starting a Bike");
    }

    @Override
    public void stop() {
        System.out.println("Stopping a Bike");
    }
}

class Car extends Vehicle{

    @Override
    public void start() {
        System.out.println("Starting a Car");
      //  throw new RuntimeException("boom you are gone....");
    }

    @Override
    public void stop() {
        System.out.println("Stopping a Car");
    }
}


