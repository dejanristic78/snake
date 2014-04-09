
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
            if(segmentNr < bodyLength) {
                nextSegment = new BodySegment(xPos, yPos, ++segmentNr);
            }
            else {
                nextSegment = null;
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
            canvas.drawBlock(this.xPos, this.yPos, Color.BLUE);
        }
        
    }
    
    private BodySegment head;
    private int bodyLength = 3;

    public static enum Direction{ UP, DOWN, LEFT, RIGHT }
    private Direction moveDirection = Direction.LEFT;
    
    private int xPos = 5;
    private int yPos = 5;
    

    public Player(GameCanvas canvas) {
        super(canvas);
        head = new BodySegment(xPos, yPos, 0);
    }
    @Override
    public void update() {
        switch(moveDirection) {
            case UP:    yPos--;     break;
            case DOWN:  yPos++;     break;
            case LEFT:  xPos--;     break;
            case RIGHT: xPos++;     break;
        }
        head.update(xPos, yPos);
    }
    @Override
    public void handle(KeyEvent event) {
        final KeyCode keyCode = event.getCode();
        switch(keyCode) {
            case UP:
                if(moveDirection != Direction.DOWN)
                    moveDirection = Direction.UP;       
                break;
            case DOWN:  
                if(moveDirection != Direction.UP)
                    moveDirection = Direction.DOWN;     
                break;
            case LEFT:  
                if(moveDirection != Direction.RIGHT)
                    moveDirection = Direction.LEFT;     
                break;
            case RIGHT: 
                if(moveDirection != Direction.LEFT)
                    moveDirection = Direction.RIGHT;    
                break;
        }
    }
}
