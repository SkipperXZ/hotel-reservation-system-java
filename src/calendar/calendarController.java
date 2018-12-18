package calendar;

import Hotel.Hotel;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import report.BookingList;
import main.Linker;
import report.Booking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import reservation.IO;
import staff.StaffList;
import Hotel.CustomerList;


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
    @FXML private ImageView logOut = new ImageView();
    @FXML private ImageView exit = new ImageView();
    @FXML private Label nameHotel;


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


    ArrayList<Booking> bookingDatabase = BookingList.bookingDatabase;
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
        nameHotel.setText("HOTELLO");



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
               // System.out.println(bookingCount+" "+bookingData.get(0).getRoomNum());
                bookingCount = 0;
               // System.out.println("remove fail");
            }
            else {
                bookingData.remove(bookingCount);
                bookingCount=0;
               // System.out.println("removed");
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

        day01_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol1());
        day02_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol2());
        day03_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol3());
        day04_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol4());
        day05_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol5());
        day06_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol6());
        day07_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol7());
        day08_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol8());
        day09_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol9());
        day10_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol10());
        day11_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol11());
        day12_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol12());
        day13_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol13());
        day14_1.setCellValueFactory(cellData -> cellData.getValue().getValue().getCol14());

        for (TreeTableColumn<calendar,String> e : Day){
            check(e);
        }



        makeF1.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");

        makeF1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                makeF1.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");
                makeF2.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF3.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF4.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF5.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                changeTag(1);
                algo();


            }
        });

        makeF2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                makeF2.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");
                makeF1.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF3.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF4.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF5.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                changeTag(2);
                algo();

            }
        });
        makeF3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                makeF3.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");
                makeF2.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF1.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF4.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF5.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                changeTag(3);
                algo();


            }
        });
        makeF4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                makeF4.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");
                makeF2.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF3.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF1.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF5.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                changeTag(4);
                algo();


            }
        });
        makeF5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                makeF5.setStyle("-fx-background-color: #1473e6;-fx-text-fill: #ffffff");
                makeF2.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF3.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF4.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                makeF1.setStyle("-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f");
                changeTag(5);
                algo();



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
        dashboardButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newDashboardScene());
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
                IO.saveCustomer(CustomerList.customerDatabase);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingList.bookingDatabase);
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
                IO.saveCustomer(CustomerList.customerDatabase);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingList.bookingDatabase);
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
                        day = Math.abs(Duration.between(c.getRecordTime().plusDays(c.getNightNum()), LocalDateTime.now()).toDays());
                        for (int k = 0; k <= 14; k++) {
                            if(c.getRecordTime().plusDays(c.getNightNum()).isBefore(LocalDateTime.now().plusDays(k))){
                                break;
                            }
                            if (c.getRecordTime().isAfter(LocalDateTime.now().plusDays(k))){
                            }
                            else {
                                arrayString[k] = "*";
                            }
                        }
                    }

                }
            }
            for (Booking c : bookingData) {
                System.out.println(c.getArrivalDate());
                if (c.getRoomNum().equals(Room.get(i).getValue())) {
                    if (c.getArrivalDate().plusDays(c.getNightNum()).isAfter(LocalDateTime.now())) {
                        day = Math.abs(Duration.between(c.getRecordTime().plusDays(c.getNightNum()), LocalDateTime.now()).toDays());
                        for (int k = 0; k <= 14; k++) {
                            if(c.getArrivalDate().plusDays(c.getNightNum()).isBefore(LocalDateTime.now().plusDays(k))){
                                break;
                            }
                            if (c.getArrivalDate().isAfter(LocalDateTime.now().plusDays(k))){
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

    public void check (TreeTableColumn< calendar,String> c){
        c.setCellFactory(column ->{
            return new TreeTableCell<calendar, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty){
                        setText(null);
                        setStyle("");
                    }
                    else if (item.equals("=")){
                        setText(" ");
                        setStyle("-fx-background-color: yellow");
                    }
                    else if (item.equals("*")){
                        setText(" ");
                        setStyle("-fx-background-color:  rgb(124,252,0)");
                    }
                }
            };
        });
    }
    public void algo (){
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
                //   System.out.println("remove fail");
            }
            else {
                bookingData.remove(bookingCount);
                bookingCount=0;
                //  System.out.println("removed");
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
        for(Booking runCancel :cancelData){
            fullName = runCancel.getFullname();
            roomNum = runCancel.getRoomNum();
            checkDate = runCancel.getRecordDate().toString();

            for (Booking runBooking : bookingData) {
                if (fullName.equals(runBooking.getFullname())) {
                    if (roomNum.equals(runBooking.getRoomNum())) {
                        if (checkDate.equals(runBooking.getRecordDate().toString())) {
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
                bookingCount = 0;
            }
            else{
                bookingData.remove(bookingCount);
                bookingCount=0;

            }

        }

        comPare();
        calendarSet();
        for (TreeTableColumn<calendar,String> e : Day){
            check(e);
        }


    }
    public void changeTag (int num){
        if(num == 1){
            room1.setValue("A101");
            room2.setValue("A102");
            room3.setValue("A103");
            room4.setValue("A104");
            room5.setValue("A105");
            room6.setValue("A106");
            room7.setValue("B107");
            room8.setValue("B108");
            room9.setValue("B109");
            room10.setValue("B110");
            room11.setValue("B111");
            room12.setValue("B112");
        }

        else if (num == 2) {
            room1.setValue("D201");
            room2.setValue("D202");
            room3.setValue("D203");
            room4.setValue("D204");
            room5.setValue("A205");
            room6.setValue("A206");
            room7.setValue("A207");
            room8.setValue("A208");
            room9.setValue("B209");
            room10.setValue("B210");
            room11.setValue("B211");
            room12.setValue("B212");
        }
        else if (num ==3) {
            room1.setValue("S301");
            room2.setValue("S302");
            room3.setValue("D303");
            room4.setValue("D304");
            room5.setValue("B305");
            room6.setValue("B306");
            room7.setValue("B307");
            room8.setValue("B308");
            room9.setValue("D309");
            room10.setValue("D310");
            room11.setValue("S311");
            room12.setValue("S312");
        }
        else if (num ==4) {
            room1.setValue("S401");
            room2.setValue("S402");
            room3.setValue("D403");
            room4.setValue("D404");
            room5.setValue("F405");
            room6.setValue("B406");
            room7.setValue("B407");
            room8.setValue("D408");
            room9.setValue("D409");
            room10.setValue("D410");
            room11.setValue("S411");
            room12.setValue("S412");
        }
        else if (num ==5) {

            room1.setValue("S501");
            room2.setValue("S502");
            room3.setValue("S503");
            room4.setValue("S504");
            room5.setValue("D505");
            room6.setValue("D506");
            room7.setValue("D507");
            room8.setValue("D508");
            room9.setValue("S509");
            room10.setValue("S510");
            room11.setValue("S511");
            room12.setValue("S512");

        }
    }


}
