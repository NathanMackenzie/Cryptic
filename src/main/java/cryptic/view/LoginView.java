package cryptic.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main class of Cryptic which starts the entire application.
 *
 * @author Nathan Mackenzie
 */
public class LoginView extends Application {

    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    private Stage stage;

    // Define the coordinate location of a click within the scene
    private double sceneX;
    private double sceneY;

    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;

        // Load view
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        }catch (Exception e){
            root = null;
            LOGGER.log(Level.SEVERE, "Failed to locate login view!", e);
        }

        Scene scene = new Scene(root, 250, 350, Color.TRANSPARENT);

        // Listeners for window dragging
        scene.setOnMouseDragged(e -> mouseDragged(e));
        scene.setOnMousePressed(e -> mousePressed(e));

        primaryStage.setTitle("Cryptic");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }


    /**
     * Starts the application.
     *
     * @param args command line parameters
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void mouseDragged(MouseEvent e){
        stage.setX(e.getScreenX()-sceneX);
        stage.setY(e.getScreenY()-sceneY);
    }

    private void mousePressed(MouseEvent e){
        sceneX = e.getSceneX();
        sceneY = e.getSceneY();
    }
}
