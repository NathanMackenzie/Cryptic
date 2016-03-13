package cryptic.controller;

import cryptic.model.AddAccountModel;
import cryptic.view.WindowView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.logging.Logger;

public class AddAccountController {

    private static Logger LOGGER = Logger.getLogger(AddAccountController.class.getName());

    @FXML
    Pane content;

    @FXML
    ComboBox comboBox;

    @FXML
    public void initialize(){
        comboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                switch (newValue.intValue()){
                    case 0:
                        loadEmail();
                        break;
                }
            }
        });
    }

    private void loadEmail(){
        try{
            content.getChildren().clear();
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/dialogues/email.fxml")));
        }catch (Exception e){
            System.out.print(e);
        }
    }

    private void addEmail(){
        TextField userName = (TextField) content.lookup("#userName");
        TextField website = (TextField) content.lookup("#website");
        TextField password = (TextField) content.lookup("#password");

        new AddAccountModel().addEmail(WindowView.getUserID(), website.getText(),
                userName.getText(), password.getText());
    }

    public void add(){
        switch (comboBox.getSelectionModel().getSelectedIndex()){
            case 0:
                addEmail();
                break;
        }
    }


}
