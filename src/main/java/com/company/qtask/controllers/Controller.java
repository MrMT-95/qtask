package com.company.qtask.controllers;

import com.company.qtask.role.Role;
import com.company.qtask.role.RoleRequest;
import com.company.qtask.role.RoleService;
import com.company.qtask.user.UserRequest;
import com.company.qtask.user.UserResponse;
import com.company.qtask.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    UserService userService;
    RoleService roleService;

    @Autowired
    public Controller(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostMapping(value = "/user/register", consumes = "application/json")
    public void registerUser(@Valid @RequestBody UserRequest userRequest, BindingResult result){
        if (result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            errorList.forEach(objectError -> stringBuilder.append(System.lineSeparator()).append(objectError.getDefaultMessage()));
            throw new ResponseStatusException(HttpStatus.CONFLICT,stringBuilder.toString());
        }else {
            userService.registerUser(userRequest);
        }

    }

    @GetMapping("/users")
    public Iterable<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/roles")
    public void addRole(RoleRequest roleRequest){
        roleService.addRole(roleRequest);
    }

    @GetMapping("/roles")
    public Iterable<Role> getRoles(){
        return roleService.getRoles();
    }
}
