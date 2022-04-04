package com.lld.messagequeue.public_interface;

import com.lld.messagequeue.model.Message;

public interface ISubscriber {

    String getId();

    void consume(Message message) throws  InterruptedException;
}
