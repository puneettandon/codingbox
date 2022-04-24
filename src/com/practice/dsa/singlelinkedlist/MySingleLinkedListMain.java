package com.practice.dsa.singlelinkedlist;

public class MySingleLinkedListMain {

    public static void main(String[] args) {

        MySingleLinkedList list = new MySingleLinkedList();
    //    list.createSingleLinkedList(5);

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.insertAtEnd(50);

        list.insertAtBegin(60);
        list.insertAtBegin(70);
        list.insertAtBegin(80);
        list.insertAtBegin(90);

      //  list.head.next = list.head;

       list.traverseLinkedList();

        list.countNodesIteratively();
        list.countNodeRecursively();

        list.printMiddleElementSlowFastPtr();

        list.printMiddleElementUsingSize();

        list.IsLinkedListPallindrome();

        list.reverseLinkedList();

       // list.reverseLinkedListRecursively();

        if(list.detectLoop()) System.out.println("Contains Loop");
       else System.out.println("Does not contain loop");

        if(list.detectLoopWithoutHashSet()) System.out.println("Contains Loop");
        else System.out.println("Does not contain loop");

        if(list.detectLoopFloyd()) System.out.println("Contains Loop");
        else System.out.println("Does not contain loop");



     //  list.moveLastToFirst();
       // System.out.println();
     //  list.traverseLinkedList();

   //    list.deleteFromBegin();
   //    list.deleteFromBegin();
       list.traverseLinkedList();

      // list.deleteFromEnd();
     //  list.deleteFromEnd();
       list.traverseLinkedList();


       list.searchElement(70);

       list.mergeSort();

    }
}
