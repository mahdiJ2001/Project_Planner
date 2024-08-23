<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styles.css">
    <title>About Us</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Change font family */
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
            margin-top: 20px;
        }

        .about-us-container {
            width: 80%;
            margin: 20px auto;
            position: relative;
            top: 180px; 
            color: rgb(0, 0, 0); 
            background-color: rgba(255, 255, 255, 0.8); 
            padding: 20px; 
            border-radius: 10px; 
        }

        

        h1 {
            color: #646262; 
        }

        p {
            font-size: 1.6em;
            line-height: 1.6;
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
    <div class="elementor-container about-us-container">
        <h1>About Us</h1>
        <p>This is a project in the subject J2EE during the first semester of our second year at ENIT. I am Mahdi Jellali, a second-year software student, and this is my Project.</p>
    </div>
</div>

</body>
</html>