package calendar;

import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import calendar.calendar;

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


    TreeItem<String> root = new TreeItem<>("root");
    TreeItem<String> room1 = new TreeItem<>("A101");
    TreeItem<String> room2 = new TreeItem<>("A102");
    TreeItem<String> room3 = new TreeItem<>("A103");
    TreeItem<String> room4 = new TreeItem<>("A104");
    TreeItem<String> room5 = new TreeItem<>("A105");
    TreeItem<String> room6 = new TreeItem<>("A106");
    TreeItem<String> room7 = new TreeItem<>("B101");
    TreeItem<String> room8 = new TreeItem<>("B102");
    TreeItem<String> room9 = new TreeItem<>("B103");
    TreeItem<String> room10 = new TreeItem<>("B104");
    TreeItem<String> room11 = new TreeItem<>("B105");
    TreeItem<String> room12 = new TreeItem<>("B106");

    TreeItem<calendar> root2 = new TreeItem<>();
    TreeItem<calendar> room = new TreeItem<>();



    static ObservableList<calendar>floor1;
    static ObservableList<Booking>floor2;
    static ObservableList<Booking>floor3;
    static ObservableList<Booking>floor4;
    static ObservableList<Booking> list;

    ArrayList<Booking> bookingDatabase = BookingDatabase.bookingDatabase;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();

    ArrayList<calendar> arrayRoom = new ArrayList<calendar>();

    ArrayList<TreeTableColumn> Day = new ArrayList<TreeTableColumn>();
    ArrayList<TreeItem> Room = new ArrayList<TreeItem>();
    String[] arrayString = new String[14];

    int bookingCount=0,cancelCount=0;
    String fullName,roomNum,checkDate;
    String fullNameCC,roomNumCC,checkDateCC;

    @FXML
    public void initialize()  {
        addDay();
        calendarSet();
        for (Booking number : bookingDatabase) {

            System.out.println("Reg Number " + number.getRegNum() +" Full name "+number.getFullname()+" room number "+number.getRoomNum()+" room type "+number.getRoomType()+" operation "+number.getOperation());
            System.out.println("reccord date "+number.getRecordDate()+"record time "+number.getRecordTime());
            System.out.println("time formet "+number.getTimeFormet());
            System.out.println("night sum "+number.getNightNum());
            System.out.println();

        }

        Linker linker = new Linker();

        root.getChildren().setAll(room1,room2,room3,room4,room5,room6,room7,room8,room9,room10,room11,room12);
        tableRoom.setRoot(root);
        tableRoom.setShowRoot(false);

        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);

        System.out.println(day01_1.getText());

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
        for (Booking runOut :checkoutData){
            fullNameCC = runOut.getFullname();
            roomNumCC = runOut.getRoomNum();
            for (Booking runCheck : checkinData){
                if (fullNameCC.equals(runCheck.getFullname())){
                    if (roomNumCC.equals(runCheck.getRoomNum())){
                        break;
                    }
                    else {
                         cancelCount++;
                    }
                }
            }
            checkinData.remove(cancelCount);
            cancelCount = 0;
        }
        for(Booking a:checkinData){
            System.out.println(a.getNightNum()+" "+a.getFullname()+" "+a.getRecordTime());
        }
        //comPare();
        int day;
        int month;
        int year;
        String all;
        //all =LocalDateTime.now().plusDays(checkinData.get(0).getNightNum()).format(DateTimeFormatter.ofPattern("YYYY-MMM-DD"));
       // System.out.println("============");
        //System.out.println(checkinData.get(1).getNightNum());
       // System.out.println(all);
        //day = Integer.parseInt(all.substring(8));
        //System.out.println(day);


        colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));

        day01_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol1()));
        day02_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol2()));
        day03_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol3()));
        day04_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol4()));
        day05_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol5()));
        day06_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol6()));
        day07_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol7()));
        day08_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol8()));
        day09_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol9()));
        day10_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol10()));
        day11_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol11()));
        day12_1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCol12()));
        tableDay.setRoot(root2);
        tableDay.setShowRoot(false);





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
       // day01_1.setCellValueFactory(new TreeItemPropertyValueFactory<calendar,String>("col1"));

    }

    public void calendarSet(){
        day01_1.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM")));
        day02_1.setText(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd MMM")));
        day03_1.setText(LocalDateTime.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd MMM")));
        day04_1.setText(LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd MMM")));
        day05_1.setText(LocalDateTime.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd MMM")));
        day06_1.setText(LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd MMM")));
        day07_1.setText(LocalDateTime.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd MMM")));
        day08_1.setText(LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd MMM")));
        day09_1.setText(LocalDateTime.now().plusDays(8).format(DateTimeFormatter.ofPattern("dd MMM")));
        day10_1.setText(LocalDateTime.now().plusDays(9).format(DateTimeFormatter.ofPattern("dd MMM")));
        day11_1.setText(LocalDateTime.now().plusDays(10).format(DateTimeFormatter.ofPattern("dd MMM")));
        day12_1.setText(LocalDateTime.now().plusDays(11).format(DateTimeFormatter.ofPattern("dd MMM")));
        day13_1.setText(LocalDateTime.now().plusDays(12).format(DateTimeFormatter.ofPattern("dd MMM")));
        day14_1.setText(LocalDateTime.now().plusDays(13).format(DateTimeFormatter.ofPattern("dd MMM")));


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
        Day.add(day08_1);
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
    }
    public void comPare(){
        String all;
        int day,month,year;
        for (int i =0;i<12;i++) {
            for (int array = 0; array < 14; array++) {
                arrayString[array] = " ";
            }
            for (int j = 0; j < 13; j++) {
                for (Booking c : checkinData) {
                    if (c.getRoomNum().equals(Room.get(i).getValue())) {
                        all = LocalDateTime.now().plusDays(c.getNightNum()).format(DateTimeFormatter.ofPattern("YYYY-MMM-DD"));
                        day = Integer.parseInt(all.substring(8));
                        month = Integer.parseInt(all.substring(6, 8));
                        year = Integer.parseInt(all.substring(0, 5));
                        if (Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("DD"))) <= (day + c.getNightNum())) {
                            for (int k = 0; k < 3; k++) {
                                arrayString[i + k] = "*";
                            }
                        }

                    }
                }
                for (Booking c : bookingData) {
                    if (c.getRoomNum().equals(Room.get(i).getValue())) {
                        all = LocalDateTime.now().plusDays(c.getNightNum()).format(DateTimeFormatter.ofPattern("YYYY-MMM-DD"));
                        day = Integer.parseInt(all.substring(8));
                        month = Integer.parseInt(all.substring(6, 8));
                        year = Integer.parseInt(all.substring(0, 5));
                        if (Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("DD"))) <= (day + c.getNightNum())) {
                            for (int k = 0; k < 3; k++) {
                                arrayString[i + k] = "=";
                            }
                        }

                    }
                }
            }
            arrayRoom.add(new calendar(arrayString[0], arrayString[1],
                    arrayString[2], arrayString[3],
                    arrayString[4], arrayString[5],
                    arrayString[6], arrayString[7],
                    arrayString[8], arrayString[9],
                    arrayString[10], arrayString[11],
                    arrayString[12], arrayString[13]
            ));
        }
        floor1 = FXCollections.observableArrayList(arrayRoom);

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
        for (calendar a : arrayRoom){
            room.setValue(a);
            root2.getChildren().setAll(room);

        }


    }
}
