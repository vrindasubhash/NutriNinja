package entity;

import java.util.List;

public class UserPreference {
    private NutrientRange nutrientRange;
    private List<String> health;
    private List<String> dishType;


    public UserPreference(NutrientRange nutrientRange, List<String> health, List<String> dietPreference, List<String> cuisinePreference) {
        this.nutrientRange = nutrientRange;
        this.health = health;
        this.dishType = dietPreference;
    }

    public NutrientRange getNutrientRange() {
        return nutrientRange;
    }

    public void setNutrientRange(NutrientRange nutrientRange) {
        this.nutrientRange = nutrientRange;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getDishType() {
        return dishType;
    }

    public void setDishType(List<String> dishType) {
        this.dishType = dishType;
    }

}
