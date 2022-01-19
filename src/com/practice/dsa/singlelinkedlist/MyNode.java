package com.practice.dsa.singlelinkedlist;

public class MyNode {

    int value;
    MyNode next;
    int flag;

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public MyNode getNext() { return  next; }

    public void setNext(MyNode next) { this.next = next; }

    @Override
    public String toString() { return  value + ""; }
}
