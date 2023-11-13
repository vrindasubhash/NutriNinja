package interface_adapter.save_preferences;
import java.util.List;

import entity.NutrientRange;
import use_case.save_preferences.SavePreferencesInputBoundary;
import use_case.save_preferences.SavePreferencesInputData;

public class SavePreferencesController {
    final SavePreferencesInputBoundary saveUseCaseInteractor;
    public SavePreferencesController(SavePreferencesInputBoundary saveUseCaseInteractor) {
        this.saveUseCaseInteractor = saveUseCaseInteractor;
    }
    public void execute(NutrientRange nutrientRange, List<String> healthPreferences,
                        List<String> dishType) {
        SavePreferencesInputData savePreferencesInputData = new SavePreferencesInputData(nutrientRange, healthPreferences, dishType);
        saveUseCaseInteractor.execute(savePreferencesInputData);
    }
}
