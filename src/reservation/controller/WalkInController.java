package reservation.controller;

public class WalkInController {
   /* @FXML
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


    private Boolean isConfirm = false;
    private int adultNum;
    private int childNum;
    private String title;
    private String firstName;
    private String lastName;
    private String tel;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationPageController parentController;
    private int extraBedNum;
    private int nightNum;
    private String email;
    private int price=0;
    private int weekDayNum=0,weekEndNum=0;
    private String country;
    private String idNum;
    private Customer guest;
    @FXML
    public void initialize() {

        adultNumChoice.getItems().addAll(0,1,2,3,4);
        childNumChoice.getItems().addAll(0,1,2,3,4);
        extraBedChoice.getItems().addAll(0,1,2);
        titleChoice.getItems().addAll("Mr.","Mrs.");

        makeCheckIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  System.out.println(weekDayNum);
                try {
                    adultNum = adultNumChoice.getValue();
                    childNum = childNumChoice.getValue();
                    title = titleChoice.getValue();
                    firstName = firstNameText.getText();
                    lastName = lastNameText.getText();
                    tel = telNumText.getText();
                    email = emailText.getText();
                    extraBedNum = extraBedChoice.getValue();
                    checkInDate = checkInDatePicker.getValue();
                    checkOutDate = checkOutDatePicker.getValue();
                    idNum = idNumText.getText();
                    country = countryText.getText();
                    isConfirm = true;
                }catch (Exception e){
                    System.out.println(e);
                    return;
                }
                System.out.println(weekDayNum);
                guest = new Customer(adultNum, childNum, title, firstName, lastName, tel, checkInDate, checkOutDate,extraBedNum,email,price,weekDayNum,weekEndNum);
                guest.setCountry(country);
                guest.setIdNum(idNum);
                guest.setCheckInTime(LocalDateTime.now());
                System.out.println(guest.getWeekDayNum());
                parentController.setCustomer(guest);
                parentController.getWalkInStage().close();
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
                try {
                    adultNum = adultNumChoice.getValue();
                    childNum = childNumChoice.getValue();
                    title = titleChoice.getValue();
                    firstName = firstNameText.getText();
                    lastName = lastNameText.getText();
                    tel = telNumText.getText();
                    email = emailText.getText();
                    extraBedNum = extraBedChoice.getValue();
                    checkInDate = checkInDatePicker.getValue();
                    checkOutDate = checkOutDatePicker.getValue();
                    idNum = idNumText.getText();
                    country = countryText.getText();
                    isConfirm = true;
                }catch (Exception e){
                    return;
                }

                guest = new Customer(adultNum, childNum, title, firstName, lastName, tel, checkInDate, checkOutDate,extraBedNum,email,price,weekDayNum,weekEndNum);
                guest.setCountry(country);
                guest.setIdNum(idNum);
                guest.setPayment(true);
                guest.setCheckInTime(LocalDateTime.now());
                parentController.setCustomer(guest);
                parentController.getWalkInStage().close();

            }

        });

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
        this.weekDayNum=0;
        this.weekEndNum=0;
        Room room;
        int price=0;
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
      //  System.out.println(weekDayNum);
        return price+(extraBedChoice.getValue()*316*nightNum);
    }
    public String getTel() {
        return tel;
    }

    public void setParentController(ReservationPageController parentController) {
        this.parentController = parentController;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }*/


}

