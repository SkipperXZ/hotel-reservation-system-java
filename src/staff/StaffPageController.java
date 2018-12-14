package staff;

import Account.Account;
import Hotel.Hotel;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.geometry.Point2D;
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
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import main.Main;
import report.BookingDatabase;
import reservation.IO;
import Hotel.CustomerDatabase;

public class StaffPageController implements Initializable {
    public static int max=100;
//    int []a = new int[max];
    public static ObservableList<Staff>list;
    ArrayList<Staff> userArrayList = StaffDatabase.userArrayList;
    ArrayList<UserNoButton>userNoButtons= StaffDatabase.userNoButtons;
    Linker linker = new Linker();

    @FXML private TableView<Staff>table;
    @FXML private TableColumn<Staff,String> user;
    @FXML private TableColumn<Staff,String> email;
    @FXML private TableColumn<Staff,String> role;
    @FXML private TableColumn<Staff,String> phone;
    @FXML private TableColumn<Staff,String> userType;
    @FXML private TableColumn<Staff, String> btE;
    @FXML private TableColumn<Staff, String> btD;

    @FXML private JFXButton btnNew = new JFXButton();
    @FXML private JFXButton dashboardButtton = new JFXButton();
    @FXML private JFXButton calendarButtton = new JFXButton();
    @FXML private JFXButton reservationButtton = new JFXButton();
    @FXML private JFXButton customerButtton = new JFXButton();
    @FXML private JFXButton reportButtton = new JFXButton();
    @FXML private JFXButton userButtton = new JFXButton();
    @FXML private ImageView logOut = new ImageView();
    @FXML private ImageView exit = new ImageView();
    @FXML private Label nameHotel;
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
                    StaffDatabase.userCur = i;
                    System.out.println("curr " + StaffDatabase.userCur);
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
                    StaffDatabase.userCur = i;
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
        nameHotel.setText("HOTELLO");

        userLabel.setText(Account.currentUser);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    StaffDatabase.userCur=table.getSelectionModel().getFocusedIndex();
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
        final Tooltip tooltip = new Tooltip("Logout");
        tooltip.setStyle("-fx-background-color: #1473e6; -fx-text-fill: white; -fx-font-size: 15; -fx-font-weight: bold; ");
        logOut.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Point2D p = logOut.localToScreen(logOut.getLayoutBounds().getMaxX()-50, logOut.getLayoutBounds().getMaxY()+5);
                tooltip.show(logOut, p.getX(), p.getY());
            }
        });
        logOut.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tooltip.hide();
            }
        });
        // Tooltip.install(logOut, new Tooltip("Logout"));
        logOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IO.saveHotel(Hotel.hotel);
                IO.saveCustomer(CustomerDatabase.customerDatabase);
                IO.saveUser(StaffDatabase.userNoButtons);
                IO.saveAllBooking(BookingDatabase.bookingDatabase);
                System.out.println("Save done");
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

        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IO.saveHotel(Hotel.hotel);
                IO.saveCustomer(CustomerDatabase.customerDatabase);
                IO.saveUser(StaffDatabase.userNoButtons);
                IO.saveAllBooking(BookingDatabase.bookingDatabase);
                System.out.println("Save done");
                System.exit(0);
            }
        });
        final Tooltip tooltipExit = new Tooltip("Exit");
        tooltipExit.setStyle("-fx-background-color: #1473e6; -fx-text-fill: white; -fx-font-size: 15; -fx-font-weight: bold; ");
        exit.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Point2D p = exit.localToScreen(exit.getLayoutBounds().getMaxX()-45, exit.getLayoutBounds().getMaxY()+5);
                tooltipExit.show(exit, p.getX(), p.getY());
            }
        });
        exit.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tooltipExit.hide();
            }
        });
        setButton();
        ///Set Table init
        list = FXCollections.observableArrayList(
                userArrayList
        );
        btnNew.setVisible(false);
        user.setCellValueFactory(new PropertyValueFactory<Staff,String>("userName"));
        email.setCellValueFactory(new PropertyValueFactory<Staff,String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<Staff,String>("role"));
        phone.setCellValueFactory(new PropertyValueFactory<Staff,String>("tel"));
        userType.setCellValueFactory(new PropertyValueFactory<Staff,String>("userType"));
        if(Account.currentUserType.equals("Admin")||Account.currentUserType.equals("prime minister")){
            btE.setCellValueFactory(new PropertyValueFactory<Staff, String>("buttonE"));
            btD.setCellValueFactory(new PropertyValueFactory<Staff, String>("buttonD"));
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
