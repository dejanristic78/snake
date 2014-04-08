package dejan.snake;

public abstract class GameObject {
    protected final Gamecanvas canvas;
    public GameObject(Gamecanvas canvas) {
        this.canvas = canvas;
    }
    public abstract void update();
}
