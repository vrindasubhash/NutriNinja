package entity;

public interface User {
    String getUsername();
    String getPassword();
    List<Meal> getMeals();
    UserPreference getPreferences();
}
