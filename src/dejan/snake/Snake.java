
package dejan.snake;

import javafx.scene.paint.Color;

public class Snake {
    private final Gamecanvas canvas;
    int a = 0;
    
    public Snake(Gamecanvas canvas) {
        this.canvas = canvas;
    }
    public void update() {
        
        canvas.drawPos(a, a, Color.BROWN);
        a++;
    }
}
