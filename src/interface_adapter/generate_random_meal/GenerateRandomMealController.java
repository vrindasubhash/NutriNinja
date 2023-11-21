package interface_adapter.generate_random_meal;

import use_case.generate_meal.GenerateMealInputBoundary;
import use_case.generate_meal_by_id.GenerateMealByIDInputBoundary;
import use_case.generate_meal_by_id.GenerateMealByIDInputData;
import use_case.generate_meal_by_id.GenerateMealByIDInteractor;

public class GenerateRandomMealController {

    final GenerateMealByIDInteractor generateMealByIDInteractor;

    public GenerateRandomMealController(GenerateMealByIDInputBoundary generateMealUseCaseInteractor) {
        this.generateMealByIDInteractor = generateMealUseCaseInteractor;
    }

    public void execute(String mealID){
        GenerateMealByIDInputData inputData = new GenerateMealByIDInputData(mealID);
        generateMealByIDInteractor.execute(inputData);
    }

}
