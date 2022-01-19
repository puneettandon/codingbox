package com.practice.dp;

public class Main {
    public static void main(String[] args) {
        try {
            throw  new MyDerivedClass();
        }catch (MyBaseClass b){
            System.out.println("caught base class");
        }
        /*catch (MyDerivedClass d){
            System.out.println("caught derived class");
        }*/
    }
}


class MyBaseClass extends Exception{}

class MyDerivedClass extends MyBaseClass{
}
