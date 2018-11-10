package report;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.Linker;
import report.Booking;

public class reportController {

    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private JFXButton dashboardButtton;
    @FXML
    private JFXButton  calendarButtton;
    @FXML
    private JFXButton  reservationButtton;
    @FXML
    private JFXButton  customerButtton;
    @FXML
    private JFXButton  reportButtton;
    @FXML
    private JFXButton  userButtton;

    private Booking booking;

    @FXML
    public void initialize() {

        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(Linker.resScene);
            }
        });
    }
}
