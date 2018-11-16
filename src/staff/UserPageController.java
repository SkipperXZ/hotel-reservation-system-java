package staff;

import Account.Account;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import javafx.scene.Scene;
import main.Linker;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import main.Main;

public class UserPageController implements Initializable {
    public static int max=100;
//    int []a = new int[max];
    public static ObservableList<User>list;
    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    ArrayList<UserNoButton>userNoButtons=UserDatabase.userNoButtons;
    Linker linker = new Linker();

    @FXML private TableView<User>table;
    @FXML private TableColumn<User,String> user;
    @FXML private TableColumn<User,String> email;
    @FXML private TableColumn<User,String> role;
    @FXML private TableColumn<User,String> phone;
    @FXML private TableColumn<User,String> userType;
    @FXML private TableColumn<User, String> btE;
    @FXML private TableColumn<User, String> btD;

    @FXML private JFXButton btnNew = new JFXButton();
    @FXML private JFXButton dashboardButtton = new JFXButton();
    @FXML private JFXButton calendarButtton = new JFXButton();
    @FXML private JFXButton reservationButtton = new JFXButton();
    @FXML private JFXButton customerButtton = new JFXButton();
    @FXML private JFXButton reportButtton = new JFXButton();
    @FXML private JFXButton userButtton = new JFXButton();
    @FXML private ImageView logOut = new ImageView();
    @FXML private Label date;

    @FXML private Label time;
    @FXML private ImageView userPic;
    @FXML private Label userLabel;

    public static Button [] buttonE=new Button[max];
    public static Button [] buttonD=new Button[max];
    @FXML
    private void handleButtonAction(ActionEvent event){
        if((Account.currentUserType.equals("Admin")||Account.currentUserType.equals("prime minister"))) {
            for (int i = 0; i < userArrayList.size(); i++) {
                if (event.getSource() == buttonE[i]) {
                    System.out.println("E " + i);
                    UserDatabase.userCur = i;
                    System.out.println("curr " + UserDatabase.userCur);
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/editPageNew.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Edit : "+userArrayList.get(i).getFirstName()+" "+userArrayList.get(i).getLastName());
                        stage.setScene(new Scene(root, 1080, 720));
                        stage.show();
                    } catch (Exception e) {

                    }
//                setButton();
//                setToTableView();
                } else if (event.getSource() == buttonD[i]) {
                    UserDatabase.userCur = i;
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/popUpDelete.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Delete : "+userArrayList.get(i).getFirstName()+" "+userArrayList.get(i).getLastName());
                        stage.setScene(new Scene(root, 300, 200));
                        stage.show();
                    } catch (Exception e) {

                    }
                    System.out.println("D " + i);
                }
            }
        }
        if(event.getSource()==btnNew && (Account.currentUserType.equals("Admin")||Account.currentUserType.equals("prime minister"))) {
            System.out.println("N ");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/newUserPage.fxml"));
                Parent root = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("New User");
                stage.setScene(new Scene(root,1080,720));
                stage.show();
            }catch (Exception e){

            }
        }else if(event.getSource()==dashboardButtton){
            Linker.primaryStage.setScene(linker.newDashboardScene());
        }else if(event.getSource()==calendarButtton){
            Linker.primaryStage.setScene(linker.newCustomerScene());
        }else if(event.getSource()==reservationButtton){
            Linker.primaryStage.setScene(linker.newResScene());
        }else if(event.getSource()==reportButtton){
            Linker.primaryStage.setScene(linker.newReportScene());
        }else if(event.getSource()==userButtton){
            Linker.primaryStage.setScene(linker.newUserScene());
        }else if(event.getSource()==customerButtton){
            Linker.primaryStage.setScene(linker.newCustomerScene());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        userLabel.setText(Account.currentUser);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    UserDatabase.userCur=table.getSelectionModel().getFocusedIndex();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/userPopUp.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Edit");
                        stage.setScene(new Scene(root,1080,720));
                        stage.show();
                    }catch (Exception e){

                    }
                }
            }
        });
        for(int i=0;i<max;i++){
            buttonE[i]=new Button();
            buttonE[i].setOnAction(this::handleButtonAction);
            buttonD[i]=new Button();
            buttonD[i].setOnAction(this::handleButtonAction);
//            a[i]=-1;
        }

        dashboardButtton.setOnAction(this::handleButtonAction);
        calendarButtton.setOnAction(this::handleButtonAction);
        reservationButtton.setOnAction(this::handleButtonAction);
        reportButtton.setOnAction(this::handleButtonAction);
        customerButtton.setOnAction(this::handleButtonAction);
        userButtton.setOnAction(this::handleButtonAction);
        logOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Linker.primaryStage.close();
                Stage stage= new Stage();
                Main main = new Main();
                try {
                    main.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setButton();
        ///Set Table init
        list = FXCollections.observableArrayList(
                userArrayList
        );
        btnNew.setVisible(false);
        user.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
        email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        phone.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
        userType.setCellValueFactory(new PropertyValueFactory<User,String>("userType"));
        if(Account.currentUserType.equals("Admin")||Account.currentUserType.equals("prime minister")){
            btE.setCellValueFactory(new PropertyValueFactory<User, String>("buttonE"));
            btD.setCellValueFactory(new PropertyValueFactory<User, String>("buttonD"));
            btnNew.setOnAction(this::handleButtonAction);
            btnNew.setVisible(true);
        }
        table.setItems(list);
    }

    public void setButton(){
        for(int i=0;i<userArrayList.size();i++){
            userArrayList.get(i).setButtonD(buttonD[i]);
            userArrayList.get(i).setButtonE(buttonE[i]);
        }
    }
    public void update(){
        list.clear();
        setButton();
        for(int i=0;i<userArrayList.size();i++) {
            list.add(userArrayList.get(i));
        }
    }

}
