package entity;

public class CommonUser implements User {
    private String username;
    private String password;
    private List<Meal> meals;
    private UserPreference userPreference;

    public CommonUser(String username, String password, List<Meal> meals, UserPreference userPreference) {
        this.username = username;
        this.password = password;
        this.meals = meals;
        this.userPreference = userPreference;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public UserPreference getPreferences() {
        return userPreference;
    }
}
