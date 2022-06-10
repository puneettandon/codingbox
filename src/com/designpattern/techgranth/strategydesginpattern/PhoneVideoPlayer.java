package com.designpattern.techgranth.strategydesginpattern;

public class PhoneVideoPlayer extends VideoPlayer{

    public PhoneVideoPlayer(Device device,Resolution resolution) {
        this.currentDevice = device;
        this.currentResolution = resolution;
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
