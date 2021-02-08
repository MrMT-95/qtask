package com.company.qtask.role;

import com.company.qtask.user.User;
import com.company.qtask.user.UserResponse;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Role {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany
    private List<User> users;

    //constructors

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
    // methods

    public RoleResponse toRoleResponse() {
        List<UserResponse> usersResponse = this.users.stream()
                .map(User::toUserResponseForRole)
                .collect(Collectors.toList());

        return new RoleResponse(this.id, this.name, usersResponse);
    }

    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
