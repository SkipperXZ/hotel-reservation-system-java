package report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
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
import main.Linker;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class reportController implements Initializable {

    ObservableList<Booking>list1;
    ObservableList<Booking>list2;
    ObservableList<Booking>list3;
    ObservableList<Booking>list4;
    ArrayList<Booking> allBooking = AllBooking.allBooking;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();

    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label roomIDLabel_001;
    @FXML
    private JFXButton dashboardButtton;
    @FXML
    private JFXButton calendarButtton;
    @FXML
    private JFXButton reservationButtton;
    @FXML
    private JFXButton customerButtton;
    @FXML
    private JFXButton reportButtton;
    @FXML
    private JFXButton userButtton;
    @FXML
    private Label currentDayLabel;
    @FXML
    private Button makePreDay;
    @FXML
    private Button makeNextDay;
    @FXML private TableView<Booking> checkinTable;
    @FXML private TableColumn<Booking, String> guest1;
    @FXML private TableColumn<Booking, String> regNo1;
    @FXML private TableColumn<Booking, String> phone1;
    @FXML private TableColumn<Booking, String> room1;
    @FXML private TableColumn<Booking, String> roomType1;
    @FXML private TableColumn<Booking, String> price1;
    @FXML private TableColumn<Booking, String> checkinTime1;
    @FXML private TableView<Booking> checkoutTable;
    @FXML private TableColumn<Booking, String> guest2;
    @FXML private TableColumn<Booking, String> regNo2;
    @FXML private TableColumn<Booking, String> phone2;
    @FXML private TableColumn<Booking, String> room2;
    @FXML private TableColumn<Booking, String> roomType2;
    @FXML private TableColumn<Booking, String> price2;
    @FXML private TableColumn<Booking, String> checkinTime2;
    @FXML private TableView<Booking> cancelTable;
    @FXML private TableColumn<Booking, String> guest3;
    @FXML private TableColumn<Booking, String> regNo3;
    @FXML private TableColumn<Booking, String> phone3;
    @FXML private TableColumn<Booking, String> room3;
    @FXML private TableColumn<Booking, String> roomType3;
    @FXML private TableColumn<Booking, String> price3;
    @FXML private TableColumn<Booking, String> checkinTime3;
    @FXML private TableView<Booking> bookingTable;
    @FXML private TableColumn<Booking, String> guest4;
    @FXML private TableColumn<Booking, String> regNo4;
    @FXML private TableColumn<Booking, String> phone4;
    @FXML private TableColumn<Booking, String> room4;
    @FXML private TableColumn<Booking, String> roomType4;
    @FXML private TableColumn<Booking, String> price4;
    @FXML private TableColumn<Booking, String> checkinTime4;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Booking e : allBooking) {

            if(e.getOperation()==1) {
                checkinData.add(e);
            }
            else if(e.getOperation()==2) {
                checkoutData.add(e);
            }
            else if(e.getOperation()==3) {
                cancelData.add(e);
            }
            else if(e.getOperation()==4) {
                bookingData.add(e);
            }
        }
        list1= FXCollections.observableArrayList(
                checkinData
        );
        list2= FXCollections.observableArrayList(
                checkoutData
        );
        list3= FXCollections.observableArrayList(
                cancelData
        );
        list4= FXCollections.observableArrayList(
                bookingData
        );

        guest1.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo1.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone1.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price1.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime1.setCellValueFactory(new PropertyValueFactory<Booking, String>("recordTime"));
        checkinTable.setItems(list1);

        guest2.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo2.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone2.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price2.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime2.setCellValueFactory(new PropertyValueFactory<Booking, String>("recordTime"));
        checkoutTable.setItems(list2);

        guest3.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo3.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone3.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price3.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime3.setCellValueFactory(new PropertyValueFactory<Booking, String>("recordTime"));
        cancelTable.setItems(list3);

        guest4.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo4.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone4.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price4.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime4.setCellValueFactory(new PropertyValueFactory<Booking, String>("recordTime"));
        bookingTable.setItems(list4);

        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(Linker.resScene);
            }
        });
    }

}
