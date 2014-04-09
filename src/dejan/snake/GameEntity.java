package dejan.snake;

public abstract class GameEntity {
    protected final GameCanvas canvas;
    public GameEntity(GameCanvas canvas) {
        this.canvas = canvas;
    }
    public abstract void update();
}
