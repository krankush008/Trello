package com.example.Model;

import java.util.ArrayList;

public class Project {
 
    Integer id;
    ArrayList<Subproject> subprojects;

    public Project(){
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

    public ArrayList<Subproject> getSubprojects(){
        return subprojects;
    }

    public Subproject getSubProject(Integer id){
        Subproject subproject = new Subproject();
        for(int i=0;i<subprojects.size();i++){
            if(subprojects.get(i).getId() == id){
                subproject = subprojects.get(i);
            }
        }
        return subproject;
    }

}
