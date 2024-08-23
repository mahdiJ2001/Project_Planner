package com.projet.mvc.Daoimpl;

import java.util.List;

import com.projet.mvc.Dao.ProjectDao;
import com.projet.mvc.entity.Project;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext( unitName="projetsUnit")
    EntityManager entityManager;

    @Override
    public List<Project> listProjects() {
        String jpqlQuery = "SELECT p FROM Project p";
        Query query = entityManager.createQuery(jpqlQuery, Project.class);

        return query.getResultList();
    }
    
    @Override
    public Project getProjectById(String projectId) {
        return entityManager.find(Project.class, projectId);
    }

    @Override
    public void addProject(Project project) {
        entityManager.persist(project);
    }

    @Override
    public void updateProject(Project project) {
        entityManager.merge(project);
      
    }

    @Override
    public void removeProject(Project project) {
        Project managedProject = entityManager.find(Project.class, project.getCode());
        if (managedProject != null) {
            entityManager.remove(managedProject);
        }
    }
}
