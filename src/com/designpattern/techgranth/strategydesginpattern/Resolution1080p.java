package com.designpattern.techgranth.strategydesginpattern;

public class Resolution1080p implements Resolution{
    @Override
    public void resolution() {
        System.out.println("Playing in resolution 1080p");
    }
}
