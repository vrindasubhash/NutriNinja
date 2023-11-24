package use_case.generate_meal_by_id;

import use_case.generate_meal.GenerateMealOutputData;

public interface GenerateMealByIDOutputBoundary {

    void prepareSuccessView(GenerateMealByIDOutputData outputData);

    void prepareFailView(String error);
}
