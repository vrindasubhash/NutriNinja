package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.save_preferences.SavePreferencesInputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final SavePreferencesViewModel savePreferencesViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, SavePreferencesViewModel savePreferencesViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.savePreferencesViewModel = savePreferencesViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the save preferences view.
        // To be implemented once the save preferences view is ready.
        SavePreferencesState savePreferencesState = savePreferencesViewModel.getState();
        savePreferencesState.setUsername(response.getUsername());
        savePreferencesState.setNutrientRange(response.getUserPreferences().getNutrientRange());
        savePreferencesState.setHealthPreferences(response.getUserPreferences().getHealthPreferences());
        savePreferencesState.setDishType(response.getUserPreferences().getDishType());
        this.savePreferencesViewModel.setState(savePreferencesState);
        this.savePreferencesViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(savePreferencesViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        loginViewModel.getState().setError(error);
        loginViewModel.firePropertyChanged();
    }
}
