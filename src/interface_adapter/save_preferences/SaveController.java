package interface_adapter.save_preferences;

import entity.NutrientRange;
import use_case.save_preferences.SaveInputBoundary;
import use_case.save_preferences.SaveInputData;

public class SaveController{
    final SaveInputBoundary saveUseCaseInteractor;
    public SaveController(SaveInputBoundary saveUseCaseInteractor) {
        this.saveUseCaseInteractor = saveUseCaseInteractor;
    }
    public void execute(NutrientRange nutrientRange, String healthPreferences,
                        String dietPreference,
                        String cuisinePreference) {
        SaveInputData saveInputData = new SaveInputData(nutrientRange, healthPreferences, dietPreference, cuisinePreference);
        saveUseCaseInteractor.execute(saveInputData);
    }
}
