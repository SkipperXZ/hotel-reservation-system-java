package staff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import javafx.scene.Scene;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class EditUser implements Initializable {

    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    int userCur = UserDatabase.userCur;
    @FXML
    private TextField userN = new TextField();
    @FXML
    private TextField email= new TextField();
    @FXML
    private TextField phone= new TextField();
    @FXML
    private TextField userType= new TextField();
    @FXML
    private TextField role= new TextField();
    @FXML
    private Button button = new Button();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        userArrayList.get(userCur).setUserName(userN.getText());
        userArrayList.get(userCur).setEmail(email.getText());
        userArrayList.get(userCur).setTel(phone.getText());
        userArrayList.get(userCur).setUserType(userType.getText());
        userArrayList.get(userCur).setRole(role.getText());
        System.out.println(userCur);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::handleButtonAction);
    }
}
