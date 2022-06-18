package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock 
{
    private int[][] shape;
    private int[][][] shapes;
    private Color color;
    private int x, y;
    private int currentRotation;
    private Color[] colorList = {Color.green, Color.red, Color.blue, Color.yellow, Color.pink, Color.orange, Color.cyan};
    
    public TetrisBlock(int[][] shape) 
    {
        this.shape = shape;
        initShapes();
    }
    
    public void initShapes()
    {
        shapes = new int[4][][];
        for (int i = 0; i < 4; i++)
        {   
            int r = shape[0].length;
            int c = shape.length;
            shapes[i] = new int[r][c];
            
            for (int y = 0; y < r; y++)
            {
                for (int x = 0; x < c; x++)
                {
                    shapes[i][y][x] = shape[c - x - 1][y]; 
                }
            }
            shape = shapes[i];
        }
    }
    
    public void spawn(int gridWidth)
    {   
        Random r = new Random();
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());
        color = colorList[r.nextInt(colorList.length)];
    }
    
    public int[][] getShape() {return shape;}
    
    public Color getColor() {return color;}
    
    public int getHeight() {return shape.length;}
    
    public int getWidth() {return shape[0].length;}
    
    public int getX() {return x;}
    
    public void setX(int newX) {x = newX;}
    
    public int getY() {return y;}
    
    public void setY(int newY) {y = newY;}
    
    public int getBottomEdge() {return y + getHeight();}
    
    public int getLeftEdge() {return x;}
    
    public int getRightEdge() {return x + getWidth();}
    
    // Moving block
    public void moveDown() {y++;}
    
    public void moveRight() {x++;}
    
    public void moveLeft() {x--;}
    
    public void rotate() {
        currentRotation++;
        // Since the block can rotate 90 deg each time so there are 4 types of 1 block, therefore the counter can't be > 4
        if(currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }
} 
