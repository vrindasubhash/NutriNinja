package interface_adapter.generate_random_meal;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate_meal.GenerateMealState;
import interface_adapter.generate_meal.GenerateMealViewModel;
import use_case.generate_meal_by_id.GenerateMealByIDOutputBoundary;
import use_case.generate_meal_by_id.GenerateMealByIDOutputData;

import java.util.Arrays;

public class GenerateRandomMealPresenter implements GenerateMealByIDOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private GenerateMealViewModel generateMealViewModel;

    public  GenerateRandomMealPresenter(ViewManagerModel viewManagerModel, GenerateMealViewModel generateMealViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.generateMealViewModel = generateMealViewModel;
    }
    @Override
    public void prepareSuccessView(GenerateMealByIDOutputData outputData) {
        GenerateMealState generateMealState = generateMealViewModel.getState();

        generateMealState.setMealName(outputData.getRecipe().getLabel());
        generateMealState.setImageUrl(outputData.getRecipe().getImage());
        generateMealState.setMealCalories(outputData.getRecipe().getCalories());
        generateMealState.setMealProtein(outputData.getRecipe().getTotalNutrients().getProtein().getQuantity());
        generateMealState.setMealCarbs(outputData.getRecipe().getTotalNutrients().getCarb().getQuantity());
        generateMealState.setMealFat(outputData.getRecipe().getTotalNutrients().getFat().getQuantity());
        generateMealState.setIngredientsLabel(Arrays.toString(outputData.getRecipe().getIngredientLines()));
        generateMealState.setRecipeSource(outputData.getRecipe().getSource());
        generateMealState.setRecipeUrl(outputData.getRecipe().getUrl());
        generateMealState.setServings(outputData.getRecipe().getServings());

        this.generateMealViewModel.setState(generateMealViewModel.getState());
        generateMealViewModel.firePropertyChanged();


        this.viewManagerModel.setActiveView(generateMealViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GenerateMealState generateMealState = generateMealViewModel.getState();
        generateMealState.setAPIError(error);

        this.generateMealViewModel.setState(generateMealViewModel.getState());
        generateMealViewModel.firePropertyChanged();
    }
}