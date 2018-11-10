package staff;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerPopupController implements Initializable {
    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    int userCur = UserDatabase.userCur;

    @FXML
    private Label fullname = new Label();

    @FXML
    private Label employeeId = new Label();

    @FXML
    private Label firstName = new Label();

    @FXML
    private Label lastName = new Label();

    @FXML
    private Label ID = new Label();

    @FXML
    private Label country = new Label();

    @FXML
    private Label tel = new Label();

    @FXML
    private Label email = new Label();

    @FXML
    private Label adderss = new Label();

    @FXML
    private JFXButton cancel = new JFXButton();

    @FXML
    private Label userName = new Label();

    @FXML
    private Label userType = new Label();

    @FXML
    private Label role = new Label();
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Cancel");
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fullname.setText(userArrayList.get(userCur).getFirstName()+" "+userArrayList.get(userCur).getLastName());
        employeeId.setText(userArrayList.get(userCur).getEmployeeId());
        firstName.setText(userArrayList.get(userCur).getFirstName());
        lastName.setText(userArrayList.get(userCur).getLastName());
        ID.setText(userArrayList.get(userCur).getPassId());
        country.setText(userArrayList.get(userCur).getCountry());
        tel.setText(userArrayList.get(userCur).getTel());
        email.setText(userArrayList.get(userCur).getEmail());
        adderss.setText(userArrayList.get(userCur).getAddress());
        userName.setText(userArrayList.get(userCur).getUserName());
        userType.setText(userArrayList.get(userCur).getUserType());
        role.setText(userArrayList.get(userCur).getRole());
        cancel.setOnAction(this::handleButtonAction);
    }
}
