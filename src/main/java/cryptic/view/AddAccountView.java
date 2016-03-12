package cryptic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Logger;

public class AddAccountView {

    private static Logger LOGGER = Logger.getLogger(AddAccountView.class.getName());

    private Stage stage;

    public AddAccountView(Stage parent){
        stage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/add_account.fxml"));
        }catch (Exception e){
            root = null;
        }


        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }
}
