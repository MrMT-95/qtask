package com.company.qtask.controllers;

import com.company.qtask.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/user/register", consumes = "application/json")
    public void registerUser(@Valid @RequestBody UserRequest userRequest, BindingResult result) {

        if (result.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            errorList.forEach(objectError -> stringBuilder.append(System.lineSeparator()).append(objectError.getDefaultMessage()));
            throw new ResponseStatusException(HttpStatus.CONFLICT, stringBuilder.toString());
        } else {
            userService.registerUser(userRequest);
        }
    }


    @GetMapping(value = "/user/login", consumes = "application/json")
    public void loginUser(@Valid @RequestBody UserLogin userLogin, BindingResult result) {

        if (result.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            errorList.forEach(objectError -> stringBuilder.append(System.lineSeparator()).append(objectError.getDefaultMessage()));
            throw new ResponseStatusException(HttpStatus.CONFLICT, stringBuilder.toString());
        } else {
            userService.loginUser(userLogin);
        }
    }


    @GetMapping("/users")
    public Iterable<UserResponse> getUsers() {
        return userService.getUsers();
    }


    @DeleteMapping("/users")
    public void deleteUser(String email) {
        userService.deleteUser(email);
    }

    @PatchMapping(value = "/users", consumes = "application/json")
    public void updateUser(@Valid @RequestBody UserUpdate userUpdate, BindingResult result){

        if (result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            errorList.forEach(objectError -> stringBuilder.append(System.lineSeparator()).append(objectError.getDefaultMessage()));
            throw new ResponseStatusException(HttpStatus.CONFLICT, stringBuilder.toString());
        }else {

            userService.updateUser(userUpdate);
        }
    }
}
