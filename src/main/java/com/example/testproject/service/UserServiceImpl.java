package com.example.testproject.service;

import com.example.testproject.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final List<User> userStorage = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<User> findUsersByUserId(int userId) {
        return userStorage.stream()
                .filter(user -> user.getUserId().equals(userId))
                .sorted(Comparator.comparingInt(User::getResult).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByLevelId(int levelId) {
        return userStorage.stream()
                .filter(user -> user.getLevelId().equals(levelId))
                .sorted(Comparator.comparingInt(User::getResult).thenComparing(User::getUserId).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(User user) {
        userStorage.add(user);
        logger.info("User added");
    }

    @Override
    public void cleanData() {
        userStorage.clear();
        logger.info("All users deleted");
    }
}
