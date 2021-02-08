package com.company.qtask.role;

import com.company.qtask.user.UserResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RoleResponse {

    int id;
    String name;
    List<UserResponse> users;

    public RoleResponse(String name) {
        this.name = name;
    }

    public RoleResponse(int id, String name, List<UserResponse> users) {

        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
