package cryptic.controller;

import cryptic.model.NewUserModel;
import cryptic.model.SQLiteDatabase;

import cryptic.view.WindowView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * This class handles all control (MVC) functionality of /view/NewUserView.
 *
 * @author Nathan Mackenzie
 */
public class NewUserController {

    private static final Logger LOGGER = Logger.getLogger(NewUserController.class.getName());

    @FXML
    private Parent root;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField verifyPasswordField;
    @FXML
    private Text warningLabel;

    @FXML
    public void createUser(){
        NewUserModel db = new NewUserModel();

        // Verify matching passwords
        if(passwordField.getText().equals(verifyPasswordField.getText())){

            LOGGER.info("Attempting to add user...");
            if(!db.addUser(userNameField.getText(), passwordField.getText())){
                warningLabel.setText("User Already Exists");
            }else{
                new WindowView(db.login(userNameField.getText(), passwordField.getText()));
                root.getScene().getWindow().hide();
            }
        }else{
            warningLabel.setText("Passwords Don't Match");
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
    }
}
