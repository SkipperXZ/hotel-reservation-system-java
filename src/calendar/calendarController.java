package calendar;

import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.Callback;
import report.BookingDatabase;
import main.Linker;
import report.Booking;
import report.BookingDatabase;
import java.util.ArrayList;

public class calendarController {

    @FXML private Label date;
    @FXML private Label time;
    @FXML private Label roomIDLabel_001;
    @FXML private JFXButton dashboardButtton;
    @FXML private JFXButton calendarButtton;
    @FXML private JFXButton reservationButtton;
    @FXML private JFXButton customerButtton;
    @FXML private JFXButton reportButtton;
    @FXML private JFXButton userButtton;
    @FXML private TreeTableView<String> tableDay;
    @FXML private TreeTableColumn<String, String> day01_1;
    @FXML private TreeTableColumn<String, String> day02_1;
    @FXML private TreeTableColumn<String, String> day03_1;
    @FXML private TreeTableColumn<String, String> day04_1;
    @FXML private TreeTableColumn<String, String> day05_1;
    @FXML private TreeTableColumn<String, String> day06_1;
    @FXML private TreeTableColumn<String, String> day07_1;
    @FXML private TreeTableColumn<String, String> day08_1;
    @FXML private TreeTableColumn<String, String> day09_1;
    @FXML private TreeTableColumn<String, String> day10_1;
    @FXML private TreeTableColumn<String, String> day11_1;
    @FXML private TreeTableColumn<String, String> day12_1;
    @FXML private TreeTableColumn<String, String> day13_1;
    @FXML private TreeTableColumn<String, String> day14_1;
    @FXML private TreeTableColumn<String, String> day15_1;
    @FXML private TreeTableColumn<String, String> day16_1;
    @FXML private TreeTableColumn<String, String> day17_1;
    @FXML private TreeTableColumn<String, String> day18_1;
    @FXML private TreeTableColumn<String, String> day19_1;
    @FXML private TreeTableColumn<String, String> day20_1;
    @FXML private TreeTableColumn<String, String> day21_1;
    @FXML private TreeTableColumn<String, String> day22_1;
    @FXML private TreeTableColumn<String, String> day23_1;
    @FXML private TreeTableColumn<String, String> day24_1;
    @FXML private TreeTableColumn<String, String> day25_1;
    @FXML private TreeTableColumn<String, String> day26_1;
    @FXML private TreeTableColumn<String, String> day27_1;
    @FXML private TreeTableColumn<String, String> day28_1;
    @FXML private TreeTableColumn<String, String> day29_1;
    @FXML private TreeTableColumn<String, String> day30_1;
    @FXML private TreeTableColumn<String, String> day31_1;
    @FXML private TreeTableView<String > tableRoom;
    @FXML private TreeTableColumn<String, String> colRoom;



    TreeItem<String> room1 = new TreeItem<>("ROOM1");
    TreeItem<String> Type1 = new TreeItem<>("Type1");
    TreeItem<String> root = new TreeItem<>("ALL TYPE");

    static ObservableList<Booking>floor1;
    static ObservableList<Booking>floor2;
    static ObservableList<Booking>floor3;
    static ObservableList<Booking>floor4;
    static ObservableList<Booking> list;

    ArrayList<Booking> allBooking = BookingDatabase.bookingDatabase;
    ArrayList<Booking> bookingDatabase = BookingDatabase.bookingDatabase;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();

    int bookingCount=0,cancelCount=0;
    String fullName,roomNum,checkDate;
    String fullNameCC,roomNumCC,checkDateCC;

    @FXML
    public void initialize()  {
        for (Booking number : bookingDatabase) {

            System.out.println("Reg Number " + number.getRegNum() +" Full name "+number.getFullname()+" room number "+number.getRoomNum()+" room type "+number.getRoomType()+" operation "+number.getOperation());
            System.out.println("reccord date "+number.getRecordDate()+"record time "+number.getRecordTime());
            System.out.println("time formet "+number.getTimeFormet());
            System.out.println("night sum "+number.getNightNum());
            System.out.println();

        }

        Linker linker = new Linker();
        root.getChildren().setAll(room1,Type1);
        tableRoom.setRoot(root);
        tableRoom.setShowRoot(false);
        tableDay.setRoot(Type1);

        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);


        for (Booking e : bookingDatabase) {
            if (e.getOperation() == 4) {
                bookingData.add(e);
            } else if (e.getOperation() == 1) {
                checkinData.add(e);
            } else if (e.getOperation() == 2) {
                checkoutData.add(e);
            } else if (e.getOperation() == 3) {
                cancelData.add(e);
            }

        }

        for(Booking runCancel :cancelData){
            fullName = runCancel.getFullname();
            roomNum = runCancel.getRoomNum();
            checkDate = runCancel.getRecordDate().toString();

            for (Booking runBooking : bookingData){
                if (fullName.equals(runBooking.getFullname())){
                    if(roomNum.equals(runBooking.getRoomNum())){
                        if(checkDate.equals(runBooking.getRecordDate().toString())){
                            break;
                        }
                        else{
                            bookingCount++;
                        }
                    }
                }
            }
            bookingData.remove(bookingCount);
            bookingCount=0;
        }

        for(Booking runCheckIn :checkinData){
            fullName = runCheckIn.getFullname();
            roomNum = runCheckIn.getRoomNum();
            checkDate = runCheckIn.getRecordDate().toString();

            for (Booking runBooking : bookingData){
                if (fullName.equals(runBooking.getFullname())){
                    if(roomNum.equals(runBooking.getRoomNum())){
                        if(checkDate.equals(runBooking.getRecordDate().toString())){
                            break;
                        }
                        else{
                            bookingCount++;
                        }
                    }
                }
            }
            bookingData.remove(bookingCount);
            bookingCount=0;
        }
        for (Booking runCheckin :bookingData){

        }



        System.out.println(bookingData.size());
        System.out.println(checkinData.size());



       // colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        //day01_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        //day02_1.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        //tableDay.setRoot(room1);



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
        reportButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newReportScene());
            }
        });
        dashboardButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newDashboardScene());
            }
        });
    }

    class calendarTable extends RecursiveTreeObject<calendarTable>{

    }
}
