package com.projet.mvc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.projet.mvc.Dao.ProjectDao;
import com.projet.mvc.Dao.TaskDao;
import com.projet.mvc.entity.Project;
import com.projet.mvc.entity.Task;
import com.projet.mvc.model.TaskModel;
 

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation classTaskController
 */


@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @EJB
    private TaskDao metier;

    @Inject
    private ProjectDao projetDao;

    @Override
    public void init() throws ServletException {
    }

	/**
     * @see HttpServlet#HttpServlet()
     */

    
    public TaskController() {
        super();
    }


    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskModel model = new TaskModel();
        request.setAttribute("model", model);
        String action = request.getParameter("action");
        List<Project> projects = projetDao.listProjects();
        request.setAttribute("projects", projects);
        
        if (action != null) {
            if (action.equals("Create Task")) {
                try {
                	String selectedProjectCode = request.getParameter("selectedProjectCode");
                	Project selectedProject = projetDao.getProjectById(selectedProjectCode);
                	String startDateString = request.getParameter("taskStartDate");
                	String endDateString = request.getParameter("taskEndDate");
                	if (startDateString != null && endDateString!=null && !startDateString.isEmpty() && !endDateString.isEmpty()  ) {
                    Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
                    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);           
                    model.getTask().setStartDate(startDate);
                    model.getTask().setEndDate(endDate);
                	}
                	model.getTask().setCode(request.getParameter("taskCode"));
                	model.getTask().setDescription(request.getParameter("taskDescription"));               	
                	model.getTask().setProject(selectedProject);  
                	model.setTask(model.getTask());  
                    metier.addTask(model.getTask()); 
                    model.setTasks(metier.listTasks());
                    request.getRequestDispatcher("/WEB-INF/successInsertTask.jsp").forward(request, response);
                } catch (Exception e) {
                	model.setErrors(e.getMessage());
                	request.getRequestDispatcher("/WEB-INF/failedInsertTask.jsp").forward(request, response);
                } 
            } else if (action.equals("Update Task")) {
            	try {
            	String selectedProjectCode = request.getParameter("selectedProjectCode");
            	Project selectedProject = projetDao.getProjectById(selectedProjectCode);
                String taskCode = request.getParameter("taskCode");                
                String taskDescription = request.getParameter("taskDescription");
                String startDateStr = request.getParameter("taskStartDate");
                String endDateStr = request.getParameter("taskEndDate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate;
                Date endDate;
                try {
		            startDate = dateFormat.parse(startDateStr);
		            endDate = dateFormat.parse(endDateStr);
	                model.getTask().setStartDate(startDate);
	                model.getTask().setEndDate(endDate);
		     } catch (ParseException e) {
		            e.printStackTrace(); 
		     }     
                model.getTask().setCode(taskCode);
                model.getTask().setDescription(taskDescription);
                model.getTask().setProject(selectedProject);
                model.setTask(model.getTask());               
                metier.updateTask(model.getTask()); 
                request.getRequestDispatcher("/WEB-INF/successUpdateTask.jsp").forward(request, response);}
            	catch (Exception e) {
            		model.setErrors(e.getMessage());
            		request.getRequestDispatcher("/WEB-INF/failedUpdateTask.jsp").forward(request, response);
            	}
            } else if (action.equals("Remove Task")) {
                try {
            	String taskCode = request.getParameter("taskCode");
                Task taskToDelete = metier.getTaskById(taskCode);
                metier.removeTask(taskToDelete);
                model.setTasks(metier.listTasks());
                request.getRequestDispatcher("/WEB-INF/successRemoveTask.jsp").forward(request, response);}
                catch (Exception e) {
                	model.setErrors(e.getMessage());
                	request.getRequestDispatcher("/WEB-INF/failedRemoveTask.jsp").forward(request, response);
                }
            } else if (action.equals("List Of Tasks")) {
                model.setTasks(metier.listTasks());
                request.getRequestDispatcher("/WEB-INF/listTasks.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("/WEB-INF/task.jsp").forward(request, response);
    }
}