package com.example.Model;

import java.util.ArrayList;

public class Subproject {
    
    Integer id;
    ArrayList<Task> tasks;

    public Subproject(){
        this.tasks =  new ArrayList<>();
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void setTask(Task task){
        tasks.add(task);
    }
}
