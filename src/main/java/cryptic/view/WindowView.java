package cryptic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowView {
    static int userID;
    public WindowView(Stage primaryStage, int userID){
        this.userID = userID;
        Parent root;

        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/window.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            System.out.print(e.getCause());
        }
    }
}
