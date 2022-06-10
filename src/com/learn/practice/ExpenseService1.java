package com.learn.practice;



import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseService1 {

    public Expense1 createExpense(String title, String description, LocalDateTime expenseDate, int expenseAmount, String userId) {
        Expense1 expense = new Expense1(UUID.randomUUID().toString(),
                userId,title,description,expenseDate,ExpenseStatus1.CREATED,
                expenseAmount,new ExpenseGroup1());
        ExpenseRepository1.expenseMap.putIfAbsent(expense.getId(),expense);
        return expense;
    }

    public void addUsersToExpense(String expenseId, String email) throws  ExpenseDoesNotExistsException1 {

        if(!ExpenseRepository1.expenseMap.containsKey(expenseId)){
            throw new ExpenseDoesNotExistsException1("Better come expense and come here....");
        }

        ExpenseRepository1.expenseMap.get(expenseId).getExpenseGroup().getGroupMemebers().add(UserRepository1.userHashMap.get(email));

    }

    public void assignExpenseShare(String expenseId, String email, double share) throws  ExpenseDoesNotExistsException1{

        if(!ExpenseRepository1.expenseMap.containsKey(expenseId)){
            throw new ExpenseDoesNotExistsException1(String.format("Expense %s  doesnot exxists",expenseId));
        }

        Expense1 expense1 = ExpenseRepository1.expenseMap.get(expenseId);
        expense1.getExpenseGroup().getUserContributions().put(email,new UserShare1(email,share));
    }
}
