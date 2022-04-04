package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.account.Account;
import com.lld.vehiclerental.model.account.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository implements AccountRepository {

    public static Map<String, Driver> driverMap = new HashMap<>();
    public static List<Driver> drivers = new ArrayList<>();

    @Override
    public Account createAccount(Account account) {
        driverMap.putIfAbsent(account.getEmail(), (Driver) account);
        return account;
    }

    @Override
    public void resetPassword(String userId, String password) {

    }
}
