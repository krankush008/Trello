package com.example.Service;

import java.util.ArrayList;

import com.example.Model.Project;
import com.example.Model.ProjectManager;
import com.example.Model.Subproject;
import com.example.Model.Task;
import com.example.Model.User;

public class TrelloApp {
    
    ProjectManager projectManager;

    public TrelloApp(){
        projectManager = new ProjectManager();
    }

    public void addProject(Project project){
        projectManager.setProject(project);
    }

    public void printTasks(User user){
        ArrayList<Project> projects = projectManager.getProjects();
        for(int i=0;i<projects.size();i++){
            ArrayList<Subproject> subProjects = projects.get(i).getSubprojects();
            for(int j=0;j<subProjects.size();j++){
                ArrayList<Task> tasks = subProjects.get(j).getTasks();
                for(int k=0;k<tasks.size();k++){
                    if(tasks.get(k).getUser().getId()==user.getId()){
                        System.out.println("project id = "+projects.get(i).getId()+" task id = "+tasks.get(k).getTaskId());
                    }
                }
            }
        } 
    }
}
