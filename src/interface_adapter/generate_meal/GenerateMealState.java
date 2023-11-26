package interface_adapter.generate_meal;

public class GenerateMealState {

    public String getMeal_label() {
        return meal_name;
    }

    public void setMeal_label(String meal_label) {
        this.meal_name = meal_label;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getMeal_calories() {
        return meal_calories;
    }

    public void setMeal_calories(double meal_calories) {
        this.meal_calories = meal_calories;
    }

    public double getMeal_protein() {
        return meal_protein;
    }

    public void setMeal_protein(double meal_protein) {
        this.meal_protein = meal_protein;
    }

    public double getMeal_carbs() {
        return meal_carbs;
    }

    public void setMeal_carbs(double meal_carbs) {
        this.meal_carbs = meal_carbs;
    }

    public double getMeal_fat() {
        return meal_fat;
    }

    public void setMeal_fat(double meal_fat) {
        this.meal_fat = meal_fat;
    }

    public String getIngredients_label() {
        return ingredients_label;
    }

    public void setIngredients_label(String ingredients_label) {
        this.ingredients_label = ingredients_label;
    }

    public String getRecipe_label() {
        return recipe_label;
    }

    public void setRecipe_label(String recipe_label) {
        this.recipe_label = recipe_label;
    }

    public String meal_name = "";
    public String image_url = ""; //URL of image
    public double meal_calories = 0;
    public double meal_protein = 0;
    public double meal_carbs = 0;
    public double meal_fat = 0;


    //INGREDIENTS
    public String ingredients_label = "";


    //Recipe
    public String recipe_label = ""; //url of recipe

    public GenerateMealState(GenerateMealState copy){
        this.meal_name = copy.meal_name;
        this.image_url = copy.image_url;
        this.meal_calories = copy.meal_calories;
        this.meal_protein = copy.meal_protein;
        this.meal_carbs = copy.meal_carbs;
        this.meal_fat = copy.meal_fat;
        this.ingredients_label = copy.ingredients_label;
        this.recipe_label = copy.recipe_label;
    }

    //Explicit default constructor
    public GenerateMealState(){
    }


}
