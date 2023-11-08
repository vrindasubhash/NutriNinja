package use_case.save_preferences;

import entity.NutrientRange;

import java.util.List;

public class SaveInputData {

    private final NutrientRange nutrientRange;
    private final String healthPreference;

    private final String dishType;


    public SaveInputData(NutrientRange nutrientRange, String healthPreference, String dishType) {
        this.nutrientRange = nutrientRange;
        this.healthPreference = healthPreference;
        this.dishType = dishType;
    }

    NutrientRange getNutrientRange() {
        return this.nutrientRange;
    }

    String getHealthPreferences(){
        return this.healthPreference;
    }

    String getDietPreference(){
        return this.dishType;
    }

}
