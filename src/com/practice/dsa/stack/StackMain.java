package com.practice.dsa.stack;

import java.util.Arrays;

public class StackMain {

    public static void main(String[] args) {

        StackArray stackArr = new StackArray(50);
        stackArr.push(10);
        stackArr.push(20);
        stackArr.push(30);
        stackArr.push(40);

        stackArr.printStackArray();

        System.out.println("Poping out: "+stackArr.pop());
        System.out.println("Poping out: "+stackArr.pop());

        System.out.println("Peek element: "+stackArr.peek());

        stackArr.printStackArray();


        StackLinkedList stackLinkedList = new StackLinkedList();

        stackLinkedList.push(10);
        stackLinkedList.push(20);
        stackLinkedList.push(30);
        stackLinkedList.push(40);

        stackLinkedList.printStackLinkedList();

        stackLinkedList.pop();
        stackLinkedList.pop();


        stackLinkedList.printStackLinkedList();

        String exp =   "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(stackArr.infixToPostfix(exp));


        String str = "puneet tandon";
        String reverseString = stackArr.reverseStringUsingStack(str);
        System.out.println("Actual String " + str);
        System.out.println("Reverse String "+reverseString);

        int arr[] = {1,4,2,6,1,8};
        System.out.println("Print next larger element of each array element: ");
        Arrays.stream(arr).forEach( i -> System.out.print(i + " "));
        System.out.println();
        stackArr.printNextLargerElementArray(arr);

        String delimitercheck = "{()}{";
        System.out.println("Is parenthesis matching for string: "+delimitercheck + " : " + stackArr.checkIfParenthesisMatching(delimitercheck));


        // Stack implementation using Queue

        System.out.println("\nImplementing Stack using Queue:");
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(10);
        stackQueue.push(30);
        stackQueue.push(50);
        stackQueue.push(40);
        stackQueue.push(70);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());

        stackQueue.push(5);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());


    }

}
