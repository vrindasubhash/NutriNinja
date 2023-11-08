package use_case.generate_meal;


import java.util.List;
import app.custom_data.Range;

public class GenerateMealInputData {



    private List<String> health;
    private List<String> mealType;
    private List<String> dishType;
    private Range calRange;
    private Range carbRange;
    private Range protRange;
    private Range fatRange;

    public GenerateMealInputData(List<String> health,
                                 List<String> mealType,
                                 List<String> dishType,
                                 Range calRange,
                                 Range carbRange,
                                 Range protRange,
                                 Range fatRange ){
        this.health = health;
        this.mealType = mealType;
        this.dishType = dishType;
        this.calRange = calRange;
        this.carbRange = carbRange;
        this.protRange = protRange;
        this.fatRange = fatRange;
    }

    public List<String> getHealth() {
        return health;
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

    public Range getProtRange() {
        return protRange;
    }

    public Range getFatRange() {
        return fatRange;
    }

}
