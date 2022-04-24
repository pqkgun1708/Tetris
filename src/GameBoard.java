import javax.swing.JFrame;

public class GameBoard extends JFrame {
    
    private javax.swing.JPanel board;

    public GameBoard() {
        this.add(new GameArea(board));
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameBoard().setVisible(true);
            }
        });
    }
}
