package com.company.qtask.role;


public interface RoleService {

    void addRole(RoleRequest roleRequest);
    Iterable<Role> getRoles();
}
