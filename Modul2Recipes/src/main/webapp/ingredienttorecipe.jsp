<%-- 
    Document   : newjspingredienttorecipe
    Created on : 26-09-2018, 10:02:38
    Author     : leage
--%>

<%@page import="data.Recipe"%>
<%@page import="java.util.List"%>
<%@page import="data.Ingredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="">

        <div class="topnav">
            <a href="http://localhost:8084/recipies_yes/Control?origin=index">Home</a>
            <a href="http://localhost:8084/recipies_yes/Control?origin=showrecipes">Recipes</a>
            <a class="active" href="http://localhost:8084/recipies_yes/Control?origin=ingredients">Ingredients</a>
            <a href="#about">About</a>
        </div> 

        <% List<Ingredient> i_list = (List) request.getSession().getAttribute("Ingredient");%>
        <% List<Recipe> r_list = (List) request.getSession().getAttribute("Recipe");%>


        <div id="content">
            <h1 id="overskrift" align="center">
                <%= "test"%>
            </h1>
            <br><br>
            <h2 id="overskrift2" >Ingredients</h2>
            <br>
            <form method="POST" action="Control">
                Ingredients:<br>
                <select name="Ingredient">
                    <%
                        for (Ingredient i : i_list) {
                            out.println("<option value=\"" + i.getId() + "\" >" + i.getName() + "</option>");
                        }
                    %>
                </select>
                <br>
                <br>
                Recipe:<br>
                <select name="Recipe">
                    <%
                        for (Recipe r : r_list) {
                            out.println("<option value=\"" + r.getId() + "\" >" + r.getName() + "</option>");
                        }
                    %>
                </select>
                <br>
                <br>
                Amount:
                <input type="text" name="amount" value="1"><br><br>
                Measure:
                <input type="text" name="measure" value="g"><br><br>
                <input type="hidden" name="origin" value="ingredienttorecipe"><br><br>
                <input type="submit" value="Link ingredient to recipe"><br><br>
            </form>


            <ul id="liste" style="list-style-type:circle">
                <%
                    for (Ingredient i : i_list) {
                        out.println("<li>" + i.getId() + i.getName() + "</li><br>");
                    }
                %>
                <br>
                <br>
                <br>
                <ul id="liste" style="list-style-type:circle">
                    <%
                        for (Recipe r : r_list) {
                            out.println("<li>" + r.getId() + r.getName() + "</li><br>");
                        }
                    %>                

                </ul> 
        </div>

    </body>
</html>
