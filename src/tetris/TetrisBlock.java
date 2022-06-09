package src.tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock<availableColors>
{
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;
    private Color[] availableColors = {Color.green, Color.red, Color.blue};

    public TetrisBlock(int[][] shape)
    {
        this.shape = shape;
        this.color = color;

        initShapes();
    }

    private void initShapes() //method to store & modify blocks rotations
    {
        shapes = new int[4][][]; //store rotation blocks

        for(int i = 0; i < 4; i++)
        {
            int r = shape[0].length; // rows of shape2 = columns of shape1
            int c = shape.length; //columns of shape2 = rows of shape1

            shapes[i] = new int[r][c];

            for(int y = 0; y < r; y++) //traverse shape2s
            {
                for(int x = 0; x < c; x++)
                {
                    shapes[i][y][x] = shape[c - x - 1][y]; //assign shape1 values to shape2
                }
            }

            shape = shapes[i]; //assign shape2 values back to shape1 to repeat the loop
        }
    }
    
    public void spawn(int gridWidth)
    {
        Random r = new Random();

        currentRotation = r.nextInt(shapes.length); //reset shape rotation every spawn
        shape = shapes[currentRotation]; //then assign it to variable "shape"

        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());
    }
    
    public int[][] getShape() {return shape;}
    
    public Color getColor() {return color;}
    
    public int getHeight() {return shape.length;}
    
    public int getWidth() {return shape[0].length;}
    
    public int getX() {return x;}

    public void setX(int newX){y = newX;}
    
    public int getY() {return y;}

    public void setY(int newY) {y = newY;}

    // Moving block
    public void moveDown() {y++;}
    
    public void moveRight() {x++;}

    public void moveLeft() {x--;}

    public void rotate()
    {
        currentRotation++;
        if(currentRotation > 3) currentRotation = 0;
        shape = shapes[currentRotation];
    }

    public int getBottomEdge() {return y + getHeight();}
    public int getLeftEdge() {return x;}
    public int getRightEdge() {return x + getWidth();}
}
