package com.projet.mvc.Dao;

import com.projet.mvc.entity.Task;
import java.util.List;

public interface TaskDao {
    Task getTaskById(String taskId);
    void addTask(Task task);
    void updateTask(Task task);
    void removeTask(Task task);   
    List<Task> listTasks();
}