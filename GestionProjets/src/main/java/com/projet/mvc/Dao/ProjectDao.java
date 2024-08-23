package com.projet.mvc.Dao;

import com.projet.mvc.entity.Project;
import com.projet.mvc.entity.Task;

import java.util.List;


public interface ProjectDao {
    Project getProjectById(String projectId);
    void addProject(Project project);
    void updateProject(Project project);
    void removeProject(Project project);    
    List<Project> listProjects();
}