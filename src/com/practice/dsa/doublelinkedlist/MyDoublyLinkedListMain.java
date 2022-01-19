package com.practice.dsa.doublelinkedlist;

import org.w3c.dom.Node;

public class MyDoublyLinkedListMain {

    public static void main(String[] args) {

        MyDoublyLinkedList dll = new MyDoublyLinkedList();

        MyDNode head = null;

        // inserting at end of linkedlist
        head = dll.insert(12,head);
        head = dll.insert(99,head);
        head = dll.insert(37,head);
        head = dll.insert(5,head);
        head = dll.insert(25,head);

        head = dll.insertAtStart(20,head);
        head = dll.insertAtStart(10,head);

        // insert at any position
        head = dll.insertAtGivenPosition(50,head,1);
        head = dll.insertAtGivenPosition(80,head,4);


        // delete first node of linkedlist
        head = dll.deleteFirstNode(head);

        // size of Doubly LinkedList
        int size = dll.getSizeOfList(head);
        System.out.println("Size of Doubly LinkedList : "+ size);

        // print doubly linkedlist
        dll.printDoublyLinkedList(head);
    }




}
