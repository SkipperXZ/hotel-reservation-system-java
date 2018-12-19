package dashboard;

import Account.Account;
import Hotel.Hotel;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Linker;
import main.Main;
import report.Booking;
import report.BookingList;
import reservation.IO;
import reservation.room.*;
import staff.StaffList;
import Hotel.CustomerList;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Hotel.Hotel.hotel;

public class DashboardUI implements Initializable {

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
    @FXML private TableView<Booking> inHouseTable;
    @FXML private TableColumn<Booking, String> guestH;
    @FXML private TableColumn<Booking, String> regNoH;
    @FXML private TableColumn<Booking, String> phoneH;
    @FXML private TableColumn<Booking, String>roomH;
    @FXML private TableColumn<Booking, String> roomTypeH;
    @FXML private TableColumn<Booking, String> nightH;
    @FXML private Label Guest;
    @FXML private Label Occupied;
    @FXML private Label Occupiedpercent;
    @FXML private Label Departures;
    @FXML private Label Arrivals;
    @FXML private ImageView logOut = new ImageView();
    @FXML private ImageView exit = new ImageView();
    @FXML private Label nameHotel;

    static ObservableList<Booking> list1;
    static ObservableList<Booking>list2;
    static ObservableList<Booking>list3;
    static ObservableList<Booking>list4;
    static ObservableList<Booking>list5;
    ArrayList<Booking> allBooking = BookingList.bookingList;
    ArrayList<Booking> arrivalToday = new ArrayList<Booking>();
    ArrayList<Booking> arrivalTomorrow = new ArrayList<Booking>();
    ArrayList<Booking> departureToday = new ArrayList<Booking>();
    ArrayList<Booking> departureTomorrow = new ArrayList<Booking>();
    ArrayList<Booking> inHouse = new ArrayList<Booking>();
    private int arrivalNum=0, departureNum=0, inHouseNum=0;
    private String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    private String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    private int avaliableRoomNum;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        nameHotel.setText("HOTELLO");
        userLabel.setText(Account.currentUser);
        updateRoomAvailaible();
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
            else if(e.getOperation() == 1)
            {
                inHouse.add(e);
                inHouseNum++;
                for (Booking f : allBooking){
                    if(f.getOperation() == 2 && e.getFullname().equals(f.getFullname())){
                        inHouse.remove(e);
                        inHouseNum--;
                        break;
                    }
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
        list5= FXCollections.observableArrayList(
                inHouse
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

        guestH.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNoH.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phoneH.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        roomH.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomTypeH.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        nightH.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        inHouseTable.setItems(list5);

        Arrivals.setText(Integer.toString(arrivalNum));
        Departures.setText(Integer.toString(departureNum));
        Guest.setText(Integer.toString(inHouseNum));

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
        calendarButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newCalendarScene());
            }
        });

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
                IO.saveCustomer(CustomerList.customerList);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingList.bookingList);
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
                IO.saveCustomer(CustomerList.customerList);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingList.bookingList);
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

    }

    public void updateRoomAvailaible(){

        avaliableRoomNum = 0;

        for (int i = 0; i < hotel.get(0).getFloors().length; i++) {
            for (int j = 0; j < hotel.get(0).getFloors()[i].getRooms().length; j++) {
                Room room =hotel.get(0).getFloors()[i].getRooms()[j];

                if(room.getStatus().equals("Vacant")){
                   avaliableRoomNum++;
                }

            }
        }
        Occupied.setText(Integer.toString(60-avaliableRoomNum));
        Occupiedpercent.setText(Integer.toString(((60-avaliableRoomNum)*100)/60)+" %");
    }
}
