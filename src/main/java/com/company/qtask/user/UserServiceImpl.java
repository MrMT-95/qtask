package com.company.qtask.user;

import com.company.qtask.role.Role;
import com.company.qtask.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void addUser(UserRequest userRequest) {
        String login = userRequest.getLogin();
        String firstName = userRequest.getFirstName();
        String password = userRequest.getPassword();
        Role role = userRequest.getRole();


        //check if role is provided if not user should be set here
        if (role == null){
            role = roleRepository.findRoleByName("name");
        }

        //check if provided name exist
        Optional<User> userOptional = userRepository.findUserByLogin(login);
        userOptional.ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Given user already exists!");
        });

        //create user
        User user = new User(login,firstName,password,role);
        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK,"User added successfully");
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser() {

    }
}
