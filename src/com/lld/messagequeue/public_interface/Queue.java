package com.lld.messagequeue.public_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.lld.messagequeue.handler.TopicHandler;
import com.lld.messagequeue.model.Message;
import com.lld.messagequeue.model.Topic;
import com.lld.messagequeue.model.TopicSubscriber;

public class Queue {

    private final Map<String, TopicHandler> topicHandlers;

    public Queue(){
        this.topicHandlers = new HashMap<>();
    }

    public Topic createTopic(final String topicName){
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlers.put(topic.getTopicId(),topicHandler);
        System.out.println("Create Topic: "+topic.getTopicName());
        return topic;
    }

    public  void subscribe(ISubscriber subscriber , Topic topic){
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic "+ topic.getTopicName());
    }

    public void publish(final Topic topic, final Message message){
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: "+topic.getTopicName());
        new Thread(() -> topicHandlers.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(final Topic topic, final ISubscriber subscriber,final Integer newOffset){
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()){
            if(topicSubscriber.getSubscriber().equals(subscriber)){
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: "+newOffset);
                new Thread(() -> topicHandlers.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }

}
