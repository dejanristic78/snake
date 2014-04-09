package dejan.snake;

public abstract class GameEntity {
    protected final GameCanvass canvas;
    public GameEntity(GameCanvass canvas) {
        this.canvas = canvas;
    }
    public abstract void update();
}
