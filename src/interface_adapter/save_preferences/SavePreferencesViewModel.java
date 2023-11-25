package interface_adapter.save_preferences;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SavePreferencesViewModel extends ViewModel {

    public final String TITLE_LABEL = "Preferences";
    public final String NUTRIENT_LABEL = "Enter Preferred Nutrient Values";
    public final String HEALTH_PREF_LABEL = "Choose one or more health preferences";
    public final String DISH_TYPE_LABEL = "Choose one or more dish types";

    public static final String SAVE_PREFERENCES_BUTTON_LABEL = "Save Preferences";
    public static final String GENERATE_MEAL_BUTTON_LABEL = "Generate Meal";

    private SavePreferencesState state = new SavePreferencesState();

    public SavePreferencesViewModel(String viewName) {
        super(viewName);
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void setState(SavePreferencesState state) {
        this.state = state;
    }

    public SavePreferencesState getState(){
        return state;
    }

    @Override
    public void firePropertyChanged()  {
        support.firePropertyChange("state", null, this.state);
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}