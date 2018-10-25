package reservation.controller;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Room room;
    private ReservationPageController parentController;
    private boolean isConfirm=false;
    public void initialize() {

        makeConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(memoText != null) {
                    room.setMemo(memoText.getText());
                    isConfirm = true;
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

    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isConfirm() {
        return isConfirm;
    }
}