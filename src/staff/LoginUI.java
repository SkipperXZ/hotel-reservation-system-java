package staff;

import Account.Account;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Linker;

public class LoginUI implements Initializable {
    @FXML
    private JFXTextField username = new JFXTextField ();

    @FXML
    private Label chUser = new Label();

    @FXML
    private Label chPas = new Label();
    @FXML
    private JFXButton login =new JFXButton();
    @FXML
    private JFXPasswordField passWordNa = new JFXPasswordField ();
    @FXML
    private ImageView exit;


    Linker linker = new Linker();
    int chppp=0;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        chppp++;
        boolean ch1=true,ch2=true,ch3=true;
        chUser.setText("");
        chPas.setText("");
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
        if(StaffList.userArrayList.size()>0 && ch3 && ch2){
            for(int i = 0; i< StaffList.userArrayList.size(); i++){
                System.out.println(StaffList.userArrayList.get(i).getUserName());
                if(StaffList.userArrayList.get(i).getUserName().equals(username.getText())){
                    ch1=false;
                    if(StaffList.userArrayList.get(i).getPassWord().equals(passWordNa.getText())){
                        if(chppp>5){
                            if(StaffList.userArrayList.get(i).getUserType().equals("Admin")){
                                Account.currentUser = StaffList.userArrayList.get(i).getUserName();
                                Account.currentPassword = StaffList.userArrayList.get(i).getPassWord();
                                Account.currentUserType = StaffList.userArrayList.get(i).getUserType();
                                Linker.primaryStage.setScene(linker.newDashboardScene());
                                Linker.primaryStage.setX(0);
                                Linker.primaryStage.setY(0);
                            }else{
                                break;
                            }

                        }else {
                            Account.currentUser = StaffList.userArrayList.get(i).getUserName();
                            Account.currentPassword = StaffList.userArrayList.get(i).getPassWord();
                            Account.currentUserType = StaffList.userArrayList.get(i).getUserType();
                            Linker.primaryStage.setScene(linker.newDashboardScene());
                            Linker.primaryStage.setX(0);
                            Linker.primaryStage.setY(0);
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
        chUser.setText("");
        chPas.setText("");
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
            }
        });
//
//        root.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                xOffset = event.getSceneX();
//                yOffset = event.getSceneY();
//            }
//        });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                stage.setX(event.getScreeX() - xOfnfset);
//                stage.setY(event.getScreenY() - yOffset);
//            }
//        });
//
//        stage.setScene(new Scene(root));
//        stage.setTitle(item.getValue().firstName.get()+" "+item.getValue().lastName.get());
//        stage.show();



        login.setOnAction(this::handleButtonAction);
        chppp=0;
    }
}
