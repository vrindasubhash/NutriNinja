package entity;

import java.util.Arrays;
import java.util.List;

public interface UserFactory {
    User create(
            String username,
            String password,
            List<String> healthPreference,
            List<String> dishType,
            int[] calRange,
            int[] fatRange,
            int[] proteinRange,
            int[] carbRange
    );

    User create(String username, String password);
}
