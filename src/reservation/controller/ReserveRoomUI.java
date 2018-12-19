package reservation.controller;

import Hotel.CustomerList;
import Hotel.Hotel;
import Hotel.Customer;
import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import reservation.room.Room;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReserveRoomUI {

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private JFXDatePicker checkInDatePicker;

    @FXML
    private JFXDatePicker checkOutDatePicker;

    @FXML
    private Button makeConfirm;

    @FXML
    private TextField telNumText;
    @FXML
    private Button makeCancel;

    @FXML
    private ChoiceBox<String> titleChoice;

    @FXML
    private TextField emailText;

    @FXML
    private ChoiceBox<Integer> adultNumChoice;

    @FXML
    private ChoiceBox<Integer> childNumChoice;

    @FXML
    private ChoiceBox<Integer> extraBedChoice;
    @FXML
    private TextArea memoText;

    @FXML
    private Label priceLabel;

    @FXML
    private Label nightNumLabel;
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
    @FXML
    private TextField searchBar;
    @FXML
    private Label roomIDLabel;


    @FXML
    private Button makeSearch;
    @FXML
    private Label warningMessage;


    private Boolean isConfirm = false;
    private int adultNum;
    private int childNum;
    private String title;
    private String firstName;
    private String lastName;
    private String tel;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String memo;
    private ReservationPageUI parentController;
    private int extraBedNum;
    private int nightNum;
    private String email;
    private int price=0;
    private int weekDayNum=0,weekEndNum=0;
    private Label[] dayLabelArr;
    private Room room;

    @FXML
    void close(MouseEvent event) {
        ((Label)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void initialize() {
        warningMessage.setVisible(false);
        telNumText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    telNumText.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        adultNumChoice.getItems().addAll(0,1,2,3,4);
        childNumChoice.getItems().addAll(0,1,2);
        extraBedChoice.getItems().addAll(0,1,2);
        titleChoice.getItems().addAll("Mr.","Mrs.");
        titleChoice.setValue("Mr.");
        extraBedChoice.setValue(0);

        makeSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = searchBar.getText().replaceAll("\\s+","");
                if (CustomerList.customerList.get(name) != null){
                    Customer customer = CustomerList.customerList.get(name);
                    firstNameText.setText(customer.getFirstName());
                    lastNameText.setText(customer.getLastName());
                    telNumText.setText(customer.getTel());
                    emailText.setText(customer.getEmail());
                    titleChoice.setValue(customer.getTitle());
                }
            }
        });

        makeConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    adultNum = adultNumChoice.getValue();
                    childNum = childNumChoice.getValue();
                    title = titleChoice.getValue();
                    firstName = firstNameText.getText();
                    lastName = lastNameText.getText();
                    tel = telNumText.getText();
                    email = emailText.getText();
                    extraBedNum = extraBedChoice.getValue();
                    checkInDate = Hotel.hotel.get(parentController.getCurrentDay()-1).getDate();
                    checkOutDate = checkOutDatePicker.getValue();
                    isConfirm = true;
                    if(checkOutDate.getDayOfYear()-checkInDate.getDayOfYear() > 29){
                        return;
                    }
                    memo = memoText.getText();
                }catch (Exception e){
                    warningMessage.setVisible(true);
                    return;
                }
                if(checkOutDate.isBefore(checkInDate)){
                    warningMessage.setVisible(true);
                    return;
                }
                if(checkInDate.equals(checkOutDate)) {
                    warningMessage.setVisible(true);
                    return;
                }
                if(adultNum == 0 && childNum == 0 ){
                    warningMessage.setVisible(true);
                    return;
                }
                if(!checkAvaliableDay(getRoomIdex(room,parentController.getCurrentDay(),parentController.getCurrentFloorNum()),parentController.getCurrentDay(),parentController.getCurrentFloorNum())){
                    warningMessage.setVisible(true);
                    return;
                }
                Customer customer = new Customer(adultNum, childNum, title, firstName, lastName, tel, checkInDate, checkOutDate,extraBedNum,email,price,weekDayNum,weekEndNum,memo);
                customer.setPayment(false);
                CustomerList.updateCustomer(customer);
                parentController.setRoomIndex(getRoomIdex(room,parentController.getCurrentDay(),parentController.getCurrentFloorNum()));
                parentController.setCustomer(customer);
                parentController.getReserveStage().close();

            }


        });
        checkInDatePicker.setDisable(true);

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

        makeCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isConfirm = false;
                parentController.getReserveStage().close();

            }
        });

    }


    public int priceCalculate(){
        Room room;
        int total=0,price=0;
        LocalDate day =checkInDatePicker.getValue();
        for (int i = 0; i < nightNum ; i++) {
            if(day.getDayOfWeek().getValue()>=5){
                room = parentController.searchRoomFromPane(parentController.getSelectedPane());
                price += room.getWeekEndRoomPrice();
                weekEndNum++;
            }else {
                room = parentController.searchRoomFromPane(parentController.getSelectedPane());
                price += room.getWeekDayRoomPrice();
                weekDayNum++;
            }
            day = day.plusDays(1);

        }

        try {
            total=price+(extraBedChoice.getValue()*200*nightNum);
        }
        catch (Exception e){}
         return total;
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
            dayLabelArr[i].setAlignment(Pos.CENTER);
            if( Hotel.hotel.get(parentController.getCurrentDay()+i-1).getDate().equals(LocalDate.now()))
                dayLabelArr[i].setText("TODAY");
            else
                dayLabelArr[i].setText(Hotel.hotel.get(parentController.getCurrentDay()+i-1).getDate().format(DateTimeFormatter.ofPattern("dd/MM")));

        }
        roomIDLabel.setText(room.getRoomID());
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

    private boolean checkAvaliableDay(int roomIndex,int currentDay,int floorNum){
        for (int i = 0; i < checkOutDate.getDayOfYear()-checkInDate.getDayOfYear() ; i++) {
            Customer customer = Hotel.hotel.get(currentDay-1+i).getFloors()[floorNum-1].getRooms()[roomIndex].getCustomer();
            if(customer != null){
                return  false;
            }
        }
        return true;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public String getTel() {
        return tel;
    }

    public void setParentController(ReservationPageUI parentController) {
        this.parentController = parentController;
        initDayLabel();
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

}
