package Former;
import Documents.*;
import GameClasses.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionsLogin implements ActionListener {
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    private JTextField usernameLoginField, passwordLoginField;
    private JButton registerButton, loginButton;
    private Login login;
    private JButton  indicatorUserLogin, indicatorPassLogin;

    public ActionsLogin(Login login, JLabel labelAlreadyHaveUsername, JLabel labelAlreadyHavePassword, JTextField usernameLoginField, JTextField passwordLoginField, JButton registerButton, JButton loginButton, JButton  indicatorUserLogin, JButton indicatorPassLogin) {
        this.login = login;
        this.labelAlreadyHaveUsername = labelAlreadyHaveUsername;
        this.labelAlreadyHavePassword = labelAlreadyHavePassword;
        this.usernameLoginField = usernameLoginField;
        this.passwordLoginField = passwordLoginField;
        this.registerButton = registerButton;
        this.loginButton = loginButton;
        this.indicatorUserLogin = indicatorUserLogin;
        this.indicatorPassLogin = indicatorPassLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredUsername = usernameLoginField.getText();
        String enteredPassword = passwordLoginField.getText();
        boolean found = false;
        boolean valid = true;

        if (enteredUsername.equals("Enter Username") || enteredUsername.isEmpty()) {
            usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("Username cannot be empty");
            indicatorUserLogin.setBackground(Color.red);
            valid = false;
        }  else if (usernameLoginField.getText().contains(",") || usernameLoginField.getText().contains(".") || usernameLoginField.getText().contains("/") ||usernameLoginField.getText().contains("*") ||usernameLoginField.getText().contains("?") ||usernameLoginField.getText().contains("<") ||usernameLoginField.getText().contains(">") ||usernameLoginField.getText().contains("+")||usernameLoginField.getText().contains("=")||usernameLoginField.getText().contains("-") ||usernameLoginField.getText().contains("(") ||usernameLoginField.getText().contains(")") ||usernameLoginField.getText().contains("@") ||usernameLoginField.getText().contains("#")||usernameLoginField.getText().contains("$")||usernameLoginField.getText().contains("%")||usernameLoginField.getText().contains("^")||usernameLoginField.getText().contains("&")||usernameLoginField.getText().contains("_")) {
            usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHaveUsername.setText("Illegal symbol");
            indicatorUserLogin.setBackground(Color.red);
            valid = false;
        }  else {
            usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            indicatorUserLogin.setBackground(Color.green);
            labelAlreadyHaveUsername.setText("");
        }

        if (enteredPassword.equals("Enter Password") || enteredPassword.isEmpty()) {
            passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            indicatorPassLogin.setBackground(Color.red);
            labelAlreadyHavePassword.setText("Password cannot be empty");
            valid = false;
        } else if (passwordLoginField.getText().contains(",") || passwordLoginField.getText().contains(".") || passwordLoginField.getText().contains("/") ||passwordLoginField.getText().contains("*") ||passwordLoginField.getText().contains("?") ||passwordLoginField.getText().contains("<") ||passwordLoginField.getText().contains(">") ||passwordLoginField.getText().contains("+")||passwordLoginField.getText().contains("=")||passwordLoginField.getText().contains("-") ||passwordLoginField.getText().contains("(") ||passwordLoginField.getText().contains(")") ||passwordLoginField.getText().contains("@") ||passwordLoginField.getText().contains("#")||passwordLoginField.getText().contains("$")||passwordLoginField.getText().contains("%")||passwordLoginField.getText().contains("^")||passwordLoginField.getText().contains("&")||passwordLoginField.getText().contains("_")){
            passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(255, 2, 23, 232), 2));
            labelAlreadyHavePassword.setText("Illegal symbol");
            indicatorPassLogin.setBackground(Color.red);
            valid = false;
        } else {
            passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
            indicatorPassLogin.setBackground(Color.green);
            labelAlreadyHavePassword.setText("");
        }

        if (valid) {
            for (int i = 0; i < Register.username.size(); i++) {
                if (enteredUsername.equals(Register.username.get(i)) && enteredPassword.equals(Register.password.get(i).toString())) {
                    found = true;
                    login.dispose();
                    new Game();
                    break;

                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                indicatorPassLogin.setBackground(Color.yellow);
                indicatorUserLogin.setBackground(Color.yellow);
            }
        }

        if (e.getSource() == registerButton){
            login.dispose();
            new Register();
        }
    }

}
