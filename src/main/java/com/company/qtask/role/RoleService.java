package com.company.qtask.role;


public interface RoleService {

    void addRole(RoleRequest roleRequest);
    Iterable<RoleResponse> getRoles();
    void deleteRole(RoleRequest roleRequest);
}
