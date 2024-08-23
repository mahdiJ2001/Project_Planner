package com.projet.mvc.Daoimpl;

import java.util.List;

import com.projet.mvc.Dao.TaskDao;
import com.projet.mvc.entity.Task;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext( unitName = "projetsUnit")
    EntityManager entityManager;

    @Override
    public Task getTaskById(String taskId) {
        return entityManager.find(Task.class, taskId);
    }

    @Override
    public void addTask(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void updateTask(Task task) {
        entityManager.merge(task);
    }

    @Override
    public void removeTask(Task task) {
        Task managedTask = entityManager.find(Task.class, task.getCode());
        if (managedTask != null) {
            entityManager.remove(managedTask);
        }
    }
    @Override
    public List<Task> listTasks() {
        String jpql = "SELECT t FROM Task t";
        Query query = entityManager.createQuery(jpql, Task.class);
        return query.getResultList();
    }
}