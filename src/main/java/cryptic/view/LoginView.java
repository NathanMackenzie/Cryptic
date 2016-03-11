package cryptic.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main class of Cryptic which starts the entire application.
 *
 * @author Nathan Mackenzie
 */
public class LoginView extends Application {

    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    @Override
    public void start(Stage primaryStage){
        // Load view
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        }catch (Exception e){
            root = null;
            LOGGER.log(Level.SEVERE, "Failed to locate login view!", e);
        }

        primaryStage.setTitle("Cryptic");
        primaryStage.setScene(new Scene(root, 250, 350));
        primaryStage.setResizable(false);
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
}
