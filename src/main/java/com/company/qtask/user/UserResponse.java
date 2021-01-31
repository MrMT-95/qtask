package com.company.qtask.user;

import com.company.qtask.role.RoleResponse;
import com.company.qtask.task.Task;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserResponse {

    //attributes
    private Integer id;
    private String email;
    private String firstName;
    private String status; // active or not active
    private RoleResponse role;
    private List<Task> tasks;


    //user list response


    public UserResponse(Integer id, String email, String firstName, String status, RoleResponse role, List<Task> tasks) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.status = status;
        this.role = role;
        this.tasks = tasks;
    }

    // role list response

    public UserResponse(Integer id, String email, String firstName, String status, List<Task> tasks){
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.status = status;
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
