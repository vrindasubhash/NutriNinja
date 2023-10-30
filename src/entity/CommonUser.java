package entity;

import java.util.List;

public class CommonUser implements User {
    private String username;
    private String password;
    private UserPreference userPreference;

    public CommonUser(String username, String password, UserPreference userPreference) {
        this.username = username;
        this.password = password;
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
    public UserPreference getPreferences() {
        return userPreference;
    }
}
