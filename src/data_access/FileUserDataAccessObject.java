package data_access;

import entity.User;

import java.io.*;

public class FileUserDataAccessObject {
    private final File csvFile;

    public FileUserDataAccessObject(String csvPath) {
        this.csvFile = new File(csvPath);
    }

    // SaveUserPreference Method
    public void saveUserPreferences() {}

    // SaveUser Method
    public void saveUser() {}

    // UserExists method
    public boolean userExists() {
        return true;
    }

    // getUser
    public User getUser() {
        return null;
    }

}
