package com.practice.onlineTest;

import java.io.Serializable;

public class Person implements Serializable {
    private final transient Integer id;
    private final String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

    }
}
