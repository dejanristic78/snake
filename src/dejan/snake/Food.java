package dejan.snake;

import java.util.List;
import javafx.scene.paint.Color;

public class Food extends GameEntity{
    private static final int INITIAL_NR_FOOD_ITEMS = 9;
    private static List foodItems;
    private static int nrFoodItems;
    
    private boolean consumed = false;
    private int xPos; 
    private int yPos; 
    
    public Food(GameCanvas gameCanvas) {
        super(gameCanvas);
    }
    @Override
    public void update() {
        Color color = Color.GREEN;
        if(consumed) color = Color.WHITE;
        canvas.drawBlock(this.xPos, this.yPos, color);
    }
    
}
