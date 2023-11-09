//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package interface_adapter.signup;

import use_case_signup.SignupInputBoundary;
import use_case_signup.SignupInputData;

public class SignupController {
    final SignupInputBoundary userSignupUseCaseInteractor;

    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(username, password1, password2);
        this.userSignupUseCaseInteractor.execute(signupInputData);
    }
}
