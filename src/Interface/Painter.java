package Interface;

import java.awt.*;


public interface Painter {
    void paintComponent(Graphics g);
    void paintBorder(Graphics g);
    boolean contains(int x, int y);
}
