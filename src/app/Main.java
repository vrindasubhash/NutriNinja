package app;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate_meal.GenerateMealViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.save_preferences.SavePreferencesViewModel;
import interface_adapter.signup.SignupViewModel;
import view.LoginView;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Setting up app
        JFrame app = new JFrame("NutriNinja");
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        app.add(views);

        // Setting up view manager and models
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SavePreferencesViewModel savePreferencesViewModel = new SavePreferencesViewModel();
        GenerateMealViewModel generateMealViewModel = new GenerateMealViewModel();

        // Initiating data access object
        FileUserDataAccessObject dao;
        try {
            dao = new FileUserDataAccessObject("./app/users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Creating views
        SignupView signupView = SignupViewFactory.create(viewManagerModel, loginViewModel, signupViewModel, dao);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginViewFactory.create(viewManagerModel, loginViewModel, savePreferencesViewModel, dao);
        views.add(loginView, loginView.viewName);



        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        app.pack();
        app.setVisible(true);
    }
}
