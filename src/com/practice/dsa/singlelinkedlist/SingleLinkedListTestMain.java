package com.practice.dsa.singlelinkedlist;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;

public class SingleLinkedListTestMain {

    public static void main(String[] args) {

        SingleLinkedListTest list = new SingleLinkedListTest();
        list.insertAtEnd(100);
        list.insertAtEnd(200);
        list.insertAtEnd(300);
        list.insertAtEnd(400);
        list.insertAtEnd(500);

        list.insertAtBegin(300);
        list.insertAtBegin(400);
        list.insertAtBegin(300);
        list.insertAtBegin(200);
        list.insertAtBegin(100);

        list.traverseLinkedList();

        list.countNodeIteratively();

        list.countNodeRecursively();

        list.printMiddleElementSlowFastPtr();

        list.printMiddleElementUsingSize();

        list.IsLinkedListPallindrome();

        list.IsLinkedListPalindromeSlowFastPtr();

        list.reverseLinkedList();

        list.reverseLinkedListRecursively();

        list.detectLoop();
        list.detectLoopWithoutHashSet();
        list.detectLoopFloyd();

        list.moveLastToFirst();
    }
}

class SingleLinkedListTest{

    NodeTest head;
    NodeTest tail;
    int size;


    public void insertAtEnd(int data) {
        NodeTest node = new NodeTest();
        node.value = data;
        node.next = null;

        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAtBegin(int data) {
        NodeTest node = new NodeTest();
        node.value = data;
        node.next = null;

        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void traverseLinkedList() {
        NodeTest tempNode = head;

        while(tempNode != null){
            System.out.print(tempNode.value + "->");
            tempNode = tempNode.next;
        }
        System.out.println();
        System.out.println("Size of LinkedList : "+size);

    }

    public void countNodeIteratively() {
        NodeTest temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println("Iteratively node count : "+count);
    }


    public void countNodeRecursively() {
        System.out.println("Recursively Node count: "+getCountRecursively(head));
    }

    private int getCountRecursively(NodeTest node) {
        if(node== null){
            return 0;
        }else{
            return 1 + getCountRecursively(node.next);
        }
    }

    public void printMiddleElementSlowFastPtr() {
        NodeTest slowPtr = head;
        NodeTest fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("The middle element is : "+slowPtr.value);
    }


    public void printMiddleElementUsingSize() {
        NodeTest temp = head;
        int count = 0;
        while(count < size/2){
            temp = temp.next;
            count++;
        }
        System.out.println("The middle element is: "+temp.value);
    }

    public void IsLinkedListPallindrome() {
        NodeTest tempNode = head;
        ArrayList<Integer> linkedListValues = new ArrayList<>();

        while(tempNode != null){
            linkedListValues.add(tempNode.value);
            tempNode = tempNode.next;
        }

        for(int i = 0;i< linkedListValues.size();i++){
            if(!linkedListValues.get(i).equals(linkedListValues.get(size-1-i))){
                System.out.println("from first: "+linkedListValues.get(i));
                System.out.println("from last: "+linkedListValues.get(size-1-i));
                System.out.println("LinkedList is not palindrome");
                break;
            }
            if(i == linkedListValues.size()-1){
                System.out.println("LInkedList is Palindrome");
            }

        }
    }

    public void IsLinkedListPalindromeSlowFastPtr() {

    }

    public void reverseLinkedList() {
        NodeTest currNode = head;
        NodeTest nextNode;
        NodeTest prevNode = null;

        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;
        traverseLinkedList();

    }

    public void reverseLinkedListRecursively() {
        reverseLinkedListRecursiveUtil(head);
        traverseLinkedList();
    }

    private NodeTest reverseLinkedListRecursiveUtil(NodeTest head) {
        if(head == null || head.next == null)
            return head;
        NodeTest rest = reverseLinkedListRecursiveUtil(head.next);
        head.next.next = head;

        head.next = null;
        return rest;
    }

    public void detectLoop() {
        NodeTest tempNode = head;
        HashSet<NodeTest> mySet = new HashSet<>();

        while(tempNode != null){
            if(mySet.contains(tempNode)){
                System.out.println("Contains Loop");
                break;
            }
            mySet.add(tempNode);
            tempNode = tempNode.next;
        }
        System.out.println("Loop not found");

    }

    void detectLoopWithoutHashSet(){
        NodeTest temp = head;

        while(temp != null){
            if(temp.flag == 1){
                System.out.println("Loop found ");
                break;
            }
            temp.flag = 1;
            temp = temp.next;
        }
        System.out.println("Loop not found");
    }

    public void detectLoopFloyd() {
        NodeTest slow = head;
        NodeTest fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop Found ");
                break;
            }
        }
        System.out.println("Loop Not found");
    }

    public void moveLastToFirst() {

    }
}


class NodeTest{

    int value;
    NodeTest next;
    int flag;
}




