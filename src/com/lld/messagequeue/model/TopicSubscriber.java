package com.lld.messagequeue.model;

import com.lld.messagequeue.public_interface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(AtomicInteger offset, ISubscriber subscriber) {
        this.offset = offset;
        this.subscriber = subscriber;
    }

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
