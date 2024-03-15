package com.example.Model;

import java.util.ArrayList;

public class SubprojectManager {
    
    ArrayList<Task> tasks;

    public SubprojectManager(){
        this.tasks = new ArrayList<Task>();
    }

    public void setTask(Task task){
        tasks.add(task);
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
