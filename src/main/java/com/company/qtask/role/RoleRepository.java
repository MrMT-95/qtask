package com.company.qtask.role;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findRoleById(Integer id);

    Role findRoleByName(String name);

}
