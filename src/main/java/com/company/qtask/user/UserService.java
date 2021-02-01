package com.company.qtask.user;

public interface UserService {

    Iterable<UserResponse> getUsers();

    void registerUser(UserRequest userRequest);

    void deleteUser();
}
