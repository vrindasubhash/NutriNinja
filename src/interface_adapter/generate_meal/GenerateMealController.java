package interface_adapter.generate_meal;

import java.util.List;

public class GenerateMealController {
    final GenerateMealInputBoundary generateMealUseCaseInteractor;

    public GenerateMealController(GenerateMealInputBoundary generateMealUseCaseInteractor) {
        this.generateMealUseCaseInteractor = generateMealUseCaseInteractor;
    }

    public void execute(List<String> health, List<String> mealType, List<String> dishType, int calMin, int calMax, int carbMin, int carbMax, int proteinMin, int proteinMax, int fatMin, int fatMax) {
        GenerateMealInputData generateMealInputData = new GenerateMealInputData(
                health,
                mealType,
                dishType,
                calMin, calMax,
                carbMin, carbMax,
                proteinMin, proteinMax,
                fatMin, fatMax
        );
        generateMealUseCaseInteractor.execute(generateMealInputData);
    }
}
