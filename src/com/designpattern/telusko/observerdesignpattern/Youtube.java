package com.designpattern.telusko.observerdesignpattern;

public class Youtube {

    public static void main(String[] args) {

        Channel telusko = new Channel();
        Subscriber s1 = new Subscriber("Puneet1");
        Subscriber s2 = new Subscriber("Puneet2");
        Subscriber s3 = new Subscriber("Puneet3");
        Subscriber s4 = new Subscriber("Puneet4");

        telusko.subscribe(s1);
        telusko.subscribe(s2);
        telusko.subscribe(s3);
        telusko.subscribe(s4);

        s1.subscribeChannel(telusko);
        s2.subscribeChannel(telusko);
        s3.subscribeChannel(telusko);
        s4.subscribeChannel(telusko);


        telusko.upload("Learn Design Patterns");


    }
}
