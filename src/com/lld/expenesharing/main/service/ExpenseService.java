package com.lld.expenesharing.main.service;

import com.lld.expenesharing.main.exceptions.ExpenseDoesNotExistsException;
import com.lld.expenesharing.main.model.*;
import com.lld.expenesharing.main.repository.ExpenseRepository;
import com.lld.expenesharing.main.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class ExpenseService {

    NotificationService notificationService = new NotificationServiceImpl();

    public Expense createExpense(String title, String description, LocalDateTime expenseDate, double expenseAmount, String userId) {

        Expense expense = new Expense(UUID.randomUUID().toString(),userId,title,description,expenseDate, ExpenseStatus.CREATED,expenseAmount,new ExpenseGroup());
        ExpenseRepository.expenseMap.putIfAbsent(expense.getId(),expense);
        return expense;
    }

    public void addUsersToExpense(String expenseId, String emailId) throws ExpenseDoesNotExistsException {
        if(!ExpenseRepository.expenseMap.containsKey(expenseId)){
            throw  new ExpenseDoesNotExistsException("Better create expense and come here....");
        }
        ExpenseRepository.expenseMap.get(expenseId).getExpenseGroup().getGroupMemebers().add(UserRepository.userHashMap.get(emailId));

        if(notificationService != null){
            notificationService.notifyUser(UserRepository.userHashMap.get(emailId),
                    ExpenseRepository.expenseMap.get(expenseId));
        }
    }

    public void assignExpenseShare(String expenseId, String emailId, double share) throws ExpenseDoesNotExistsException {
        if(!ExpenseRepository.expenseMap.containsKey(expenseId)){
            throw new ExpenseDoesNotExistsException(String.format("Expense %s does not exists", expenseId));
        }
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.getExpenseGroup().getUserContributions().put(emailId,new UserShare(emailId,share));
    }

    public boolean isExpenseSettled(String expenseId) {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        Map<String,UserShare> userContributions = expenseGroup.getUserContributions();

        double total = expense.getExpenseAmount();

        for(Map.Entry<String,UserShare> entry: userContributions.entrySet()){
            UserShare userShare = entry.getValue();
            for(Contribution contribution : userShare.getContributions()){
                total -= contribution.getContributionValue();
            }
        }
        if(total <= 1 ){
            return true;
        }
        return false;
    }

    public void setExpenseStatus(String expenseId, ExpenseStatus expenseStatus) {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.setExpenseStatus(expenseStatus);
    }
}
