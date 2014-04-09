
package dejan.snake;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Player extends GameEntity implements EventHandler<KeyEvent>{
    private class BodySegment{
        private BodySegment nextSegment;
        private final int segmentNr;
        private int xPos;
        private int yPos;
        public BodySegment(int xPos, int yPos, int segmentNr) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.segmentNr = segmentNr;
            tryGrow();
        }
        
        private void tryGrow() {
            int nextSegmentNr = segmentNr + 1;
            if(nextSegmentNr < bodyLength) {
                nextSegment = new BodySegment(xPos, yPos, nextSegmentNr);
            }
            else {
                nextSegment = null;
                tail = this;
            }
        }
        
        public void update(int xPos, int yPos) {
            if(nextSegment == null) {
                canvas.drawBlock(this.xPos, this.yPos, Color.WHITE);
            }
            else { 
                nextSegment.update(this.xPos, this.yPos); 
            }
            
            this.xPos = xPos;
            this.yPos = yPos;
              
            canvas.drawBlock(this.xPos, this.yPos, COLOR);
        }
        
    }
    
    private final static int INIT_SIZE = 4;
    private final static float GROW_FACTOR = 2f;
    private final static Color COLOR = Color.BLUE;
    
    private BodySegment head;
    private BodySegment tail;
    private int bodyLength = INIT_SIZE;

    public static enum Direction{ UP, DOWN, LEFT, RIGHT }
    private Direction moveDirection;
    private Direction nextMoveDirection = Direction.RIGHT;
    
    private int xPos = 5;
    private int yPos = 5;
    
    private Food food;

    public Player(GameCanvas canvas, Food food) {
        super(canvas);
        tail = null;
        head = new BodySegment(xPos, yPos, 0);
        this.food = food;
    }
    @Override
    public void update() {
        moveDirection = nextMoveDirection;
        switch(moveDirection) {
            case UP:    yPos--;     break;
            case DOWN:  yPos++;     break;
            case LEFT:  xPos--;     break;
            case RIGHT: xPos++;     break;
        }
        head.update(xPos, yPos);
        
        if( food.foundItem(this) ) {
            bodyLength = (int)(bodyLength * GROW_FACTOR);
            tail.tryGrow();
        }
    }
    @Override
    public void handle(KeyEvent event) {
        final KeyCode keyCode = event.getCode();
        switch(keyCode) {
            case UP:
                if(moveDirection != Direction.DOWN)
                    nextMoveDirection = Direction.UP;       
                break;
            case DOWN:  
                if(moveDirection != Direction.UP)
                    nextMoveDirection = Direction.DOWN;     
                break;
            case LEFT:  
                if(moveDirection != Direction.RIGHT)
                    nextMoveDirection = Direction.LEFT;     
                break;
            case RIGHT: 
                if(moveDirection != Direction.LEFT)
                    nextMoveDirection = Direction.RIGHT;    
                break;
        }
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
    
}
