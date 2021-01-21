package com.company.qtask.controllers;

import com.company.qtask.role.RoleRequest;
import com.company.qtask.user.User;
import com.company.qtask.user.UserRequest;
import com.company.qtask.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public void addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
    }
    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/roles")
    public void addRole(RoleRequest roleRequest){

    }
}
