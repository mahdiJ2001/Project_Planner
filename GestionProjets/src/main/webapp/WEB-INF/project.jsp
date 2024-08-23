<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styles.css">
    <title>Project Details</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .background-image {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background: url('https://websitedemos.net/wordpress-agency-04/wp-content/uploads/sites/98/2019/11/hero-bg.jpg') no-repeat center center fixed;
            background-size: cover;
            opacity: 1;
            z-index: -1;
            height: 100vh;
        }

        .navbar {
            overflow: hidden;
            background-color: #333;
            z-index: 2;
            position: fixed;
            width: 100%;
            top: 0;
        }

        .elementor-section.elementor-top-section {
            position: relative;
            z-index: 1;
            margin-top: 90px;
        }

        form {
            width: 80%;
            margin: 20px auto;
            position: relative;
            top: 130px; 
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        input {
            width: 100%;
            padding: 5px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <a href="home.jsp" class="active">Home</a>
    <a href="ProjectController?action=List%20Of%20Projects">Projects</a>
    <a href="TaskController?action=List%20Of%20Tasks">Tasks</a>
    <a href="ProjectController">Add Project</a>
    <a href="TaskController">Add Task</a>
    <div class="project-planner-container">
        <div class="project-planner">Project Planner</div>
    </div>
</div>

<div class="elementor-section elementor-top-section">
    <div class="elementor-container">
        <form action="/GestionProjets/ProjectController" method="post">
            <table border="1">
                <tr>
                    <td>Project Code:</td>
                    <td><input type="text" name="code" value="${model.project.code}" placeholder="Code"/></td>
                </tr>
                <tr>
                    <td>Project Description:</td>
                    <td><input type="text" name="description" value="${model.project.description}" placeholder="Description" /></td>
                </tr>
                <tr>
                    <td>Start Date:</td>
                    <td><input type="date" name="startDate" value="${model.project.startDate}"  placeholder="yyyy-mm-dd"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="Create Project" /></td>
                    <td><input type="submit" name="action" value="Update Project" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="Remove Project" /></td>
                    <td><input type="submit" name="action" value="List Of Projects" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>