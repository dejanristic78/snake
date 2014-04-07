package dejan.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock implements Runnable{
    private List<Snake> snakes; 
    
    
    public Clock() {
        snakes = new ArrayList<>();
    }
    public void addSnake(Snake snake) {
        snakes.add(snake);
    }

    @Override
    public void run() {
        System.out.println("qqq");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Snake s : snakes) {
            s.update();
        }
    }
    
}
