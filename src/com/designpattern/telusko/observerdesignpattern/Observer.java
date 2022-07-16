package com.designpattern.telusko.observerdesignpattern;

public interface Observer {
    void update();

    void subscribeChannel(Subject ch);
}
