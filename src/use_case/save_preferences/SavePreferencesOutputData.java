package use_case.save_preferences;

public class SavePreferencesOutputData {
    private final String message;

    public SavePreferencesOutputData(){
        this.message = "Preferences Saved!";
    }
    public String getMessage(){
        return this.message;
    }
}
