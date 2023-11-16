package data_access;

import entity.NutrientRange;
import entity.User;

import java.io.*;
import java.util.*;

import entity.UserFactory;
import entity.UserPreference;

public class FileUserDataAccessObject implements LoginUserDataAccessInterface,
                                                 SignupDataAccessInterface,
                                                 SavePreferencesDataAccessInterface {
    private final File csvFile;
    private final UserFactory userFactory;
    private final Map<String, Integer> headers = new LinkedHashMap<>();  // Mapping of column name to index in row array
    private final Map<String, User> accounts = new HashMap<>();  // Mapping of username to user object

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        csvFile = new File(csvPath);
        this.userFactory = userFactory;

        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("healthPreferences", 2);
        headers.put("dishType", 3);
        headers.put("calRange", 4);
        headers.put("fatRange", 5);
        headers.put("proteinRange", 6);
        headers.put("carbRange", 7);

        if (csvFile.length() == 0) {  // If the csv file does not exist or is empty
            save();
        } else {
            // Loading the stored users into memory
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                reader.readLine();  // Skipping header

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(", ");

                    // Getting user attributes from col
                    String username = col[headers.get("username")];
                    String password = col[headers.get("password")];
                    List<String> healthPreferences = Arrays.asList(col[headers.get("healthPreferences")].split("/"));
                    List<String> dishType = Arrays.asList(col[headers.get("dishType")].split("/"));
                    int[] calRange = convertStringArrToNumArr(col[headers.get("calRange")].split("-"));
                    int[] fatRange = convertStringArrToNumArr(col[headers.get("fatRange")].split("-"));
                    int[] proteinRange = convertStringArrToNumArr(col[headers.get("proteinRange")].split("-"));
                    int[] carbRange = convertStringArrToNumArr(col[headers.get("carbRange")].split("-"));

                    User user = userFactory.create(
                            username,
                            password,
                            healthPreferences,
                            dishType, calRange,
                            fatRange,
                            proteinRange,
                            carbRange);
                    accounts.put(username, user);
                }
            }
        }
    }

    /**
     * Saves all the users stored in memory
     */
    public void save() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Writing headers to file
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            // Writing users to file
            for (User user : accounts.values()) {
                UserPreference userPreference = user.getPreferences();
                NutrientRange nutrientRange = userPreference.getNutrientRange();

                String line = String.format(
                        "%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getUsername(),
                        user.getPassword(),
                        String.join("/", userPreference.getHealthPreferences()),
                        String.join("/", userPreference.getDishType()),
                        nutrientRange.getCalorieRange().getRangeString(),
                        nutrientRange.getFatRange().getRangeString(),
                        nutrientRange.getProteinRange().getRangeString(),
                        nutrientRange.getCarbRange().getRangeString()
                );
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Creates a user and saves them to the database
     * @param username represents the username of the new user
     * @param password represents the password of the new user
     */
    public void createUser(String username, String password) {
        User user = userFactory.create(username, password);
        accounts.put(username, user);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns true if the user exists and false otherwise
     * @param username identifies the user you want to check exists
     * @return a boolean representing if the user exists or not
     */
    public boolean userExists(String username) {
        return accounts.containsKey(username);
    }

    /**
     * Returns a user object representing the user
     * @param username identifies the user
     * @return the user
     */
    public User getUser(String username) {
        return accounts.get(username);
    }

    /**
     * Converts a String array into an int array
     * @param strArr represents the array of strings
     * @return an int array
     */
    private int[] convertStringArrToNumArr(String[] strArr) {
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        return intArr;
    }
}
