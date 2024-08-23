<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styles.css">
    <title>Home Page</title>
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

    <div class="large-text">
        An Innovative Tool For Project Planning And forward thinking Companies. 
        <div class="button-container">
            <a href="aboutus.jsp" class="about-us-button">About Us</a>
        </div>
    </div>


    <section class="elementor-section elementor-top-section elementor-element elementor-element-6712270 elementor-section-boxed elementor-section-height-default elementor-section-height-default" data-id="6712270" data-element_type="section" data-settings="{&quot;background_background&quot;:&quot;classic&quot;}">
        <div class="elementor-container elementor-column-gap-default">
            <div class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-4a9ef75" data-id="4a9ef75" data-element_type="column">
                <div class="elementor-widget-wrap elementor-element-populated">
                    <div class="elementor-element elementor-element-daa1e89 elementor-widget elementor-widget-image" data-id="daa1e89" data-element_type="widget" data-widget_type="image.default">
                        <div class="elementor-widget-container">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="footer">
        <div class="contact-item">
            <i class="fas fa-map-marker-alt"></i>
            <p>Sousse , Tunisia</p>
        </div>
        <div class="contact-item">
            <i class="far fa-envelope"></i>
            <p>mehdi.jellali@etudiant-enit.utm.tn</p>
        </div>
        <div class="contact-item">
            <i class="fas fa-phone"></i>
            <p>+216 99 402 817</p>
        </div>
    </div>
</body>
</html>