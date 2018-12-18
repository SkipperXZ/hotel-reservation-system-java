package reservation.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import reservation.room.Room;

public class CleaningPageUI {
    @FXML
    private Label roomNumLabel;
    @FXML
    private TextField cleaningTimeText;

    @FXML
    private Button makeConfirm;
    @FXML
    private Button makeCancel;
    @FXML
    private Label warningMessage;


    private String roomNum;
    private Boolean isConfirm =false;
    private ReservationPageUI reservationPageController;

    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void initialize() {
        cleaningTimeText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cleaningTimeText.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        makeConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isConfirm = true;
                try {
                    reservationPageController.setCleaningTimeMinute(Integer.parseInt(cleaningTimeText.getText()));
                }catch (Exception e){
                    warningMessage.setVisible(true);
                    return;
                }

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

    public void setReservationPageController(ReservationPageUI reservationPageController) {
        this.reservationPageController = reservationPageController;
    }

    public ReservationPageUI getReservationPageController() {
        return reservationPageController;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
