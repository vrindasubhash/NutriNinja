

package use_case.signup;

import data_access.MemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignupInteractorTest {

    private MemoryUserDataAccessObject userRepository;
    private CommonUserFactory userFactory;
    private SignupInteractor interactor;
    private SignupOutputBoundary successPresenter;
    private SignupOutputBoundary failurePresenter;

    @Before
    public void setUp() {
        userRepository = new MemoryUserDataAccessObject();
        userFactory = new CommonUserFactory();
        successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                assertEquals("newUser", user.getUsername());
                assertTrue(userRepository.userExists("newUser"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                // Error message will be set in individual tests
            }
        };
        interactor = new SignupInteractor(userRepository, successPresenter, userFactory);
    }

    @After
    public void tearDown() {
        userRepository = null;
        userFactory = null;
        interactor = null;
        successPresenter = null;
        failurePresenter = null;
    }

    @Test
    public void successTest() {
        SignupInputData inputData = new SignupInputData("newUser", "password", "password");
        interactor.execute(inputData);
    }

    @Test
    public void failurePasswordMismatchTest() {
        SignupInputData inputData = new SignupInputData("newUser", "password", "differentPassword");
        failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }
        };
        interactor = new SignupInteractor(userRepository, failurePresenter, userFactory);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserExistsTest() {
        String existingUsername = "existingUser";
        User existingUser = userFactory.create(existingUsername, "password");
        userRepository.saveUser(existingUser);

        SignupInputData inputData = new SignupInputData(existingUsername, "password", "password");
        failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }
        };
        interactor = new SignupInteractor(userRepository, failurePresenter, userFactory);
        interactor.execute(inputData);
    }
}