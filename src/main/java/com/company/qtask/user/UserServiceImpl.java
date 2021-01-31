package com.company.qtask.user;

import com.company.qtask.role.Role;
import com.company.qtask.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;


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
//        String email = userRequest.getEmail();
//        String firstName = userRequest.getFirstName();
//        String password = userRequest.getPassword();
//        Role role = userRequest.getRole();
//
//        //check if provided name exist and not blank
//        Optional<User> userOptional = userRepository.findUserByEmail(email);
//        userOptional.orElseThrow(()->{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"E-mail should not be blank");
//        });
//        userOptional.ifPresent(user -> {
//            throw new ResponseStatusException(HttpStatus.CONFLICT,"Given user already exists!");
//        });
//
//        //check if role is provided if not, user(role) should be set here
//        //check if provided role exist
//        if(Optional.ofNullable(role).isEmpty()){
//            role = roleRepository.findRoleByName("user").orElseThrow(()->{
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Role \"User\" does not exist!");
//            });
//        }else{
//            Optional<Role> roleOptional = roleRepository.findRoleByName(role.getName());
//            role = roleOptional.orElseThrow(()->{
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given role does not exist!");
//            });
//        }
//
//
//        //create user
//        User user = new User(email,firstName,password, userRequest.getStatus(), role);
//        userRepository.save(user);
//        throw new ResponseStatusException(HttpStatus.OK,"User added successfully");
    }

    @Override
    public Iterable<UserResponse> getUsers() {

        return userRepository.findAll().stream()
                .map(User::toUserResponse)
                .collect(Collectors.toList());

    }

    @Override
    public void registerUser(UserRequest userRequest) {
        String email = userRequest.getEmail();
        String firstName = userRequest.getFirstName();
        String password = userRequest.getPassword();
        Role role = userRequest.getRole();

        //check if provided name exist and not blank
        Optional<User> userOptional = userRepository.findUserByEmail(email);
//        Optional.ofNullable(email).orElseThrow(()->{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"E-mail should not be blank");
//        });
        userOptional.ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Given user already exists!");
        });

        //check if role is provided if not, user(role) should be set here
        //check if provided role exist
        if(Optional.ofNullable(role).isEmpty()){
            role = roleRepository.findRoleByName("user").orElseThrow(()->{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Role \"User\" does not exist!");
            });
        }else{
            Optional<Role> roleOptional = roleRepository.findRoleByName(role.getName());
            role = roleOptional.orElseThrow(()->{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given role does not exist!");
            });
        }


        //create user
        User user = new User(email,firstName,password, userRequest.getStatus(), role);
        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK,"User added successfully");


    }

    @Override
    public void deleteUser() {

    }
}
