package entity;

import java.util.List;

public class UserPreference {
    private NutrientRange nutrientRange;
    private List<String> healthPreferences;
    private List<String> dishType;


    public UserPreference(NutrientRange nutrientRange, List<String> health, List<String> dishType) {
        this.nutrientRange = nutrientRange;
        this.healthPreferences = health;
        this.dishType = dishType;
    }

    public NutrientRange getNutrientRange() {
        return nutrientRange;
    }

    public void setNutrientRange(NutrientRange nutrientRange) {
        this.nutrientRange = nutrientRange;
    }

    public List<String> getHealthPreferences() {
        return healthPreferences;
    }

    public void setHealthPreferences(List<String> healthPreferences) {
        this.healthPreferences = healthPreferences;
    }

    public List<String> getDishType() {
        return dishType;
    }

    public void setDishType(List<String> dishType) {
        this.dishType = dishType;
    }

}
