package interface_adapter.generate_meal;

import interface_adapter.ViewManagerModel;
import use_case.generate_meal.GenerateMealOutputBoundary;
import use_case.generate_meal.GenerateMealOutputData;

import java.util.Arrays;

public class GenerateMealPresenter implements GenerateMealOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private GenerateMealViewModel generateMealViewModel;

    public  GenerateMealPresenter(ViewManagerModel viewManagerModel, GenerateMealViewModel generateMealViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.generateMealViewModel = generateMealViewModel;
    }
    @Override
    public void prepareSuccessView(GenerateMealOutputData outputData) {
        GenerateMealState generateMealState = generateMealViewModel.getState();

        int index = (int)(Math.random() * 20);
        generateMealState.setMealName(outputData.getMeals()[index].getRecipe().getLabel());
        generateMealState.setImageUrl(outputData.getMeals()[index].getRecipe().getImage());
        generateMealState.setMealCalories(outputData.getMeals()[index].getRecipe().getCalories());
        generateMealState.setMealProtein(outputData.getMeals()[index].getRecipe().getTotalNutrients().getProtein().getQuantity());
        generateMealState.setMealCarbs(outputData.getMeals()[index].getRecipe().getTotalNutrients().getCarb().getQuantity());
        generateMealState.setMealFat(outputData.getMeals()[index].getRecipe().getTotalNutrients().getFat().getQuantity());
        generateMealState.setIngredientsLabel(Arrays.toString(outputData.getMeals()[index].getRecipe().getIngredientLines()));
        generateMealState.setRecipeSource(outputData.getMeals()[index].getRecipe().getLabel());
        generateMealState.setRecipeUrl(outputData.getMeals()[index].getRecipe().getUrl());
        generateMealState.setServings(outputData.getMeals()[index].getRecipe().getServings());

        this.generateMealViewModel.setState(generateMealViewModel.getState());
        generateMealViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(generateMealViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        GenerateMealState generateMealState = generateMealViewModel.getState();
        generateMealState.setAPIError(error);
        generateMealViewModel.firePropertyChanged();
    }
}
