package com.systemdesign.messagequeue.public_interface;

import com.systemdesign.messagequeue.model.Message;

public interface ISubscriber {

    String getId();

    void consume(Message message) throws  InterruptedException;
}
