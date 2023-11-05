package use_case.save_preferences;

public class SaveOutputData {
    private final String message;

    public SaveOutputData(){
        this.message = "Preferences Saved!";
    }
    public String getMessage(){
        return this.message;
    }
}
