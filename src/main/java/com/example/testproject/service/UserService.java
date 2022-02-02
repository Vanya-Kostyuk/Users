package com.example.testproject.service;

import com.example.testproject.domain.User;

import java.util.List;

public interface UserService {

    List<User> findUsersByUserId(int userId);

    List<User> findUsersByLevelId(int levelId);

    void addUser(User user);

    void cleanData();
}
