package com.solid.kudvenkat.lsp;

public class Bike  extends Vehicle{

    @Override
    public void start() {
        System.out.println("Starting a bike");
    }

    @Override
    public void stop() {
        System.out.println("Stopping a bike");
    }
}
