package com.learn.practice;

import java.util.UUID;

public class User1 {

    private String userId;
    private  String name;
    private String email;
    private String phoneNumber;

    public User1(String name, String email, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
