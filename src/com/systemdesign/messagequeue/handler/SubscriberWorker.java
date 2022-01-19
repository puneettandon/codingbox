package com.systemdesign.messagequeue.handler;

import com.systemdesign.messagequeue.model.Message;
import com.systemdesign.messagequeue.model.Topic;
import com.systemdesign.messagequeue.model.TopicSubscriber;

public class SubscriberWorker  implements  Runnable{

    private final Topic topic ;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run(){
        synchronized (topicSubscriber){
            do{
                int currOffset = topicSubscriber.getOffset().get();
                while(currOffset >= topic.getMessages().size()){
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = topic.getMessages().get(currOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // we cannot just increment here since offset can be reset while it is consuming.
                // So, after consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(currOffset,currOffset+1);
            }while(true);
        }
    }

    synchronized  public void wakeIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }

    public Topic getTopic() {
        return topic;
    }

    public TopicSubscriber getTopicSubscriber() {
        return topicSubscriber;
    }
}
