package interface_adapter.generate_meal;

import java.util.List;
import app.custom_data.Range;

public class GenerateMealController {
    final GenerateMealInputBoundary generateMealUseCaseInteractor;

    public GenerateMealController(GenerateMealInputBoundary generateMealUseCaseInteractor) {
        this.generateMealUseCaseInteractor = generateMealUseCaseInteractor;
    }

    public void execute(List<String> healthPreferences, List<String> mealType, List<String> dishType, int calMin, int calMax, int carbMin, int carbMax, int proteinMin, int proteinMax, int fatMin, int fatMax) {
        Range calRange = new Range(calMin, calMax);
        Range carbRange = new Range(carbMin, carbMax);
        Range proteinRange = new Range(proteinMin, proteinMax);
        Range fatRange = new Range(fatMin, fatMax);
        GenerateMealInputData generateMealInputData = new GenerateMealInputData(
                healthPreferences,
                mealType,
                dishType,
                calRange,
                carbRange,
                proteinRange,
                fatRange
        );
        generateMealUseCaseInteractor.execute(generateMealInputData);
    }
}
