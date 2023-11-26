package view;

//import data_access.MemoryUserDataAccessObject;
//import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
//import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
//import use_case.login.LoginInputBoundary;
//import use_case.login.LoginInputData;
//import use_case.login.LoginInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final LoginViewModel loginViewModel;

    final JTextField usernameInputField = new JTextField(15);
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel errorField = new JLabel();

    final JButton logIn;
    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController controller) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(loginViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(loginViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);

        logIn.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();
                            currentState.setUsername(usernameInputField.getText());
                            currentState.setPassword(new String(passwordInputField.getPassword()));
                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(errorField);
        this.add(buttons);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("property changed");
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        errorField.setText(state.getError());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Login Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200); // Set an appropriate size
//
//        LoginViewModel loginViewModel = new LoginViewModel();
//        ViewManagerModel viewManagerModel = null;
//        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, loginViewModel);
//
//        MemoryUserDataAccessObject userDataAccessObject = new MemoryUserDataAccessObject();
//
//        // Implement a simple version of LoginInputBoundary for testing
//        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessObject,loginPresenter);
//
//        LoginController loginController = new LoginController(loginInteractor);
//
//        LoginView LoginView = new LoginView(loginViewModel, loginController);
//
//        frame.add(LoginView);
//        frame.setVisible(true);
//    }


}