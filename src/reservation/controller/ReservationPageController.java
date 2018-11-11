package reservation.controller;

import Hotel.Customer;
import Hotel.OneDayHotel;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Linker;
import reservation.*;
import reservation.room.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Hotel.Hotel.hotel;

public class ReservationPageController {
    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private Pane pane_00;
    @FXML
    private Label roomIDLabel_00;
    @FXML
    private Label vacantLabel_00;
    @FXML
    private Label doingLabel_00;
    @FXML
    private Label subDoingLabel_00;
    @FXML
    private Label checkInLabel_00;
    @FXML
    private Label checkOutLabel_00;
    @FXML
    private Label nameLabel_00;
    @FXML
    private Pane pane_01;
    @FXML
    private Label roomIDLabel_01;
    @FXML
    private Label vacantLabel_01;
    @FXML
    private Label doingLabel_01;
    @FXML
    private Label subDoingLabel_01;
    @FXML
    private Label checkInLabel_01;
    @FXML
    private Label checkOutLabel_01;
    @FXML
    private Label nameLabel_01;
    @FXML
    private Pane pane_02;
    @FXML
    private Label roomIDLabel_02;
    @FXML
    private Label vacantLabel_02;
    @FXML
    private Label doingLabel_02;
    @FXML
    private Label subDoingLabel_02;
    @FXML
    private Label checkInLabel_02;
    @FXML
    private Label checkOutLabel_02;
    @FXML
    private Label nameLabel_02;
    @FXML
    private Pane pane_03;
    @FXML
    private Label roomIDLabel_03;
    @FXML
    private Label vacantLabel_03;
    @FXML
    private Label doingLabel_03;
    @FXML
    private Label subDoingLabel_03;
    @FXML
    private Label checkInLabel_03;
    @FXML
    private Label checkOutLabel_03;
    @FXML
    private Label nameLabel_03;
    @FXML
    private Pane pane_04;
    @FXML
    private Label roomIDLabel_04;
    @FXML
    private Label vacantLabel_04;
    @FXML
    private Label doingLabel_04;
    @FXML
    private Label subDoingLabel_04;
    @FXML
    private Label checkInLabel_04;
    @FXML
    private Label checkOutLabel_04;
    @FXML
    private Label nameLabel_04;
    @FXML
    private Pane pane_05;
    @FXML
    private Label roomIDLabel_05;
    @FXML
    private Label vacantLabel_05;
    @FXML
    private Label doingLabel_05;
    @FXML
    private Label subDoingLabel_05;
    @FXML
    private Label checkInLabel_05;
    @FXML
    private Label checkOutLabel_05;
    @FXML
    private Label nameLabel_05;
    @FXML
    private Pane pane_06;
    @FXML
    private Label roomIDLabel_06;
    @FXML
    private Label vacantLabel_06;
    @FXML
    private Label doingLabel_06;
    @FXML
    private Label subDoingLabel_06;
    @FXML
    private Label checkInLabel_06;
    @FXML
    private Label checkOutLabel_06;
    @FXML
    private Label nameLabel_06;
    @FXML
    private Pane pane_07;
    @FXML
    private Label roomIDLabel_07;
    @FXML
    private Label vacantLabel_07;
    @FXML
    private Label doingLabel_07;
    @FXML
    private Label subDoingLabel_07;
    @FXML
    private Label checkInLabel_07;
    @FXML
    private Label checkOutLabel_07;
    @FXML
    private Label nameLabel_07;
    @FXML
    private Pane pane_08;
    @FXML
    private Label roomIDLabel_08;
    @FXML
    private Label vacantLabel_08;
    @FXML
    private Label doingLabel_08;
    @FXML
    private Label subDoingLabel_08;
    @FXML
    private Label checkInLabel_08;
    @FXML
    private Label checkOutLabel_08;
    @FXML
    private Label nameLabel_08;
    @FXML
    private Pane pane_09;
    @FXML
    private Label roomIDLabel_09;
    @FXML
    private Label vacantLabel_09;
    @FXML
    private Label doingLabel_09;
    @FXML
    private Label subDoingLabel_09;
    @FXML
    private Label checkInLabel_09;
    @FXML
    private Label checkOutLabel_09;
    @FXML
    private Label nameLabel_09;
    @FXML
    private Pane pane_010;
    @FXML
    private Label roomIDLabel_010;
    @FXML
    private Label vacantLabel_010;
    @FXML
    private Label doingLabel_010;
    @FXML
    private Label subDoingLabel_010;
    @FXML
    private Label checkInLabel_010;
    @FXML
    private Label checkOutLabel_010;
    @FXML
    private Label nameLabel_010;
    @FXML
    private Pane pane_011;
    @FXML
    private Label roomIDLabel_011;
    @FXML
    private Label vacantLabel_011;
    @FXML
    private Label doingLabel_011;
    @FXML
    private Label subDoingLabel_011;
    @FXML
    private Label checkInLabel_011;
    @FXML
    private Label checkOutLabel_011;
    @FXML
    private Label nameLabel_011;
    @FXML
    private Button makeF1;
    @FXML
    private Button makeF2;
    @FXML
    private Button makeF3;
    @FXML
    private Button makeF4;
    @FXML
    private Button makeF5;
    @FXML
    private Button makePreDay;
    @FXML
    private Button makeNextDay;
    @FXML
    private Label currentDayLabel;
    @FXML
    private Label AvaliableSuiteLabel;

