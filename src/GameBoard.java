import javax.swing.JFrame;

public class GameBoard extends JFrame {
    public GameBoard() {
        // add component to board game
        this.add(new GameArea());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameBoard().setVisible(true);
            }
        });
    }
}