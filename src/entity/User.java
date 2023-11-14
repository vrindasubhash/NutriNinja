package entity;

import java.util.List;

public interface User {
    String getUsername();
    String getPassword();
    UserPreference getPreferences();

    void setUsername(String username);
    void setPassword(String password);
    void setPreferences(UserPreference preference);
}
