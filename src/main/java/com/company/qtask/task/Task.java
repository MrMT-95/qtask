package com.company.qtask.task;

import com.company.qtask.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

    @Id
    private Integer id;


    @ManyToOne
    private User user;
}
