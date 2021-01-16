package com.company.qtask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //create user
        User user = new User(name);
        userRepository.save(user);
    }
}
