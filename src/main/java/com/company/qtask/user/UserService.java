package com.company.qtask.user;

public interface UserService {

    Iterable<UserResponse> getUsers();

    void registerUser(UserRequest userRequest);

    void deleteUser(String email);

    void loginUser(UserLogin userLogin);

    void updateUser(UserUpdate userUpdate);
}
