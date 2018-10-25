package reservation.controller;

import Account.Account;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Hotel.Customer;
import reservation.room.Room;

public class PaymentPageController {


    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label idNumLabel;

    @FXML
    private Label checkInDateLabel;

    @FXML
    private Label checkOutDateLabel;

    @FXML
    private Label nightNumLabel;

    @FXML
    private Label extraBedLabel;

    @FXML
    private Label paymenStatusLabel;

    @FXML
    private Label weekDayNumLabel;

    @FXML
    private Label weekEndNumLabel;

    @FXML
    private Label roomServiceLabel;

    @FXML
    private Label extraBedPriceLabel;

    @FXML
    private Label vatPriceLabel;

    @FXML
    private Label latePriceLabel;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private JFXButton makeCancel;

    @FXML
    private JFXButton makePay;

    @FXML
    private Text roomIDText;

    @FXML
    private Label weekEndPrice;

    @FXML
    private Label weekDayPrice;
    @FXML
    private Label roomTypeLabel;
    @FXML
    private StackPane myStackPane;

    @FXML
    private Label totalRoomPriceLabel;

    private Room room;
    private Customer customer;
    private boolean isPay=false;
    private ReservationPageController parentController;
    private boolean isCorrect = false;
    private Stage comfirmPasswordStage;
    private JFXDialog jfxDialog;

    @FXML
    public void initialize(){
        makePay.setButtonType(JFXButton.ButtonType.RAISED);
        makeCancel.setButtonType(JFXButton.ButtonType.RAISED);
        makePay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isPasswordCorrect()) {
                    isPay = true;
                 //   parentController.getPaymentStage().close();
                }
            }
        });
        makeCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isPay =false;
                parentController.getPaymentStage().close();
            }
        });
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isPay() {
        return isPay;
    }
    public void setInfo(){
        customer = room.getCustomer();
        int servicePrice =(customer.getPaymerntPrice()-(customer.getExtraBedNum()*316* customer.getNightNum()))/10;
        int vatPrice =(((customer.getPaymerntPrice()+servicePrice)*7)/100);
        if(customer.isPayment())
            paymenStatusLabel.setText("จ่ายแล้ว");
        else
            paymenStatusLabel.setText("ยังไม่จ่าย");
      /*  if(customer.getIdNum() != null)
            idNumLabel.setText(customer.getIdNum());*/
        firstNameLabel.setText(customer.getFirstName());
        lastNameLabel.setText(customer.getLastName());
        checkInDateLabel.setText(customer.getCheckInDate().toString());
        checkOutDateLabel.setText(customer.getCheckOutDate().toString());
        nightNumLabel.setText(String.valueOf(customer.getNightNum()));
        extraBedLabel.setText(String.valueOf(customer.getExtraBedNum()));
        weekDayNumLabel.setText("Weekday "+String.valueOf(customer.getWeekDayNum()));
        weekEndNumLabel.setText("Weekend "+String.valueOf(customer.getWeekEndNum()));
        roomServiceLabel.setText(String.valueOf(servicePrice));
        extraBedPriceLabel.setText(String.valueOf(customer.getExtraBedNum()*316* customer.getNightNum()));
        vatPriceLabel.setText(String.valueOf(vatPrice));
        latePriceLabel.setText("0");
        totalPriceLabel.setText(String.valueOf(customer.getPaymerntPrice()+vatPrice+servicePrice));
        weekDayPrice.setText(String.valueOf(customer.getWeekDayNum()*room.getWeekDayRoomPrice()));
        weekEndPrice.setText(String.valueOf(customer.getWeekEndNum()*room.getWeekEndRoomPrice()));
        totalRoomPriceLabel.setText(String.valueOf(customer.getWeekEndNum()*room.getWeekEndRoomPrice()+ customer.getWeekDayNum()*room.getWeekDayRoomPrice()));
        roomIDText.setText(room.getRoomID());
        roomTypeLabel.setText(room.getClass().getName());
    }

    public boolean isPasswordCorrect(){
        comfirmPasswordStage =new Stage();
        comfirmPasswordStage.setTitle("Please Confirm Password");
        PasswordField passwordField = new PasswordField();
        Button button = new Button("Confirm");
        Text text = new Text(25,40,"Please Confirm Password");
        text.setFont(new Font(20));
        button.setPrefWidth(100);
        button.setPrefHeight(50);
        button.setLayoutX(400);
        button.setLayoutY(70);
        passwordField.setPrefWidth(400);
        passwordField.setPrefHeight(50);
        passwordField.setLayoutX(0);
        passwordField.setLayoutY(70);
        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(text,passwordField,button);
        Scene scene = new Scene(layout,500,150);
        comfirmPasswordStage.setScene(scene);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(passwordField.getText().equals(Account.currentPassword)){
                    isCorrect = true;
                    dialog("ชำระเงินเสร็จสิน");
                    comfirmPasswordStage.close();
                    System.out.println();
                }
                else
                { isCorrect = false;
                    dialog("รหัสผ่านไม่ถูกต้อง");
                    comfirmPasswordStage.close();}
            }
        });
        comfirmPasswordStage.showAndWait();

        return isCorrect;

    }
    public void dialog(String text){
        JFXDialogLayout jfxDialogLayout =  new JFXDialogLayout();;
        JFXDialog jfxDialog= new JFXDialog(myStackPane,jfxDialogLayout,JFXDialog.DialogTransition.CENTER);;
        jfxDialog.setOverlayClose(false);
        JFXButton jfxButton= new JFXButton("Okay");;
        jfxDialogLayout.setHeading(new Text(text));
        jfxDialogLayout.setBody(new Text("dawsfdgdfgfd"));
        jfxButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jfxDialog.close();
                if(isCorrect)
                    parentController.getPaymentStage().close();
            }
        });
        jfxDialogLayout.setActions(jfxButton);
        jfxDialog.show();
    }
    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }
}
