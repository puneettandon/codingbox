package com.learn.practice;

import java.time.LocalDateTime;

public class Expense1 {

    private String id;
    private String userId;
    private String title;
    private String description;
    private LocalDateTime expenseDate;
    private ExpenseStatus1 expenseStatus;
    private double expenseAmount;
    private ExpenseGroup1 expenseGroup;

    public Expense1(String id, String userId, String title, String description, LocalDateTime expenseDate, ExpenseStatus1 expenseStatus, double expenseAmount, ExpenseGroup1 expenseGroup) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.expenseDate = expenseDate;
        this.expenseStatus = expenseStatus;
        this.expenseAmount = expenseAmount;
        this.expenseGroup = expenseGroup;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public ExpenseStatus1 getExpenseStatus() {
        return expenseStatus;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public ExpenseGroup1 getExpenseGroup() {
        return expenseGroup;
    }

    public void setExpenseStatus(ExpenseStatus1 expenseStatus) {
        this.expenseStatus = expenseStatus;
    }
}
