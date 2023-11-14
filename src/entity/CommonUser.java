package entity;

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

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setPreferences(UserPreference userPreference) {
        this.userPreference = userPreference;
    }
}
