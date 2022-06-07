//Thread: a separate flow of actions, in this case, moving the block by re-drawing them
package src.tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread
{   
    private GameArea garea;
    private int score;
    private GameForm gf;
    private int level = 1;
    private int scorePerLevel = 3;
    private int pause = 1000;
    private int speedupPerLevel = 100;

    public GameThread(GameArea garea, GameForm gf)
    {
        this.garea = garea;
        this.gf = gf;
    }
    
    @Override
    public void run()
    {   
        while(true)
        {
            garea.spawnBlock();

            while(garea.moveBlockDown())
            {
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(garea.isBlockOutOfBounds()) {
                    System.out.println("Game Over.");
                    break;
                }
            }

            garea.moveBlockToBackground();
            score += garea.clearLines(0);
            gf.updateScore(score);

            int lvl = score / scorePerLevel + 1;
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedupPerLevel;
            }
        }
    }
}
