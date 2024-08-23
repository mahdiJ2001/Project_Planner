package com.projet.mvc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Project implements Serializable {
    @Id
    @Column(unique = true)
    private String code;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;


    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@OneToMany(mappedBy = "project" ,  fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

    public void addTaskToProject(Task task) {
        tasks.add(task);
        task.setProject(this);
    }

    public void removeTaskFromProject(Task task) {
        tasks.remove(task);
        task.setProject(null);
    }
}