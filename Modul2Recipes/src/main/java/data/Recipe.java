package data;

import java.util.List;

public class Recipe {
    private User user; 
    private int id, cookingtime, user_id;
    private String name, description, image, todo;
    private List<Ingredient> ingredients;

    public Recipe(int id, int cookingtime, int user_id, String name, String description, String image, String todo) {
        this.id = id;
        this.cookingtime = cookingtime;
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.todo = todo;
    }

    public Recipe(int id, int cookingtime, String name, String description, String todo) {
        this.id = id;
        this.cookingtime = cookingtime;
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.todo = todo;
    }

    public Recipe(String name, String todo, String description, int cookingtime, int user_id, List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.name = name;
        this.todo = todo;
        this.cookingtime = cookingtime;
        this.user_id = user_id;
    }

    Recipe(String name, String todo, int cookingtime, String image, List<Ingredient> listIngredients) {
        this.ingredients = listIngredients;
        this.name = name;
        this.todo = todo;
        this.cookingtime = cookingtime;
        this.image = image;
    }
    
    public Recipe(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Recipe(String name) {
        this.name = name;
    }
    
    public void addIngredientToRecipe(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(int cookingtime) {
        this.cookingtime = cookingtime;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribtion() {
        return description;
    }

    public void setDescribtion(String describtion) {
        this.description = describtion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public User getUser() {
        return user;
    }
    

    public String toString1() {
        return "{" + name + '}';
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", cookingtime=" + cookingtime + ", name=" + name + ", description=" + description + ", image=" + image + ", todo=" + todo + '}';
    }

}
