package reservation.controller;
import Hotel.Hotel;
import Hotel.CustomerList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Hotel.Customer;
import javafx.scene.input.MouseEvent;
import reservation.HotelSystem;
import reservation.room.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckInUI {
    @FXML
    private Label roomIDLabel;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField idNumText;

    @FXML
    private TextField countryText;

    @FXML
    private TextField telNumText;

    @FXML
    private TextField emailText;
    @FXML
    private ChoiceBox<String> titleChoice;
    @FXML
    private ChoiceBox<Integer> adultNumChoice;

    @FXML
    private ChoiceBox<Integer> childNumChoice;

    @FXML
    private ChoiceBox<Integer> extraBedChoice;

    @FXML
    private JFXDatePicker checkInDatePicker;

    @FXML
    private JFXDatePicker checkOutDatePicker;

    @FXML
    private Label priceLabel;

    @FXML
    private Label nightNumLabel;

    @FXML
    private JFXButton makeCheckIn;

    @FXML
    private JFXButton makePayment;

    @FXML
    private TextArea memoText;

    @FXML
    private TextArea addressText;

    @FXML
    private Label dayLabel_0;

    @FXML
    private Label dayLabel_1;

    @FXML
    private Label dayLabel_2;

    @FXML
    private Label dayLabel_3;

    @FXML
    private Label dayLabel_4;

    @FXML
    private Label dayLabel_5;

    @FXML
    private Label dayLabel_6;

    private Boolean isConfirm = false;
    private int adultNum;
    private int childNum;
    private String title;
    private String firstName;
    private String lastName;
    private String tel;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationPageUI parentController;
    private int extraBedNum;
    private int nightNum;
    private String email;
    private int price=0;
    private int weekDayNum=0,weekEndNum=0;
    private String country;
    private String idNum;
    private Customer customer;
    private Room room;
    private Label[] dayLabelArr;
    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void initialize() {

        adultNumChoice.getItems().addAll(0,1,2,3,4);
        childNumChoice.getItems().addAll(0,1,2,3,4);
        extraBedChoice.getItems().addAll(0,1,2);
        titleChoice.getItems().addAll("Mr.","Mrs.");
        idNumText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    idNumText.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        makeCheckIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    idNum = idNumText.getText();
                    country = countryText.getText();
                    isConfirm = true;
                }catch (Exception e){
                    return;
                }
                nightNum = checkOutDatePicker.getValue().getDayOfYear()-checkInDatePicker.getValue().getDayOfYear();
                price = priceCalculate();
                boolean isPaymeny = room.getCustomer().isPayment();
                customer = room.getCustomer();
                customer.setPayment(isPaymeny);
                customer.setCountry(country);
                customer.setIdNum(idNum);
                customer.setAddress(addressText.getText());
                customer.setCheckInTime(LocalDateTime.now());
                CustomerList.updateCustomer(customer);
                parentController.setCustomer(customer);
                parentController.setRoomIndex(getRoomIdex(room,parentController.getCurrentDay(),parentController.getCurrentFloorNum()));
                parentController.getCheckInStage().close();
            }


        });

        checkInDatePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(checkInDatePicker.getValue() != null && checkOutDatePicker.getValue() != null)
                    nightNum = checkOutDatePicker.getValue().getDayOfYear()-checkInDatePicker.getValue().getDayOfYear();
                nightNumLabel.setText(String.valueOf(nightNum));
                price = priceCalculate();
                priceLabel.setText(String.valueOf(price));
            }
        });
        checkOutDatePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(checkInDatePicker.getValue() != null && checkOutDatePicker.getValue() != null)
                    nightNum = checkOutDatePicker.getValue().getDayOfYear()-checkInDatePicker.getValue().getDayOfYear();
                nightNumLabel.setText(String.valueOf(nightNum));
                price = priceCalculate();
                priceLabel.setText(String.valueOf(price));
            }
        });

        makePayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (parentController.isConfirmPaymentScene()){
                    HotelSystem.payment(room);
                }
            }

        });

    }
    private void initDayLabel(){
        dayLabelArr = new Label[]{dayLabel_0,dayLabel_1,dayLabel_2,dayLabel_3,dayLabel_4,dayLabel_5,dayLabel_6};
        checkInDatePicker.setValue(Hotel.hotel.get(parentController.getCurrentDay()-1).getDate());
        room = parentController.searchRoomFromPane(parentController.getSelectedPane());

        int roomIndex = getRoomIdex(room,parentController.getCurrentDay(),parentController.getCurrentFloorNum());
        for (int i = 0; i  < dayLabelArr.length; i++) {
            Customer customer = Hotel.hotel.get(parentController.getCurrentDay()+i-1).getFloors()[parentController.getCurrentFloorNum()-1].getRooms()[roomIndex].getCustomer();

            if(customer == null){
                dayLabelArr[i].setStyle("-fx-background-color: #24ec88");
            }
            else {
                dayLabelArr[i].setStyle("-fx-background-color: red");
            }
            if( Hotel.hotel.get(parentController.getCurrentDay()+i-1).getDate().equals(LocalDate.now()))
                dayLabelArr[i].setText("TODAY");
            else
                dayLabelArr[i].setText(Hotel.hotel.get(parentController.getCurrentDay()+i-1).getDate().format(DateTimeFormatter.ofPattern("dd/MM")));

        }
    }

    public void getInfoFromGuest(){
        Customer customer = room.getCustomer();
        adultNumChoice.setValue(customer.getAdultNum());
        childNumChoice.setValue(customer.getChildNum());
        titleChoice.setValue(customer.getTitle());
        firstNameText.setText(customer.getFirstName());
        lastNameText.setText(customer.getLastName());
        telNumText.setText(customer.getTel());
        emailText.setText(customer.getEmail());
        extraBedChoice.setValue(customer.getExtraBedNum());
        checkInDatePicker.setValue(customer.getCheckInDate());
        checkOutDatePicker.setValue(customer.getCheckOutDate());
        priceLabel.setText(String.valueOf(customer.getPaymerntPrice()));
        nightNumLabel.setText(String.valueOf(customer.getNightNum()));
        memoText.setText(customer.getMemo());
        adultNumChoice.setDisable(true);
        childNumChoice.setDisable(true);
        titleChoice.setDisable(true);
        firstNameText.setEditable(false);
        lastNameText.setEditable(false);
        telNumText.setEditable(false);
        emailText.setEditable(false);
        extraBedChoice.setDisable(true);
        checkInDatePicker.setEditable(false);
        checkOutDatePicker.setEditable(false);
        checkInDatePicker.setDisable(true);
        checkOutDatePicker.setDisable(true);
        memoText.setDisable(true);
        roomIDLabel.setText(room.getRoomID());
        if (CustomerList.customerDatabase.get(customer.getFirstName()+customer.getLastName()) != null){
            Customer dbCustomer = CustomerList.customerDatabase.get(customer.getFirstName()+customer.getLastName());
            if( dbCustomer.getIdNum() != null && dbCustomer.getCountry()!=null && dbCustomer.getAddress() != null){
                idNumText.setText(dbCustomer.getIdNum());
                countryText.setText(dbCustomer.getCountry());
                addressText.setText(dbCustomer.getAddress());
                idNumText.setEditable(false);
                countryText.setEditable(false);
                addressText.setEditable(false);
            }
        }
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public int getAdultNum() {
        return adultNum;
    }

    public int getChildNum() {
        return childNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public int priceCalculate(){
        Room room;
        int price=0;
        this.weekDayNum=0;
        this.weekEndNum=0;
        LocalDate day =checkInDatePicker.getValue();
        for (int i = 0; i < nightNum ; i++) {
            if(day.getDayOfWeek().getValue()>=5){
                room = parentController.searchRoomFromPane(parentController.getSelectedPane());
                price += room.getWeekEndRoomPrice();
                this.weekEndNum++;
            }else {
                room = parentController.searchRoomFromPane(parentController.getSelectedPane());
                price += room.getWeekDayRoomPrice();
                this.weekDayNum++;
            }
            day = day.plusDays(1);

        }
        return price+(extraBedChoice.getValue()*316*nightNum);
    }
    public String getTel() {
        return tel;
    }

    public void setParentController(ReservationPageUI parentController) {
        this.parentController = parentController;
        initDayLabel();
    }
    private int getRoomIdex(Room room ,int currentDay,int floorNum ){
        int index=0;
        for (int i = 0; i < Hotel.hotel.get(currentDay-1).getFloors()[floorNum-1].getRooms().length ; i++) {
            if(Hotel.hotel.get(currentDay-1).getFloors()[floorNum-1].getRooms()[i] == room){
                index = i;
                break;
            }
        }
        return index;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }


}

