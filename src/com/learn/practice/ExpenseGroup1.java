package com.learn.practice;

import java.util.*;

public class ExpenseGroup1 {

    private Set<User1> groupMemebers;
    private String expenseGroupId;
    private Map<String,UserShare1> userContributions;

    public ExpenseGroup1() {
        this.groupMemebers = new HashSet<>();
        this.expenseGroupId = UUID.randomUUID().toString();
        this.userContributions = new HashMap<>();
    }

    public Set<User1> getGroupMemebers() {
        return groupMemebers;
    }

    public Map<String, UserShare1> getUserContributions() {
        return userContributions;
    }

    public void setUserContributions(Map<String, UserShare1> userContributions) {
        this.userContributions = userContributions;
    }
}
