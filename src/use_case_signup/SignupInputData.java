//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package use_case_signup;

public class SignupInputData {
    private final String username;
    private final String password;
    private final String repeatPassword;

    public SignupInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return this.username;
    }

    String getPassword() {
        return this.password;
    }

    public String getRepeatPassword() {
        return this.repeatPassword;
    }
}
