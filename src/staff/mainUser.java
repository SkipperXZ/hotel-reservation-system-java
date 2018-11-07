package staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class mainUser implements Initializable {

    @FXML private TableView<User>table;
    @FXML private TableColumn<User,String> user;
    @FXML private TableColumn<User,String> email;
    @FXML private TableColumn<User,String> role;
    @FXML private TableColumn<User,String> phone;
    @FXML private TableColumn<User,String> userType;
    @FXML private TableColumn<User, String> bt;
    @FXML
    private void handleButtonAction(ActionEvent event){
        System.out.print("Click WTF");
    }


    public ObservableList<User>list= FXCollections.observableArrayList(
            new User("WTF","Luke","Lukey","Keenaja",
                    "1150","Thailand","088-888-8888","Luke@skywalker.com",
                    "55/54/454","Admin","Manager"),
            new User("WTF","Opai","Nom","Hum",
                    "5511","Thailand","084-444-4444","Opai@olo.B==>.com",
                    "55/54/454","Admin","Manager")
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
        email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        phone.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
        userType.setCellValueFactory(new PropertyValueFactory<User,String>("userType"));
        bt.setCellValueFactory(new PropertyValueFactory<User,String>("button"));
        table.setItems(list);
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
}
