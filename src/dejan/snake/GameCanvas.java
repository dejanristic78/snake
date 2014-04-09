package dejan.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas{
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    public final int X_GRID_SIZE = 30;
    public final int Y_GRID_SIZE = 30;
    private final int RECT_WIDTH = WIDTH / X_GRID_SIZE;
    private final int RECT_HEIGHT = HEIGHT / Y_GRID_SIZE;
    
    GraphicsContext gc;
    
    public GameCanvas() {
        super(WIDTH, HEIGHT);
        gc = getGraphicsContext2D();
    }
    public void drawBlock(int xPos, int yPos, Color color) {
        int x = RECT_WIDTH * xPos;
        int y = RECT_HEIGHT * yPos;
        gc.setFill(color);
        gc.fillRect(x, y, RECT_WIDTH, RECT_HEIGHT);
    }  
    public void clear() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        
    }
}
