package interface_adapter.save_preferences;

public class SavePreferencesViewModel extends ViewModel{

    public final String TITLE_LABEL = "Preferences";
    public final String NUTRIENT_LABEL = "Enter Preferred Nutrient Values";
    public final String HEALTH_PREF_LABEL = "Choose one or more health preferences";
    public final String DISH_TYPE_LABEL = "Choose one or more dish types";

    public static final String SAVE_PREFERENCES_BUTTON_LABEL = "Save Preferences";
    public static final String GENERATE_MEAL_BUTTON_LABEL = "Generate Meal";

    private SavePreferencesState state = new SavePreferencesState();

    private SavePreferencesState getState(){
        return state;
    }


}