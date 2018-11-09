package staff;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUser implements Initializable {
    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    @FXML
    private Label userID;

    @FXML
    private JFXButton btnCancel = new JFXButton();

    @FXML
    private JFXButton btnSave= new JFXButton();

    @FXML
    private TextField firstName = new TextField();

    @FXML
    private TextField lastName = new TextField();

    @FXML
    private TextField country = new TextField();

    @FXML
    private TextField tel = new TextField();

    @FXML
    private TextField email = new TextField();

    @FXML
    private TextArea address = new TextArea();

    @FXML
    private TextField userName = new TextField();

    @FXML
    private TextField idCard = new TextField();

    @FXML
    private TextField userType = new TextField();
    @FXML
    private TextField pass= new TextField();

    @FXML
    private TextField role = new TextField();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnSave) {
            userArrayList.add(new User("1",userName.getText(),firstName.getText(),lastName.getText(),
                    idCard.getText(),country.getText(),tel.getText(),email.getText(),address.getText(),
                    userType.getText(),role.getText(),new Button(),new Button(),pass.getText()));
            System.out.println("New User");
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }else if(event.getSource()==btnCancel){
            System.out.println("Cancel");
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSave.setOnAction(this::handleButtonAction);
        btnCancel.setOnAction(this::handleButtonAction);
    }
}
