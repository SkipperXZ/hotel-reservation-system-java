package staff;

import Account.Account;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import main.Linker;
import javafx.scene.control.PasswordField;

public class Login implements Initializable {
    @FXML
    private TextField username = new TextField();

    @FXML
    private Label chUser = new Label();

    @FXML
    private Label chPas = new Label();
    @FXML
    private JFXButton cancel =new JFXButton();
    @FXML
    private PasswordField passWordNa = new PasswordField();
    Linker linker = new Linker();
    int chppp=0;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        chppp++;
        boolean ch1=true,ch2=true,ch3=true;
        chUser.setText("");
        chPas.setText("");
        System.out.println(chppp);
        if(chppp<=5) {
            if (username.getText().equals("")) {
                ch3 = false;
                chUser.setText("*This field is required.");
            }
            if (passWordNa.getText().equals("")) {
                ch2 = false;
                chPas.setText("*This field is required.");
            }
        }else{
            chUser.setText("**Pls login Acc Admin");
            chPas.setText("**Pls login Acc Admin");
        }
        if(UserDatabase.userArrayList.size()>0 && ch3 && ch2){
            for(int i=0;i<UserDatabase.userArrayList.size();i++){
                if(UserDatabase.userArrayList.get(i).getUserName().equals(username.getText())){
                    ch1=false;
                    if(UserDatabase.userArrayList.get(i).getPassWord().equals(passWordNa.getText())){
                        if(chppp>5){
                            if(UserDatabase.userArrayList.get(i).getUserType().equals("Admin")){
                                Account.currentUser = UserDatabase.userArrayList.get(i).getUserName();
                                Account.currentPassword = UserDatabase.userArrayList.get(i).getPassWord();
                                Account.currentUserType = UserDatabase.userArrayList.get(i).getUserType();
                                Linker.primaryStage.setScene(linker.newDashboardScene());
                            }else{
                                break;
                            }

                        }else {
                            Account.currentUser = UserDatabase.userArrayList.get(i).getUserName();
                            Account.currentPassword = UserDatabase.userArrayList.get(i).getPassWord();
                            Account.currentUserType = UserDatabase.userArrayList.get(i).getUserType();
                            Linker.primaryStage.setScene(linker.newDashboardScene());
                        }
                    }else{
                        if(chppp<=5) {
                            chPas.setText("*Wrong Password");
                        }
                        break;
                    }
                }//if user
            }//for i
            if(ch1 && chppp <=5){
                chUser.setText("*Wrong Username");
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancel.setOnAction(this::handleButtonAction);
        chppp=0;
    }
}
