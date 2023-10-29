package entity;

import java.util.List;

public interface User {
    String getUsername();
    String getPassword();
    List<Meal> getMeals();
    UserPreference getPreferences();
}
