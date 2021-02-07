package com.company.qtask.controllers;

import com.company.qtask.role.Role;
import com.company.qtask.role.RoleRequest;
import com.company.qtask.role.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
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
