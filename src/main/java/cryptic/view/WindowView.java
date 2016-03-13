package cryptic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Logger;

public class WindowView {

    private static Logger LOGGER = Logger.getLogger(WindowView.class.getName());

    private Stage stage;

    private static int userID;

    public WindowView(int userID){
        this.userID = userID;

        stage = new Stage();
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/window.fxml"));
        }catch (Exception e){
            root = null;
            System.out.print(e.getCause());
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static int getUserID(){
        return userID;
    }
}
