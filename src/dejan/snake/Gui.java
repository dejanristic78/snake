package dejan.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Dejan
 */
public class Gui extends Application implements Runnable{
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        
        Gamecanvas canvas = new Gamecanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //gc.setFill(Color.CADETBLUE);
        //gc.fillRect(0, 0, 500, 500);
        
        canvas.drawPos(2, 2, Color.AQUA);
        canvas.drawPos(2, 3, Color.AQUA);
        
        root.getChildren().add(canvas);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        
        main(null);
    }
}
