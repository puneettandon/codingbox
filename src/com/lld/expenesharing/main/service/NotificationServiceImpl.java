package com.lld.expenesharing.main.service;

import com.lld.expenesharing.main.model.Expense;
import com.lld.expenesharing.main.model.User;

public class NotificationServiceImpl implements NotificationService {

    @Override
    public void notifyUser(User user, Expense expense) {
        System.out.println("Notified");
    }
}
