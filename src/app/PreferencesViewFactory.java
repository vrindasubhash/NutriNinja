package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate_meal.GenerateMealController;
import interface_adapter.generate_meal.GenerateMealPresenter;
import interface_adapter.generate_meal.GenerateMealViewModel;
import interface_adapter.generate_random_meal.GenerateRandomMealController;
import interface_adapter.generate_random_meal.GenerateRandomMealPresenter;
import interface_adapter.save_preferences.SavePreferencesController;
import interface_adapter.save_preferences.SavePreferencesPresenter;
import interface_adapter.save_preferences.SavePreferencesViewModel;
import use_case.generate_meal.GenerateMealInputBoundary;
import use_case.generate_meal.GenerateMealOutputBoundary;
import use_case.generate_meal.GenerateMealUseCaseInteractor;
import use_case.generate_meal_by_id.GenerateMealByIDInputBoundary;
import use_case.generate_meal_by_id.GenerateMealByIDInteractor;
import use_case.generate_meal_by_id.GenerateMealByIDOutputBoundary;
import use_case.save_preferences.SavePreferencesDataAccessInterface;
import use_case.save_preferences.SavePreferencesInputBoundary;
import use_case.save_preferences.SavePreferencesInteractor;
import use_case.save_preferences.SavePreferencesOutputBoundary;
import view.PreferencesView;

import javax.swing.*;
import java.io.IOException;

public class PreferencesViewFactory {
    private PreferencesViewFactory() {}

    public static PreferencesView create(
            ViewManagerModel viewManagerModel,
            SavePreferencesViewModel savePreferencesViewModel,
            GenerateMealViewModel generateMealViewModel,
            SavePreferencesDataAccessInterface savePreferencesDataAccessObject) {

        try {
            SavePreferencesController savePreferencesController = createSavePreferencesUseCase(viewManagerModel, savePreferencesViewModel,savePreferencesDataAccessObject);
            GenerateMealController generateMealController = MealViewFactory.createGenerateMealUseCase(viewManagerModel, generateMealViewModel);
            GenerateRandomMealController generateRandomMealController = MealViewFactory.createGenerateRandomMealUseCase(viewManagerModel, generateMealViewModel);
            return new PreferencesView(savePreferencesViewModel, savePreferencesController, generateMealController, generateRandomMealController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    public static SavePreferencesController createSavePreferencesUseCase(
            ViewManagerModel viewManagerModel,
            SavePreferencesViewModel savePreferencesViewModel,
            SavePreferencesDataAccessInterface savePreferencesDataAccessObject) throws IOException {

        SavePreferencesOutputBoundary savePreferencesOutputBoundary = new SavePreferencesPresenter(savePreferencesViewModel, viewManagerModel);

        SavePreferencesInputBoundary savePreferencesInteractor = new SavePreferencesInteractor(
                savePreferencesDataAccessObject, savePreferencesOutputBoundary);

        return new SavePreferencesController(savePreferencesInteractor);
    }

}


