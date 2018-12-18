package reservation.controller;

import Hotel.Customer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import reservation.room.Room;

public class CustomerInfoPageUI {
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
    @FXML
    private TextArea addressTextField;

    @FXML
    private Label statusLabel;


    private Room room;
    private Customer customer;
    private ReservationPageUI parentController;
    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

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
            if (customer.getAddress()!=null)
                addressTextField.setText(customer.getAddress());
            firstNameLabel.setText(customer.getFirstName());
            lastNameLabel.setText(customer.getLastName());
            telNumLabel.setText(customer.getTel());
            emailLabel.setText(customer.getEmail());
            statusLabel.setText(customer.getStatus());

        }

    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setParentController(ReservationPageUI parentController) {
        this.parentController = parentController;
    }
}
