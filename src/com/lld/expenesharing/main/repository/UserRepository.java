package com.lld.expenesharing.main.repository;

import com.lld.expenesharing.main.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public static Map<String, User> userHashMap = new HashMap<>();

    public static Map<String, User> getUserHashMap() {
        return userHashMap;
    }

    public static void setUserHashMap(Map<String, User> userHashMap) {
        UserRepository.userHashMap = userHashMap;
    }
}
