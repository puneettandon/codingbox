package com.lld.expenesharing.main.model;

import java.util.UUID;

public class User {

    private String name;
    private String userId;
    private String emailId;
    private String phoneNumber;

    public User(String name, String emailId, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

