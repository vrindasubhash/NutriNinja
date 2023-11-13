package use_case.save_preferences;

import entity.NutrientRange;

import java.util.List;

public class SavePreferencesInputData {

    private final NutrientRange nutrientRange;
    private final List<String> healthPreferences;

    private final List<String> dishType;


    public SavePreferencesInputData(NutrientRange nutrientRange, List<String> healthPreferences, List<String> dishType) {
        this.nutrientRange = nutrientRange;
        this.healthPreferences = healthPreferences;
        this.dishType = dishType;
    }

    NutrientRange getNutrientRange() {
        return this.nutrientRange;
    }

    List<String> getHealthPreferences(){
        return this.healthPreferences;
    }

    List<String> getDietPreference(){
        return this.dishType;
    }

}
