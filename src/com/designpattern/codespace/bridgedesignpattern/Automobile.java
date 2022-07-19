package com.designpattern.codespace.bridgedesignpattern;

public abstract class Automobile {

    protected WorkShop workShop1;
    protected WorkShop workShop2;

    protected Automobile(WorkShop workShop1,WorkShop workShop2){
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}
