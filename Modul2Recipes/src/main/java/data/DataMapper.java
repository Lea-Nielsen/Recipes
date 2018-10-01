package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public Recipe_has_Ingredient getRecipeDetails(int id) {
        Recipe_has_Ingredient recipedetails = null;
        List<Ingredient> listIngredients;
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT r.id, r.name, r.todo, r.image, r.cookingtime, rhi.amount, rhi.measure, i.name FROM recipe r JOIN recipe_has_ingredient rhi ON rhi.recipe_id = r.id JOIN ingredient i ON rhi.ingredient_id = i.id WHERE r.id = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int r_id = rs.getInt("id");
                String r_name = rs.getString("name");
                String r_todo = rs.getString("todo");
                String r_image = rs.getString("image");
                int r_cookingtime = rs.getInt("cookingtime");
                String rd_amount = rs.getString("amount");
                String rd_measureType = rs.getString("measure");
                System.out.println(r_id);
                //String rd_ingredients_name = rs.getString("ingredients_name");
                //listIngredients.add(new Ingredient(rd_ingredients_name));
                listIngredients = getIngredientsByRecipe(r_id);
                recipedetails = new Recipe_has_Ingredient(r_id, rd_amount, rd_measureType, new Recipe(r_name, r_todo, r_cookingtime, r_image, listIngredients));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return recipedetails;
    }
//    public ArrayList<Recipe> getRecipes() {
//        ArrayList<Recipe> recipesList = new ArrayList();
//        try {
//            Connection conn = new DBConnector().getConnection();
//            String sql = "SELECT id, name FROM recipe";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                int r_id = rs.getInt("id");
//                String r_name = rs.getString("name");
//                
//                
//                recipesList.add(new Recipe(r_id, r_name));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } 
//
//        return recipesList;
//    }

    public List<Ingredient> getIngredientsByRecipe(int recipe_id) {
        List<Ingredient> ingredientsInRecipe = new ArrayList();
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT `name`, `id` "
                    + "FROM ingredient "
                    + "JOIN recipe_has_ingredient "
                    + "WHERE id = ingredient_id AND recipe_id = " + recipe_id + "";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int r_id = rs.getInt("id");
                String r_name = rs.getString("name");

                ingredientsInRecipe.add(new Ingredient(r_name, r_id));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ingredientsInRecipe;

    }

    public ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipesList = new ArrayList();
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT id, name FROM recipe ORDER BY name";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int r_id = rs.getInt("id");
                String r_name = rs.getString("name");

                recipesList.add(new Recipe(r_id, r_name));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return recipesList;
    }

    public Recipe getRecipebyName(String name) {
        Recipe recipe = null;
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT name, id, description, todo, cookingtime FROM recipe WHERE `name` = '" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String r_name = rs.getString("name");
                String description = rs.getString("description");
                String todo = rs.getString("todo");
                int cookingtime = rs.getInt("cookingtime");
                int id = rs.getInt("id");

                recipe = new Recipe(id, cookingtime, name, description, todo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return recipe;
    }

    public void addIngredient(List<Ingredient> ingredients) {
        String ingredientName = "";
        int ingredientId; 
        try {
            Connection conn = new DBConnector().getConnection();

            for (Ingredient ingredient : ingredients) {
                ingredientName = ingredient.getName();
                ingredientId = ingredient.getId();

                String sql = "INSERT INTO `ingredient` (name)"
                        + "VALUES (?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, ingredientName);
                pstmt.executeUpdate();
                
                
                
            }
//            Ingredient ingredient = new Ingredient(""); 

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createRecipe(Recipe recipe) throws SQLException {
       
        User user = new User(1, "hej", "my");
        try {
            Connection conn = new DBConnector().getConnection();

            String sql = "INSERT INTO `recipe` (name, todo, description, cookingtime, user_id)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, recipe.getName());
            pstmt.setString(2, recipe.getTodo());
            pstmt.setString(3, recipe.getDescribtion());
            pstmt.setInt(4, recipe.getCookingtime());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
           
            
            
        } //            Ingredient ingredient = new Ingredient(""); 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addIngredientIdAndRecipeId(int recipe_id, int ingredient_id, String amount, String measure){
                
        try {
            Connection conn = new DBConnector().getConnection();

            String sql = "INSERT INTO `recipe_has_ingredient` (recipe_id, ingredient_id, amount, measure)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, recipe_id);
            pstmt.setInt(2, ingredient_id);
            pstmt.setString(3, amount);
            pstmt.setString(4, measure); 
            pstmt.executeUpdate();
            
            
           
            
            
        } //            Ingredient ingredient = new Ingredient(""); 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
      public List<Ingredient> getAllIngredients() {
        List<Ingredient> allIngredients = new ArrayList();
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT `name`, `id` "
                    + "FROM ingredient ";
               
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ingredient_id = rs.getInt("id");
                String ingredient_name = rs.getString("name");

                allIngredients.add(new Ingredient(ingredient_name, ingredient_id));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allIngredients;

    }

    //    

    public static void main(String[] args) throws SQLException {

        DataMapper dataMapper = new DataMapper();
        List<Ingredient> ingredients = new ArrayList();
        ingredients.add(new Ingredient("hest"));
        ingredients.add(new Ingredient("ost"));
        ingredients.add(new Ingredient("mad"));
        ingredients.add(new Ingredient("pølse"));

        dataMapper.addIngredient(ingredients);
        Recipe recipe = new Recipe("pølse is", "tomat og mad", "lækker æzsjkfdpoamf lkfdnms", 20, 1, ingredients);
        dataMapper.createRecipe(recipe);
        dataMapper.addIngredient(ingredients);
        
        
        //dataMapper.addIngredientIdAndRecipeId(0, 0);


}

    public void sortMeasureAndAmount(String ingredients) {
        String[] ingredient = ingredients.split(";");
    }
    
   
}
