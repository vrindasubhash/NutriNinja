package use_case.generate_meal;


import java.util.List;
import app.custom_data.Range;

public class GenerateMealInputData {



    private List<String> healthPreferences;
    private List<String> mealType;
    private List<String> dishType;
    private Range calRange;
    private Range carbRange;
    private Range proteinRange;
    private Range fatRange;

    public GenerateMealInputData(List<String> healthPreferences,
                                 List<String> mealType,
                                 List<String> dishType,
                                 Range calRange,
                                 Range carbRange,
                                 Range proteinRange,
                                 Range fatRange ){
        this.healthPreferences = healthPreferences;
        this.mealType = mealType;
        this.dishType = dishType;
        this.calRange = calRange;
        this.carbRange = carbRange;
        this.proteinRange = proteinRange;
        this.fatRange = fatRange;
    }

    public List<String> getHealthPreferences() {
        return healthPreferences;
    }

    public List<String> getMealType() {
        return mealType;
    }

    public List<String> getDishType() {
        return dishType;
    }

    public Range getCalRange() {
        return calRange;
    }

    public Range getCarbRange() {
        return carbRange;
    }

    public Range getProteinRange() {
        return proteinRange;
    }

    public Range getFatRange() {
        return fatRange;
    }

}
