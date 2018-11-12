package dashboard;

import Account.Account;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Linker;

public class DashboardController {

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

    @FXML private Label Guest;
    @FXML private Label Occupied;
    @FXML private Label Occupiedpercent;
    @FXML private Label Departures;
    @FXML private Label Arrivals;


    @FXML
    public void initialize() {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        userLabel.setText(Account.currentUser);
        Linker linker = new Linker();

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
