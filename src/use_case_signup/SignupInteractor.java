//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package use_case_signup;

import entity.User;
import entity.UserFactory;
import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface, SignupOutputBoundary signupOutputBoundary, UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    public void execute(SignupInputData signupInputData) {
        if (this.userDataAccessObject.existsByName(signupInputData.getUsername())) {
            this.userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            this.userPresenter.prepareFailView("Passwords don't match.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            User user = this.userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), now);
            this.userDataAccessObject.save(user);
            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
            this.userPresenter.prepareSuccessView(signupOutputData);
        }

    }
}
