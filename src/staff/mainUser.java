package staff;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import javafx.scene.Scene;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class mainUser implements Initializable {
    int max=100;
//    int []a = new int[max];
    ObservableList<User>list;
    HashMap<String,User> userHashMap = UserDatabase.userDatabase;
    ArrayList<User> userArrayList = UserDatabase.userArrayList;
    @FXML private TableView<User>table;
    @FXML private TableColumn<User,String> user;
    @FXML private TableColumn<User,String> email;
    @FXML private TableColumn<User,String> role;
    @FXML private TableColumn<User,String> phone;
    @FXML private TableColumn<User,String> userType;
    @FXML private TableColumn<User, String> btE;
    @FXML private TableColumn<User, String> btD;
    @FXML private JFXButton btnNew = new JFXButton();
    @FXML private JFXButton btnRefresh= new JFXButton();

    Button [] buttonE=new Button[max];
    Button [] buttonD=new Button[max];
    @FXML
    private void handleButtonAction(ActionEvent event){
        for(int i=0;i<userArrayList.size();i++){
            if(event.getSource()==buttonE[i]){
                System.out.println("E "+i);
                UserDatabase.userCur=i;
                System.out.println("curr "+UserDatabase.userCur);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/editPageNew.fxml"));
                    Parent root = (Parent)fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Edit");
                    stage.setScene(new Scene(root,1080,720));
                    stage.show();
                }catch (Exception e){

                }
//                setButton();
//                setToTableView();
            }else if(event.getSource()==buttonD[i]){
                userArrayList.remove(i);
                System.out.println("D "+i);
                setButton();
                setToTableView();

            }
        }
        if(event.getSource()==btnNew){
            System.out.println("N ");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//staff/newUserPage.fxml"));
                Parent root = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Edit");
                stage.setScene(new Scene(root,1080,720));
                stage.show();
            }catch (Exception e){

            }
        }
        if(event.getSource()==btnRefresh){
            setButton();
            setToTableView();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        btnNew.setOnAction(this::handleButtonAction);
        btnRefresh.setOnAction(this::handleButtonAction);
//        userHashMap.put("Luke",new User("WTF","Luke","Lukey","Keenaja",
//                "1150","Thailand","088-888-8888","Luke@skywalker.com",
//                "55/54/454","Admin","Manager",new Button(),new Button()));
//        userHashMap.put("Olo",new User("WTF","Opai","Nom","Hum",
//                "5511","Thailand","084-444-4444","Opai@olo.B==>.com",
//                "55/54/454","Admin","Manager",new Button(),new Button()));

        userArrayList.add(new User("WTF","Luke","Lukey","Keenaja",
                "1150","Thailand","088-888-8888","Luke@skywalker.com",
                "55/54/454","Admin","Manager",new Button(),new Button(),"55545454"));
        userArrayList.add(new User("WTF","Opai","Nom","Hum",
                "5511","Thailand","084-444-4444","Opai@olo.B==>.com",
                "55/54/454","Admin","Manager",new Button(),new Button(),"55545454"));
        userArrayList.add(new User("Poppy01","Poppy","Ham","yai",
                "5511","Thailand","084-444-4444","poppyEuEu@olo.B==>.com",
                "55/54/454","Admin","Manager",new Button(),new Button(),"55545454"));


//        list= FXCollections.observableArrayList(
//                new User("WTF","Luke","Lukey","Keenaja",
//                        "1150","Thailand","088-888-8888","Luke@skywalker.com",
//                        "55/54/454","Admin","Manager",buttonE[0],buttonD[0]),
//                new User("WTF","Opai","Nom","Hum",
//                        "5511","Thailand","084-444-4444","Opai@olo.B==>.com",
//                        "55/54/454","Admin","Manager",buttonE[1],buttonD[1])
//        );
        setButton();
        setToTableView();
//        TableColumn user = new TableColumn("User");
//        TableColumn email = new TableColumn("Email");
//        TableColumn role = new TableColumn("Role");
//        TableColumn phone = new TableColumn("Phone");
//        TableColumn userType = new TableColumn("User Type");
//        TableColumn bt = new TableColumn("Action");
//        table.getColumns().addAll(user,email,phone,userType,role,bt);
//
//        user.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
//
//        bt.setCellValueFactory(new PropertyValueFactory<User,String>("button"));
//        table.setItems(list);
    }
    public void setToTableView(){
        list= FXCollections.observableArrayList(
                userArrayList
        );
        user.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
        email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        phone.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
        userType.setCellValueFactory(new PropertyValueFactory<User,String>("userType"));
        btE.setCellValueFactory(new PropertyValueFactory<User,String>("buttonE"));
        btD.setCellValueFactory(new PropertyValueFactory<User,String>("buttonD"));
        table.setItems(list);
    }
    public void setButton(){
        for(int i=0;i<userArrayList.size();i++){
            userArrayList.get(i).setButtonD(buttonD[i]);
            userArrayList.get(i).setButtonE(buttonE[i]);
        }
    }
}
