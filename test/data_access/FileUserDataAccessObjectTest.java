package data_access;

import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileUserDataAccessObjectTest {

    @Before
    public void setUp() throws Exception {
        UserFactory userFactory = new CommonUserFactory();
        FileUserDataAccessObject dao = new FileUserDataAccessObject("./test_data", userFactory);

        User testUser = userFactory.create("test_username", "test_password");
        dao.saveUser(testUser);
    }

    @After
    public void tearDown() {
        File testData = new File("./test_data");
        if (testData.delete()) {
            System.out.println("Deleted test_data.csv successfully.");
        } else {
            System.out.println("Deleted test_data.csv unsuccessfully.");
        }
    }

    @Test
    public void save() {

    }

    @Test
    public void saveUser() {
    }

    @Test
    public void saveUserPreferences() {
    }

    @Test
    public void userExists() {
    }

    @Test
    public void getUser() {
    }
}