package interface_adapter.generate_meal;

import use_case.generate_meal.GenerateMealInputData;

public class GenerateMealController {
    final GenerateMealInputBoundary generateMealUseCaseInteractor;

    public GenerateMealController(GenerateMealInputBoundary generateMealUseCaseInteractor) {
        this.generateMealUseCaseInteractor = generateMealUseCaseInteractor;
    }

    public void execute() {
        GenerateMealInputData generateMealInputData = new GenerateMealInputData(

        );
        generateMealUseCaseInteractor.execute(generateMealInputData);
    }
}
