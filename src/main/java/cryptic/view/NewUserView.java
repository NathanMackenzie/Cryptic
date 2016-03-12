package cryptic.view;

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
 *  This class switches stages content over to the new users window view
 *
 * @author Nathan Mackenzie
 */
public class NewUserView {

    private static final Logger LOGGER = Logger.getLogger(NewUserView.class.getName());

    private Stage stage;

    // Define the coordinate location of a click within the scene
    private double sceneX;
    private double sceneY;

    /**
     * Loads the stages new view
     *
     * @param primaryStage the parent stage
     */
    public NewUserView(Stage primaryStage){
        stage = primaryStage;
        Parent root;

        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/new_user.fxml"));
        }catch (Exception e){
            root = null;
            LOGGER.log(Level.SEVERE, "Failed to locate new user view!", e);
        }

        Scene scene = new Scene(root, 250, 350, Color.TRANSPARENT);

        // Listeners for window dragging
        scene.setOnMouseDragged(e -> mouseDragged(e));
        scene.setOnMousePressed(e -> mousePressed(e));

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
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
