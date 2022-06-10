package tetris;

import javax.swing.JOptionPane;

public class Tetris 
{
    private static GameForm gf;
    private static StartForm sf;
    private static HighScoreForm hsf;
    
    public static void start()
    {
        gf.setVisible(true);
        gf.startGame();
    }
    
    public static void showHighScore()
    {
        hsf.setVisible(true);
    }
    
    public static void showMenu() 
    {
        sf.setVisible(true);
    }
    
    public static void gameOver(int score)
    {
        String playerName = JOptionPane.showInputDialog("Game Over.\nEnter player name");
        gf.setVisible(false);
        hsf.addPlayer(playerName, score);
    }
    
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                gf = new GameForm();
                sf = new StartForm();
                hsf = new HighScoreForm();
                sf.setVisible(true);
            }
        });
    }
}
