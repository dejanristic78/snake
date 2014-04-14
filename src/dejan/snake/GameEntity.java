package dejan.snake;

public abstract class GameEntity {
    protected final GameCanvas gameCanvas;
    public GameEntity(GameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
    }
    protected abstract void update();
}
