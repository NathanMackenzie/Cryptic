package cryptic.controller;

import cryptic.model.AddAccountModel;
import cryptic.view.WindowView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 *
 * @author Nathan Mackenzie
 */
public class AddAccountController {

    private static Logger LOGGER = Logger.getLogger(AddAccountController.class.getName());

    @FXML
    Pane content;
    @FXML
    Text warningLabel;
    @FXML
    ComboBox comboBox;

    @FXML
    public void initialize(){
        comboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                switch (newValue.intValue()){
                    case 0:
                        loadReg();
                        break;
                    case 1:
                        loadCreditCard();
                        break;
                }
            }
        });
    }


    private void loadReg(){
        try{
            content.getChildren().clear();
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/dialogues/reg_account.fxml")));
        }catch (Exception e){
            System.out.print(e);
        }
    }

    private void loadCreditCard(){
        try {
            content.getChildren().clear();
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/dialogues/credit_card.fxml")));
        }catch (Exception e){
            System.out.print(e);
        }
    }

    private void addReg(){
        TextField name = (TextField) content.lookup("#name");
        TextField website = (TextField) content.lookup("#website");
        TextField username = (TextField) content.lookup("#username");
        TextField password = (TextField) content.lookup("#password");
        TextField category = (TextField) content.lookup("#category");

        if(name.getText() == null || name.getText().trim().isEmpty() ||
                category.getText() == null || category.getText().trim().isEmpty()){
            warningLabel.setText("Name and Category text fields cannot be empty!");
        }else{
            new AddAccountModel().add(WindowView.getUserID(), name.getText(), website.getText(),
                    username.getText(), password.getText(), category.getText());
            ((Stage) content.getScene().getWindow()).close();
        }

    }

    private void addCreditCard(){
        TextField name = (TextField) content.lookup("#ccName");
        TextField ccNum = (TextField) content.lookup("#ccNum");

    }


    public void add(){
        switch (comboBox.getSelectionModel().getSelectedIndex()){
            case 0:
                addReg();
                break;
        }
    }


}
