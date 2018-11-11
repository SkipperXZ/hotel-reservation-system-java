package calendar;

import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TreeTableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeItem;

import javafx.util.Callback;
import main.Linker;

public class calendarController {
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
    private TreeTableView<String> tableDay;

    @FXML
    private TreeTableColumn<String, String> day1;

    @FXML
    private TreeTableColumn<String, String> day2;

    @FXML
    private TreeTableColumn<String, String>day3;

    @FXML
    private TreeTableColumn<String, String>day4;

    @FXML
    private TreeTableColumn<String, String> day5;

    @FXML
    private TreeTableColumn<String, String>day6;

    @FXML
    private TreeTableColumn<String, String> day7;

    @FXML
    private TreeTableColumn<String, String> day8;

    @FXML
    private TreeTableColumn<String, String>day9;

    @FXML
    private TreeTableColumn<String, String> day10;

    @FXML
    private TreeTableColumn<String, String> day11;

    @FXML
    private TreeTableColumn<String, String>day12;

    @FXML
    private TreeTableColumn<String, String> day13;

    @FXML
    private TreeTableColumn<String, String>day14;

    @FXML
    private TreeTableColumn<String, String> day15;

    @FXML
    private TreeTableColumn<String, String>day16;

    @FXML
    private TreeTableColumn<String, String> day17;

    @FXML
    private TreeTableColumn<String, String> day18;

    @FXML
    private TreeTableColumn<String, String> day19;

    @FXML
    private TreeTableColumn<String, String> day20;

    @FXML
    private TreeTableColumn<String, String> day21;

    @FXML
    private TreeTableColumn<String, String> day22;

    @FXML
    private TreeTableColumn<String, String> day23;

    @FXML
    private TreeTableColumn<String, String> day24;

    @FXML
    private TreeTableColumn<String, String> day25;

    @FXML
    private TreeTableColumn<String, String> day26;

    @FXML
    private TreeTableColumn<String, String> day27;

    @FXML
    private TreeTableColumn<String, String> day28;

    @FXML
    private TreeTableColumn<String, String> day29;

    @FXML
    private TreeTableColumn<String, String> day30;

    @FXML
    private TreeTableColumn<String, String> day31;

    @FXML
    private TreeTableView<String > tableRoom;

    @FXML
    private TreeTableColumn<String, String> colRoom;

    @FXML
    private Button makeF1;

    @FXML
    private Button makeF2;

    @FXML
    private Button makeF3;

    @FXML
    private Button makeF4;

    @FXML
    private Button makeF5;
    TreeItem<String> room1 = new TreeItem<>("ROOM1");
    TreeItem<String> Type1 = new TreeItem<>("Type1");

    TreeItem<String> root = new TreeItem<>("ALL TYPE");


    @FXML
    public void initialize()  {
        Linker linker = new Linker();

        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);

        Type1.getChildren().setAll(room1);
        root.getChildren().setAll(Type1);

        tableRoom.setRoot(root);
        colRoom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
         calendarButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newCalendarScene());
            }
        });

    }

    class calendarTable extends RecursiveTreeObject<calendarTable>{

    }
}
