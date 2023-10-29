package entity;

import java.util.List;

public class Meal {
    private MealType mealType;
    private String name;
    private Nutrients nutrients;
    private List<Ingredient> ingredients;
    private List<HealthPreference> healthPreferences;
    private List<DietPreference> dietPreference;
    private List<CuisinePreference> cuisinePreference;

    public Meal(MealType mealType, String name, Nutrients nutrients, List<Ingredient> ingredients, List<HealthPreference> healthPreferences, List<DietPreference> dietPreference, List<CuisinePreference> cuisinePreference) {
        this.mealType = mealType;
        this.name = name;
        this.nutrients = nutrients;
        this.ingredients = ingredients;
        this.healthPreferences = healthPreferences;
        this.dietPreference = dietPreference;
        this.cuisinePreference = cuisinePreference;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<HealthPreference> getHealthPreferences() {
        return healthPreferences;
    }

    public void setHealthPreferences(List<HealthPreference> healthPreferences) {
        this.healthPreferences = healthPreferences;
    }

    public List<DietPreference> getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(List<DietPreference> dietPreference) {
        this.dietPreference = dietPreference;
    }

    public List<CuisinePreference> getCuisinePreference() {
        return cuisinePreference;
    }

    public void setCuisinePreference(List<CuisinePreference> cuisinePreference) {
        this.cuisinePreference = cuisinePreference;
    }
}
