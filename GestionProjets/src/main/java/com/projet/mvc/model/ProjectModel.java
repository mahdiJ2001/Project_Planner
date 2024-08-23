package com.projet.mvc.model;

import java.util.ArrayList;
import java.util.List;
import com.projet.mvc.entity.Project;


public class ProjectModel {
    private Project project = new Project();
    private List<Project> projects = new ArrayList<>();
    private String errors;
 


    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }  
}