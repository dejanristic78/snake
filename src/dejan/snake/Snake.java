
package dejan.snake;

import javafx.scene.paint.Color;

public class Snake extends GameObject{
    private enum direction{ UP, DOWN, LEFT, RIGHT }
    private direction moveDirection = direction.LEFT;
    
    public Snake(Gamecanvas canvas) {
        super(canvas);
    }
    @Override
    public void update() {
    }
}
