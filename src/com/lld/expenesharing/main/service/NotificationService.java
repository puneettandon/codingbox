package com.lld.expenesharing.main.service;

import com.lld.expenesharing.main.model.Expense;
import com.lld.expenesharing.main.model.User;

public interface NotificationService {

    void notifyUser(User user, Expense expense);
}
