package com.designpattern.telusko.observerdesignpattern;

public class Subscriber implements Observer {

    private String name;
    private Subject channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(){
        System.out.println("Hey! " +name+", Video Uploaded ");
    }

    @Override
    public void subscribeChannel(Subject ch){
        this.channel = ch;
    }
}
