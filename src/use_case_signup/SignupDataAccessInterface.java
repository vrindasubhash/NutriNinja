

package use_case_signup;

import entity.User;

public interface SignupDataAccessInterface {
    boolean userExists(String username);

    public void saveUser(User user);
}
