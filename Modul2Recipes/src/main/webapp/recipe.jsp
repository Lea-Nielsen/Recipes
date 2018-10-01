<%-- 
    Document   : recipe
    Created on : 25-09-2018, 14:13:39
    Author     : morte
--%>

<%@page import="data.Ingredient"%>
<%@page import="data.Recipe_has_Ingredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>

        <link rel="stylesheet" href="css.css">

    </head>

    <body background="book.jpg">

        <div class="topnav">
            <a href="http://localhost:8084/recipies_yes/Control?origin=index">Home</a>
            <a href="http://localhost:8084/recipies_yes/Control?origin=showrecipes">Recipes</a>
            <a href="http://localhost:8084/recipies_yes/Control?origin=ingredients">Ingredients</a>
            <a class="active" href="#about">About</a>
        </div> 


        <% Recipe_has_Ingredient rhi = (Recipe_has_Ingredient) request.getAttribute("recipeDetails");%>

        <div id="content">
            <h1 id="overskrift" align="center">
                <%= rhi.getRecipe().getName()%>
            </h1>

            <div id="stuff">

                <div id="ingredients">
                    <h2 >Ingredients</h2>


                    <ul id="liste" style="list-style-type:circle">
                        <%
                            for (Ingredient i : rhi.getRecipe().getIngredients()) {
                                out.println("<li>" + i.getName() + "</li><br>");
                            }
                        %>
                    </ul> 

                </div>

                <div id="cookingtime">
                    <h2 align="center" >Cookingtime</h2>

                    <p align="center">
                        <%= rhi.getRecipe().getCookingtime()%>
                    </p>

                </div>

                <div id="todo">
                    <h2 id="overskrift2" >ToDo</h2>

                    <p id="todotext">
                        <%= rhi.getRecipe().getTodo()%>
                    </p>

                </div>
            </div>
        </div>

    </body>

</html>
