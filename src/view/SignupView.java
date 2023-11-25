package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
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

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";
    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;
    private final JButton signUp;
    private final JButton cancel;
    private final JButton clear;

    public SignupView(SignupController controller, final SignupViewModel signupViewModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Sign Up View");
        title.setAlignmentX(0.5F);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Choose username"), this.usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Choose password"), this.passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel("Enter password again"), this.repeatPasswordInputField);
        JPanel buttons = new JPanel();
        this.signUp = new JButton("Sign up");
        buttons.add(this.signUp);
        this.cancel = new JButton("Cancel");
        buttons.add(this.cancel);
        this.clear = new JButton("Clear");
        buttons.add(this.clear);
        this.signUp.addActionListener((evt) -> {
            if (evt.getSource().equals(this.signUp)) {
                SignupState currentState = signupViewModel.getState();
                this.signupController.execute(currentState.getUsername(), currentState.getPassword(), currentState.getRepeatPassword());
            }

        });
        this.clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.cancel.addActionListener(this);
        this.usernameInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String var10000 = SignupView.this.usernameInputField.getText();
                String text = var10000 + e.getKeyChar();
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
                String var10001 = SignupView.this.passwordInputField.getText();
                currentState.setPassword(var10001 + e.getKeyChar());
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
                String var10001 = SignupView.this.repeatPasswordInputField.getText();
                currentState.setRepeatPassword(var10001 + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, 1));
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState)evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }

    }
}
