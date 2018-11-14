package reservation.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Hotel.Customer;
import javafx.scene.input.MouseEvent;
import reservation.ReservationHandler;
import reservation.room.Room;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOutPageController {
    @FXML
    private Label adultNumLabel;

    @FXML
    private Label childNumLabel;

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

    @FXML
    private JFXCheckBox lateCheck;

    private Room room;
    private Customer customer;
    private boolean isCheckOut=false;
    private ReservationPageController parentController;
    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
       /* if(parentController.getPaymentStage() != null){
            parentController.getPaymentStage().close();
        }*/
    }

    @FXML
    public void initialize(){

        makeCheckOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(customer.isPayment() && returnCardCheck.isSelected() && !lateCheck.isSelected()){
                    isCheckOut = true;
                    parentController.getCheckOutStage().close();
                }


            }
        });
        makePayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(lateCheck.isSelected()){
                    customer.setLate(true);
                }
                System.out.println("pay");
                if (parentController.isConfirmPaymentScene()){

                    customer.setPaymerntPrice(customer.getPaymerntPrice()+customer.getPaymerntPrice()/10);
                    ReservationHandler.payment(room);
                    lateCheck.setSelected(false);
                    lateCheck.setDisable(true);
                }

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
            paymentStatusLabel.setText("Paid");
        else
            paymentStatusLabel.setText("Not Pay Yet");
        if(customer.getIdNum() != null)
            idNumLabel.setText(customer.getIdNum());
        firstNameLabel.setText(customer.getFirstName());
        lastNameLabel.setText(customer.getLastName());
        countryLabel.setText(customer.getCountry());
        telNumLabel.setText(customer.getTel());
        emailLabel.setText(customer.getEmail());
        adultNumLabel.setText(String.valueOf(customer.getAdultNum()));
        childNumLabel.setText(String.valueOf(customer.getChildNum()));
        checkInTimeLabel.setText(customer.getCheckInTime().format(DateTimeFormatter.ofPattern("dd MMM yyyy     HH:mm")));
        nightNumLabel.setText(String.valueOf(customer.getNightNum()));
        checkOutTImeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy     HH:mm")));
        statusLabel.setText(room.getStatus());
        roomIDLabel.setText(room.getRoomID());
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }
}
