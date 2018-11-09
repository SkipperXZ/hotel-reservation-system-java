package customer;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NewCustomerController{
        @FXML
        private Label customerID;

        @FXML
        private JFXButton btnCancel;

        @FXML
        private JFXButton btnCreate;

        @FXML
        private TextField firstName;

        @FXML
        private TextField lastName;

        @FXML
        private TextField ID;

        @FXML
        private TextField country;

        @FXML
        private TextField tel;

        @FXML
        private TextField email;

        @FXML
        private TextArea address;


    @FXML
    public void initialize() {


            btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            Stage stage = (Stage) btnCancel.getScene().getWindow();
                            stage.close();
                    }
            });

    }

}
