package staff;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import main.Linker;

public class Login implements Initializable {
    @FXML
    private TextField username = new TextField();

    @FXML
    private TextField password = new TextField();

    @FXML
    private Label chUser = new Label();

    @FXML
    private Label chPas = new Label();
    @FXML
    private JFXButton cancel =new JFXButton();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        boolean ch1=true,ch3=true;
        chUser.setText("");
        chPas.setText("");
        if(username.getText()==null){
            ch3=false;
            chUser.setText("This field is required.");
            System.out.println("5555555555");
        }
        if(password.getText()==null){
            ch3=false;
            chPas.setText("This field is required.");
        }
        if(UserDatabase.userArrayList.size()>0 && ch3){
            for(int i=0;i<UserDatabase.userArrayList.size();i++){
                if(UserDatabase.userArrayList.get(i).getUserName().equals(username.getText())){
                    ch1=false;
                    if(UserDatabase.userArrayList.get(i).getPassWord().equals(password.getText())){

                    }else{
                        chPas.setText("Wrong Password");
                        break;
                    }
                }//if user
            }//for i
            if(ch1){
                chUser.setText("Wrong Username");
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText("");
        password.setText("");
        cancel.setOnAction(this::handleButtonAction);
    }
}