    @FXML
    private Label AvaliableDeluxeLabel;

    @FXML
    private Label AvaliableSuperiorLabel;

    @FXML
    private Label AvaliableStandardLabel;

    @FXML
    private Label AllSuiteLabel;

    @FXML
    private Label AllStandardLabel;

    @FXML
    private Label AllSuperiorLabel;

    @FXML
    private Label AllDeluxeLabel;

    @FXML
    private JFXButton customerButtton;

    @FXML
    private JFXButton  reportButtton;

    @FXML
    private Button makeDisplayRoomDB;

    private int roomIndex;
    private int currentDay = 1;
    private int avaSuite=0,avaStandard=0,avaSuperior=0,avaDeluxe=0;

    private ContextMenu context2 = new ContextMenu();

    private MenuItem walkInOnVacant = new MenuItem("Walk In");
    private MenuItem reserveOnvacant = new MenuItem("Reserve a room");
    private MenuItem cleanOnVacant = new MenuItem("Cleaning");
    private MenuItem blockOnVacant = new MenuItem("Room blocks");
    private MenuItem outOfServiceOnVacant = new MenuItem("Out of service");
    private MenuItem infoOnVacant = new MenuItem("Room info");

    private MenuItem checkInOnReserved = new MenuItem("Check In");
    private MenuItem paymentOnReserved = new MenuItem("Payment");
    private MenuItem guestInfoOnReserved = new MenuItem(("Customer"));
    private MenuItem tranferOnReserved   = new MenuItem("Tranfer");
    private MenuItem cancelOnReserved = new MenuItem("Cancel");
    private MenuItem roomInfoOnReserved = new MenuItem("Room info");

    private MenuItem checkOutOnInHouse = new MenuItem("Check out");
    private MenuItem paymentOnInHouse = new MenuItem("Payment");
    private MenuItem guestInfoOnInHouse = new MenuItem(("Customer"));
    private MenuItem tranferOnInHouse   = new MenuItem("Tranfer");
    //private MenuItem cancelOnInHouse= new MenuItem("Cancel");
    private MenuItem roomInfoOnInHouse= new MenuItem("Room info");

    private MenuItem doneOnCleaning = new MenuItem("Done");
    private MenuItem roomInfoOnCleaning = new MenuItem("RoomInfo");

    private MenuItem cancelOnOutofService = new MenuItem("Cancel");
    private MenuItem roomInfoOnOutofService = new MenuItem("Room info");

    private MenuItem cancelOnRoomBlock = new MenuItem("Cancel");
    private MenuItem roomInfoRoomBlock = new MenuItem("Room info");
    private MenuItem reserveOnRoomBlock = new MenuItem("Reserve");

    private ContextMenu vacantMenu = new ContextMenu();
    private ContextMenu reservedMenu = new ContextMenu();
    private ContextMenu inHouseMenu = new ContextMenu();
    private ContextMenu cleaningMenu = new ContextMenu();
    private ContextMenu outOfServiceMenu = new ContextMenu();
    private ContextMenu roomBlockMenu = new ContextMenu();

    //public static ArrayList<Pane> paneArrayList = new ArrayList<Pane>();

    private Pane selectedPane;
    private Stage reserveStage;
    private Stage cleaningStage;
    private Stage walkInStage;
    private Stage checkInStage;
    private Stage paymentStage;
    private Stage checkOutStage;
    private Stage roomInfoStage;
    private Stage guestFolioStage;
    private Stage outOfServiceStage;
    private Stage roomBlockStage;

