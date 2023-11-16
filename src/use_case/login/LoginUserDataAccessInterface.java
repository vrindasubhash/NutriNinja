package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean userExists(String identifier);

    User get(String username);
}
