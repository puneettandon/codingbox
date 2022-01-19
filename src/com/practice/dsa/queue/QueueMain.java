package com.practice.dsa.queue;

public class QueueMain {

    public static void main(String[] args) {

        // Queue implementation using LinkedList
        System.out.println("LinkedList Implementation of Queue: ");
        QueueLinkedList queueL = new QueueLinkedList();

        queueL.insert(10);
        queueL.insert(20);
        queueL.insert(30);
        queueL.insert(40);
        queueL.insert(50);

        System.out.println("size: "+queueL.getSize());
        System.out.println("Front: "+queueL.getFront());
        System.out.println("Rear: "+queueL.getRear());

        System.out.println("Removed Element: "+queueL.remove());

        System.out.println("Size: "+queueL.getSize());
        System.out.println("Front: "+queueL.getFront());
        System.out.println("Rear: "+queueL.getRear());

        queueL.insert(50);

        System.out.println("Removed Element: "+queueL.remove());
        System.out.println("Removed Element: "+queueL.remove());
        System.out.println("Removed Element: "+queueL.remove());
        System.out.println("Removed Element: "+queueL.remove());
        System.out.println("Removed Element: "+queueL.remove());
        System.out.println("Removed Element: "+queueL.remove());


        // Queue Implementation using Array

        System.out.println("\n Array Implementation of Queue: ");

        QueueArray queueArray = new  QueueArray();

        queueArray.insert(10);
        queueArray.insert(20);
        queueArray.insert(30);
        queueArray.insert(40);
        queueArray.insert(50);

        System.out.println("size: "+queueArray.getSize());
        System.out.println("Front: "+queueArray.getFront());
        System.out.println("Rear: "+queueArray.getRear());

        System.out.println("Removed Element: "+queueArray.remove());

        System.out.println("Size: "+queueArray.getSize());
        System.out.println("Front: "+queueArray.getFront());
        System.out.println("Rear: "+queueArray.getRear());

        queueArray.insert(60);

        System.out.println("Removed Element: "+queueArray.remove());
        System.out.println("Removed Element: "+queueArray.remove());
        System.out.println("Removed Element: "+queueArray.remove());
        System.out.println("Removed Element: "+queueArray.remove());
        System.out.println("Removed Element: "+queueArray.remove());
        System.out.println("Removed Element: "+queueArray.remove());









    }
}
