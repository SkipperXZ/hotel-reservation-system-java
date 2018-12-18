package reservation.controller;

import Hotel.Customer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reservation.room.Room;

public class RoomInfoPageUI {
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
    @FXML
    private Label roomNumLabel_1;
    @FXML
    private Pane pane;

    @FXML
    private Label nameLabel;
    private String inHouseColor = "-fx-background-color: #24ec88";
    private String cleaningColor = "-fx-background-color: #4bccfd";
    private String vacantColor = "-fx-background-color:  #f6faff";
    private String outOfServiceColor = "-fx-background-color: #fc7777";
    private String bookedColor = "-fx-background-color: #f6d03a";
    private String roomBlockColor ="-fx-background-color: #f754dc";

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
                parentController.getRoomInfoStage().close();
            }
        });

    }

    public void setInfo(){
        roomNumLabel.setText(room.getRoomID());
        roomTypeLabel.setText(room.getRoomType());
        roomNumLabel_1.setText(room.getRoomID());

        if(room.getCustomer() != null) {
            customer = room.getCustomer();
            if (customer.getIdNum() != null)
                idNumLabel.setText(customer.getIdNum());
            if (customer.getCountry() != null)
                countryLabel.setText(customer.getCountry());

            statusLabel.setText(room.getStatus());
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
        paneColor();
        roomStatusLabel.setText(room.getStatus());

    }

    public void paneColor(){
        if(room.getStatus().equals("Vacant") ) {
            nameLabel.setText("Vacant");
            pane.setStyle(vacantColor);
            nameLabel.setStyle("-fx-text-fill: #3d8ceb");
            roomNumLabel_1.setStyle("-fx-text-fill: #3d8ceb");

        }else if(room.getStatus().equals("Reserved")){
            nameLabel.setText(room.getCustomer().getFirstName() + "  " + room.getCustomer().getLastName().substring(0, 1) + '.');
            pane.setStyle(bookedColor);
        }else if(room.getStatus().equals("In House")){
            nameLabel.setText(room.getCustomer().getFirstName() + "  " + room.getCustomer().getLastName().substring(0, 1) + '.');
            pane.setStyle(inHouseColor);
        }else if(room.getStatus().equals("Cleaning")){
            pane.setStyle(cleaningColor);
            nameLabel.setText("Cleaning");
        }else if(room.getStatus().equals("Out Of Service")){
            pane.setStyle(outOfServiceColor);
            nameLabel.setText(room.getMemo());
        }else if(room.getStatus().equals("Room Block")){
            pane.setStyle(roomBlockColor);
            nameLabel.setText(room.getMemo());
        }
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public void setParentController(ReservationPageUI parentController) {
        this.parentController = parentController;
    }
}
