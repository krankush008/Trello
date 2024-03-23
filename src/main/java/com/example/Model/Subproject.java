package com.example.Model;

import java.util.ArrayList;

public class Subproject {
    
    Integer id;
    ArrayList<Task> tasks;

    public Subproject(Integer id){
        this.id = id;
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

    public void setUser(Integer taskId, User user){
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).getTaskId() == taskId){
                tasks.get(i).setUser(user);
            }
        }
    }

}
