package Former;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import Documents.*;

import static Former.Register.*;

public class ActionsRegister implements ActionListener {
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    private JLabel labelAlreadyHaveEmail;
    private JTextField usernameField, passwordField, emailField;
    private JButton loginButton, registerButton,  indicatorUser, indicatorPass, indicatorEmail;
    private Register register;

    public ActionsRegister(JLabel labelAlreadyHaveUsername, JLabel labelAlreadyHavePassword, JLabel labelAlreadyHaveEmail, JTextField usernameField, JTextField passwordField, JTextField emailField, JButton loginButton, JButton registerButton, JButton indicatorUser, JButton indicatorPass, JButton indicatorEmail, Register register) {
        this.labelAlreadyHaveUsername = labelAlreadyHaveUsername;
        this.labelAlreadyHavePassword = labelAlreadyHavePassword;
        this.labelAlreadyHaveEmail = labelAlreadyHaveEmail;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.emailField = emailField;
        this.loginButton = loginButton;
        this.registerButton = registerButton;
        this.indicatorUser = indicatorUser;
        this.indicatorPass = indicatorPass;
        this.indicatorEmail = indicatorEmail;
        this.register = register;


        if (this.indicatorUser == null || this.indicatorPass == null || this.indicatorEmail == null) {
            throw new IllegalArgumentException("Indicators cannot be null");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameText = usernameField.getText();
        String passwordText = passwordField.getText();
        String emailText = emailField.getText();
        boolean valid = true;
        if (emailText.equals("Enter Email") || emailText.isEmpty()) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("Email cannot be empty");
            indicatorEmail.setBackground(Color.red);
            valid = false;
        } else if (email.contains(emailText)) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("This email is already registered");
            indicatorEmail.setBackground(Color.red);
            valid = false;
        } else if (!emailText.endsWith("@gmail.com")) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("You must have email @gmail.com");
            indicatorEmail.setBackground(Color.red);
            valid = false;
        } else if (emailField.getText().contains(",")|| emailField.getText().contains("+")|| emailField.getText().contains("/") ||emailField.getText().contains("*") ||emailField.getText().contains("?") ||emailField.getText().contains("<") ||emailField.getText().contains(">") ||emailField.getText().contains("+")||emailField.getText().contains("=")||emailField.getText().contains("-") ||emailField.getText().contains("(") ||emailField.getText().contains(")") ||emailField.getText().contains("^") ||emailField.getText().contains("#")||emailField.getText().contains("$")||emailField.getText().contains("%")||emailField.getText().contains("^")||emailField.getText().contains("&")||emailField.getText().contains("_")) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("Illegal symbol");
            indicatorEmail.setBackground(Color.red);
            valid = false;
        } else {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            labelAlreadyHaveEmail.setText("");
            indicatorEmail.setBackground(Color.green);
        }

        if (usernameText.equals("Enter Username") || usernameText.isEmpty()) {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("Username cannot be empty");
            indicatorUser.setBackground(Color.red);
            valid = false;
        } else if (username.contains(usernameText)) {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("This username is already registered");
            indicatorUser.setBackground(Color.red);
            valid = false;
        } else {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            indicatorUser.setBackground(Color.green);
            labelAlreadyHaveUsername.setText("");
        }


        if (passwordText.equals("Enter Password") || passwordText.isEmpty()) {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHavePassword.setText("Password cannot be empty");
            indicatorPass.setBackground(Color.red);
            valid = false;
        } else if (passwordField.getText().contains(",")|| passwordField.getText().contains(".")|| passwordField.getText().contains("/") ||passwordField.getText().contains("*") ||passwordField.getText().contains("?") ||passwordField.getText().contains("<") ||passwordField.getText().contains(">") ||passwordField.getText().contains("+")||passwordField.getText().contains("=")||passwordField.getText().contains("-") ||passwordField.getText().contains("(") ||passwordField.getText().contains(")") ||passwordField.getText().contains("@") ||passwordField.getText().contains("#")||passwordField.getText().contains("$")||passwordField.getText().contains("%")||passwordField.getText().contains("^")||passwordField.getText().contains("&")||passwordField.getText().contains("_")) {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHavePassword.setText("Illegal symbol");
            indicatorPass.setBackground(Color.red);
            valid = false;
        } else {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            indicatorPass.setBackground(Color.green);
            labelAlreadyHavePassword.setText("");
        }

        if (e.getSource() == loginButton){
            register.dispose();
            new Login();
        }

        if(valid) {
            username.add(usernameText);
            usernameField.setText("");
            password.add(String.valueOf(Integer.parseInt(passwordText)));
            passwordField.setText("");
            email.add(emailText);
            emailField.setText("");
            JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            register.dispose();
            new Login();
        }
    }
}