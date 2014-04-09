
package dejan.snake;

import javafx.scene.paint.Color;

public class Player extends GameEntity{
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
            Color color;
            //if(segmentNr == bodyLength) color = Color.WHITE;
            //else color = Color.BLUE;
            
            
            if(nextSegment == null) {
                canvas.drawPos(this.xPos, this.yPos, Color.WHITE);
            }
            else { 
                nextSegment.update(this.xPos, this.yPos); 
            }
            
            this.xPos = xPos;
            this.yPos = yPos;
            canvas.drawPos(this.xPos, this.yPos, Color.BLUE);
        }
        
    }
    private static enum direction{ UP, DOWN, LEFT, RIGHT }
    private direction moveDirection = direction.LEFT;
    
    private BodySegment head;
    private int bodyLength = 3;
    int a = 5;
    
    public Player(GameCanvass canvas) {
        super(canvas);
        head = new BodySegment(5, 5, 0);
    }
    @Override
    public void update() {
        a++;
        //canvas.drawPos(a, a, Color.BLUE);
        canvas.clear();
        head.update(a, a);
    }
}
