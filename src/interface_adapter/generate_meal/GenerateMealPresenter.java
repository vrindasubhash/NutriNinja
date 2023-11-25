package interface_adapter.generate_meal;

import interface_adapter.ViewManagerModel;
import use_case.generate_meal.GenerateMealOutputBoundary;
import use_case.generate_meal.GenerateMealOutputData;

public class GenerateMealPresenter implements GenerateMealOutputBoundary {


    @Override
    public void prepareSuccessView(GenerateMealOutputData outputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
