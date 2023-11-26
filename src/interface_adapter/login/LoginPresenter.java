package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the save preferences view.
        // To be implemented once the save preferences view is ready.
        loginViewModel.getState().setUsername(response.getUsername());
        loginViewModel.getState().setError("");
    }

    @Override
    public void prepareFailView(String error) {
        loginViewModel.getState().setError(error);
        loginViewModel.firePropertyChanged();
    }
}
