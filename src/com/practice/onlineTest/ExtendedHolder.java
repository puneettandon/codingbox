package com.practice.onlineTest;

import com.practice.onlineTest.Holder;

public class ExtendedHolder // extends Holder
 {

    private static final int SIZE = 30;

    private final int size = 20;

    public ExtendedHolder() {
        System.out.println(SIZE);
    }

    protected int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        new ExtendedHolder();
    }
}
