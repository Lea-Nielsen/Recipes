
package data;

import java.util.ArrayList;

public class Recipes {
    
    private ArrayList<Recipe> recipes;

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Recipes{" + "recipes=" + recipes + '}';
    }
    
    
}
