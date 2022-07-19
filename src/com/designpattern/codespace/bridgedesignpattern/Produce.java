package com.designpattern.codespace.bridgedesignpattern;

public class Produce implements WorkShop{

    @Override
    public void work() {
        System.out.print("Produced ");
    }
}
