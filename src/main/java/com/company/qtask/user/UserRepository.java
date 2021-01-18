package com.company.qtask.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById (Integer id);
    Optional<User> findUserByName (String name);
}
