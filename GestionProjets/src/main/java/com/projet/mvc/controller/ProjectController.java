package com.projet.mvc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.projet.mvc.Dao.ProjectDao ; 
import com.projet.mvc.entity.Project;
import com.projet.mvc.model.ProjectModel;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProjectController
 */


@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProjectDao metier ; 
	
	@Override
	public void init() throws ServletException {
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectModel model = new ProjectModel(); 
		request.setAttribute("model", model);
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("Create Project")) {
				try {
					Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
		            model.getProject().setCode(request.getParameter("code"));
		            model.getProject().setDescription(request.getParameter("description"));
		            model.getProject().setStartDate(startDate);
		            metier.addProject(model.getProject());
		            model.setProjects(metier.listProjects());
		            request.getRequestDispatcher("/WEB-INF/successInsertProject.jsp").forward(request, response);
		        } catch (Exception e) {
		            model.setErrors(e.getMessage());
		            request.getRequestDispatcher("/WEB-INF/failedInsertProject.jsp").forward(request, response);
		        }
		    }
			else if (action.equals("Update Project")) {
				try { 
				String code = request.getParameter("code");
			     String description = request.getParameter("description");
			     String startDateStr = request.getParameter("startDate");		
			     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			     Date startDate = null;
			     try {
			            startDate = dateFormat.parse(startDateStr);
			     } catch (ParseException e) {
			            e.printStackTrace(); 
			     } 
			     Project updatedProject = new Project();
			     updatedProject.setCode(code);
			     updatedProject.setDescription(description);
			     updatedProject.setStartDate(startDate);
			     model.setProject(updatedProject);
			     metier.updateProject(updatedProject);
			     request.getRequestDispatcher("/WEB-INF/successUpdateProject.jsp").forward(request, response);}
				catch (Exception e) {
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedUpdateProject.jsp").forward(request, response);
				}
			}
			else if (action.equals("Remove Project")){
				try {
				String projectCode = request.getParameter("code");
				Project projectToDelete = metier.getProjectById(projectCode);
				metier.removeProject(projectToDelete);
				model.setProjects(metier.listProjects());
				 request.getRequestDispatcher("/WEB-INF/successRemoveProject.jsp").forward(request, response);}
				catch (Exception e) {
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedRemoveProject.jsp").forward(request, response);
				}
			}
			else if (action.equals("List Of Projects")) {
				model.setProjects(metier.listProjects());	
				request.getRequestDispatcher("/WEB-INF/listProjects.jsp").forward(request, response);
			}	
		}
		request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);
	}
}


