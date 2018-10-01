<%-- 
    Document   : userLogin
    Created on : 24-09-2018, 12:52:28
    Author     : morte
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="data.Recipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>

        <link rel="stylesheet" href="css.css">

    </head>

    <body background="spaghetti.jpg">

        <div class="topnav">
            <a href="http://localhost:8084/recipies_yes/Control?origin=index">Home</a>
            <a class="active" href="http://localhost:8084/recipies_yes/Control?origin=showrecipes">Recipes</a>
            <a href="http://localhost:8084/recipies_yes/Control?origin=ingredients">Ingredients</a>
            <a href="#about">About</a>
        </div> 


        <% List<Recipe> listOfAllRecipes = (List) request.getSession().getAttribute("allRecipes");%>

        <div id="content">
            <h1 id="overskrift" align="center">LeMoNiMa <br>Recipes</h1>


            <div id="listedrecipes">

                <h2 id="overskrift2" >Our recipes are listed below</h2>
                <br>

                <ul id="liste" style="list-style-type:circle">
                    <%
                        for (Recipe r : listOfAllRecipes) {
                            out.println("<li><a href=\"Control?origin=showSingleRecipe&recipeId=" + r.getId() + "\">" + r.getName() + "</li><br>");
                        }
                    %>
                </ul>

            </div>



        </div>

    </body>

</html>
