package com.designpattern.codespace.bridgedesignpattern;

public class Bus extends Automobile{

    protected Bus(WorkShop workShop1, WorkShop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Bus is ");
        workShop1.work();
        workShop2.work();
    }
}
