package entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param username
     * @param password
     * @return
     */

    @Override
    public User create(String username, String password,  UserPreference preference) {
        return new CommonUser(username, password, preference);
    }
}
