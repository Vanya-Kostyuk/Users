package com.example.testproject.controller;


import com.example.testproject.domain.User;
import com.example.testproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userinfo/{user_id}")
    public List<User> findUsersByUserId(@PathVariable("user_id") Integer userId) {
        return userService.findUsersByUserId(userId);
    }

    @GetMapping("/levelinfo/{level_id}")
    public List<User> findUserByLevelId(@PathVariable("level_id") Integer levelId) {
        return userService.findUsersByLevelId(levelId);
    }

    @PutMapping("/setinfo")
    public void setUserInfo(@RequestBody User user) {
        userService.addUser(user);
    }
}
