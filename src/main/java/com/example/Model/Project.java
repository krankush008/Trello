package com.example.Model;

import java.util.ArrayList;

public class Project {
 
    Integer id;
    ArrayList<Subproject> subprojects;

    public Project(Integer id){
        this.id = id;
        this.subprojects = new ArrayList<>();
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }


    public void setSubProject(Subproject subproject){
        subprojects.add(subproject);
    }

    public void addTask(Integer subprojectId, Task task){
        for(int i=0; i<subprojects.size(); i++){
            if(subprojects.get(i).getId() == subprojectId){
                subprojects.get(i).setTask(task);
            }
        }
    }

    public void setUser(Integer subprojectId, Integer taskId, User user){
        for(int i=0; i<subprojects.size(); i++){
            if(subprojects.get(i).getId() == subprojectId){
                subprojects.get(i).setUser(taskId, user);
            }
        }
    }

    public ArrayList<Subproject> getSubprojects(){
        return subprojects;
    }

    public Subproject getSubProject(Integer id){
        Subproject subproject = new Subproject(id);
        for(int i=0;i<subprojects.size();i++){
            if(subprojects.get(i).getId() == id){
                subproject = subprojects.get(i);
            }
        }
        return subproject;
    }

}
