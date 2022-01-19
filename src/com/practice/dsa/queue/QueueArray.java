package com.practice.dsa.queue;

public class QueueArray {

    int MAX = 5;
    int front = 0;
    int rear = -1;
    int size = 0;
    int[] arr = new int[MAX];

    private boolean isFull(){
        if(size == MAX){
            return true;
        }
        return false;
    }


    public void insert(int val){
        if(isFull()){
            System.out.println("Queue is full.Remove some elements");
            return;
        }
        rear = (rear + 1) % MAX;
        size++;
        arr[rear] = val;
    }

    public boolean ifEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int remove(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing to remove");
            return Integer.MIN_VALUE;
        }
        front = front % MAX;
        size--;
        return arr[front++];
    }

    public int getSize(){
        return size;
    }

    public int getFront(){
        if(ifEmpty()){
            System.out.println("Queue is empty. Nothing at front");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int getRear(){
        if(ifEmpty()){
            System.out.println("Queue is empty. Nothing at rear");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }
}
