package com.company.qtask.user;

public interface UserService {

     void addUser(UserRequest userRequest);
     Iterable<User> getUsers();

}
