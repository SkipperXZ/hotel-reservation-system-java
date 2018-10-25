package reservation.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Hotel.Customer;
import reservation.room.Room;

import java.time.LocalDateTime;

public class CheckOutPageController {

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
    private Label roomIDLabel;

    @FXML
    private JFXCheckBox returnCardCheck;
    @FXML
    private Label checkInTimeLabel;

    @FXML
    private Label nightNumLabel;

    @FXML
    private Label paymentStatusLabel;

    @FXML
    private Label checkOutTImeLabel;

    @FXML
    private JFXButton makePayment;

    @FXML
    private JFXButton makeCheckOut;

    private Room room;
    private Customer customer;
    private boolean isCheckOut=false;
    private ReservationPageController parentController;

    @FXML
    public void initialize(){

        makeCheckOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(customer.isPayment() && returnCardCheck.isSelected()){
                    isCheckOut = true;
                    parentController.getCheckOutStage().close();
                }

            }
        });
        makePayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isCheckOut =false;
                parentController.getCheckOutStage().close();
            }
        });
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }
    public void setInfo(){
        customer = room.getCustomer();
        if(customer.isPayment())
            paymentStatusLabel.setText("จ่ายแล้ว");
        else
            paymentStatusLabel.setText("ยังไม่จ่าย");
        if(customer.getIdNum() != null)
            idNumLabel.setText(customer.getIdNum());
        firstNameLabel.setText(customer.getFirstName());
        lastNameLabel.setText(customer.getLastName());
        countryLabel.setText(customer.getCountry());
        telNumLabel.setText(customer.getTel());
        emailLabel.setText(customer.getEmail());
        checkInTimeLabel.setText(customer.getCheckInTime().toLocalTime().toString());
        nightNumLabel.setText(String.valueOf(customer.getNightNum()));
        checkOutTImeLabel.setText(LocalDateTime.now().toLocalTime().toString());
        //System.out.println(room);
        //latePriceLabel.setText("0");
        roomIDLabel.setText(room.getRoomID());
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }
}
