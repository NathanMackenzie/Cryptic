package cryptic.controller;

import cryptic.model.LoginModel;
import cryptic.view.NewUserView;
import cryptic.view.WindowView;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * This class provides all the control (MVC) functionality of the /view/LoginView.
 *
 * @author Nathan Mackenzie
 */
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @FXML
    private Parent root;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text warningLabel;

    @FXML
    public void login(){
        LoginModel db = new LoginModel();

        // Get users ID
        LOGGER.info("Attempting to log in...");
        int userID = db.login(userNameField.getText(), passwordField.getText());

        // Check to see if login was successful
        if(userID == -1){
            warningLabel.setText("Username or Password Incorrect");
        }else{
            new WindowView((Stage) userNameField.getScene().getWindow(), userID);
        }
    }

    @FXML
    public void newUser(){
        new NewUserView((Stage) root.getScene().getWindow());
    }

}
