/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataMapper;
import data.Ingredient;
import data.Recipe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leage
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    //DataMapper dataMapper = new DataMapper(); 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DataMapper dataMapper = new DataMapper();

        String origin = request.getParameter("origin");

        if (origin == null) {
            origin = "showrecipes";
        }

        switch (origin) {
            case "index":
                request.getSession().setAttribute("allRecipes", dataMapper.getAllRecipes());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "showrecipes":
                request.getSession().setAttribute("allRecipes", dataMapper.getAllRecipes());
                request.getRequestDispatcher("showrecipes.jsp").forward(request, response);
                break;
            case "showSingleRecipe":
                int recipeId = Integer.parseInt(request.getParameter("recipeId"));
                request.setAttribute("recipeDetails", dataMapper.getRecipeDetails(recipeId));
                request.getRequestDispatcher("recipe.jsp").forward(request, response);
                break;
            case "createrecipe":
                request.getParameter("name");
                request.getParameter("todo");
                String ingredients = request.getParameter("ingredients");
//                dataMapper.createRecipe(new Recipe);
                dataMapper.sortMeasureAndAmount(ingredients);
                break;
            case "ingredientvalue":
                request.getParameter("ingredientvalue");
                break;
            case "ingredients":
                List<Ingredient> allIngredients = dataMapper.getAllIngredients();
                List<Recipe> allRecipes = dataMapper.getAllRecipes();
                request.getSession().setAttribute("Ingredient", allIngredients);
                request.getSession().setAttribute("Recipe", allRecipes);
                request.getRequestDispatcher("ingredienttorecipe.jsp").forward(request, response);
                break;
            case "ingredienttorecipe":
                int recipe_id = Integer.parseInt(request.getParameter("Recipe"));
                int ingredient_id = Integer.parseInt(request.getParameter("Ingredient"));
                String amount = request.getParameter("amount");
                String measure = request.getParameter("measure");
                System.out.println(recipe_id);
                System.out.println(ingredient_id);
                System.out.println(amount);
                System.out.println(measure);
                dataMapper.addIngredientIdAndRecipeId(recipe_id, ingredient_id, amount, measure);
                break;

            //generate fields based on number input
            //sendRedirect!!!!
            //if numinput = 1,2,3 
        }

//        //Get data from jsp form
//        String username = request.getParameter("user");
//        String password = request.getParameter("password");
//        request.getSession().setAttribute("username", username);
//        request.getSession().setAttribute("password", password);
//        
//        request.setAttribute("username", username);
//        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
