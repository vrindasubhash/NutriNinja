package interface_adapter.generate_meal;

import interface_adapter.ViewModel;
import use_case.generate_meal.GenerateMealOutputData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

public class GenerateMealViewModel extends ViewModel {

    public static final String TITLE = "Meal Page";//TITLE


    public GenerateMealOutputData data = new GenerateMealOutputData();
    //HEADERS

    //Index of meal from 0 to 19 inclusive

    private int index = (int)(Math.random() * 20);
    public String MEAL_LABEL = data.getMeals()[index].getRecipe().getLabel();
    public String IMAGE_URL = data.getMeals()[index].getRecipe().getImage(); //URL of image
    public double MEAL_CALORIES = data.getMeals()[index].getRecipe().getCalories();
    public double MEAL_PROTEIN = data.getMeals()[index].getRecipe().getTotalNutrients().getProtein().getQuantity();
    public double MEAL_CARBS =  data.getMeals()[index].getRecipe().getTotalNutrients().getCarb().getQuantity();
    public double MEAL_FAT = data.getMeals()[index].getRecipe().getTotalNutrients().getFat().getQuantity();


    //INGREDIENTS
    public String INGREDIENTS_LABEL = Arrays.toString(data.getMeals()[index].getRecipe().getIngredientLines());


    //Recipe
    public String RECIPE_LABEL = data.getMeals()[index].getRecipe().getUrl(); //url of recipe

    private GenerateMealState state= new GenerateMealState();

    public GenerateMealState getLoginState(){
        return state;
    }
    public void setLoginState(GenerateMealState state){
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
