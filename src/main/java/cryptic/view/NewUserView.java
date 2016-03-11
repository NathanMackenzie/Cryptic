package cryptic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  This class switches stages content over to the new users window view
 *
 * @author Nathan Mackenzie
 */
public class NewUserView {

    private static final Logger LOGGER = Logger.getLogger(NewUserView.class.getName());

    /**
     * Loads the stages new view
     *
     * @param primaryStage the parent stage
     */
    public NewUserView(Stage primaryStage){
        Parent root;

        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/new_user.fxml"));
        }catch (Exception e){
            root = null;
            LOGGER.log(Level.SEVERE, "Failed to locate new user view!", e);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
