package com.company.qtask.controllers;

import com.company.qtask.user.UserRequest;
import com.company.qtask.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public String addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return "User added!";
    }
}
