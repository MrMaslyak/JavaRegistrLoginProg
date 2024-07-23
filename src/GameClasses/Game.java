package GameClasses;
import Interface.Frame;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.Font;

public class Game extends JFrame implements Frame {
    public Game() {
        setTitle("Breakout Ball");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        frame();
        setVisible(true);
    }

    @Override
    public void frame() {
        JLabel label = new JLabel("VERY COOL GAME AHAHA");
        label.setBounds(200, 200, 200, 100);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.red);

        add(label);
    }
}
