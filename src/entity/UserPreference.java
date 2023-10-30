package entity;

import java.util.List;

public class UserPreference {
    private NutrientRange nutrientRange;
    private List<HealthPreference> healthPreferences;
    private List<DietPreference> dietPreference;
    private List<CuisinePreference> cuisinePreference;


    public UserPreference(NutrientRange nutrientRange, List<HealthPreference> healthPreferences, List<DietPreference> dietPreference, List<CuisinePreference> cuisinePreference) {
        this.nutrientRange = nutrientRange;
        this.healthPreferences = healthPreferences;
        this.dietPreference = dietPreference;
        this.cuisinePreference = cuisinePreference;
    }

    public NutrientRange getNutrientRange() {
        return nutrientRange;
    }

    public void setNutrientRange(NutrientRange nutrientRange) {
        this.nutrientRange = nutrientRange;
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
