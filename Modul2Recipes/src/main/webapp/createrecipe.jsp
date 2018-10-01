<%-- 
    Document   : createrecipe
    Created on : 25-09-2018, 11:02:00
    Author     : Yeha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css.css">
  


    </head>
    <body>
        
        
        <form method="POST" action="Control">
            Recipe name:<br>
            <input type="text" name="name" value="Type in name of your recipe"><br><br>
            
            Instructions:<br>
            <textarea id="hej" name="todo" rows="10" cols="30">Type in the instruction for your recipe here</textarea><br><br>

            Description:<br>
            <textarea id="hej" name="ingredients" rows="10" cols="30">Type in the decription for your recipe here</textarea><br><br>
            
            Cooking time:<br>
            <textarea id="hej" name="ingredients" rows="1" cols="2">45</textarea><br><br>

            <input type="submit" value="Add new recipe" onclick="window.location.href = 'Control?origin=createrecipe'">
        </form>
    </body>
</html>



