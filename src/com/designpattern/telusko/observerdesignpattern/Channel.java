package com.designpattern.telusko.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    List<Observer> subscriberList = new ArrayList<>();
    private String title;

    @Override
    public void subscribe(Observer subscriber){
        subscriberList.add(subscriber);
    }

    @Override
    public void unSubscribe(Observer subscriber){
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber(){
        for(Observer sub: subscriberList){
            sub.update();
        }
    }

    @Override
    public void upload(String title){
        this.title = title;
        notifySubscriber();
    }
}
