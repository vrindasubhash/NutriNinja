package entity;

import java.util.List;

public interface User {
    String getUsername();
    String getPassword();
    UserPreference getPreferences();
}
