package reservation.controller;

import Hotel.Customer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import reservation.room.Room;

public class RoomInfoPageController {
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label idNumLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label telNumLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label roomTypeLabel;
    @FXML
    private Label checkInLabel;
    @FXML
    private Label checkOutLabel;
    @FXML
    private Label nightNumLabel;
    @FXML
    private JFXButton makeOK;
    @FXML
    private Label extraBedNumLabel;
    @FXML
    private Label childNumLabel;
    @FXML
    private Label adultNumLabel;
    @FXML
    private Label roomNumLabel;
    @FXML
    private Label roomStatusLabel;

    private Room room;
    private Customer customer;
    private ReservationPageController parentController;

    @FXML
    public void initialize(){
        makeOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parentController.getRoomInfoStage().close();
            }
        });

    }

    public void setInfo(){
        roomNumLabel.setText(room.getRoomID());
        roomTypeLabel.setText(room.getRoomType());
        roomStatusLabel.setText(room.getStatus());
        if(room.getCustomer() != null) {
            customer = room.getCustomer();
            if (customer.getIdNum() != null)
                idNumLabel.setText(customer.getIdNum());
            if (customer.getCountry() != null)
                countryLabel.setText(customer.getCountry());
            firstNameLabel.setText(customer.getFirstName());
            lastNameLabel.setText(customer.getLastName());
            telNumLabel.setText(customer.getTel());
            emailLabel.setText(customer.getEmail());
            nightNumLabel.setText(String.valueOf(customer.getNightNum()));
            checkInLabel.setText(customer.getCheckInDate().toString());
            checkOutLabel.setText(customer.getCheckOutDate().toString());
            adultNumLabel.setText(String.valueOf(customer.getAdultNum()));
            childNumLabel.setText(String.valueOf(customer.getChildNum()));
            extraBedNumLabel.setText(String.valueOf(customer.getExtraBedNum()));
        }

    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }
}
