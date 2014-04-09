package dejan.snake;

import java.util.ArrayList;
import java.util.List;
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
    private final List <GameEntity> gameEntities;
    
    
    public GuiApplication() {
        gameEntities = new ArrayList<>();
    }
    
    @Override
    public void start(Stage stage) {
        //Platform.setImplicitExit(false);
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        
        GameCanvas canvas = new GameCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        root.getChildren().add(canvas);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
        
        
        
        
        gameEntities.add( new Player(canvas) );
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(GameEntity e : gameEntities) {
                    e.update();
                }
            }
        }));
        
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
        
        
    }
    public static void main(String[] args) {
        
        
        launch(args);
        
    }


    
}
