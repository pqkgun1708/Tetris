import javax.swing.JPanel;
import java.awt.Graphics;

public class GameArea extends JPanel {
    // Draw stuff on board
    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, 50, 50);
    }
}
