package com.designpattern.telusko.observerdesignpattern;

public interface Subject {
    void subscribe(Observer subscriber);

    void unSubscribe(Observer subscriber);

    void notifySubscriber();

    void upload(String title);
}
