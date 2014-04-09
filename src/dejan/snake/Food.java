package dejan.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class Food extends GameEntity{
    public class FoodItem {
        private final int xPos; 
        private final int yPos; 

        public FoodItem(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
            canvas.drawBlock(this.xPos, this.yPos, Color.GREEN);
        }
        
    }
    private static final int INITIAL_NR_FOOD_ITEMS = 9;
    private static List<FoodItem> foodItems;
    
    
    public Food(GameCanvas gameCanvas) {
        super(gameCanvas);
        placeFoodItems();
    }
    private void placeFoodItems() {
        Random rand = new Random();
        foodItems = new ArrayList<>(INITIAL_NR_FOOD_ITEMS);
        for(int i = 0; i < INITIAL_NR_FOOD_ITEMS; i++) {
            int xPos = rand.nextInt(canvas.X_GRID_SIZE);
            int yPos = rand.nextInt(canvas.Y_GRID_SIZE);
            foodItems.add( new FoodItem(xPos, yPos) );
            System.out.println("x: "+xPos+"y: "+yPos);
        }
    }
    @Override
    public void update() {
    }
    public boolean foundItem(Player player) {
        FoodItem found = null;
        for(FoodItem fi : foodItems) {
            if( fi.xPos == player.getXPos() && fi.yPos == player.getYPos() ) {
                found = fi;
                break;
            }
        }
        if(found == null) {
            return false;
        }
        else {
            foodItems.remove(found);
            System.out.println("Food items left: "+foodItems.size());
            return true;
        }
    }
    
}
