package com.practice.dsa.singlecircularlinkedlist;

public class MyCircularSinglyLinkedList {

    MyCSNode head;
    MyCSNode tail;

    public void addAtBegin(int data) {
        MyCSNode newNode = new MyCSNode();
        newNode.value = data;
        newNode.next = null;

        if(head == null){
            head = newNode;
            tail = newNode;
            head.next = newNode;
        }else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int data){
        MyCSNode newNode = new MyCSNode();
        newNode.value = data;
        newNode.next = null;

        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void traverseCircularsingleLinkedList(){
        MyCSNode tempNode = head;

        if(head != null){
            do {
                System.out.print(tempNode.value + "->");
                tempNode = tempNode.next;
            }while (tempNode != head);
            System.out.println();
        }
    }

    public void isCirular(){
        if(head == null){
            System.out.println("Linked List is empty and circular");
        }
        MyCSNode tempNode = head.next;
        while(tempNode != null && tempNode != head){
            tempNode = tempNode.next;
        }
        if(tempNode == head)
            System.out.println("LinkedList is Circular");
        else
            System.out.println("LinkedList is not Circular");
    }


}
