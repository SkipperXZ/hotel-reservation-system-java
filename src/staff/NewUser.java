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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class NewUser implements Initializable {
    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    ArrayList<UserNoButton>userNoButtons=UserDatabase.userNoButtons;
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
    private ImageView image = new ImageView();

    @FXML private JFXButton btnImage = new JFXButton();

    @FXML
    private TextField passWord= new TextField();
    @FXML
    private TextField role = new TextField();
    @FXML private Label chUser = new Label();

    @FXML private Label chEmail = new Label();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        chUser.setText("");
        chEmail.setText("");
        if(event.getSource()==btnSave) {
            boolean ch1=true,ch2=true,ch3=true,ch4=true,ch5=true,ch6=true,ch7=true,ch8=true;

            for(int i=0;i<userArrayList.size();i++){
                if(userArrayList.get(i).getUserName().equals(userName.getText()))ch1=false;
                if(userArrayList.get(i).getEmail().equals(email.getText()))ch2=false;
            }
            if (userName.getText().equals(""))ch3=false;
            if (email.getText().equals(""))ch4=false;
            if (firstName.getText().equals(""))ch5=false;
            if(lastName.getText().equals(""))ch6=false;
            if(userType.getText().equals(""))ch7=false;
            if(passWord.getText().equals(""))ch8=false;
            if((ch1&&ch2&&ch3&&ch4&&ch5&&ch6&&ch7&&ch8)||(userArrayList.size()==0)) {
                userArrayList.add(new User(Integer.toString(UserDatabase.employeeId), userName.getText(), firstName.getText(), lastName.getText(),
                        idCard.getText(), country.getText(), tel.getText(), email.getText(), address.getText(),
                        userType.getText(), role.getText(), new Button(), new Button(), pass.getText(), passWord.getText()));
                userNoButtons.add(new UserNoButton(Integer.toString(UserDatabase.employeeId), userName.getText(), firstName.getText(), lastName.getText(),
                        idCard.getText(), country.getText(), tel.getText(), email.getText(), address.getText(),
                        userType.getText(), role.getText(), pass.getText(), passWord.getText()));
                System.out.println("New User");
                UserDatabase.employeeId++;
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                stage.close();
                mainUser mu = new mainUser();
                mu.update();
            }
            if(ch3==false||ch4==false||ch5==false||ch6==false||ch7==false||ch8==false){
                chUser.setText("Please enter : Username,Password,UserType,Fristname,Lastname and Email ");
            }else {
                if (ch1 == false) chUser.setText("This username already taken.");
                if (ch2 == false) chEmail.setText("This email already taken.");
            }

        }else if(event.getSource()==btnCancel){
            System.out.println("Cancel");
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }else if(event.getSource()==btnImage){
            //image.setImage(new Image("src/staff/logo.png"));
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSave.setOnAction(this::handleButtonAction);
        btnCancel.setOnAction(this::handleButtonAction);
        btnImage.setOnAction(this::handleButtonAction);
        userID.setText(Integer.toString(UserDatabase.employeeId));
    }
}
