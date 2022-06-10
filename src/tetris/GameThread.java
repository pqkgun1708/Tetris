package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread
{   
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    private int speed = 700;
    private int speedupPerLevel = 100;
    
    public GameThread(GameArea ga, GameForm gf)
    {
        this.ga = ga;
        this.gf = gf;
        
        gf.updateScore(score);
        gf.updateLevel(level);
    }
    
    @Override
    public void run()
    {   
        // game loop
        while(true)
        {   
            ga.spawnBlock();
            while(ga.moveBlockDown()) 
            {
                try {
                    Thread.sleep(speed);
                } 
                catch (InterruptedException ex) 
                {
                    return;
                }
            }
            
            if (ga.isOutOfBound())
            {
                Tetris.gameOver(score);
                break;
            }
            
            ga.moveBlockToBackGround();
            score += ga.clearLines();
            gf.updateScore(score);
            // update level 
            int lvl = score / scorePerLevel + 1;
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                speed -= speedupPerLevel;
            }
        }
    }
}
