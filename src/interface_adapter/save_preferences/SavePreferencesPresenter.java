package interface_adapter.save_preferences;

import use_case.save_preferences.SavePreferencesOutputBoundary;
import use_case.save_preferences.SavePreferencesOutputData;

public class SavePreferencesPresenter implements SavePreferencesOutputBoundary {
    private final SavePreferencesViewModel saveViewModel;

    public SavePreferencesPresenter(SavePreferencesViewModel saveViewModel){
        this.saveViewModel = saveViewModel;
    }
    @Override
    public void prepareSuccessView(SavePreferencesOutputData response) {
        // On success, present the user with the success message

        SavePreferencesState saveState = saveViewModel.getState();
        this.saveViewModel.setState(saveState);
    }
    public void prepareFailView(SavePreferencesOutputData response) {
        // On fail, present the user with the fail message


    }
}

