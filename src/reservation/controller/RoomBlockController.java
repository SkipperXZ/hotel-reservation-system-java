package reservation.controller;
import Hotel.Hotel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import reservation.room.Room;

public class RoomBlockController {

    @FXML
    private Label roomIDLabel;

    @FXML
    private TextArea memoText;

    @FXML
    private JFXButton makeConfirm;

    @FXML
    private JFXButton makeCancel;
    @FXML
    private JFXDatePicker startDatePicker;
    @FXML
    private JFXDatePicker finishDatePicker;
    @FXML
    private Label warningMessage;


    private Room room;
    private ReservationPageController parentController;
    private boolean isConfirm=false;

    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

    public void initialize() {


        makeConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(finishDatePicker.getValue()== null){
                    warningMessage.setVisible(true);
                    return;
                }
                if(startDatePicker.getValue().isAfter(finishDatePicker.getValue()))
                {
                    warningMessage.setVisible(true);
                    return;
                }
                if(memoText != null) {
                    room.setMemo(memoText.getText());
                    isConfirm = true;
                    parentController.setStartDate(startDatePicker.getValue());
                    parentController.setFinishDate(finishDatePicker.getValue());
                    parentController.getRoomBlockStage().close();
                }

            }


        });
        makeCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parentController.getRoomBlockStage().close();
            }
        });
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;

    }
    public void setInfo(){
        startDatePicker.setValue(Hotel.hotel.get(parentController.getCurrentDay()-1).getDate());
        startDatePicker.setDisable(true);
    }
    public void setRoom(Room room) {
        this.room = room;
        roomIDLabel.setText(room.getRoomID());
    }

    public boolean isConfirm() {
        return isConfirm;
    }
}