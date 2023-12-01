package view;

import app.custom_data.Range;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate_meal.GenerateMealController;
import interface_adapter.generate_meal.GenerateMealViewModel;
import interface_adapter.generate_random_meal.GenerateRandomMealController;
import interface_adapter.save_preferences.SavePreferencesController;
import interface_adapter.save_preferences.SavePreferencesState;
import interface_adapter.save_preferences.SavePreferencesViewModel;
import use_case.generate_meal.GenerateMealInputBoundary;
import use_case.generate_meal.GenerateMealInputData;
import use_case.generate_meal_by_id.GenerateMealByIDInputBoundary;
import use_case.generate_meal_by_id.GenerateMealByIDInputData;
import use_case.save_preferences.SavePreferencesInputBoundary;
import use_case.save_preferences.SavePreferencesInputData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.List;

public class GenerateMealView extends JPanel implements ActionListener, PropertyChangeListener {

    public static String viewName = "Generate Meal";


    public final GenerateMealViewModel generateMealViewModel;
    public final GenerateMealController generateMealController;
    public final SavePreferencesController savePreferencesController;


    private final ViewManagerModel viewManagerModel;
    public final SavePreferencesViewModel savePreferncesViewModel;
    public final GenerateRandomMealController generateRandomMealController;
    public GenerateMealView(ViewManagerModel viewmanagerModel,
                            GenerateMealViewModel generateMealViewModel,
                            SavePreferencesViewModel savePreferencesViewModel,
                            GenerateMealController generateMealController,
                            SavePreferencesController savePreferencesController,
                            GenerateRandomMealController generateRandomMealController) throws IOException{


        this.viewManagerModel = viewmanagerModel;
        this.generateMealViewModel = generateMealViewModel;
        this.generateMealController = generateMealController;
        this.savePreferencesController = savePreferencesController;
        this.generateRandomMealController = generateRandomMealController;
        this.savePreferncesViewModel = savePreferencesViewModel;
        generateMealViewModel.addPropertyChangeListener(this);
        savePreferencesViewModel.addPropertyChangeListener(this);

        Font f1 = new Font("Lucida Grande", Font.PLAIN, 13);
        Font f2 = new Font("Lucida Grande", Font.BOLD, 15);


        JLabel title = new JLabel(GenerateMealViewModel.TITLE);
        title.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel mealSuggestedPanel = new JPanel();
        JLabel mealSuggestedHeader = new JLabel(GenerateMealViewModel.MEAL_HEADER);
        mealSuggestedHeader.setFont(f2);
        mealSuggestedPanel.add(mealSuggestedHeader);
        mealSuggestedPanel.add(new JLabel(generateMealViewModel.getState().getMealName()));

        JPanel picturePanel = new JPanel();
        JLabel pictureLabel = new JLabel();
        try {
            pictureLabel.setIcon(new ImageIcon(ImageIO.read(new URL(generateMealViewModel.getState().getImageURL()))));
        } catch (MalformedURLException e){
            pictureLabel.setText("No Image Available");
        }
        picturePanel.add(pictureLabel);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        JPanel servingsPanel = new JPanel();
        JLabel servingsHeader = new JLabel(GenerateMealViewModel.SERVINGS_HEADER);
        servingsHeader.setFont(f2);
        servingsPanel.add(servingsHeader);
        servingsPanel.add(new JLabel(String.valueOf(generateMealViewModel.getState().getServings())));

        JPanel caloriesPanel= new JPanel();
        JLabel caloriesHeader = new JLabel(GenerateMealViewModel.CALORIES_HEADER);
        caloriesHeader.setFont(f2);
        caloriesPanel.add(caloriesHeader);
        caloriesPanel.add(new JLabel(String.valueOf(generateMealViewModel.getState().getMealCalories())));

        JPanel proteinPanel = new JPanel();
        JLabel proteinHeader = new JLabel(GenerateMealViewModel.PROTEIN_HEADER);
        proteinHeader.setFont(f2);
        proteinPanel.add(proteinHeader);
        proteinPanel.add(new JLabel(String.valueOf(generateMealViewModel.getState().getMealProtein())));

        JPanel carbsPanel = new JPanel();
        JLabel carbsHeader = new JLabel(GenerateMealViewModel.CARBS_HEADER);
        carbsHeader.setFont(f2);
        carbsPanel.add(carbsHeader);
        carbsPanel.add(new JLabel(String.valueOf(generateMealViewModel.getState().getMealCarbs())));

        JPanel fatPanel = new JPanel();
        JLabel fatHeader = new JLabel(GenerateMealViewModel.FAT_HEADER);
        fatHeader.setFont(f2);
        fatPanel.add(fatHeader);
        fatPanel.add(new JLabel(String.valueOf(generateMealViewModel.getState().getMealFat())));

        infoPanel.add(servingsPanel);
        infoPanel.add(caloriesPanel);
        infoPanel.add(proteinPanel);
        infoPanel.add(carbsPanel);
        infoPanel.add(fatPanel);



        JPanel ingredientsPanel = new JPanel();
        JLabel ingredientHeader = new JLabel(GenerateMealViewModel.INGREDIENTS_HEADER);
        ingredientHeader.setFont(f2);
        ingredientsPanel.add(ingredientHeader);
        ingredientsPanel.add(new JLabel(generateMealViewModel.getState().getIngredientsLabel()));


        JPanel recipeSourcePanel = new JPanel();
        JLabel recipeSourceHeader = new JLabel(GenerateMealViewModel.RECIPE_SOURCE_HEADER);
        recipeSourceHeader.setFont(f2);
        recipeSourcePanel.add(recipeSourceHeader);
        recipeSourcePanel.add(new JLabel(generateMealViewModel.getState().getRecipeSource()));

        JPanel recipeLinkPanel = new JPanel();
        JLabel recipeLinkHeader = new JLabel(GenerateMealViewModel.RECIPE_LINK_HEADER);
        recipeLinkHeader.setFont(f2);
        recipeLinkPanel.add(recipeLinkHeader);
        recipeLinkPanel.add(new JLabel(generateMealViewModel.getState().getRecipeURL()));


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());


