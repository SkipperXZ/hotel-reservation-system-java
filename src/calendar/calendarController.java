package calendar;

import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import report.AllBooking;
import javafx.util.Callback;
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

    static ObservableList<Booking>list1;
    static ObservableList<Booking>list2;
    static ObservableList<Booking>list3;
    static ObservableList<Booking>list4;
    static ObservableList<Booking> list;
    ArrayList<Booking> allBooking = AllBooking.allBooking;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();
    ArrayList<Booking> checkoutData = new ArrayList<Booking>();
    ArrayList<Booking> cancelData = new ArrayList<Booking>();
    ArrayList<Booking> bookingData = new ArrayList<Booking>();

    private int checkinNum=0, checkoutNum=0, cancelNum=0, bookingNum=0;



    @FXML
    public void initialize()  {
        for (Booking number : allBooking) {

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


        colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        day1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        day2.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        root.setExpanded(true);







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
