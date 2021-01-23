package com.company.qtask.role;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleServiceImpl implements RoleService{
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(RoleRequest roleRequest) {
        String name = roleRequest.getName();
        Role role = new Role(name);
        roleRepository.save(role);
        throw new ResponseStatusException(HttpStatus.OK,"Role added successfully");
    }

    @Override
    public Iterable<Role> getRoles() {

        return roleRepository.findAll();
    }
}
