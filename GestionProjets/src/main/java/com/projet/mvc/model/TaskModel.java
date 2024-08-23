package com.projet.mvc.model;

import java.util.ArrayList;
import java.util.List;

import com.projet.mvc.entity.Task;


public class TaskModel {
    private Task task = new Task();
    private List<Task> tasks = new ArrayList<>();
    private String errors;


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}