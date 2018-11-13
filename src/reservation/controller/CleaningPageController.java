package reservation.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import reservation.room.Room;

public class CleaningPageController {
    @FXML
    private Label roomNumLabel;
    @FXML
    private TextField cleaningTimeText;

    @FXML
    private Button makeConfirm;
    @FXML
    private Button makeCancel;

    private String roomNum;
    private Boolean isConfirm =false;
    private ReservationPageController reservationPageController;
    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void initialize() {

        makeConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isConfirm = true;
                reservationPageController.setCleaningTimeMinute(Integer.parseInt(cleaningTimeText.getText()));
                reservationPageController.getCleaningStage().close();
            }
        });
        makeCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isConfirm = false;
                reservationPageController.getCleaningStage().close();
            }
        });
    }

    public void initRoom(){
        System.out.println(reservationPageController);
        Room room = reservationPageController.searchRoomFromPane(reservationPageController.getSelectedPane());
        roomNumLabel.setText(room.getRoomID());
    }

    public void setReservationPageController(ReservationPageController reservationPageController) {
        this.reservationPageController = reservationPageController;
    }

    public ReservationPageController getReservationPageController() {
        return reservationPageController;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
