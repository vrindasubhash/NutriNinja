package entity;

import app.custom_data.Range;

import java.util.List;

public class CommonUserFactory implements UserFactory{
    @Override
    public User create(String username, String password, List<String> healthPreference, List<String> dishType, int[] calRange, int[] fatRange, int[] proteinRange, int[] carbRange) {
        NutrientRange nutrientRange = new NutrientRange(
                new Range(calRange[0], calRange[1]),
                new Range(fatRange[0], fatRange[1]),
                new Range(proteinRange[0], proteinRange[1]),
                new Range(carbRange[0], carbRange[1])
        );
        UserPreference userPreference = new UserPreference(nutrientRange, healthPreference, dishType);
        return new CommonUser(username, password, userPreference);
    }
}
