package interface_adapter.save_preferences;

import entity.NutrientRange;

public class SaveState {
    private NutrientRange nutrientRange = new NutrientRange(new Range(), new Range(), new Range(), new Range());
    private String healthPreferences = "";
    private String dishType = "";

    public SaveState(SaveState copy) {
        nutrientRange = copy.nutrientRange;
        healthPreferences = copy.healthPreferences;
        dishType = copy.dishType;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SaveState() {}

    public NutrientRange getNutrientRange() {
        return nutrientRange;
    }

    public String getHealthPreferences() {
        return healthPreferences;
    }

    public String getDishType() {
        return dishType;
    }

    public void setNutrientRange(NutrientRange nutrientRange) {
        this.nutrientRange = nutrientRange;
    }

    public void setHealthPreferences(String healthPreferences) {
        this.healthPreferences = healthPreferences;
    }

    public void setDishType(String dishType) {this.dishType = dishType;}


}
