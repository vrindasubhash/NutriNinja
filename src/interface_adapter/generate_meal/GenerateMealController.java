package interface_adapter.generate_meal;

import java.net.URISyntaxException;
import java.util.List;
import app.custom_data.Range;
import use_case.generate_meal.GenerateMealInputBoundary;
import use_case.generate_meal.GenerateMealInputData;

public class GenerateMealController {
    final GenerateMealInputBoundary generateMealUseCaseInteractor;

    public GenerateMealController(GenerateMealInputBoundary generateMealUseCaseInteractor) {
        this.generateMealUseCaseInteractor = generateMealUseCaseInteractor;
    }

    public void execute(List<String> healthPreferences, List<String> mealType, List<String> dishType, int calMin, int calMax, int carbMin, int carbMax, int proteinMin, int proteinMax, int fatMin, int fatMax){
        Range<Integer> calRange = new Range<>(calMin, calMax);
        Range<Integer> carbRange = new Range<>(carbMin, carbMax);
        Range<Integer> proteinRange = new Range<>(proteinMin, proteinMax);
        Range<Integer> fatRange = new Range<>(fatMin, fatMax);
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
