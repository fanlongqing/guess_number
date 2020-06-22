package com.twschool.practice.dao;

import com.twschool.practice.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<>();

    public User getUserById(String id) {
        return userMap.get(id);

    }

    public void setUserInfo(String id, User user) {
        userMap.put(id, user);

    }
}
