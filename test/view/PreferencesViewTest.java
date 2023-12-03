package view;

import app.PreferencesViewFactory;
import data_access.FileUserDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate_meal.GenerateMealViewModel;
import interface_adapter.save_preferences.SavePreferencesViewModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class PreferencesViewTest {

    SavePreferencesViewModel savePreferencesViewModel = new SavePreferencesViewModel();
    GenerateMealViewModel generateMealViewModel = new GenerateMealViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    PreferencesView preferencesView;
    User user;

    @Before
    public void setUp(){
        JFrame app = new JFrame("NutriNinja");
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        app.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        FileUserDataAccessObject dao;
        try {
            dao = new FileUserDataAccessObject("test_preferences_view.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        preferencesView = PreferencesViewFactory.create(viewManagerModel, savePreferencesViewModel, generateMealViewModel, dao);
        views.add(preferencesView, preferencesView.viewName);

        viewManagerModel.setActiveView(preferencesView.viewName);
        viewManagerModel.firePropertyChanged();

        app.pack();
        app.setVisible(true);
    }
    @After
    public void tearDown() {
        File testData = new File("test_preferences_view.csv");
        if (testData.delete()) {
            System.out.println("Deleted test_preferences_view.csv successfully.");
        } else {
            System.out.println("Deleted test_preferences_view.csv unsuccessfully.");
        }
    }

    @Test
    public void testPreferences() {
//        user.setUsername("user");
//        user.setPassword("pass");
//        user.setUserPreferences(100, );
        savePreferencesViewModel.getState().getNutrientRange().getCalorieRange().setLowerBound(100);
        savePreferencesViewModel.getState().getNutrientRange().getCalorieRange().setUpperBound(200);
        savePreferencesViewModel.getState().getNutrientRange().getFatRange().setLowerBound(100);
        savePreferencesViewModel.getState().getNutrientRange().getFatRange().setUpperBound(200);
        savePreferencesViewModel.getState().getNutrientRange().getProteinRange().setLowerBound(100);
        savePreferencesViewModel.getState().getNutrientRange().getProteinRange().setUpperBound(200);
        savePreferencesViewModel.getState().getNutrientRange().getCarbRange().setLowerBound(100);
        savePreferencesViewModel.getState().getNutrientRange().getCarbRange().setUpperBound(200);
        savePreferencesViewModel.getState().setHealthPreferences(new ArrayList<>(Arrays.asList("kosher", "gluten-free")));
        savePreferencesViewModel.getState().setDishType(new ArrayList<>(Arrays.asList("salad")));
        savePreferencesViewModel.getState().setMealType(new ArrayList<>(Arrays.asList("lunch")));
        preferencesView.savePreferences.doClick();
        assertEquals(Optional.of(100), savePreferencesViewModel.getState().getNutrientRange().getCalorieRange().getLowerBound());
        assertEquals(Optional.of(200), savePreferencesViewModel.getState().getNutrientRange().getCalorieRange().getUpperBound());
        assertEquals(Optional.of(100), savePreferencesViewModel.getState().getNutrientRange().getFatRange().getLowerBound());
        assertEquals(Optional.of(200), savePreferencesViewModel.getState().getNutrientRange().getFatRange().getUpperBound());
        assertEquals(Optional.of(100), savePreferencesViewModel.getState().getNutrientRange().getProteinRange().getLowerBound());
        assertEquals(Optional.of(200), savePreferencesViewModel.getState().getNutrientRange().getProteinRange().getUpperBound());
        assertEquals(Optional.of(100), savePreferencesViewModel.getState().getNutrientRange().getCarbRange().getLowerBound());
        assertEquals(Optional.of(200), savePreferencesViewModel.getState().getNutrientRange().getCarbRange().getUpperBound());
    }

}