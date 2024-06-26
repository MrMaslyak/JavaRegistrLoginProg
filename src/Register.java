import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Register extends JFrame implements ActionListener {
    public static ArrayList<String> username = new ArrayList<>();
    public static ArrayList<Integer> password = new ArrayList<>();
    public static ArrayList<String> email = new ArrayList<>();
    private JLabel labelAlreadyHaveEmail;
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    private  JTextField usernameField, passwordField, emailField;

    Register(){
        setSize(500, 800);
        setTitle("Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        ui();
        setVisible(true);


    }
    public void ui(){
        JPanel panel = new JPanel();
        panel.setBounds(70, 100, 350, 500);
        panel.setBackground(new java.awt.Color(234, 228, 228));
        panel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Registration");
        label.setBounds(130, 20, 150, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);

        //----------------------------------------------------------------------

        usernameField = new JTextField();
        usernameField.setBounds(25, 100, 250, 30);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color (13, 100, 191, 232), 2));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        addPlaceholder(usernameField, "Enter Username");
        ((AbstractDocument) usernameField.getDocument()).setDocumentFilter(new LimitDocumentFilter(10));
        panel.add(usernameField);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(25 , 130, 120, 30);
        usernameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(usernameLabel);

        labelAlreadyHaveUsername = new JLabel();
        labelAlreadyHaveUsername.setBounds(25, 70, 300, 30);
        labelAlreadyHaveUsername.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveUsername.setForeground(Color.red);
        panel.add(labelAlreadyHaveUsername);

        //----------------------------------------------------------------------

         passwordField = new JTextField();
        passwordField.setBounds(25, 180, 250, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color (13, 100, 191, 232), 2));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        addPlaceholder(passwordField, "Enter Password");
        ((AbstractDocument) passwordField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        panel.add(passwordField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(25 , 205, 120, 30);
        passwordLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(passwordLabel);

        labelAlreadyHavePassword = new JLabel();
        labelAlreadyHavePassword.setBounds(25, 150, 300, 30);
        labelAlreadyHavePassword.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHavePassword.setForeground(Color.red);
        panel.add(labelAlreadyHavePassword);

        //----------------------------------------------------------------------

         emailField = new JTextField();
        emailField.setBounds(25, 250, 250, 30);
        emailField.setBorder(BorderFactory.createLineBorder(new Color (13, 100, 191, 232), 2));
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        addPlaceholder(emailField, "Enter Email");
        panel.add(emailField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(25 , 275, 120, 30);
        emailLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(emailLabel);

        labelAlreadyHaveEmail = new JLabel();
        labelAlreadyHaveEmail.setBounds(25, 220, 300, 30);
        labelAlreadyHaveEmail.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveEmail.setForeground(Color.red);
        panel.add(labelAlreadyHaveEmail);

        //----------------------------------------------------------------------

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(90, 325, 150, 30);
        registerButton.setBackground(new Color(123, 164, 205, 232));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        registerButton.addActionListener(this);
        panel.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 450, 75, 30);
        loginButton.setBackground(new Color(146, 197, 251, 232));
        loginButton.setFont(new Font("Arial", Font.ITALIC, 16));
        loginButton.addActionListener(e -> {
            dispose();
            new Login();
        });
        panel.add(loginButton);
    }


    private void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
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
            valid = false;
        } else if (email.contains(emailText)) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("This email is already registered");
            valid = false;
        } else if (!emailText.endsWith("@gmail.com")) {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveEmail.setText("You must have email @gmail.com");
            valid = false;
        }else {
            emailField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            labelAlreadyHaveEmail.setText("");
        }

        if (usernameText.equals("Enter Username") || usernameText.isEmpty()) {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("Username cannot be empty");
            valid = false;
        } else if (username.contains(usernameText)) {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("This username is already registered");
            valid = false;
        } else {
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            labelAlreadyHaveUsername.setText("");
        }

        if (passwordText.equals("Enter Password") || passwordText.isEmpty()) {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHavePassword.setText("Password cannot be empty");
            valid = false;
        } else if (passwordField.getText().contains(",") || passwordField.getText().contains(".") || passwordField.getText().contains("/") ||passwordField.getText().contains("*") ||passwordField.getText().contains("?") ||passwordField.getText().contains("<") ||passwordField.getText().contains(">") ||passwordField.getText().contains("+")||passwordField.getText().contains("=")||passwordField.getText().contains("-") ||passwordField.getText().contains("(") ||passwordField.getText().contains(")") ||passwordField.getText().contains("@") ||passwordField.getText().contains("#")||passwordField.getText().contains("$")||passwordField.getText().contains("%")||passwordField.getText().contains("^")||passwordField.getText().contains("&")||passwordField.getText().contains("_")) {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHavePassword.setText("Illegal symbol");
            valid = false;
        } else {
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            labelAlreadyHavePassword.setText("");
        }

        if(valid) {
            username.add(usernameText);
            usernameField.setText("");
            password.add(Integer.parseInt(passwordText));
            passwordField.setText("");
            email.add(emailText);
            emailField.setText("");
            JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new Login();
        }
    }
}
