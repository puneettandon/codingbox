package com.practice.dsa.singlelinkedlist;

import java.util.ArrayList;
import java.util.HashSet;

//https://github.com/teivah/algodeck/blob/master/linkedlist.md
public class MySingleLinkedList   {

    MyNode head;
    private MyNode tail;
    private int size =0;

    public void insertAtEnd(int data) {
       MyNode node = new MyNode();
       node.value = data;
       node.next = null;

       if(head == null){
           head = node;
           tail = node;

       }else {
           tail.next = node;
           tail = node;
       }
       size++;
    }

    public void insertAtBegin(int data) {
        MyNode node = new MyNode();
        node.value = data;
        node.next = null;
        node.flag = 0;

        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public  void insertAtMiddle(int data,int position){
     /*   MyNode node = new MyNode();
        node.value = data;
        node.next = null;

        if(position == 0){
            insertAtBegin(data);
        }else if(position == size){
            insertAtEnd(data);
        }else{
            MyNode tempNode = head;
            while(position-- != 0){
                if(position == 1){

                }

            }
        }*/
    }

    void traverseLinkedList(){
        MyNode tempNode = head;

       while(tempNode != null){
           System.out.print(tempNode.value + " -> ");
           tempNode = tempNode.next;
       }
       System.out.println();
       System.out.println("LinkedList Size: "+size);
    }

    void countNodesIteratively(){
        MyNode tempNode = head;
        int count = 0;
        while(tempNode != null){
            count++;
            tempNode = tempNode.next;
        }
        System.out.println("Iteratively Node count in linked list: "+count);
    }

    void  countNodeRecursively(){
        System.out.println("Recursively Node count in linked list: "+getCountRecursively(head));
    }

    private int getCountRecursively(MyNode node) {
        if(node == null)
            return  0;
        else return  1 + getCountRecursively(node.next);
    }

    MyNode printMiddleElementSlowFastPtr(){
        MyNode slowPtr = head;
        MyNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("The middle element is : "+ slowPtr.value);
        return slowPtr;
    }

    void printMiddleElementUsingSize() {
        MyNode tempNode = head;
        int count = 0;
        while (count < size/2 ) {
            tempNode = tempNode.next;
            count++;
        }
        System.out.println("The middle element is : "+tempNode.value);
    }

    void IsLinkedListPallindrome(){
        MyNode tempNode = head;
        ArrayList<Integer> linkedListValues = new ArrayList<>();
        while(tempNode != null){
            linkedListValues.add(tempNode.value);
            tempNode = tempNode.next;
        }

        for(int i = 0;i< linkedListValues.size();i++){
            if(linkedListValues.get(i).equals(linkedListValues.get(size-1-i))){
                System.out.println("Linked List is not Palindrome");
                break;
            }
            if(i == linkedListValues.size()-1){
                System.out.println("LinkedList is Palindrome");
            }
        }
    }

    void isLinkedListPallindromeMethod2(){
        MyNode slow = head;
        MyNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    void reverseLinkedList(){
        MyNode currNode = head;
        MyNode nextNode = null;
        MyNode prevNode = null;

        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        traverseLinkedList();
    }

    void reverseLinkedListRecursively(){
        reverseLinkedListRecursiveUtil(head);
        traverseLinkedList();
    }

    MyNode reverseLinkedListRecursiveUtil(MyNode head){
        if(head == null || head.next == null)
            return head;
        MyNode rest = reverseLinkedListRecursiveUtil(head.next);
        head.next.next = head;

        head.next = null;
        return  rest;
    }

    boolean detectLoop(){
        MyNode tempNode= head;
        HashSet<MyNode> mySet = new HashSet<>();

        while(tempNode != null){
            if(mySet.contains(tempNode)){
                return  true;
            }
            mySet.add(tempNode);
            tempNode = tempNode.next;
        }
        return false;
    }

    boolean detectLoopWithoutHashSet(){
        MyNode tempNode = head;

        while(tempNode != null){
            if(tempNode.flag == 1)
                return true;
            tempNode.flag = 1;
            tempNode = tempNode.next;
        }
        return  false;
    }

    boolean detectLoopFloyd(){
        MyNode slow = head;
        MyNode fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return  true;
        }
        return false;
    }

    void removeDuplicateSortedLinkedList(){
        MyNode curr = head;
        while(curr != null){
            MyNode tempNode = curr;
            while(tempNode != null && tempNode.value == curr.value){
                tempNode = tempNode.next;
            }
            curr.next = tempNode;
            curr = curr.next;
        }
    }

    void moveLastToFirst(){
       MyNode last= head;
       MyNode secLast = null;

       while(last.next != null){
           System.out.print(last.value+ "=>");
           secLast = last;
           last = last.next;
       }
       secLast.next = null;
       last.next = head;
       head = last;
    }

    void deleteFromBegin(){
        if(head != null) {
            head = head.next;
        }
        size--;
    }

    void deleteFromEnd(){
        MyNode tempNode = head;
        MyNode prevNode = null;

        while(tempNode.next != null){
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
        prevNode.next = null;
        tail = prevNode;
        size--;
    }

    void searchElement(int data){
        MyNode tempNode = head;
        int flag = 0;
        while(tempNode != null ){
            if(tempNode.value == data){
                flag = 1;
            }
            tempNode = tempNode.next;
        }
        if(flag ==1 ) System.out.println("Element " + data + " found in linkedlist");
        else System.out.println("Element " + data + " not found in linkedlist");

    }

    void deleteLargestElement(){
     /*   MyNode tempNode = head;
        MyNode prevNode = null;
        MyNode largestNode = null;
        MyNode prevLargestNode = null;

        while(tempNode.next != null){
            prevNode = tempNode;
            if(tempNode.value  > prevNode.value){
                prevLargestNode =
                largestNode = tempNode;
            }
        }
        tempNode*/
    }

    void rotateClockwise(int k){
        if(head == null) return;
        k = k % size;

        MyNode tempNode = head;
        int i = 1;

        while(i < size - k){
            tempNode = tempNode.next;
            i++;
        }

        MyNode tempNode2 = tempNode.next;
        MyNode node = tempNode2;
        tempNode.next = null;

        i = 1;
        while(tempNode2.next != null){
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = head;
        head = node;
    }

    public void mergeSort(){
        mergeSortUtil(head);
        traverseLinkedList();
    }


    public MyNode mergeSortUtil(MyNode head) {
        if(head.next  == null)
            return head;

        MyNode mid = printMiddleElementSlowFastPtr();

        MyNode head2 = mid.next;
        mid.next = null;

        MyNode newHead1= mergeSortUtil(head);
        MyNode newHead2 = mergeSortUtil(head2);
        MyNode finalHead = merge(newHead1,newHead2);

        return  finalHead;
    }

    private MyNode merge(MyNode head1, MyNode head2) {

        MyNode  merged = new MyNode();
        merged.value = -1;
        MyNode temp = merged;

        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return merged.next;
    }
}
