package com.systemdesign.messagequeue.handler;

import com.systemdesign.messagequeue.model.Topic;
import com.systemdesign.messagequeue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private final Topic topic;
    private final Map<String,SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish(){
        for(TopicSubscriber topicSubscriber: topic.getSubscribers()){
            startSubscriberWorker(topicSubscriber);
        }
    }

    public  void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if(!subscriberWorkers.containsKey(subscriberId)){
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic,topicSubscriber);
            subscriberWorkers.put(subscriberId,subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final  SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeIfNeeded();
    }
}
