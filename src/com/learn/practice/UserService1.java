package com.learn.practice;

import com.lld.expenesharing.main.exceptions.ContributionExceededException;

public class UserService1 {

    public User1 createUser(String email, String name, String pNo) {
        User1 user = new User1(email,name,pNo);
        UserRepository1.userHashMap.putIfAbsent(email,user);
        return user;
    }

    public void contributeToExpense(String expenseId, String email, Contribution1 contribution) throws InvalidExpenseState1, ExpenseSettledException1, ContributionExceededException1 {

        Expense1 expense1 = ExpenseRepository1.expenseMap.get(expenseId);
        ExpenseGroup1 expenseGroup1 = expense1.getExpenseGroup();
        if(expense1.getExpenseStatus() == ExpenseStatus1.CREATED){
            throw new InvalidExpenseState1("Invalid Expense State");
        }

        if(expense1.getExpenseStatus() == ExpenseStatus1.SETTLED){
            throw new ExpenseSettledException1("Exception is already Settled");
        }

        UserShare1 userShare1 = expenseGroup1.getUserContributions().get(email);
        if(contribution.getContributionValue() > userShare1.getShare()){
            throw new ContributionExceededException1("User %s contributed %d exceeded the share %d");
        }
        userShare1.getContributions().add(contribution);
    }
}
