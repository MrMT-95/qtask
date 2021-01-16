package com.company.qtask.user;


import com.company.qtask.role.Role;
import com.company.qtask.task.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty("name")
    private String name;

    @ManyToOne
    private Role role;

    @OneToMany
    private List<Task> tasks;

    public User(String name) {
    }

    public User() {
        
    }

    //constructors



    //getters and setters
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

