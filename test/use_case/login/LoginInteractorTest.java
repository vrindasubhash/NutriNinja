package use_case.login;

import data_access.MemoryUserDataAccessObject;
import entity.CommonUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginInteractorTest {
    MemoryUserDataAccessObject userDataAccessObject;
    String firstUser = "Bob";
    String firstPassword = "pass";

    @Before
    public void setUp() throws Exception {
        this.userDataAccessObject = new MemoryUserDataAccessObject();
        this.userDataAccessObject.saveUser(new CommonUser(this.firstUser, this.firstPassword, null));
    }

    @After
    public void tearDown() throws Exception {
        this.userDataAccessObject = null;
    }

    @Test
    public void testUserExistsAndPasswordCorrect() {
        String name = this.firstUser;
        String password = this.firstPassword;
        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals(name, user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("User is in the data access object, but fail view was called.");
            }
        };
        LoginInputData loginInputData = new LoginInputData(name, password);
        LoginInteractor loginInteractor = new LoginInteractor(this.userDataAccessObject, loginPresenter);
        loginInteractor.execute(loginInputData);
    }

    @Test
    public void testWrongPassword() {
        String name = this.firstUser;
        String password = this.firstPassword + "x";
        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Succeeded even with the wrong password.");
            }

            @Override
            public void prepareFailView(String error) {
                String expectedMessage = "Incorrect password for " + name + ".";
                assertEquals(expectedMessage, error);
            }
        };
        LoginInputData loginInputData = new LoginInputData(name, password);
        LoginInteractor loginInteractor = new LoginInteractor(this.userDataAccessObject, loginPresenter);
        loginInteractor.execute(loginInputData);
    }

    @Test
    public void testUserDoesNotExist() {
        String name = this.firstUser + "1";
        String password = this.firstPassword;
        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("User is not in the data access object, but success view was called.");
            }

            @Override
            public void prepareFailView(String error) {
                String expectedMessage = name + ": Account does not exist.";
                assertEquals(expectedMessage, error);
            }
        };
        LoginInputData loginInputData = new LoginInputData(name, password);
        LoginInteractor loginInteractor = new LoginInteractor(this.userDataAccessObject, loginPresenter);
        loginInteractor.execute(loginInputData);
    }
}