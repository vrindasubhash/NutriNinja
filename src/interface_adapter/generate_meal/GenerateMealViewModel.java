package interface_adapter.generate_meal;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GenerateMealViewModel extends ViewModel {

    public static final String TITLE = "Meal Page";//TITLE


    //HEADERS
    public static final String MEAL_HEADER = "Meal: ";
    public static final String SERVINGS_HEADER = "Servings: ";
    public static final String CALORIES_HEADER = "Calories: ";
    public static final String PROTEIN_HEADER = "Protein: ";
    public static final String CARBS_HEADER = "Carbs: ";
    public static final String FAT_HEADER = "Fat: ";
    public final static String INGREDIENTS_HEADER = "Ingredients";
    public final static String RECIPE_LINK_HEADER = "Recipe Link";
    public final static String RECIPE_SOURCE_HEADER = "Recipe Source";



    //LABELS
    public static final String MEAL_LABEL = "Meal: ";
    public static final String SERVINGS_LABEL = "Servings: ";
    public static final String CALORIES_LABEL = "";
    public static final String PROTEIN_LABEL = "";
    public static final String CARBS_LABEL = "";
    public static final String FAT_LABEL = "";
    public static final String INGREDIENTS_LABEL = "";
    public static final String RECIPE_LINK_LABEL = "";
    public static final String RECIPE_SOURCE_LABEL = "";


    //Buttons
    public String BACK_BUTTON_LABEL = "Back";
    public String REGENERATE_BUTTON_LABEL = "Generate Another Meal";

    private GenerateMealState state= new GenerateMealState();

    public GenerateMealState getState(){
        return state;
    }
    public void setState(GenerateMealState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GenerateMealViewModel(String viewName) {
        super("Generate Meal View");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
