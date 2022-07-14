package com.javainterviewquestions.quizquestions;

public class DiamondProblem {

    public static void main(String[] args) {
        final Car hybridCar = new HybridCar();
        hybridCar.start();
    }
}


interface Car{
    default void start(){
        System.out.println("Car");
    }
}

interface ElectricCar extends Car{
    @Override
    default void start() {
        System.out.println("Electric Car");
    }
}

interface GasolineCar extends Car{
    @Override
    default void start() {
        System.out.println("Gasoline Car");
    }
}

class HybridCar implements ElectricCar,GasolineCar{

    @Override
    public void start() {
        ElectricCar.super.start();
        GasolineCar.super.start();
    }
}