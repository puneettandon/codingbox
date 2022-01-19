package com.practice.dsa.singlecircularlinkedlist;

import com.practice.dsa.singlelinkedlist.MySingleLinkedList;

public class MyCircularSinglyLinkedListMain {

    public static void main(String[] args) {

        MyCircularSinglyLinkedList list = new MyCircularSinglyLinkedList();

        list.addAtBegin(10);
        list.addAtBegin(20);
        list.addAtBegin(30);

        list.addAtEnd(40);
        list.addAtEnd(50);
        list.addAtEnd(60);
        list.addAtEnd(70);

        list.traverseCircularsingleLinkedList();

        list.isCirular();

    }
}
