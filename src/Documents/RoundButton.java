package Documents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import Interface.*;
import Interface.Painter;

public class RoundButton extends JButton implements Painter {

    public RoundButton(String label) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape;
        shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);
    }
}

