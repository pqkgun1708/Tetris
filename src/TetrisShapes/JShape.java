package src.TetrisShapes;

import src.tetris.TetrisBlock;

public class JShape extends TetrisBlock
{
    public JShape()
    {
        super(new int[][]{ {0,1},
                           {0,1},
                           {1,1}
        });
    }
}