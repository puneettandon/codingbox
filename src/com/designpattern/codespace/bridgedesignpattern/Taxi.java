package com.designpattern.codespace.bridgedesignpattern;

public class Taxi extends Automobile{

    protected Taxi(WorkShop workShop1, WorkShop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Taxi is ");
        workShop1.work();
        workShop2.work();
    }
}
