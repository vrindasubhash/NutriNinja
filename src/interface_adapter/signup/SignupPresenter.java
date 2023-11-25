package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    public void prepareSuccessView(SignupOutputData response) {
//        To be implemented once the login view is ready
    }

    public void prepareFailView(String error) {
        SignupState signupState = this.signupViewModel.getState();
        signupState.setUsernameError(error);
        this.signupViewModel.firePropertyChanged();
    }
}
