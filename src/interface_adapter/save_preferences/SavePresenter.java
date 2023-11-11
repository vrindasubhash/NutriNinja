package interface_adapter.save_preferences;

import use_case.save_preferences.SaveOutputBoundary;
import use_case.save_preferences.SaveOutputData;

public class SavePresenter implements SaveOutputBoundary {
    private final SaveViewModel saveViewModel;

    public SavePresenter(SaveViewModel saveViewModel){
        this.saveViewModel = saveViewModel;
    }
    @Override
    public void prepareSuccessView(SaveOutputData response) {
        // On success, switch to the logged in view.

        SaveState saveState = saveViewModel.getState();
        this.saveViewModel.setState(saveState);
    }
}
