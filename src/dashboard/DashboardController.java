package dashboard;

import Account.Account;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import main.Linker;
import report.AllBooking;
import report.Booking;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML private Label date;
    @FXML private Label time;
    @FXML private ImageView userPic;
    @FXML private Label userLabel;
    @FXML private JFXButton dashboardButtton;
    @FXML private JFXButton calendarButtton;
    @FXML private JFXButton reservationButtton;
    @FXML private JFXButton customerButtton;
    @FXML private JFXButton reportButtton;
    @FXML private JFXButton userButtton;
    @FXML private TableView<Booking> arrivalTodayTable;
    @FXML private TableColumn<Booking, String> guestA1;
    @FXML private TableColumn<Booking, String> regNoA1;
    @FXML private TableColumn<Booking, String> phoneA1;
    @FXML private TableColumn<Booking, String> roomA1;
    @FXML private TableColumn<Booking, String> roomTypeA1;
    @FXML private TableColumn<Booking, String> nightA1;
    @FXML private TableView<Booking> arrivalTomorrowTable;
    @FXML private TableColumn<Booking, String> guestA2;
    @FXML private TableColumn<Booking, String> regNoA2;
    @FXML private TableColumn<Booking, String> phoneA2;
    @FXML private TableColumn<Booking, String> roomA2;
    @FXML private TableColumn<Booking, String> roomTypeA2;
    @FXML private TableColumn<Booking, String> nightA2;
    @FXML private TableView<Booking> departureTodayTable;
    @FXML private TableColumn<Booking, String> guestD1;
    @FXML private TableColumn<Booking, String> regNoD1;
    @FXML private TableColumn<Booking, String> phoneD1;
    @FXML private TableColumn<Booking, String> roomD1;
    @FXML private TableColumn<Booking, String> roomTypeD1;
    @FXML private TableColumn<Booking, String> nightD1;
    @FXML private TableView<Booking> departureTomorrowTable;
    @FXML private TableColumn<Booking, String> guestD2;
    @FXML private TableColumn<Booking, String> regNoD2;
    @FXML private TableColumn<Booking, String> phoneD2;
    @FXML private TableColumn<Booking, String> roomD2;
    @FXML private TableColumn<Booking, String>roomTypeD2;
    @FXML private TableColumn<Booking, String> nightD2;
    @FXML private Label Guest;
    @FXML private Label Occupied;
    @FXML private Label Occupiedpercent;
    @FXML private Label Departures;
    @FXML private Label Arrivals;

    static ObservableList<Booking> list1;
    static ObservableList<Booking>list2;
    static ObservableList<Booking>list3;
    static ObservableList<Booking>list4;
    ArrayList<Booking> allBooking = AllBooking.allBooking;
    ArrayList<Booking> arrivalToday = new ArrayList<Booking>();
    ArrayList<Booking> arrivalTomorrow = new ArrayList<Booking>();
    ArrayList<Booking> departureToday = new ArrayList<Booking>();
    ArrayList<Booking> departureTomorrow = new ArrayList<Booking>();
    private int arrivalNum=0, departureNum=0;
    private String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    private String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        userLabel.setText(Account.currentUser);
        Linker linker = new Linker();

        for (Booking e : allBooking) {

            if(e.getOperation() == 4) {
                if (e.getArrivalDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).equals(todayDate)) {
                    arrivalToday.add(e);
                    arrivalNum++;
                }
                else if (e.getArrivalDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).equals(tomorrowDate)) {
                    arrivalTomorrow.add(e);
                }
                if ( e.getDepartureDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).equals(todayDate)) {
                    departureToday.add(e);
                    departureNum++;
                }
                else if (e.getDepartureDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).equals(tomorrowDate)) {
                    departureTomorrow.add(e);
                }
            }
        }
        list1= FXCollections.observableArrayList(
                arrivalToday
        );
        list2= FXCollections.observableArrayList(
                arrivalTomorrow
        );
        list3= FXCollections.observableArrayList(
                departureToday
        );
        list4= FXCollections.observableArrayList(
                departureTomorrow
        );

        guestA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNoA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phoneA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        roomA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomTypeA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        nightA1.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        arrivalTodayTable.setItems(list1);

        guestA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNoA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phoneA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        roomA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomTypeA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        nightA2.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        arrivalTomorrowTable.setItems(list2);

        guestD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNoD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phoneD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        roomD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomTypeD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        nightD1.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        departureTodayTable.setItems(list3);

        guestD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNoD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phoneD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        roomD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomTypeD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        nightD2.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        departureTomorrowTable.setItems(list4);

        calendarButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newCalendarScene());
            }
        });

        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newResScene());
            }
        });
        customerButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newCustomerScene());
            }
        });
        reportButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newReportScene());
            }
        });
        userButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newUserScene());
            }
        });

    }
}
