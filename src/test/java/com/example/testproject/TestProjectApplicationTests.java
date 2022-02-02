package com.example.testproject;

import com.example.testproject.domain.User;
import com.example.testproject.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestProjectApplicationTests {

    private static final User USER_1 = new User(1, 1, 55);
    private static final User USER_2 = new User(1, 2, 8);
    private static final User USER_3 = new User(1, 3, 15);
    private static final User USER_4 = new User(2, 3, 22);

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init() {
        userService.addUser(USER_1);
        userService.addUser(USER_2);
        userService.addUser(USER_3);
        userService.addUser(USER_4);

    }

    @Test
    void fetchUsersByUserId() {
        assertEquals(List.of(USER_1, USER_3, USER_2), userService.findUsersByUserId(1));
    }

    @Test
    void fetchUsersByLevelId() {
        assertEquals(List.of(USER_4, USER_3), userService.findUsersByLevelId(3));
    }

    @AfterEach
    public void cleanUpEach() {
        userService.cleanData();
    }


}
