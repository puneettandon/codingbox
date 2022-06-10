package com.designpattern.techgranth.strategydesginpattern;

public class TVVideoPlayer extends VideoPlayer{

    public TVVideoPlayer(Device device,Resolution resolution) {
        this.currentDevice = device;
        this.currentResolution = resolution;
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
