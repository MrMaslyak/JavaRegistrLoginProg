import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame   {
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    Login(){

       setSize(500, 600);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(70, 100, 350, 450);
        panelLogin.setBackground(new Color(234, 228, 228));
        panelLogin.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        panelLogin.setLayout(null);
        add(panelLogin);

        JLabel labelLogin = new JLabel("Login");
        labelLogin.setBounds(150, 20, 150, 30);
        labelLogin.setFont(new Font("Arial", Font.BOLD, 20));
        panelLogin.add(labelLogin);

        //----------------------------------------------------------------------

        JTextField usernameLoginField = new JTextField();
        usernameLoginField.setBounds(25, 100, 250, 30);
        usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color (13, 100, 191, 232), 2));
        usernameLoginField.setFont(new Font("Arial", Font.PLAIN, 16));
        addPlaceholder(usernameLoginField, "Enter Username");
        panelLogin.add(usernameLoginField);

        JLabel usernameLoginLabel = new JLabel("Username");
        usernameLoginLabel.setBounds(25 , 130, 120, 30);
        usernameLoginLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panelLogin.add(usernameLoginLabel);


        labelAlreadyHaveUsername = new JLabel();
        labelAlreadyHaveUsername.setBounds(25, 70, 300, 30);
        labelAlreadyHaveUsername.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveUsername.setForeground(Color.red);
        panelLogin.add(labelAlreadyHaveUsername);

        //----------------------------------------------------------------------

        JTextField passwordLoginField = new JTextField();
        passwordLoginField.setBounds(25, 180, 250, 30);
        passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color (13, 100, 191, 232), 2));
        passwordLoginField.setFont(new Font("Arial", Font.PLAIN, 16));
        addPlaceholder(passwordLoginField, "Enter Password");
        panelLogin.add(passwordLoginField);

        JLabel passwordLoginLabel = new JLabel("Password");
        passwordLoginLabel.setBounds(25 , 205, 120, 30);
        passwordLoginLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panelLogin.add(passwordLoginLabel);


        labelAlreadyHavePassword = new JLabel();
        labelAlreadyHavePassword.setBounds(25, 150, 300, 30);
        labelAlreadyHavePassword.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHavePassword.setForeground(Color.red);
        panelLogin.add(labelAlreadyHavePassword);

        //----------------------------------------------------------------------


        JButton loginButton = new JButton("Join");
        loginButton.setBounds(90, 265, 150, 30);
        loginButton.setBackground(new Color(123, 164, 205, 232));
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.addActionListener(e -> {
            String enteredUsername = usernameLoginField.getText();
            String enteredPassword = passwordLoginField.getText();

            boolean found = false;
            boolean valid = true;

            if (enteredUsername.equals("Enter Username") || enteredUsername.isEmpty()) {
                usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
                labelAlreadyHaveUsername.setText("Username cannot be empty");
                valid = false;
            }  else if (usernameLoginField.getText().contains(",") || usernameLoginField.getText().contains(".") || usernameLoginField.getText().contains("/") ||usernameLoginField.getText().contains("*") ||usernameLoginField.getText().contains("?") ||usernameLoginField.getText().contains("<") ||usernameLoginField.getText().contains(">") ||usernameLoginField.getText().contains("+")||usernameLoginField.getText().contains("=")||usernameLoginField.getText().contains("-") ||usernameLoginField.getText().contains("(") ||usernameLoginField.getText().contains(")") ||usernameLoginField.getText().contains("@") ||usernameLoginField.getText().contains("#")||usernameLoginField.getText().contains("$")||usernameLoginField.getText().contains("%")||usernameLoginField.getText().contains("^")||usernameLoginField.getText().contains("&")||usernameLoginField.getText().contains("_")) {
                usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
                labelAlreadyHaveUsername.setText("Illegal symbol");
                valid = false;
            } else {
                usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
                labelAlreadyHaveUsername.setText("");
            }

            if (enteredPassword.equals("Enter Password") || enteredPassword.isEmpty()) {
                passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
                labelAlreadyHavePassword.setText("Password cannot be empty");
                valid = false;
            } else if (passwordLoginField.getText().contains(",") || passwordLoginField.getText().contains(".") || passwordLoginField.getText().contains("/") ||passwordLoginField.getText().contains("*") ||passwordLoginField.getText().contains("?") ||passwordLoginField.getText().contains("<") ||passwordLoginField.getText().contains(">") ||passwordLoginField.getText().contains("+")||passwordLoginField.getText().contains("=")||passwordLoginField.getText().contains("-") ||passwordLoginField.getText().contains("(") ||passwordLoginField.getText().contains(")") ||passwordLoginField.getText().contains("@") ||passwordLoginField.getText().contains("#")||passwordLoginField.getText().contains("$")||passwordLoginField.getText().contains("%")||passwordLoginField.getText().contains("^")||passwordLoginField.getText().contains("&")||passwordLoginField.getText().contains("_")){
                passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
                labelAlreadyHavePassword.setText("Illegal symbol");
                valid = false;
            } else {
                passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
                labelAlreadyHavePassword.setText("");
            }

            if (valid) {
                for (int i = 0; i < Register.username.size(); i++) {
                    if (enteredUsername.equals(Register.username.get(i)) && enteredPassword.equals(Register.password.get(i).toString())) {
                        found = true;
                        dispose();
                        new Game();
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelLogin.add(loginButton);



        JButton registerButton = new JButton("Regist");
        registerButton.setBounds(220, 400, 100, 30);
        registerButton.setBackground(new Color(146, 197, 251, 232));
        registerButton.setFont(new Font("Arial", Font.ITALIC, 16));
        registerButton.addActionListener(e -> {
            dispose();
            new Register();
        });
        panelLogin.add(registerButton);

        setVisible(true);
    }
    private void addPlaceholder(JTextField textField, String placeholder) { //гпт нарисовал
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

}
