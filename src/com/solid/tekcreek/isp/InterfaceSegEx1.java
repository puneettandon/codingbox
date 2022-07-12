package com.solid.tekcreek.isp;

public class InterfaceSegEx1 {

    // I - Interface Segregation Principle - A client should never be forced to implement an interface that it does not use.
    public static void main(String[] args) {

    }
}

// Problem - forcing AbcRestaurant to implement vegMeals and nonVegMeals even it is veg restaurant only
interface Restaurant{
    void vegMeals();
    void nonVegMeals();
}

class AbcRestaurant implements  Restaurant{

    @Override
    public void vegMeals() {
        System.out.println("Provides veg meals");
    }

    @Override
    public void nonVegMeals() {
        System.out.println("Sorry I don't");
    }
}

// Solution
interface VegRestaurant{
    void vegMeals();
}

interface NonVegRestaurant{
    void nonVegMeals();
}

class AbcVegRestaurant implements VegRestaurant{

    @Override
    public void vegMeals() {
        System.out.println("Provides veg  meals");
    }
}

class XyzRestaurant implements VegRestaurant,NonVegRestaurant{

    @Override
    public void vegMeals() {
        System.out.println("Provides veg meals");
    }

    @Override
    public void nonVegMeals() {
        System.out.println("Provides non veg meals");
    }
}