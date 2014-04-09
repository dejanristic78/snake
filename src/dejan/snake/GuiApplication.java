package dejan.snake;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
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
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        
        GameCanvas canvas = new GameCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        root.getChildren().add(canvas);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
        
        
        
        Player p1 = new Player(canvas);
        scene.setOnKeyPressed(p1);
        gameEntities.add(p1);
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>() {
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