    private String inHouseColor = "-fx-background-color: #24ec88";
    private String cleaningColor = "-fx-background-color: #4bccfd";
    private String vacantColor = "-fx-background-color:  #f6faff";
    private String outOfServiceColor = "-fx-background-color: #fc7777";
    private String bookedColor = "-fx-background-color: #f6d03a";
    private String roomBlockColor ="-fx-background-color: #f754dc";
    private String selectedFloorStyle = "-fx-background-color: #1473e6; -fx-text-fill: #ffffff";
    private String nonSelectFloorStyle = "-fx-background-color: #f0f5f2;-fx-text-fill: #9f9f9f";

    private Pane[] paneArr;
    private Label[] roomIDLabelArr;
    private Label[] doingLabelArr;
    private Label[] subDoingLabelArr;
    private Label[] vacantLabelArr;
    private Label[] nameLabelArr;
    private Label[] checkInLabelArr;
    private Label[] checkOutLabelArr;
    private Button[] floorButtonArr;

    private Customer customer;
    private int cleaningTimeMinute = 0;
    private LocalDate startDate;
    private LocalDate finishDate;

    private int currentFloorNum = 1;
    @FXML
    public void initialize() {
        Linker linker = new Linker();
        initClock();
        initLabel();
        initMenu();
        initRoomID();
        initPaneEffect();
        countRoom();
        updateRoomAvailaible();

        vacantMenu.getItems().addAll(reserveOnvacant,cleanOnVacant,blockOnVacant,outOfServiceOnVacant,infoOnVacant);
        reservedMenu.getItems().addAll(checkInOnReserved,paymentOnReserved,guestInfoOnReserved,cancelOnReserved,roomInfoOnReserved);
        inHouseMenu.getItems().addAll(checkOutOnInHouse,paymentOnInHouse,guestInfoOnInHouse,roomInfoOnInHouse);
        cleaningMenu.getItems().addAll(doneOnCleaning,roomInfoOnCleaning);
        outOfServiceMenu.getItems().addAll(cancelOnOutofService,roomInfoOnOutofService);
        roomBlockMenu.getItems().addAll(reserveOnRoomBlock,cancelOnRoomBlock,roomInfoRoomBlock);

        if(hotel.get(currentDay-1).getDate().equals(LocalDate.now()) ) {
            currentDayLabel.setText("TODAY");
            cleanOnVacant.setDisable(false);
            checkInOnReserved.setDisable(false);
            checkOutOnInHouse.setDisable(false);
        }
        else{
            currentDayLabel.setText(hotel.get(currentDay-1).getDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).toUpperCase());
            cleanOnVacant.setDisable(true);
            checkInOnReserved.setDisable(true);
            checkOutOnInHouse.setDisable(true);
        }

       /* walkInOnVacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)walkInOnVacant.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmWalkInScene()) {
                    ReservationHandler.walkInCheckIn(customer,room);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }

            }
        });*/

        reportButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(Linker.report);
            }
        });

        customerButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newCustomerScene());
            }
        });

        reserveOnvacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                selectedPane = (Pane)reserveOnvacant.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmReservationScene()) {
                    ReservationHandler.booking(customer,roomIndex,currentFloorNum,currentDay);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }

            }
        });

        cleanOnVacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)cleanOnVacant.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmCleaningScene()){
                    ReservationHandler.cleaning(room,cleaningTimeMinute);
                    updatePaneStatus(selectedPane);

                }
            }
        });

        blockOnVacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)blockOnVacant.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if(isRoomBlockScene()) {
                    ReservationHandler.roomBlock(roomIndex,currentFloorNum,currentDay,startDate,finishDate);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }
            }
        });
        outOfServiceOnVacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)cleanOnVacant.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if(isOutOfServiceScene()){
                    ReservationHandler.outOfService(roomIndex,currentFloorNum,currentDay,startDate,finishDate);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }
            }
        });

        infoOnVacant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)infoOnVacant.getParentPopup().getOwnerNode();
                roomInfoScene();
            }
        });

        checkInOnReserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)checkInOnReserved.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmCheckInScene()) {
                    ReservationHandler.checkIn(customer,roomIndex,currentFloorNum,currentDay);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }
            }
        });

        paymentOnReserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)paymentOnReserved.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmPaymentScene()){
                    ReservationHandler.payment(room);
                }
            }
        });

        guestInfoOnReserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)guestInfoOnReserved.getParentPopup().getOwnerNode();
                guestFolioScene();


            }
        });

        cancelOnReserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)cancelOnReserved.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                ReservationHandler.cancelBooking(roomIndex,currentFloorNum,currentDay);
                updatePaneStatus(selectedPane);
                updateRoomAvailaible();
            }
        });

        roomInfoOnReserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)roomInfoOnReserved.getParentPopup().getOwnerNode();
                roomInfoScene();
            }
        });

        checkOutOnInHouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)checkOutOnInHouse.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if(isCheckOutScene()){
                    ReservationHandler.checkOut(roomIndex,currentFloorNum,currentDay);
                    if (isConfirmCleaningScene()) {
                        ReservationHandler.cleaning(room, cleaningTimeMinute);
                    }
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();

                }

            }
        });

        paymentOnInHouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)paymentOnInHouse.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmPaymentScene()){
                    ReservationHandler.payment(room);
                }
            }
        });

        guestInfoOnInHouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)guestInfoOnInHouse.getParentPopup().getOwnerNode();
                guestFolioScene();

            }
        });

        tranferOnInHouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)tranferOnInHouse.getParentPopup().getOwnerNode();


            }
        });

        roomInfoOnInHouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)roomInfoOnInHouse.getParentPopup().getOwnerNode();
                roomInfoScene();
            }
        });
        doneOnCleaning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)doneOnCleaning.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                // System.out.println(selectedPane+"cureent");
                ReservationHandler.doneCleaning(room);
                updatePaneStatus(selectedPane);
            }
        });
        roomInfoOnCleaning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roomInfoScene();
            }
        });
        cancelOnOutofService.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)cancelOnOutofService.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                ReservationHandler.cancel(room);
                updatePaneStatus(selectedPane);
                updateRoomAvailaible();
            }
        });

        roomInfoOnOutofService.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)roomInfoOnOutofService.getParentPopup().getOwnerNode();
                roomInfoScene();
            }
        });

        roomInfoRoomBlock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane= (Pane)roomInfoRoomBlock.getParentPopup().getOwnerNode();
                roomInfoScene();
            }
        });
        cancelOnRoomBlock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)cancelOnRoomBlock.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                ReservationHandler.cancel(room);
                updatePaneStatus(selectedPane);
                updateRoomAvailaible();
            }
        });
        reserveOnRoomBlock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPane = (Pane)reserveOnRoomBlock.getParentPopup().getOwnerNode();
                Room room = searchRoomFromPane(selectedPane);
                if (isConfirmReservationScene()) {
                    ReservationHandler.booking(customer,roomIndex,currentFloorNum,currentDay);
                    updatePaneStatus(selectedPane);
                    updateRoomAvailaible();
                }
            }
        });



        makeF1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentFloorNum != 1){
                    floorButtonArr[currentFloorNum-1].setStyle(nonSelectFloorStyle);
                    currentFloorNum = 1;
                    floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
                    updateAll();
                }
            }
        });
        makeF2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentFloorNum != 2){
                    floorButtonArr[currentFloorNum-1].setStyle(nonSelectFloorStyle);
                    currentFloorNum = 2;
                    floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
                    updateAll();
                }
            }
        });
        makeF3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentFloorNum != 3) {
                    floorButtonArr[currentFloorNum-1].setStyle(nonSelectFloorStyle);
                    currentFloorNum = 3;

                    floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
                    updateAll();
                }
            }
        });
        makeF4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentFloorNum != 4) {
                    floorButtonArr[currentFloorNum-1].setStyle(nonSelectFloorStyle);
                    currentFloorNum = 4;
                    floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
                    updateAll();
                }

            }
        });
        makeF5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentFloorNum != 5) {
                    floorButtonArr[currentFloorNum-1].setStyle(nonSelectFloorStyle);
                    currentFloorNum = 5;
                    floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
                    updateAll();

                }

            }
        });
        makeNextDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(currentDay < 30){
                    currentDay++;
                    updateAll();
                }
                if(hotel.get(currentDay-1).getDate().equals(LocalDate.now()) ) {
                    currentDayLabel.setText("TODAY");
                    cleanOnVacant.setDisable(false);
                    checkInOnReserved.setDisable(false);
                    checkOutOnInHouse.setDisable(false);
                }
                else{
                    currentDayLabel.setText(hotel.get(currentDay-1).getDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).toUpperCase());
                    cleanOnVacant.setDisable(true);
                    checkInOnReserved.setDisable(true);
                    checkOutOnInHouse.setDisable(true);
                }
                updateRoomAvailaible();;

            }


        });
        makePreDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(currentDay > 1){
                    currentDay--;
                    updateAll();
                }
                if(hotel.get(currentDay-1).getDate().equals(LocalDate.now()) ) {
                    currentDayLabel.setText("TODAY");
                    cleanOnVacant.setDisable(false);
                    checkInOnReserved.setDisable(false);
                    checkOutOnInHouse.setDisable(false);
                }
                else{
                    currentDayLabel.setText(hotel.get(currentDay-1).getDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")).toUpperCase());
                    cleanOnVacant.setDisable(true);
                    checkInOnReserved.setDisable(true);
                    checkOutOnInHouse.setDisable(true);
                }
                updateRoomAvailaible();
            }
        });
        updateAll();

    }
    public Room searchRoomFromPane(Pane selectedPane){
        Room room = null;
        for (int i = 0; i < paneArr.length  ; i++) {
            if (selectedPane ==paneArr[i]) {
                room = hotel.get(currentDay-1).getFloors()[currentFloorNum -1].getRooms()[i];
                roomIndex = i;
            }

        }

        return room;
    }
    private void initLabel(){
        roomIDLabelArr = new Label[]{roomIDLabel_00,roomIDLabel_01,roomIDLabel_02,roomIDLabel_03,roomIDLabel_04,roomIDLabel_05,roomIDLabel_06,roomIDLabel_07
                ,roomIDLabel_08,roomIDLabel_09,roomIDLabel_010,roomIDLabel_011};
        doingLabelArr = new Label[]{doingLabel_00,doingLabel_01,doingLabel_02,doingLabel_03,doingLabel_04,doingLabel_05,doingLabel_06
                ,doingLabel_07,doingLabel_08,doingLabel_09,doingLabel_010,doingLabel_011};
        subDoingLabelArr = new Label[]{subDoingLabel_00,subDoingLabel_01,subDoingLabel_02,subDoingLabel_03,subDoingLabel_04,subDoingLabel_05,subDoingLabel_06
                ,subDoingLabel_07,subDoingLabel_08,subDoingLabel_09,subDoingLabel_010,subDoingLabel_011};
        vacantLabelArr = new Label[]{vacantLabel_00,vacantLabel_01,vacantLabel_02,vacantLabel_03,vacantLabel_04,vacantLabel_05,vacantLabel_06
                ,vacantLabel_07,vacantLabel_08,vacantLabel_09,vacantLabel_010,vacantLabel_011};
        nameLabelArr = new Label[]{nameLabel_00,nameLabel_01,nameLabel_02,nameLabel_03,nameLabel_04,nameLabel_05,nameLabel_06
                ,nameLabel_07,nameLabel_08,nameLabel_09,nameLabel_010,nameLabel_011};
        checkInLabelArr = new Label[]{checkInLabel_00,checkInLabel_01,checkInLabel_02,checkInLabel_03,checkInLabel_04,checkInLabel_05,checkInLabel_06
                ,checkInLabel_07,checkInLabel_08,checkInLabel_09,checkInLabel_010,checkInLabel_011};
        checkOutLabelArr = new Label[]{checkOutLabel_00,checkOutLabel_01,checkOutLabel_02,checkOutLabel_03,checkOutLabel_04,checkOutLabel_05,checkOutLabel_06
                ,checkOutLabel_07,checkOutLabel_08,checkOutLabel_09,checkOutLabel_010,checkOutLabel_011};
        floorButtonArr = new Button[]{makeF1,makeF2,makeF3,makeF4,makeF5};


    }
    private void initRoomID(){

        for (int i = 0; i < roomIDLabelArr.length; i++) {
            // System.out.println(hotel.get(currentDay-1).getFloors()[currentFloorNum -1].getRooms()[4].getRoomID());
            roomIDLabelArr[i].setText(hotel.get(currentDay-1).getFloors()[currentFloorNum -1].getRooms()[i].getRoomID());
        }

    }
    private void initMenu(){

        paneArr = new Pane[]{pane_00,pane_01,pane_02,pane_03,pane_04,pane_05,pane_06,pane_07,pane_08,pane_09,pane_010,pane_011};

        for (Pane pane:paneArr) {
            pane.setOnContextMenuRequested(event -> vacantMenu.show(pane,event.getScreenX(),event.getScreenY()));
        }

    }
    private void initPaneEffect(){
        for (int i = 0; i < paneArr.length  ; i++) {
            int index = i;
            paneArr[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    paneArr[index].setEffect(new DropShadow());
                }
            });
            paneArr[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(selectedPane !=  paneArr[index])
                        paneArr[index].setEffect(null);
                }

            });
            paneArr[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton() == MouseButton.SECONDARY) {
                        for (Pane pane : paneArr) {
                            pane.setEffect(null);
                        }
                        paneArr[index].setEffect(new DropShadow());
                        selectedPane = paneArr[index];
                    }else {
                        for (Pane pane : paneArr) {
                            pane.setEffect(null);
                        }
                        selectedPane = null;
                    }
                }
            });


        }
    }
    private void  initClock(){
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
    }
    private boolean isRoomBlockScene(){
        boolean isConfirm = false;
        RoomBlockController roomBlockController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/RoomBlockPage.fxml"));
            Parent root = loader.load();
            roomBlockController = loader.getController();
            roomBlockController.setParentController(this);
            roomBlockController.setRoom(searchRoomFromPane(selectedPane));
            roomBlockController.setInfo();
            roomBlockStage = new Stage();
            roomBlockStage.setTitle("Room Block");
            roomBlockStage.setScene(new Scene(root, 612, 410));
            roomBlockStage.showAndWait();
            isConfirm = roomBlockController.isConfirm();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isConfirm;
    }
    private boolean isOutOfServiceScene(){
        boolean isConfirm = false;
        OutOfServiceController outOfServiceController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/OutOFServicePage.fxml"));
            Parent root = loader.load();
            outOfServiceController = loader.getController();
            outOfServiceController.setParentController(this);
            outOfServiceController.setRoom(searchRoomFromPane(selectedPane));
            outOfServiceController.setInfo();
            outOfServiceStage = new Stage();
            outOfServiceStage.setTitle("Cleaning");
            outOfServiceStage.setScene(new Scene(root, 600, 400));
            outOfServiceStage.showAndWait();
            isConfirm = outOfServiceController.isConfirm();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isConfirm;
    }
    private void guestFolioScene(){
        CustomerInfoPageController customerInfoPageController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/CustomerFolioPage.fxml"));
            Parent root = loader.load();
            customerInfoPageController = loader.getController();
            customerInfoPageController.setParentController(this);
            customerInfoPageController.setRoom(searchRoomFromPane(selectedPane));
            customerInfoPageController.setInfo();
            guestFolioStage = new Stage();
            guestFolioStage.setTitle("Cleaning");
            guestFolioStage.setScene(new Scene(root, 600, 500));
            guestFolioStage.showAndWait();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private void roomInfoScene(){
        RoomInfoPageController roomInfoPageController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/RoomInfoPage.fxml"));
            Parent root = loader.load();
            roomInfoPageController = loader.getController();
            roomInfoPageController.setParentController(this);
            roomInfoPageController.setRoom(searchRoomFromPane(selectedPane));
            roomInfoPageController.setInfo();
            roomInfoStage = new Stage();
            roomInfoStage.setTitle("Cleaning");
            roomInfoStage.setScene(new Scene(root, 647, 565));
            roomInfoStage.showAndWait();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private boolean isCheckOutScene(){
        boolean isCheckOut = false;
        CheckOutPageController checkOutPageController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/CheckOutPage.fxml"));
            Parent root = loader.load();
            checkOutPageController = loader.getController();
            checkOutPageController.setParentController(this);
            checkOutPageController.setRoom(searchRoomFromPane(selectedPane));
            checkOutPageController.setInfo();
            checkOutStage = new Stage();
            checkOutStage.setTitle("Cleaning");
            checkOutStage.setScene(new Scene(root, 664, 710));
            checkOutStage.showAndWait();
            isCheckOut = checkOutPageController.isCheckOut();
        }catch (Exception e){
            System.out.println(e);
        }
        return isCheckOut;
    }


    private boolean isConfirmCleaningScene(){
        boolean isConfirm = false;
        CleaningPageController cleaningPageController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/CleaningPage.fxml"));
            Parent root = loader.load();
            cleaningPageController = loader.getController();
            cleaningPageController.setReservationPageController(this);
            cleaningPageController.initRoom();
            cleaningStage = new Stage();
            cleaningStage.setTitle("Cleaning");
            cleaningStage.setScene(new Scene(root, 600, 400));
            cleaningStage.showAndWait();
            isConfirm = cleaningPageController.getConfirm();
        }catch (Exception e){
               e.printStackTrace();
        }
        return isConfirm;
    }
    private boolean isConfirmCheckInScene(){
        boolean isConfirm = false;
        CheckInController checkInController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/CheckInReserved.fxml"));
            Parent root = loader.load();
            checkInController = loader.getController();
            checkInController.setParentController(this);
            checkInController.setRoom(searchRoomFromPane(selectedPane));
            checkInController.getInfoFromGuest();
            checkInStage = new Stage();
            checkInStage.setTitle("Check In");
            checkInStage.setScene(new Scene(root, 1000, 770));
            checkInStage.showAndWait();
            isConfirm = checkInController.getConfirm();
        }catch (Exception e){
            System.out.println(e);
        };

        return isConfirm;
    }
    /* private boolean isConfirmWalkInScene(){
         boolean isConfirm = false;
         WalkInController walkInController;
         try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/CheckInWalkIn.fxml"));
             Parent root = loader.load();
             walkInController = loader.getController();
             walkInController.setParentController(this);
             walkInStage = new Stage();
             walkInStage.setTitle("Walk In");
             walkInStage.setScene(new Scene(root, 800, 782));
             walkInStage.showAndWait();
             isConfirm = walkInController.getConfirm();
         }catch (Exception e){
             System.out.println(e);
         };
         return isConfirm;
     }*/
    private boolean isConfirmReservationScene() {
        boolean isConfirm = false;
        ReserveRoomController reserveRoomController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/ReserveRoomPage.fxml"));
            // System.out.println();
            Parent root = loader.load();
            reserveRoomController = loader.getController();
            reserveRoomController.setParentController(this);
            reserveStage = new Stage();
            reserveStage.setTitle("ReservationHandler");
            reserveStage.setScene(new Scene(root, 834, 698));
            reserveStage.showAndWait();
            isConfirm = reserveRoomController.getConfirm();
        }catch (Exception e){
            e.printStackTrace();
        }

        return isConfirm;
    }
    public boolean isConfirmPaymentScene() {
        boolean isPay = false;
        PaymentPageController paymentPageController;

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../page/PaymentPage.fxml"));
            // System.out.println();
            //  System.out.println(loader);
            Parent root = loader.load();
            paymentPageController = loader.getController();
            paymentPageController.setParentController(this);
            paymentPageController.setRoom(searchRoomFromPane(selectedPane));
            paymentPageController.setInfo();
            paymentStage = new Stage();
            paymentStage.setTitle("Payment");
            paymentStage.setScene(new Scene(root, 700, 500));
            paymentStage.showAndWait();
            isPay= paymentPageController.isPay();
        }catch (Exception e){
            System.out.println(e.getCause());
        }

        return isPay;
    }
    public void updatePaneStatus(Pane selected ){
        for (int i = 0; i < paneArr.length  ; i++) {
            if (selected == paneArr[i]) {
                Room room = hotel.get(currentDay-1).getFloors()[currentFloorNum -1].getRooms()[i];
                String status = room.getStatus();
                Customer customer =  room.getCustomer();
                vacantLabelArr[i].setText("");
                doingLabelArr[i].setText("");
                subDoingLabelArr[i].setText("");
                checkInLabelArr[i].setText("");
                checkOutLabelArr[i].setText("");
                nameLabelArr[i].setText("");
                if(status.equals("Vacant") ) {
                    if(room.getCustomer()!=null)
                        vacantLabelArr[i].setText(room.getCustomer().getFirstName());
                    else
                        vacantLabelArr[i].setText("Vacant");
                    selected.setStyle(vacantColor);
                    selected.setOnContextMenuRequested(event1 -> vacantMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #3d8ceb");

                }else if(status.equals("Reserved")){
                    doingLabelArr[i].setText(customer.getFirstName() + "  " + customer.getLastName().substring(0, 1) + '.');
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #ffffff");
                    selected.setStyle(bookedColor);
                    selected.setOnContextMenuRequested(event1 -> reservedMenu.show(selected,event1.getScreenX(),event1.getScreenY()));

                }else if(status.equals("In House")){
                    selected.setStyle(inHouseColor);
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #ffffff");
                    doingLabelArr[i].setText(customer.getFirstName() + "  " + customer.getLastName().substring(0, 1) + '.');
                    selected.setOnContextMenuRequested(event1 -> inHouseMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
                }else if(status.equals("Cleaning")){
                    selected.setStyle(cleaningColor);
                    selected.setOnContextMenuRequested(event1 -> cleaningMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
                    doingLabelArr[i].setText("Cleaning");
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #ffffff");
                    room.getCountDownClock().setCountDownLabel(subDoingLabelArr[i]);
                    room.getCountDownClock().setReservationPageController(this);
                    room.getCountDownClock().clock();
                }else if(status.equals("Out Of Service")){
                    selected.setStyle(outOfServiceColor);
                    selected.setOnContextMenuRequested(event1 -> outOfServiceMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
                    doingLabelArr[i].setText(room.getMemo());
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #ffffff");
                }else if(status.equals("Room Block")){
                    selected.setStyle(roomBlockColor);
                    selected.setOnContextMenuRequested(event1 ->  roomBlockMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
                    doingLabelArr[i].setText(room.getMemo());
                    roomIDLabelArr[i].setStyle("-fx-text-fill: #ffffff");
                }
            }
        }
    }
    public void updateAll(){
        for (OneDayHotel e:hotel) {
            for (int i = 0; i < e.getFloors().length; i++) {
                for (int j = 0; j < e.getFloors()[i].getRooms().length; j++) {
                    if( e.getFloors()[i].getRooms()[j].getCountDownClock()!=null)
                        e.getFloors()[i].getRooms()[j].getCountDownClock().setCountDownLabel(null);
                }
            }
        }

        for (int i = 0; i < paneArr.length; i++) {
            updatePaneStatus(paneArr[i]);
        }
        initRoomID();
        floorButtonArr[currentFloorNum-1].setStyle(selectedFloorStyle);
    }

    public void countRoom(){
        int allSuite=0,allStandard=0,allSuperior=0,allDeluxe=0;
        for (int i = 0; i < hotel.get(currentDay-1).getFloors().length; i++) {
            for (int j = 0; j < hotel.get(currentDay-1).getFloors()[i].getRooms().length; j++) {
                Room room =hotel.get(currentDay-1).getFloors()[i].getRooms()[j];
                if(room instanceof StandardRoom ){
                    allStandard++;
                }else if(room instanceof SuiteRoom ){
                    allSuite++;
                }else if(room instanceof DeluxeRoom  ){
                    allDeluxe++;
                }else if(room instanceof SuperiorRoom ){
                    allSuperior++;

                }
            }
        }
        AllSuiteLabel.setText(Integer.toString(allSuite));
        AllDeluxeLabel.setText(Integer.toString(allDeluxe));
        AllStandardLabel.setText(Integer.toString(allStandard));
        AllSuperiorLabel.setText(Integer.toString(allSuperior));

    }

    public void updateRoomAvailaible(){
        avaDeluxe=0;
        avaSuite=0;
        avaStandard=0;
        avaSuperior=0;
        for (int i = 0; i < hotel.get(currentDay-1).getFloors().length; i++) {
            for (int j = 0; j < hotel.get(currentDay-1).getFloors()[i].getRooms().length; j++) {
                Room room =hotel.get(currentDay-1).getFloors()[i].getRooms()[j];

                if(room.getStatus().equals("Vacant")){
                    if(room instanceof StandardRoom ){
                        this.avaStandard++;
                    }else if(room instanceof SuiteRoom ){
                        this.avaSuite++;
                    }else if(room instanceof DeluxeRoom  ){
                        this.avaDeluxe++;
                    }else if(room instanceof SuperiorRoom ){
                        this.avaSuperior++;
                    }
                }

            }
        }
        AvaliableDeluxeLabel.setText(Integer.toString(avaDeluxe));
        AvaliableStandardLabel.setText(Integer.toString(avaStandard));
        AvaliableSuiteLabel.setText(Integer.toString(avaSuite));
        AvaliableSuperiorLabel.setText(Integer.toString(avaSuperior));
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pane[] getPaneArr() {
        return paneArr;
    }


    public int getCurrentFloorNum() {
        return currentFloorNum;
    }

    public Pane getSelectedPane() {
        return selectedPane;
    }

    public void setCleaningTimeMinute(int cleaningTimeMinute) {
        this.cleaningTimeMinute = cleaningTimeMinute;
    }

    public Stage getReserveStage() {
        return reserveStage;
    }

    public Stage getCleaningStage() {
        return cleaningStage;
    }

    public Stage getWalkInStage() {
        return walkInStage;
    }

    public Stage getCheckInStage() {
        return checkInStage;
    }

    public Stage getPaymentStage() {
        return paymentStage;
    }

    public Stage getOutOfServiceStage() {
        return outOfServiceStage;
    }

    public Stage getCheckOutStage() {
        return checkOutStage;
    }
    public Stage getRoomInfoStage(){
        return roomInfoStage;
    }
    public Stage getGuestFolioStage(){
        return guestFolioStage;
    }

    public Stage getRoomBlockStage() {
        return roomBlockStage;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getCurrentDay() {
        return currentDay;
    }
    public void setRoomIndex(int roomIndex){
        this.roomIndex =roomIndex;
    }
    /* private void makeCheckIn(MenuItem checkInItem){
        TilePane selected = (TilePane)checkInItem.getParentPopup().getOwnerNode();
        selected.setStyle("-fx-background-color: red");
        selected.setOnContextMenuRequested(event1 -> inHouseMenu.show(selected,event1.getScreenX(),event1.getScreenY()));
    }*/

}

