package Former;
import Documents.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import Interface.Frame;

public class Login extends JFrame implements Frame {
    private JLabel labelAlreadyHaveUsername;
    private JLabel labelAlreadyHavePassword;
    private JTextField usernameLoginField, passwordLoginField;
    private JButton registerButton, loginButton;
    private JPanel panelLogin;
    private ActionsLogin actionsLogin;
    private JButton indicatorUserLogin, indicatorPassLogin;

    Login() {
        setSize(500, 600);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        frame();
        setVisible(true);
    }

    public void frame() {
        panelLogin = new JPanel();
        panelLogin.setBounds(70, 100, 350, 450);
        panelLogin.setBackground(new Color(234, 228, 228));
        panelLogin.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        panelLogin.setLayout(null);
        add(panelLogin);

        JLabel labelLogin = new JLabel("Login");
        labelLogin.setBounds(150, 20, 150, 30);
        labelLogin.setFont(new Font("Arial", Font.BOLD, 20));
        panelLogin.add(labelLogin);

        usernameLoginField = new JTextField();
        usernameLoginField.setBounds(25, 100, 250, 30);
        usernameLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
        ((AbstractDocument) usernameLoginField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        usernameLoginField.setFont(new Font("Arial", Font.PLAIN, 16));
        new PlaceHolder(usernameLoginField, "Enter Username");
        panelLogin.add(usernameLoginField);

        JLabel usernameLoginLabel = new JLabel("Username");
        usernameLoginLabel.setBounds(25, 130, 120, 30);
        usernameLoginLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panelLogin.add(usernameLoginLabel);

        labelAlreadyHaveUsername = new JLabel();
        labelAlreadyHaveUsername.setBounds(25, 70, 300, 30);
        labelAlreadyHaveUsername.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHaveUsername.setForeground(Color.red);
        panelLogin.add(labelAlreadyHaveUsername);

        passwordLoginField = new JTextField();
        passwordLoginField.setBounds(25, 180, 250, 30);
        passwordLoginField.setBorder(BorderFactory.createLineBorder(new Color(13, 100, 191, 232), 2));
        ((AbstractDocument) passwordLoginField.getDocument()).setDocumentFilter(new LimitDocumentFilter(15));
        passwordLoginField.setFont(new Font("Arial", Font.PLAIN, 16));
        new PlaceHolder(passwordLoginField, "Enter Password");
        panelLogin.add(passwordLoginField);

        JLabel passwordLoginLabel = new JLabel("Password");
        passwordLoginLabel.setBounds(25, 205, 120, 30);
        passwordLoginLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        panelLogin.add(passwordLoginLabel);

        labelAlreadyHavePassword = new JLabel();
        labelAlreadyHavePassword.setBounds(25, 150, 300, 30);
        labelAlreadyHavePassword.setFont(new Font("Arial", Font.ITALIC, 16));
        labelAlreadyHavePassword.setForeground(Color.red);
        panelLogin.add(labelAlreadyHavePassword);

        loginButton = new JButton("Join");
        loginButton.setBounds(90, 265, 150, 30);
        loginButton.setBackground(new Color(123, 164, 205, 232));
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        panelLogin.add(loginButton);

        registerButton = new JButton("Regist");
        registerButton.setBounds(220, 400, 100, 30);
        registerButton.setBackground(new Color(146, 197, 251, 232));
        registerButton.setFont(new Font("Arial", Font.ITALIC, 16));
        panelLogin.add(registerButton);

        CreaterIdicator UserindicatorUserLogin = new CreaterIdicator(285, 110, null, panelLogin);
        CreaterIdicator UserindicatorPassLogin = new CreaterIdicator(285, 190, null, panelLogin);

        indicatorUserLogin =  UserindicatorUserLogin.getIndicator();
        indicatorPassLogin = UserindicatorPassLogin.getIndicator();


        actionsLogin = new ActionsLogin(this, labelAlreadyHaveUsername, labelAlreadyHavePassword, usernameLoginField, passwordLoginField, registerButton, loginButton, indicatorUserLogin, indicatorPassLogin);
        loginButton.addActionListener(actionsLogin);
        registerButton.addActionListener(actionsLogin);
    }
}
