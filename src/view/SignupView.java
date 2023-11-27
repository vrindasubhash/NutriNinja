package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";
    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;
    private final JButton signUp;
    private final JButton alreadyHaveAccount = new JButton("Already have an account");

    private final ViewManagerModel viewManagerModel;

    public SignupView(SignupController controller, final SignupViewModel signupViewModel, ViewManagerModel viewManagerModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        signupViewModel.addPropertyChangeListener(this);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), this.usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), this.passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel("Re-Enter Password"), this.repeatPasswordInputField);
        JPanel buttons = new JPanel();
        this.signUp = new JButton("Sign up");
        buttons.add(this.signUp);
        buttons.add(this.alreadyHaveAccount);
        this.alreadyHaveAccount.addActionListener(this);
        this.signUp.addActionListener((evt) -> {
            if (evt.getSource().equals(this.signUp)) {
                SignupState currentState = signupViewModel.getState();
                this.signupController.execute(currentState.getUsername(), currentState.getPassword(), currentState.getRepeatPassword());
            }

        });

        this.usernameInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String user = SignupView.this.usernameInputField.getText();
                String text = user + e.getKeyChar();
                currentState.setUsername(text);
                signupViewModel.setState(currentState);
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.passwordInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String pass = SignupView.this.passwordInputField.getText();
                currentState.setPassword(pass + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.repeatPasswordInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String pass = SignupView.this.repeatPasswordInputField.getText();
                currentState.setRepeatPassword(pass + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, 1));
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == this.signUp) {
            // Sign up logic
            SignupState currentState = signupViewModel.getState();
            this.signupController.execute(currentState.getUsername(), currentState.getPassword(), currentState.getRepeatPassword());
        } else if (evt.getSource() == this.alreadyHaveAccount) {
            // Logic to switch to the login view
            viewManagerModel.setActiveView("loginViewName"); // Replace with the actual name of the login view
            viewManagerModel.firePropertyChanged();
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState)evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Signup Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Set an appropriate size

        SignupViewModel viewModel = new SignupViewModel();

        // Implement a simple version of SignupInputBoundary for testing
        SignupInputBoundary mockSignupInteractor = new SignupInputBoundary() {
            @Override
            public void execute(SignupInputData signupInputData) {
                System.out.println("Signup requested with: " + signupInputData);
                // Add mock logic as needed for testing
            }
        };

        SignupController controller = new SignupController(mockSignupInteractor);

        // Create an instance of ViewManagerModel
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Pass the newly created ViewManagerModel as the third argument
        SignupView signupView = new SignupView(controller, viewModel, viewManagerModel);

        frame.add(signupView);
        frame.setVisible(true);
    }
}
