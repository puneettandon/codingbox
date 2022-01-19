package com.practice.onlineTest;

final class Car {
    private String make;
    //other fields

    public void setMake(String _make) {
        make = _make;
    }

    String getMake() {
        return make;
    }
    //other getters/setters
}
public class MyClass {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Toyota");
        String make = car.getMake();
    }
}
