package calendar;

import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.Callback;
import jdk.nashorn.api.tree.PropertyTree;
import report.BookingDatabase;
import main.Linker;
import report.Booking;
import report.BookingDatabase;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import calendar.calendar;
import javafx.css.PseudoClass;
import javax.swing.text.html.CSS;

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
    @FXML private TreeTableView<calendar> tableDay;
    @FXML private TreeTableColumn<calendar, String> day01_1;
    @FXML private TreeTableColumn<calendar, String> day02_1;
    @FXML private TreeTableColumn<calendar, String> day03_1;
    @FXML private TreeTableColumn<calendar, String> day04_1;
    @FXML private TreeTableColumn<calendar, String> day05_1;
    @FXML private TreeTableColumn<calendar, String> day06_1;
    @FXML private TreeTableColumn<calendar, String> day07_1;
    @FXML private TreeTableColumn<calendar, String> day08_1;
    @FXML private TreeTableColumn<calendar, String> day09_1;
    @FXML private TreeTableColumn<calendar, String> day10_1;
    @FXML private TreeTableColumn<calendar, String> day11_1;
    @FXML private TreeTableColumn<calendar, String> day12_1;
    @FXML private TreeTableColumn<calendar, String> day13_1;
    @FXML private TreeTableColumn<calendar, String> day14_1;
    @FXML private TreeTableView<String > tableRoom;
    @FXML private TreeTableColumn<String, String> colRoom;
    @FXML private Button makeF1;
    @FXML private Button makeF2;
    @FXML private Button makeF3;
    @FXML private Button makeF4;
    @FXML private Button makeF5;


    TreeItem<String> root = new TreeItem<>("root");
    TreeItem<String> room1 = new TreeItem<>("A101");
    TreeItem<String> room2 = new TreeItem<>("A102");
    TreeItem<String> room3 = new TreeItem<>("A103");
    TreeItem<String> room4 = new TreeItem<>("A104");
    TreeItem<String> room5 = new TreeItem<>("A105");
    TreeItem<String> room6 = new TreeItem<>("A106");
    TreeItem<String> room7 = new TreeItem<>("B107");
    TreeItem<String> room8 = new TreeItem<>("B108");
    TreeItem<String> room9 = new TreeItem<>("B109");
    TreeItem<String> room10 = new TreeItem<>("B110");
    TreeItem<String> room11 = new TreeItem<>("B111");
    TreeItem<String> room12 = new TreeItem<>("B112");

    TreeItem<calendar> root2 = new TreeItem<>();
    TreeItem<calendar> room_2 = new TreeItem<>();
    TreeItem<calendar> room2_2 = new TreeItem<>();
    TreeItem<calendar> room3_2 = new TreeItem<>();
    TreeItem<calendar> room4_2 = new TreeItem<>();
    TreeItem<calendar> room5_2 = new TreeItem<>();
    TreeItem<calendar> room6_2 = new TreeItem<>();
    TreeItem<calendar> room7_2 = new TreeItem<>();
    TreeItem<calendar> room8_2 = new TreeItem<>();
    TreeItem<calendar> room9_2 = new TreeItem<>();
    TreeItem<calendar> room10_2 = new TreeItem<>();
    TreeItem<calendar> room11_2 = new TreeItem<>();
    TreeItem<calendar> room12_2 = new TreeItem<>();


    ArrayList<Booking> bookingDatabase = BookingDatabase.bookingDatabase;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();

    ArrayList<calendar> arrayRoom = new ArrayList<calendar>();

    ArrayList<TreeTableColumn> Day = new ArrayList<TreeTableColumn>();

    ArrayList<TreeItem> Room = new ArrayList<TreeItem>();
    ArrayList<TreeItem> Room2 = new ArrayList<TreeItem>();

    String[] arrayString = new String[14];

    int bookingCount=0,cancelCount=0;
    String fullName,roomNum,checkDate;
    String fullNameCC,roomNumCC;

    private PseudoClass childOfSelected = PseudoClass.getPseudoClass("child-of-selected");
    private PseudoClass parentOfSelected = PseudoClass.getPseudoClass("parent-of-selected");

    @FXML
    public void initialize()  {
        addDay();
        for (Booking number : bookingDatabase) {

            System.out.println("Reg Number " + number.getRegNum() +" Full name "+number.getFullname()+" room number "+number.getRoomNum()+" room type "+number.getRoomType()+" operation "+number.getOperation());
            System.out.println("reccord date "+number.getRecordDate()+"record time "+number.getRecordTime());
            System.out.println("time formet "+number.getTimeFormet());
            System.out.println("night sum "+number.getNightNum());
            System.out.println();

        }

        Linker linker = new Linker();

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
                            if (checkDate.equals(runBooking.getRecordDate().toString())) {
                                break;
                            } else {
                                bookingCount++;
                            }
                    }else {bookingCount++;}
                }else {bookingCount++;}
            }
            if(bookingCount == bookingData.size()){
                bookingCount = 0;
            }
            else{
                bookingData.remove(bookingCount);
                bookingCount=0;

            }

        }

        for(Booking runCheckIn :checkinData) {
            fullName = runCheckIn.getFullname();
            roomNum = runCheckIn.getRoomNum();
            checkDate = runCheckIn.getRecordDate().toString();

            for (Booking runBooking : bookingData) {
                if (fullName.equals(runBooking.getFullname())) {
                    if (roomNum.equals(runBooking.getRoomNum())) {
                            if (checkDate.equals(runBooking.getRecordDate().toString())) {
                                runCheckIn.setNightNum(runBooking.getNightNum());
                                break;
                            } else {
                                bookingCount++;
                            }
                    } else {
                        bookingCount++;
                    }
                } else {
                    bookingCount++;
                }
            }

            if(bookingCount == bookingData.size()){
                System.out.println(bookingCount+" "+bookingData.get(0).getRoomNum());
                bookingCount = 0;
                System.out.println("remove fail");
            }
            else {
                bookingData.remove(bookingCount);
                bookingCount=0;
                System.out.println("removed");
            }

        }
            for (Booking runOut : checkoutData) {
                fullNameCC = runOut.getFullname();
                roomNumCC = runOut.getRoomNum();
                for (Booking runCheck : checkinData) {
                    if (fullNameCC.equals(runCheck.getFullname())) {
                        if (roomNumCC.equals(runCheck.getRoomNum())) {
                            break;
                        } else {
                            cancelCount++;
                        }
                    } else {
                        cancelCount++;
                    }
                }
                if(cancelCount == checkinData.size()){
                    cancelCount = 0;
                }
                else {
                    checkinData.remove(cancelCount);
                    cancelCount=0;

                }
            }


        for (int i = 0;i<12;i++){
            arrayRoom.add(new calendar(" "," "," "," "," "," "," "," "," "," "," "," "," "," "));
        }
        comPare();
        calendarSet();



        root.getChildren().setAll(room1,room2,room3,room4,room5,room6,room7,room8,room9,room10,room11,room12);
        tableRoom.setRoot(root);
        tableRoom.setShowRoot(false);

        colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));

        day01_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col1"));
        day02_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col2"));
        day03_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col3"));
        day04_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col4"));
        day05_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col5"));
        day06_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col6"));
        day07_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col7"));
        day08_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col8"));
        day09_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col9"));
        day10_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col10"));
        day11_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col11"));
        day12_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col12"));
        day13_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col13"));
        day14_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col14"));








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

    public void calendarSet(){
        int num=0;
        for (TreeTableColumn cal:Day){
            cal.setText(LocalDateTime.now().plusDays(num).format(DateTimeFormatter.ofPattern("dd MMM")));
            num++;
        }

    }

    public void addDay (){
        Day.add(day01_1);
        Day.add(day02_1);
        Day.add(day03_1);
        Day.add(day04_1);
        Day.add(day05_1);
        Day.add(day06_1);
        Day.add(day07_1);
        Day.add(day08_1);
        Day.add(day09_1);
        Day.add(day10_1);
        Day.add(day11_1);
        Day.add(day12_1);
        Day.add(day13_1);
        Day.add(day14_1);

        Room.add(room1);
        Room.add(room2);
        Room.add(room3);
        Room.add(room4);
        Room.add(room5);
        Room.add(room6);
        Room.add(room7);
        Room.add(room8);
        Room.add(room9);
        Room.add(room10);
        Room.add(room11);
        Room.add(room12);

        Room2.add(room_2);
        Room2.add(room2_2);
        Room2.add(room3_2);
        Room2.add(room4_2);
        Room2.add(room5_2);
        Room2.add(room6_2);
        Room2.add(room7_2);
        Room2.add(room8_2);
        Room2.add(room9_2);
        Room2.add(room10_2);
        Room2.add(room11_2);
        Room2.add(room12_2);
    }
    public void comPare(){
        int count =0;
        long day;
        for (int i =0;i<12;i++) {
            for (int array = 0; array < 14; array++) {
                arrayString[array] = " ";
            }
            for (Booking c : checkinData) {
                if (c.getRoomNum().equals(Room.get(i).getValue())) {
                    if (c.getRecordTime().plusDays(c.getNightNum()).isAfter(LocalDateTime.now())) {
                        day = Math.abs(Duration.between(c.getRecordTime().plusDays(c.getNightNum()),LocalDateTime.now()).toDays());
                        for (int k = 0; k <= day; k++) {
                            if (k == 14){
                                break;
                            }
                            else {
                                arrayString[k] = "*";
                            }
                        }
                    }

                }
            }
            for (Booking c : bookingData) {
                if (c.getRoomNum().equals(Room.get(i).getValue())) {
                    if (c.getRecordTime().plusDays(c.getNightNum()).isAfter(LocalDateTime.now())) {
                        day = Math.abs(Duration.between(c.getRecordTime().plusDays(c.getNightNum()),LocalDateTime.now()).toDays());
                        for (int k = 0; k <= day; k++) {
                            if (k == 14){
                                break;
                            }
                            else {
                                arrayString[k] = "=";
                            }
                        }

                    }

                }
            }


            arrayRoom.set(i, new calendar(arrayString[0], arrayString[1],
                    arrayString[2], arrayString[3],
                    arrayString[4], arrayString[5],
                    arrayString[6], arrayString[7],
                    arrayString[8], arrayString[9],
                    arrayString[10], arrayString[11],
                    arrayString[12], arrayString[13]
            ));

        }

        for (calendar a : arrayRoom){
            Room2.get(count).setValue(a);
            root2.getChildren().setAll(room_2,room2_2,room3_2,room4_2,
                    room5_2,room6_2,room7_2,room8_2,
                    room9_2,room10_2,room11_2,room12_2);
            tableDay.setRoot(root2);
            tableDay.setShowRoot(false);
            count++;
        }
    }
    public void color (String col){
        if (col.equals("*")){

        }
        else if (col.equals("=")){

        }
    }

}
