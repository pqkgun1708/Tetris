package src.tetris;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import TetrisShape.*;

public class GameArea extends JPanel 
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock block;
    private TetrisBlock[] blocks;
    private Color[] background;
    
    // Set game board , constructor
    public GameArea(JPanel placeholder, int columns) 
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        // setup grid
        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
        background = new Color[gridRows][gridColumns];
        blocks = new TetrisBlock[]{new IShape(),
                                   new JShape(),
                                   new LShape(),
                                   new OShape(),
                                   new SShape(),
                                   new TShape(),
                                   new ZShape()};
        
        spawnBlock();
    }
    
    public void spawnBlock()
    {   
        // L shape
        block = new TetrisBlock( new int[][]{{1,0}, {1,0}, {1,1}}, Color.green);
        block.spawn(gridColumns);
    }
     
    public boolean checkBottom() 
    {
        if( block.getBottomEdge() == gridRows )
        {
            return false;
        }
        
        return true;
    }
    
    public void moveBlockDown() 
    {   
        if(checkBottom() == false) 
            return;
        block.moveDown();
        repaint();
    }
    
    public void moveBlockRight() 
    {
        block.moveRight();
        repaint();
    }
    
    public void moveBlockLeft()
    {
        block.moveLeft();
        repaint();
    }
    
    // set block location
    private void drawBlock(Graphics g) 
    {
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int[][] shape = block.getShape();
        
        for(int row = 0; row < h; row++)
        {
            for(int col = 0; col < w; col++)
            {
                if(shape[row][col] == 1)
                {   
                    int x = (block.getX() + col) * gridCellSize;
                    int y = (block.getY() + row) * gridCellSize;
                    g.setColor(c);
                    g.fillRect(x, y, gridCellSize, gridCellSize); // draw block shape
                    g.setColor(Color.black);
                    g.drawRect(x, y, gridCellSize, gridCellSize); // draw the grid on the block
                }
            }
        }
    }
    
    // draw grid
    @Override
    protected void paintComponent(Graphics g)
    {
        // draw things on game board
        super.paintComponent(g);
        
        // draw block
        drawBlock(g);
    }
}
