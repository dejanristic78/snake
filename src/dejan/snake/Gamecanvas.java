package dejan.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Gamecanvas extends Canvas{
    private final static int WIDTH = 200;
    private final static int HEIGHT = 200;
    private final int X_GRID_SIZE = 20;
    private final int Y_GRID_SIZE = 20;
    private final int RECT_WIDTH = WIDTH / X_GRID_SIZE;
    private final int RECT_HEIGHT = HEIGHT / Y_GRID_SIZE;
    
    
    private int[][] xGrid = new int[X_GRID_SIZE][Y_GRID_SIZE];
    private int[][] yGrid = new int[X_GRID_SIZE][Y_GRID_SIZE];
    
    
    GraphicsContext gc;
    
    public Gamecanvas() {
        super(WIDTH, HEIGHT);
        gc = getGraphicsContext2D();
        
        for(int i = 0; i < X_GRID_SIZE; i++) {
            for(int j = 0; j < Y_GRID_SIZE; j++) {
                xGrid[i][j] = RECT_WIDTH * j;
                yGrid[i][j] = RECT_HEIGHT * i;
            }
        }
    }
    private void getRect(int xPos, int yPos) {
        
    }
    public void drawPos(int xPos, int yPos, Color color) {
        gc.setFill(color);
        gc.fillRect(xGrid[xPos][yPos], yGrid[xPos][yPos], RECT_WIDTH, RECT_HEIGHT);
    }  
}
