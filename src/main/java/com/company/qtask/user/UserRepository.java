package com.company.qtask.user;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(Integer id);

    Optional<User> findUserByEmail(String email);

    ArrayList<User> findAll();

    List<User> findAllByRoleName(String name);
}
