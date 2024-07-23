package Former;

import Documents.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.ArrayList;

import Interface.Frame;

public class Register extends JFrame implements Frame {
    public static ArrayList<String> username = new ArrayList<>();
    public static ArrayList<String> password = new ArrayList<>();
    public static ArrayList<String> email = new ArrayList<>();

    private JLabel labelAlreadyHaveEmail;
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    private JTextField usernameField, passwordField, emailField;
    private JButton loginButton, registerButton, indicatorUser, indicatorPass, indicatorEmail;
    private JPanel panel;
    private ActionsRegister actionsRegister;

    public Register() {
        setSize(500, 800);
        setTitle("Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        frame();
        setVisible(true);
    }

    public void frame() {
        panel = new JPanel();
        panel.setBounds(70, 100, 350, 500);
        panel.setBackground(new java.awt.Color(234, 228, 228));
        panel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Registration");
        label.setBounds(130, 20, 150, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);

        usernameField = new JTextField();
        usernameField.setBounds(25, 100, 250, 30);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
        ((AbstractDocument) usernameField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        new PlaceHolder(usernameField, "Enter Username");
        panel.add(usernameField);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(25, 130, 120, 30);
        usernameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(usernameLabel);

        labelAlreadyHaveUsername = new JLabel();
        labelAlreadyHaveUsername.setBounds(25, 70, 300, 30);
        labelAlreadyHaveUsername.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveUsername.setForeground(Color.red);
        panel.add(labelAlreadyHaveUsername);

        passwordField = new JTextField();
        passwordField.setBounds(25, 180, 250, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
        ((AbstractDocument) passwordField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        new PlaceHolder(passwordField, "Enter Password");
        panel.add(passwordField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(25, 205, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(passwordLabel);

        labelAlreadyHavePassword = new JLabel();
        labelAlreadyHavePassword.setBounds(25, 150, 300, 30);
        labelAlreadyHavePassword.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHavePassword.setForeground(Color.red);
        panel.add(labelAlreadyHavePassword);

        emailField = new JTextField();
        emailField.setBounds(25, 260, 250, 30);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
        ((AbstractDocument) emailField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        new PlaceHolder(emailField, "Enter Email");
        panel.add(emailField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(25, 290, 120, 30);
        emailLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(emailLabel);

        labelAlreadyHaveEmail = new JLabel();
        labelAlreadyHaveEmail.setBounds(25, 230, 300, 30);
        labelAlreadyHaveEmail.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveEmail.setForeground(Color.red);
        panel.add(labelAlreadyHaveEmail);

        registerButton = new JButton("Register");
        registerButton.setBounds(90, 320, 150, 30);
        registerButton.setBackground(new Color(123, 164, 205, 232));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(220, 400, 100, 30);
        loginButton.setBackground(new Color(146, 197, 251, 232));
        loginButton.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(loginButton);


        CreaterIdicator userIndicatorCreator = new CreaterIdicator(285, 110, null, panel);
        CreaterIdicator passIndicatorCreator = new CreaterIdicator(285, 190, null, panel);
        CreaterIdicator emailIndicatorCreator = new CreaterIdicator(285, 270, null, panel);

        indicatorUser =  userIndicatorCreator.getIndicator();
        indicatorPass = passIndicatorCreator.getIndicator();
        indicatorEmail = emailIndicatorCreator.getIndicator();

        actionsRegister = new ActionsRegister(labelAlreadyHaveUsername, labelAlreadyHavePassword, labelAlreadyHaveEmail, usernameField, passwordField, emailField, loginButton, registerButton, indicatorUser, indicatorPass, indicatorEmail, this);
        registerButton.addActionListener(actionsRegister);
        loginButton.addActionListener(actionsRegister);
    }
}
