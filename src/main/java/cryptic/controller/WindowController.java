package cryptic.controller;

import cryptic.view.AddAccountView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * This class handles all control (MVC) functionality of /view/WindowView.
 *
 * @author Nathan Mackenzie
 */
public class WindowController {

    @FXML
    Parent root;

    @FXML
    public void addAccount(){
        new AddAccountView((Stage) root.getScene().getWindow());
    }
}
