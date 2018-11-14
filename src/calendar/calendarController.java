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
import report.BookingDatabase;
import main.Linker;
import report.Booking;

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
    @FXML private TreeTableColumn<String, String> day1;
    @FXML private TreeTableColumn<String, String> day2;
    @FXML private TreeTableColumn<String, String>day3;
    @FXML private TreeTableColumn<String, String>day4;
    @FXML private TreeTableColumn<String, String> day5;
    @FXML private TreeTableColumn<String, String>day6;
    @FXML private TreeTableColumn<String, String> day7;
    @FXML private TreeTableColumn<String, String> day8;
    @FXML private TreeTableColumn<String, String>day9;
    @FXML private TreeTableColumn<String, String> day10;
    @FXML private TreeTableColumn<String, String> day11;
    @FXML private TreeTableColumn<String, String>day12;
    @FXML private TreeTableColumn<String, String> day13;
    @FXML private TreeTableColumn<String, String>day14;
    @FXML private TreeTableColumn<String, String> day15;
    @FXML private TreeTableColumn<String, String>day16;
    @FXML private TreeTableColumn<String, String> day17;
    @FXML private TreeTableColumn<String, String> day18;
    @FXML private TreeTableColumn<String, String> day19;
    @FXML private TreeTableColumn<String, String> day20;
    @FXML private TreeTableColumn<String, String> day21;
    @FXML private TreeTableColumn<String, String> day22;
    @FXML private TreeTableColumn<String, String> day23;
    @FXML private TreeTableColumn<String, String> day24;
    @FXML private TreeTableColumn<String, String> day25;
    @FXML private TreeTableColumn<String, String> day26;
    @FXML private TreeTableColumn<String, String> day27;
    @FXML private TreeTableColumn<String, String> day28;
    @FXML private TreeTableColumn<String, String> day29;
    @FXML private TreeTableColumn<String, String> day30;
    @FXML private TreeTableColumn<String, String> day31;
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



        colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        day1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        day2.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        tableDay.setRoot(room1);


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
    }

    class calendarTable extends RecursiveTreeObject<calendarTable>{

    }
}
