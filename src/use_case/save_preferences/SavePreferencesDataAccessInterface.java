package use_case.save_preferences;

import entity.UserPreference;

public interface SavePreferencesDataAccessInterface {
    void saveUserPreference(String username, UserPreference preference);
}
