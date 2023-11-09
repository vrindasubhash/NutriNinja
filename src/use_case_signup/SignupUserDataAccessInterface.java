//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package use_case_signup;

import entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String var1);

    void save(User var1);
}
