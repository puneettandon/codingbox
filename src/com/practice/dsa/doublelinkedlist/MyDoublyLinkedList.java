package com.practice.dsa.doublelinkedlist;


import org.w3c.dom.Node;

public class MyDoublyLinkedList {


    public MyDNode insert(int i , MyDNode node){
        if(node == null) {
            MyDNode newNode = getNewNode(i);
        }

        MyDNode head = node;

        while(node.next != null){
            node = node.next;
        }
        MyDNode newNode = getNewNode(i);
        newNode.prev = node;

        return head;
    }

    private MyDNode getNewNode(int i) {
        MyDNode newNode = new MyDNode();
        newNode.data = i;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    }

    public MyDNode insertAtStart(int data, MyDNode head) {
        if(head == null){
            return getNewNode(data);
        }
        MyDNode newNode = getNewNode(data);
        head.prev = newNode;
        newNode.next = head;

        return  newNode;
    }


    public MyDNode insertAtGivenPosition(int data, MyDNode head, int position) {
        if(head == null){
            if(position == 1)
                return getNewNode(data);
            else
                return  null;
        }

        if(position == 1){
            return insertAtStart(data,head);
        }

        MyDNode node = head;
        while(node != null && position > 2){
            node = node.next;
            position--;
        }
        if(node == null)
        {
            System.out.println("Position is not valid");
            return head;
        }

        MyDNode newNode = getNewNode(data);
        newNode.next = node.next;
        newNode.prev = node;
        if(node.next != null){
            node.next.prev = newNode;
        }
        node.next = newNode;

        return head;
    }


    public MyDNode deleteFirstNode(MyDNode head) {

        if(head == null){
            return null;
        }
        if(head.next == null){
            head.next.prev = null;
        }

        return head.next;
    }

    public int getSizeOfList(MyDNode node) {
        if(node == null)
            return 0;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public void printDoublyLinkedList(MyDNode node) {

        if(node == null)
            return;
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public MyDNode rotateList(MyDNode head,int k){
        if(head == null || head.next == null){
            return head;
        }
        MyDNode node = head;
        k = k % getSizeOfList(head);
        if(k == 0){
            return head;
        }

        while(node != null && k > 1){
            node = node.next;
            k--;
        }
        MyDNode newHead = node.next;
        newHead.prev = null;

        node.next = null;
        MyDNode temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;

        return  newHead;
    }
}
