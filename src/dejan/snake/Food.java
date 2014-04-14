package dejan.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class Food extends GameEntity{
    private final static Color COLOR = Color.GREEN;
    private int xPos; 
    private int yPos; 
    private final Player player;
    
    
    public Food(GameCanvas gameCanvas, Player player) {
        super(gameCanvas);
        this.player = player;
        placeFood();
    }
    private void placeFood() {
        Random rand = new Random();
        int xPos;
        int yPos;
        do {
            xPos = rand.nextInt(gameCanvas.X_GRID_SIZE);
            yPos = rand.nextInt(gameCanvas.Y_GRID_SIZE);
        } while( player.occupies(xPos, yPos) );
        this.xPos = xPos;
        this.yPos = yPos;
    }
    @Override
    public void update() {
        gameCanvas.drawBlock(xPos, yPos, COLOR);
        if( player.occupies(xPos, yPos) ) {
            System.out.println("Food found");
            player.foundFood();
            placeFood();
        }
    }
    
    
}
