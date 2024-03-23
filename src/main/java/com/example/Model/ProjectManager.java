package com.example.Model;

import java.util.ArrayList;

public class ProjectManager {
    
    ArrayList<Project> projects;
    
    public ProjectManager(){
        projects =  new ArrayList<Project>();
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public void setProject(Project project){
        projects.add(project);
    }

    public Project getProject(Integer projectId){
        Project project = new Project(projectId);
        for(int i=0; i<projects.size(); i++){
            if(projects.get(i).getId() == projectId){
                project = projects.get(i);
            }
        }
        return project;
    }
}
