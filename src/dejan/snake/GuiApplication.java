package dejan.snake;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Dejan
 */
public class GuiApplication extends Application{
    @Override
    public void start(Stage stage) {
        //Platform.setImplicitExit(false);
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        
        Gamecanvas canvas = new Gamecanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        
        
        canvas.drawPos(2, 2, Color.AQUA);
        canvas.drawPos(2, 3, Color.AQUA);
        
        root.getChildren().add(canvas);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
        
        Snake s = new Snake(canvas);
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                s.update();
            }
        }));
        
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
        
        
    }
    private void doThing() {
        System.out.println("thing");
    }
    public static void main(String[] args) {
        
        
        launch(args);
        
    }


    
}
