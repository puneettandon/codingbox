package com.lld.expenesharing.main.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ExpenseGroup {

    private Set<User> groupMemebers = new HashSet<>();
    private String expenseGroupId;
    private Map<String,UserShare> userContributions;


    public ExpenseGroup() {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.groupMemebers = new HashSet<>();
        this.groupMemebers = groupMemebers;
    }

    public Set<User> getGroupMemebers() {
        return groupMemebers;
    }

    public String getExpenseGroupId() {
        return expenseGroupId;
    }

    public Map<String, UserShare> getUserContributions() {
        return userContributions;
    }

    public void setUserContributions(Map<String, UserShare> userContributions) {
        this.userContributions = userContributions;
    }
}
