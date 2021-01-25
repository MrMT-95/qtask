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
        String login = userRequest.getLogin();
        String firstName = userRequest.getFirstName();
        String password = userRequest.getPassword();
        Role role = userRequest.getRole();

        //check if provided name exist
        Optional<User> userOptional = userRepository.findUserByLogin(login);
//        userOptional.orElseThrow(()->{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Login should not be blank");
//        });
        userOptional.ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Given user already exists!");
        });

        //check if role is provided if not, user(role) should be set here
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
        User user = new User(login,firstName,password, userRequest.getStatus(), role);
        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK,"User added successfully");
    }

    @Override
    public Iterable<UserResponse> getUsers() {

        return userRepository.findAll().stream()
                .map(User::toUserResponse)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteUser() {

    }
}
