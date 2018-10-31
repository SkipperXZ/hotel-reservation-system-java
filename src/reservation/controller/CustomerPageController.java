package reservation.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import main.Linker;


public class CustomerPageController {

    @FXML
    private JFXButton  dashboardButtton;
    @FXML
    private JFXButton  calendarButtton;
    @FXML
    private JFXButton  reservationButtton;
    @FXML
    private JFXButton  customerButtton;
    @FXML
    private JFXButton  reportButtton;
    @FXML
    private JFXButton  userButtton;

    @FXML
    public void initialize() {
        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(Linker.resScene);
            }
        });
        //test


//        CalendarButtton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    gotoReservation(event);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
//    public void gotoReservation(ActionEvent event) throws IOException {
//        Parent reservationParent = FXMLLoader.load(getClass().getResource("res.fxml"));
//        Scene  reservationScene = new Scene(reservationParent);
//
//        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(reservationScene);
//        window.show();
//
//    }

}
