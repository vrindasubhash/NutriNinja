package view;

import interface_adapter.login.LoginController;
import interface_adapter.save_preferences.SavePreferencesController;
import interface_adapter.save_preferences.SavePreferencesState;
import interface_adapter.save_preferences.SavePreferencesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PreferencesView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Preferences";

    JLabel username;

    final JButton savePreferences;
    final JButton generateMeal;
    final JButton feelingLucky;
    final JTextField calorieInputField = new JTextField(15);
    private final JLabel calorieErrorField = new JLabel();

    final JTextField fatInputField = new JTextField(15);
    private final JLabel fatErrorField = new JLabel();

    final JTextField proteinInputField = new JTextField(15);
    private final JLabel proteinErrorField = new JLabel();

    final JTextField carbInputField = new JTextField(15);
    private final JLabel carbErrorField = new JLabel();

    String[] healthPreferencesOptions = {};
    String[] dishTypeOptions = {};
    String[] mealTypeOptions = {};

    final JComboBox healthPreferences = new JComboBox(healthPreferencesOptions);
    private final JLabel healthPreferencesErrorField = new JLabel();
    final JComboBox dishType = new JComboBox(dishTypeOptions);
    private final JLabel dishTypeErrorField = new JLabel();
    final JComboBox mealType = new JComboBox(mealTypeOptions);
    private final JLabel mealTypeErrorField = new JLabel();

    private final SavePreferencesController savePreferencesController;


    /**
     * A window with a title and a JButton.
     */
    public PreferencesView(SavePreferencesViewModel savePreferencesViewModel, SavePreferencesController savePreferencesController) {
        savePreferencesViewModel.addPropertyChangeListener(this);
        this.savePreferencesController = savePreferencesController;

        JLabel title = new JLabel("Enter Preferences");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        savePreferences = new JButton(SavePreferencesViewModel.SAVE_PREFERENCES_BUTTON_LABEL);
        generateMeal = new JButton((SavePreferencesViewModel.GENERATE_MEAL_BUTTON_LABEL));
        feelingLucky = new JButton((SavePreferencesViewModel.FEELING_LUCKY_BUTTON_LABEL));
        buttons.add(savePreferences);
        buttons.add(generateMeal);
        buttons.add(feelingLucky);


        savePreferences.addActionListener(this);
        generateMeal.addActionListener(this);
        feelingLucky.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SavePreferencesState state = (SavePreferencesState) evt.getNewValue();
    }
}