        JButton backButton = new JButton(GenerateMealViewModel.BACK_BUTTON_LABEL);
        JButton regenerateButton = new JButton(GenerateMealViewModel.REGENERATE_BUTTON_LABEL);
        JButton feelingLuckyButton = new JButton(GenerateMealViewModel.FEELING_LUCKY_BUTTON_LABEL);


        buttonsPanel.add(backButton);
        buttonsPanel.add(regenerateButton);
        buttonsPanel.add(feelingLuckyButton);

        backButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backButton)) {
                            SavePreferencesState currentState = savePreferencesViewModel.getState();
                            savePreferencesController.execute(
                                    currentState.getNutrientRange().getCalorieRange(),
                                    currentState.getNutrientRange().getFatRange(),
                                    currentState.getNutrientRange().getProteinRange(),
                                    currentState.getNutrientRange().getCarbRange(),
                                    currentState.getHealthPreferences(),
                                    currentState.getDishType(),
                                    currentState.getUsername()
                            );
                        }
                    }
                }
        );

        regenerateButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(regenerateButton)) {
                            SavePreferencesState currentState = savePreferencesViewModel.getState();
                            generateMealController.execute(
                                    currentState.getHealthPreferences(),
                                    currentState.getMealType(),
                                    currentState.getDishType(),
                                    currentState.getNutrientRange().getCalorieRange().getLowerBound(),
                                    currentState.getNutrientRange().getCalorieRange().getUpperBound(),
                                    currentState.getNutrientRange().getCarbRange().getLowerBound(),
                                    currentState.getNutrientRange().getCarbRange().getUpperBound(),
                                    currentState.getNutrientRange().getProteinRange().getLowerBound(),
                                    currentState.getNutrientRange().getProteinRange().getUpperBound(),
                                    currentState.getNutrientRange().getFatRange().getLowerBound(),
                                    currentState.getNutrientRange().getFatRange().getUpperBound()
                            );

                        }
                    }
                }
        );

        feelingLuckyButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(feelingLuckyButton)){
                            generateRandomMealController.execute();
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(mealSuggestedPanel);
        this.add(picturePanel);
        this.add(infoPanel);
        this.add(ingredientsPanel);
        this.add(recipeSourcePanel);
        this.add(recipeLinkPanel);
        this.add(buttonsPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


    }





    public static void main(String[] args) throws IOException{
        JFrame frame = new JFrame("Preferences Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1000);



        GenerateMealInputBoundary fakeGenerateMealInteractor = new GenerateMealInputBoundary() {
            @Override
            public void execute(GenerateMealInputData inputData) {

                System.out.println("Generate Meal: " + inputData);
            }

        };

        GenerateMealByIDInputBoundary fakeGenerateMealByIDInteractor = new GenerateMealByIDInputBoundary() {
            @Override
            public void execute(GenerateMealByIDInputData inputData) {
                System.out.println("Generate Random Meal: " + inputData);
            }
        };


        SavePreferencesInputBoundary fakeSavePreferencesInteractor = new SavePreferencesInputBoundary() {
            @Override
            public void execute(SavePreferencesInputData inputData) {
                System.out.println("Save Preferences: " + inputData);
            }
        };

        GenerateMealInputData inputData = new GenerateMealInputData(java.util.List.of("peanut-free"),
                java.util.List.of("Lunch"),
                List.of("Main course"),
                new Range<>(0, 300), //Cal range(per serving),
                new Range<>(0, 100), //Carb range(per serving)
                new Range<>(0, 100), //Protein range(per serving)
                new Range<>(0, 40)); //Fat range(per serving)


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateMealViewModel generateMealViewModel = new GenerateMealViewModel(viewName);
        SavePreferencesViewModel savePreferencesViewModel = new SavePreferencesViewModel("Preferences");
        GenerateMealController generateMealController = new GenerateMealController(fakeGenerateMealInteractor);
        //generateMealController.execute(List.of("peanut-free"),List.of("Lunch"),List.of("Main course"),0,300,0,100,0,100,0,40);
        SavePreferencesController savePreferencesController = new SavePreferencesController(fakeSavePreferencesInteractor);
        GenerateRandomMealController generateRandomMealController1 = new GenerateRandomMealController(fakeGenerateMealByIDInteractor);



        GenerateMealView generateMealView = new GenerateMealView(viewManagerModel, generateMealViewModel,savePreferencesViewModel,generateMealController,savePreferencesController,generateRandomMealController1);

        frame.add(generateMealView);
        frame.setVisible(true);
    }
}
