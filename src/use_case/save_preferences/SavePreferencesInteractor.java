package use_case.save_preferences;
    public class SavePreferencesInteractor implements SavePreferencesInputBoundary {
        final SavePreferencesDataAccessInterface saveDataAccessObject;
        final SavePreferencesOutputBoundary savePresenter;


    public SavePreferencesInteractor(SavePreferencesDataAccessInterface saveDataAccessObject,
                                     SavePreferencesOutputBoundary savePresenter){
        this.saveDataAccessObject = saveDataAccessObject;
        this.savePresenter = savePresenter;
    }

    @Override
    public void execute(SavePreferencesInputData savePreferencesInputData) {
        saveDataAccessObject.save();
        SavePreferencesOutputData savePreferencesOutputData = new SavePreferencesOutputData();
        savePresenter.prepareSuccessView(savePreferencesOutputData);
    }

}
