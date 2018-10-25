package reservation.controller;

import Hotel.Customer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import reservation.room.Room;

public class GuestInfoPageController {
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
    private JFXButton makeOK;


    private Room room;
    private Customer customer;
    private ReservationPageController parentController;

    @FXML
    public void initialize(){
        makeOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parentController.getGuestFolioStage().close();
            }
        });

    }

    public void setInfo(){
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
        }

    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }
}
