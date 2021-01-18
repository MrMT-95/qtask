package com.company.qtask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserRequest userRequest) {
        String name = userRequest.getName();

        //check if provided name exist
        Optional<User> userOptional = userRepository.findUserByName(name);
        userOptional.ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Given user already exists!");
        });

        //create user
        User user = new User(name);
        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK,"User added successfully");
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
