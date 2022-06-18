package com.practice.dsa.singlelinkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import static java.util.Collections.swap;

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


    void isLinkedListPalindromeUsingStack(){
        MyNode temp = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();

        while(temp != null){
            stack.push(temp.value);
            temp = temp.next;
        }

        MyNode temp2 = head;
        while(temp2 != null){
            int i = stack.pop();
            if(temp2.value == i){
                isPalindrome = true;
            }else{
                isPalindrome = false;
                break;
            }
            temp2 = temp2.next;
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

    }

    boolean isLinkedListPalindromeByReversingLinkedList(){
        MyNode slow = head;
        MyNode fast = head;
        MyNode prevOfSlowPtr = head;
        MyNode midNode= null;
        boolean isPalindrome = true;

        // find the mid of the element
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        midNode = slow;

        // reverse the second half of linkedlist
        MyNode revNode = reverseLinkedListRecursiveUtil(midNode.next);


        // compare nodes of first half and second half
        MyNode temp = head;
        while(temp != null){
            if(temp.value != revNode.value){
                isPalindrome = false;
                break;
            }
            temp = temp.next;
            revNode = revNode.next;
        }
        // reconstruct the second half by reversing again
        reverseLinkedListRecursiveUtil(midNode);
        return isPalindrome;
    }

    MyNode reverseLinkedList(){
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
        return head;
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

    void removeDuplicateSortedLinkedListV2(){
        MyNode temp = head, prev = head;
        while(temp != null){
            if(temp.value != prev.value){
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if(prev != temp)
            prev.next = null;
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

    //To rotate the linked list, we need to change the next of kth node to NULL,
    // the next of the last node to the previous head node, and finally, change the head to (k+1)th node.
    //So we need to get hold of three nodes: kth node, (k+1)th node, and last node.
    // Traverse the list from the beginning and stop at kth node
    // Store pointer to kth node. We can get (k+1)th node using kthNode->next
    //Keep traversing till the end and store a pointer to the last node also
    //Finally, change pointers as stated above.
    void rotate(int k){
        if(k == 0)
            return;

        MyNode curr = head;

        int count = 1;
        while(count < k && curr != null){
            curr = curr.next;
            count++;
        }

        if(curr == null)
            return;

        MyNode kthNode = curr;

        while(curr.next != null)
            curr = curr.next;

        curr.next = head;
        head = kthNode.next;

        kthNode.next = null;
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

    public MyNode partition(int x){

        MyNode smallerHead = null, smallerLast = null;
        MyNode greaterLast = null, greaterHead = null;
        MyNode equalHead = null, equalLast = null;

        while(head != null){

            if(head.value == x){
                if(equalHead == null)
                    equalHead = equalLast = head;
                else{
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            }else if(head.value < x){
                if(smallerHead == null)
                    smallerHead = smallerLast = head;
                else{
                    smallerLast.next = head;
                    smallerLast = head;
                }
            }else{
                if(greaterHead == null)
                    greaterLast = greaterHead = head;
                else{
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }
            head = head.next;
        }

        if(greaterLast != null){
            greaterLast.next = null;
        }

        if(smallerHead == null){
            if(equalHead == null)
                return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        if(equalHead == null){
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        smallerLast.next = equalHead;
        equalLast.next = greaterHead;
        return  smallerHead;

    }

    public void addTwoNumbersLinkedList(MyNode first, MyNode second){
        MyNode start1 = new MyNode();
        start1.value = 0; start1.next = first;

        MyNode start2 = new MyNode();
        start2.value = 0; start2.next = second;

        addPrecedingZeros(start1,start2);
        MyNode result = new MyNode();
        result.value = 0;
        if(sumTwoNodes(start1.next,start2.next,result) == 1){
            MyNode node = new MyNode();
            node.value = 1;
            node.next = result.next;
            result.next = node;
        }
        traverseLinkedList();
    }

    private int sumTwoNodes(MyNode first, MyNode second, MyNode result) {
        if(first == null)
            return 0;
        int number = first.value + second.value + sumTwoNodes(first.next,second.next,result);
        MyNode node = new MyNode();
        node.value = number %10;
        node.next = result.next;
        result.next = node;
        return number/10;
    }

    private void addPrecedingZeros(MyNode start1, MyNode start2) {
        MyNode next1 = start1.next;
        MyNode next2 = start2.next;

        while(next1 != null && next2 != null){
            next1 = next1.next;
            next2 = next2.next;
        }
        if(next1 == null && next2 != null){
            while(next2 != null){
                MyNode node = new MyNode();
                node.value = 0;
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if ((next2 == null && next1 != null)) {
            while(next1 != null){
                MyNode node = new MyNode();
                node.value = 0;
                node.next = start2.next;
                start2.next = node;
                next1 = next2.next;
            }
        }
    }
    
    public void pairWiseSwapNodesIteratively(){

        MyNode temp = head;
        while(temp != null && temp.next != null){
            int k = temp.value;
            temp.value  = temp.next.value;
            temp.next.value = k;
            temp = temp.next.next;
        }
    }

    public void pairWiseSwapNodesRecursively(MyNode head){
        if(head != null  && head.next != null){
            swap(head.value,head.next.value);
            pairWiseSwapNodesRecursively(head.next.next);
        }
    }

    private void swap(int value1, int value2) {
        int temp = value1;
        value1 = value2;
        value2  = temp;
    }
}
