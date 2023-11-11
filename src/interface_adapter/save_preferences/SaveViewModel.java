package interface_adapter.save_preferences;

public class SaveViewModel extends ViewModel{

    public final String TITLE_LABEL = "Preferences";
    public final String NUTRIENT_LABEL = "Enter Preferred Nutrient Values";
    public final String HEALTH_PREF_LABEL = "Enter Health Preferences";
    public final String DISH_TYPE_LABEL = "Enter Breakfast, Lunch, or Dinner";

    public static final String SAVE_PREFERENCES_BUTTON_LABEL = "Save Preferences";
    public static final String GENERATE_MEAL_BUTTON_LABEL = "Generate Meal";

    private SaveState state = new SaveState();

    private SaveState getState(){
        return state;
    }


}
