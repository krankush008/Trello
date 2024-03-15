package com.example.Model;

public class Task {
    
    Integer id;
    User user;

    public Task(Integer id, User user){
        this.id = id;
        this.user = user;
    }

    public Integer getTaskId(){
        return id;
    }

    public void setTaskId(Integer id){
        this.id = id;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
