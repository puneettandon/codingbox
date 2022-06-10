package com.designpattern.techgranth.strategydesginpattern;

public class Resolution480p implements Resolution{

    @Override
    public void resolution() {
        System.out.println("Playing in resolution 480p");
    }
}
