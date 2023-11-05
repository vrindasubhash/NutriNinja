package use_case.save_preferences;

import entity.NutrientRange;

import java.util.List;

public class SaveInputData {

    private final NutrientRange nutrientRange;
    private final String healthPreference;
    private final String dietPreference;
    private final String cuisinePreference;


    public SaveInputData(NutrientRange nutrientRange, String healthPreference, String dietPreference, String cuisinePreference) {
        this.nutrientRange = nutrientRange;
        this.healthPreference = healthPreference;
        this.dietPreference = dietPreference;
        this.cuisinePreference = cuisinePreference;
    }

    NutrientRange getNutrientRange() {
        return this.nutrientRange;
    }

    String getHealthPreferences(){
        return this.healthPreference;
    }

    String getDietPreference(){
        return this.dietPreference;
    }

    String getCuisinePreference(){
        return this.cuisinePreference;
    }
}
