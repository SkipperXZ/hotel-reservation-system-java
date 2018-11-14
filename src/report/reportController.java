package report;

import Account.Account;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Linker;
import main.Main;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class reportController implements Initializable {

    static ObservableList<Booking>list1;
    static ObservableList<Booking>list2;
    static ObservableList<Booking>list3;
    static ObservableList<Booking>list4;
    static ObservableList<Booking> list;
    ArrayList<Booking> allBooking = BookingDatabase.bookingDatabase;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();

    private int checkinNum=0, checkoutNum=0, cancelNum=0, bookingNum=0;

    Linker linker;
    private String currentDay;
    static int click=0;
    @FXML private Label date;
    @FXML private Label time;
    @FXML private Label userLabel;
    @FXML private JFXButton dashboardButtton;
    @FXML private JFXButton calendarButtton;
    @FXML private JFXButton reservationButtton;
    @FXML private JFXButton customerButtton;
    @FXML private JFXButton userButtton;
    @FXML private Label currentDayLabel;
    @FXML private Button makePreDay;
    @FXML private Button makeNextDay;
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
    @FXML private TableColumn<Booking, String> checkoutTime2;
    @FXML private TableView<Booking> cancelTable;
    @FXML private TableColumn<Booking, String> guest3;
    @FXML private TableColumn<Booking, String> regNo3;
    @FXML private TableColumn<Booking, String> phone3;
    @FXML private TableColumn<Booking, String> room3;
    @FXML private TableColumn<Booking, String> roomType3;
    @FXML private TableColumn<Booking, String> price3;
    @FXML private TableColumn<Booking, String> checkinTime3;
    @FXML private TableColumn<Booking, String> checkoutTime3;
    @FXML private TableColumn<Booking, String> nightNum3;
    @FXML private TableView<Booking> bookingTable;
    @FXML private TableColumn<Booking, String> guest4;
    @FXML private TableColumn<Booking, String> regNo4;
    @FXML private TableColumn<Booking, String> phone4;
    @FXML private TableColumn<Booking, String> room4;
    @FXML private TableColumn<Booking, String> roomType4;
    @FXML private TableColumn<Booking, String> price4;
    @FXML private TableColumn<Booking, String> checkinTime4;
    @FXML private TableColumn<Booking, String> checkoutTime4;
    @FXML private TableColumn<Booking, String> nightNum4;
    @FXML private TableView<Booking> summaryTable;
    @FXML private TableColumn<Booking, String> summary;
    @FXML private TableColumn<Booking, String> total;
    @FXML private ImageView logOut = new ImageView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Linker linker = new Linker();
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        userLabel.setText(Account.currentUser);
        currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        for (Booking e : allBooking) {

            if(e.getOperation()==1) {
                checkinData.add(e);
                checkinNum++;
            }
            else if(e.getOperation()==2) {
                checkoutData.add(e);
                checkoutNum++;
            }
            else if(e.getOperation()==3) {
                cancelData.add(e);
                cancelNum++;
            }
            else if(e.getOperation()==4) {
                bookingData.add(e);
                bookingNum++;
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
        checkinTime1.setCellValueFactory(new PropertyValueFactory<Booking, String>("timeFormet"));
        checkinTable.setItems(list1);

        guest2.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo2.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone2.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price2.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkoutTime2.setCellValueFactory(new PropertyValueFactory<Booking, String>("timeFormet"));
        checkoutTable.setItems(list2);

        guest3.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo3.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone3.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price3.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime3.setCellValueFactory(new PropertyValueFactory<Booking, String>("arrivalTimeFormet"));
        checkoutTime3.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureTimeFormet"));
        nightNum3.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        cancelTable.setItems(list3);

        guest4.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo4.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone4.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price4.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime4.setCellValueFactory(new PropertyValueFactory<Booking, String>("arrivalTimeFormet"));
        checkoutTime4.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureTimeFormet"));
        nightNum4.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        bookingTable.setItems(list4);

        summary.setCellValueFactory(new PropertyValueFactory<>("summaryTopic"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        list = getSummaryList();
        summaryTable.setItems(list);

        makePreDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(click<30) {
                    click++;
                    if (currentDay.equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))) && click == 0) {
                        currentDayLabel.setText("TODAY");
                    } else {
                        currentDayLabel.setText(LocalDate.now().minusDays(click).format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
                    }
                    updateReport();
                }
            }
        });

        makeNextDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(click>0) {
                    click--;
                    if (currentDay.equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))) && click == 0) {
                        currentDayLabel.setText("TODAY");
                    } else {
                        currentDayLabel.setText(LocalDate.now().minusDays(click).format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
                    }
                    updateReport();
                }
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

        userButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newUserScene());
            }
        });

        dashboardButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newDashboardScene());
            }
        });
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

    }

    public void updateReport(){

        checkinData.clear();
        checkoutData.clear();
        cancelData.clear();
        bookingData.clear();

        checkoutNum=0;
        checkinNum=0;
        cancelNum=0;
        bookingNum=0;

        for (Booking e : allBooking) {

            if(e.getRecordDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).equals(LocalDate.now().minusDays(click).format(DateTimeFormatter.ofPattern("dd MMM yyyy")))) {

                if (e.getOperation() == 1) {
                    checkinData.add(e);
                    checkinNum++;
                } else if (e.getOperation() == 2) {
                    checkoutData.add(e);
                    checkoutNum++;
                } else if (e.getOperation() == 3) {
                    cancelData.add(e);
                    cancelNum++;
                } else if (e.getOperation() == 4) {
                    bookingData.add(e);
                    bookingNum++;
                }
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
        checkinTime1.setCellValueFactory(new PropertyValueFactory<Booking, String>("timeFormet"));
        checkinTable.setItems(list1);

        guest2.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        roomType2.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price2.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkoutTime2.setCellValueFactory(new PropertyValueFactory<Booking, String>("timeFormet"));
        checkoutTable.setItems(list2);

        guest3.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo3.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone3.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType3.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price3.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime3.setCellValueFactory(new PropertyValueFactory<Booking, String>("arrivalTimeFormet"));
        checkoutTime3.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureTimeFormet"));
        nightNum3.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        cancelTable.setItems(list3);

        guest4.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullname"));
        regNo4.setCellValueFactory(new PropertyValueFactory<Booking, String>("regNum"));
        phone4.setCellValueFactory(new PropertyValueFactory<Booking, String>("tel"));
        room4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNum"));
        roomType4.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomType"));
        price4.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        checkinTime4.setCellValueFactory(new PropertyValueFactory<Booking, String>("arrivalTimeFormet"));
        checkoutTime4.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureTimeFormet"));
        nightNum4.setCellValueFactory(new PropertyValueFactory<Booking, String>("nightNum"));
        bookingTable.setItems(list4);

        summary.setCellValueFactory(new PropertyValueFactory<>("summaryTopic"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        list = getSummaryList();
        summaryTable.setItems(list);
    }

    private ObservableList<Booking> getSummaryList() {

        Booking topic1 = new Booking("Check-In", checkinNum);
        Booking topic2 = new Booking("Check-Out", checkoutNum);
        Booking topic3 = new Booking("Cancellation", cancelNum);
        Booking topic4 = new Booking("Booking", bookingNum);

        ObservableList<Booking> list = FXCollections.observableArrayList(topic1, topic2, topic3, topic4);
        return list;
    }

}
