package staff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class EditUser implements Initializable {

    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    int userCur = UserDatabase.userCur;


    @FXML
    private Label customerID;

    @FXML
    private JFXButton btnCancel=new JFXButton();

    @FXML
    private JFXButton btnSave = new JFXButton();

    @FXML
    private TextField firstName;//

    @FXML
    private TextField lastName;

    @FXML
    private TextField country;//

    @FXML
    private TextField tel;//

    @FXML
    private TextField email;//

    @FXML
    private TextArea address;//



    private Button button = new Button();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnSave) {
            userArrayList.get(userCur).setFirstName(firstName.getText());
            userArrayList.get(userCur).setEmail(email.getText());
            userArrayList.get(userCur).setTel(tel.getText());
            userArrayList.get(userCur).setCountry(country.getText());
            userArrayList.get(userCur).setAddress(address.getText());
            userArrayList.get(userCur).setLastName(lastName.getText());
            System.out.println("Save");
        }else{
            System.out.println("Cancel");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstName.setText(userArrayList.get(userCur).getFirstName());
        email.setText(userArrayList.get(userCur).getEmail());
        tel.setText(userArrayList.get(userCur).getTel());
        country.setText(userArrayList.get(userCur).getCountry());
        address.setText(userArrayList.get(userCur).getAddress());
        lastName.setText(userArrayList.get(userCur).getLastName());
        btnSave.setOnAction(this::handleButtonAction);
        btnCancel.setOnAction(this::handleButtonAction);
    }
}
