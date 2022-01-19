package com.practice.dsa.stack;

public class StackLinkedList {

    StackNode head;

    boolean isEmpty(){
        if(head == null)
            return  true;
        else
            return false;
    }

    void push(int data){
        StackNode newNode = new StackNode(data);

        if(isEmpty()){
            head = newNode;
        }
        else{
            StackNode tempNode = head;
            newNode.next = tempNode;
            head = newNode;
        }
    }

    int pop(){
        int popped = Integer.MIN_VALUE;
        if(isEmpty()) System.out.println("Stack is empty");
        else{
            popped = head.data;
            head = head.next;
        }
        return  popped;
    }

    int peek(){
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return  Integer.MIN_VALUE;
        }else return  head.data;
    }

    void printStackLinkedList(){
        StackNode tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
