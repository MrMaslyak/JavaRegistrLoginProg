package Documents;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import Interface.*;

public class CreaterIdicator extends RoundButton implements GetIndicator{
    private JButton indicator;
    private JPanel panel;

    public CreaterIdicator(int x, int y, JButton indicator, JPanel panel) {
        super("");
        this.panel = panel;
        this.indicator = new JButton("");
        this.indicator.setBounds(x, y, 10, 10);
        this.indicator.setBackground(Color.yellow);
        this.indicator.setBorder(null);
        this.indicator.setEnabled(false);
        this.indicator.setOpaque(true);
        panel.add(this.indicator);
    }

    public JButton getIndicator() {
        return indicator;
    }
}
