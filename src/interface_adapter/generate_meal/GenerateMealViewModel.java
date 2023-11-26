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
    public String mealName = data.getMeals()[index].getRecipe().getLabel();
    public String image_url = data.getMeals()[index].getRecipe().getImage(); //URL of image
    public double mealCalories = data.getMeals()[index].getRecipe().getCalories();
    public double mealProtein = data.getMeals()[index].getRecipe().getTotalNutrients().getProtein().getQuantity();
    public double meaLCarbs =  data.getMeals()[index].getRecipe().getTotalNutrients().getCarb().getQuantity();
    public double meal_Fat = data.getMeals()[index].getRecipe().getTotalNutrients().getFat().getQuantity();


    //INGREDIENTS
    public final static String INGREDIENTS_HEADER = "Ingredients";
    public String ingredients = Arrays.toString(data.getMeals()[index].getRecipe().getIngredientLines());


    //Recipe
    public final static String RECIPE_HEADER = "Recipe Link";
    public String recipeSource =  data.getMeals()[index].getRecipe().getSource(); //source of recipe
    public String recipeLink = data.getMeals()[index].getRecipe().getUrl(); //url of recipe

    //Buttons
    public String BACK_BUTTON_LABEL = "Back";
    public String REGENERATE_BUTTON_LABEL = "Generate Another Meal";

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
