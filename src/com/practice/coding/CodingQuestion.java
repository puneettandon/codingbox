package com.practice.coding;

public class CodingQuestion extends  Thread {
    public static void main(String[] args) {
        B b = new B();

        if(b instanceof  A){
            System.out.println("A 's instance");
        }
        if(b instanceof  C){
            System.out.println("C's instance ");
        }
    }
}

interface  A{}
class C{}
class D extends  C{}
class B extends  D implements  A{}
