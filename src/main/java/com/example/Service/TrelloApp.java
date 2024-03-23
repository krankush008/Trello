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

    public void addTasks(Integer projectId, Integer subProjectId, Task task){
        ArrayList<Project> projects = projectManager.getProjects();
        for(int i=0; i<projects.size(); i++){
            if(projects.get(i).getId()==projectId){
                projects.get(i).addTask(subProjectId, task);
            }
        }
    }

    public void addUser(Integer projectId, Integer subProjectId, Integer taskId, User user){
        ArrayList<Project> projects = projectManager.getProjects();
        for(int i=0; i<projects.size(); i++){
            if(projects.get(i).getId()==projectId){
                projects.get(i).setUser(subProjectId, taskId, user);
            }
        }
    }

    public Project getProject(int projectId){
        ArrayList<Project> projects = projectManager.getProjects();
        Project project = new Project(0);
        for(int i=0; i<projects.size(); i++){
            if(projects.get(i).getId()==projectId){
                project = projects.get(i);
            }
        }
        return project;
    }

    public ArrayList<Task> getTasksByProjectIdSubProjectId(Integer projectId, Integer subprojectId){
        ArrayList<Project> projects = projectManager.getProjects();
        ArrayList<Task> tasks = new ArrayList<>(); 
        for(int i=0;i<projects.size();i++){
            if(projects.get(i).getId() == projectId){
                ArrayList<Subproject> subProjects = projects.get(i).getSubprojects();
                for(int j=0;j<subProjects.size();j++){
                    if(subProjects.get(j).getId()==subprojectId){
                        tasks = subProjects.get(j).getTasks();
                    }
                }
            }
        } 
        return tasks;
    }

    public ArrayList<Task> getTasksByUserId(Integer userId){
        ArrayList<Project> projects = projectManager.getProjects();
        ArrayList<Task> tasks = new ArrayList<>(); 
        for(int i=0;i<projects.size();i++){
            ArrayList<Subproject> subProjects = projects.get(i).getSubprojects();
            for(int j=0;j<subProjects.size();j++){
                for(int k=0;k<subProjects.get(j).getTasks().size();k++){
                    if(subProjects.get(j).getTasks().get(k).getUser().getId()==userId){
                        tasks.add(subProjects.get(j).getTasks().get(k));
                    }
                }
            }
        } 
        return tasks;
    }

    public User getUser(Integer projectId, Integer subprojectId, Integer taskId){
        ArrayList<Project> projects = projectManager.getProjects();
        User user = new User(0, ""); 
        for(int i=0;i<projects.size();i++){
            if(projects.get(i).getId() == projectId){
                ArrayList<Subproject> subProjects = projects.get(i).getSubprojects();
                for(int j=0;j<subProjects.size();j++){
                    if(subProjects.get(j).getId()==subprojectId){
                        ArrayList<Task> tasks = subProjects.get(j).getTasks();
                        for(int k=0;k<tasks.size();k++){
                            if(tasks.get(k).getTaskId()==taskId){
                                user = tasks.get(k).getUser();
                            }
                        }
                    }
                }
            }
        } 
        return user;
    }

    public void removeUser(Integer projectId, Integer subProjectId, Integer taskId){
        addUser(projectId, subProjectId, taskId, null);
    }

    public void printTasks(User user){
        ArrayList<Project> projects = projectManager.getProjects();
        for(int i=0;i<projects.size();i++){
            ArrayList<Subproject> subProjects = projects.get(i).getSubprojects();
            for(int j=0;j<subProjects.size();j++){
                ArrayList<Task> tasks = subProjects.get(j).getTasks();
                for(int k=0;k<tasks.size();k++){
                    if(tasks.get(k).getUser()!=null && tasks.get(k).getUser().getId()==user.getId()){
                        System.out.println("user id = "+user.getId()+" project id = "+projects.get(i).getId()+" task id = "+tasks.get(k).getTaskId());
                    }
                }
            }
        } 
    }


}
