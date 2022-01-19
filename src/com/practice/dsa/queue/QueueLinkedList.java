package com.practice.dsa.queue;

public class QueueLinkedList {


    QueueNode first;
    QueueNode last;
    int size;

    public QueueNode getNewNode(int val){
        QueueNode node = new QueueNode();
        node.data = val;
        node.next = null;
        return node;
    }

    // complexity : O(1)
    public void insert(int val){
        if(last == null){
            first = last = getNewNode(val);
            size++;
            return;
        }
        size++;
        last.next = getNewNode(val);
        last = last.next;
        System.out.println(val + " inserted in queue using linkedlist");
    }

    // complexity : O(1)
    public boolean ifEmpty(){
        if(last == null){
            return true;
        }
        return false;
    }

    // complexity: O(1)
    public int remove(){
        if(ifEmpty()){
            System.out.println("Queue is empty. Nothing to remove");
            return Integer.MIN_VALUE;
        }
        size--;
        int val = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        return val;
    }

    // complexity O(1)
    public int getSize(){
        return size;
    }

    // complexity: O(1)
    public int getFront(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing at front");
            return Integer.MIN_VALUE;
        }
        return first.data;
    }

    // complexity: O(1)
    public  int getRear(){
        if(ifEmpty()){
            System.out.println("Queue is empty. Nothing at raear");
            return Integer.MIN_VALUE;
        }
        return last.data;
    }
}
