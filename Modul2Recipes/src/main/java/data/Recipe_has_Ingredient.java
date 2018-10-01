/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author leage
 */
public class Recipe_has_Ingredient {
    private int recipe_id; 
    private int ingredients_id; 
    private String amount, measure;
    private Recipe recipe;

    public Recipe_has_Ingredient(int recipe_id, int ingredients_id, String amount, String measure, Recipe recipe) {
        this.recipe_id = recipe_id;
        this.ingredients_id = ingredients_id; 
        this.amount = amount;
        this.measure = measure;
        this.recipe = recipe;
        
    }
    public Recipe_has_Ingredient(int recipe_id, String amount, String measure, Recipe recipe) {
        this.recipe_id = recipe_id; 
        this.amount = amount;
        this.measure = measure;
        this.recipe = recipe;
        
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
    
    
    
}
