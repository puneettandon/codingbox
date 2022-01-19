package com.solid.kudvenkat.lsp;

public class Car extends  Vehicle{

    @Override
    public void start() {
        //System.out.println("Starting a car");
        throw new RuntimeException("boom you are gone....");
    }

    @Override
    public void stop() {
        System.out.println("Stopping a car");
    }
}
