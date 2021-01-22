package com.company.qtask.user;

import com.company.qtask.role.Role;
import com.company.qtask.role.RoleResponse;
import com.company.qtask.task.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class User {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("login")
    private String login;
    private String firstName;
    private String password;
    private String status; /* active or deleted */

    @ManyToOne
    private Role role;

    @OneToMany
    private List<Task> tasks;

    //constructors


    public User(String login, String firstName, String password,String status, Role role) {
        this.login = login;
        this.firstName = firstName;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public User() {

    }

    //methods

    public UserResponse toUserResponse (){
        RoleResponse roleResponse = new RoleResponse(this.role.getName());
        return new UserResponse(this.id,this.login,this.firstName,this.status,roleResponse,this.tasks);
    }

    //getters and setters
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

