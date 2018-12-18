package reservation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import reservation.controller.ReservationPageUI;
import reservation.room.Room;

import java.io.Serializable;

import static Hotel.Hotel.hotel;

public class CountDownClock implements Serializable {

    @FXML
    private Label countDownLabel ;
    private int countDownTimeMin =0;
    private ReservationPageUI reservationPageController;
    private int sec = 0;
    private int min = 0;
    private String minText ="";
    private String secText ="";
    private Timeline countDown;
    private Room room;



    public CountDownClock(Room room){
        countDownTimeMin = room.getCleaningTimeMinute();

        this.room =room;
        min = countDownTimeMin;
        //System.out.println("CountDownClock");


    }
    public void skipCleaning() {
        if (room.getFloorNum() == reservationPageController.getCurrentFloorNum()) {
            for (int i = 0; i < hotel.get(reservationPageController.getCurrentDay()-1).getFloors()[room.getFloorNum() - 1].getRooms().length; i++) {
                  // System.out.println(Hotel.RoomList.oneDayHotel.getFloors()[room.getCurrentFloorNum()-1].getRooms()[i]+"   "+room);
                if (hotel.get(reservationPageController.getCurrentDay()-1).getFloors()[room.getFloorNum() - 1].getRooms()[i] == room)
                    reservationPageController.updatePaneStatus(reservationPageController.getPaneArr()[i]);
            }
        }
        room.setCountDownClock(null);
        countDown.stop();
    }
    public void clock(){
        if(countDown == null){
        countDown = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            if(countDownLabel != null) {
                secText = Integer.toString(sec);
                minText = Integer.toString(min);
                if (min < 10)
                    minText = "0" + min;
                if (sec < 10)
                    secText = "0" + sec;
                countDownLabel.setText("Time Out   " + minText + ":" + secText);
            }
            if(min == 0 && sec == 0){
                //System.out.println(room);
                room.setStatus(room.getPreStatus());
                if (room.getFloorNum() == reservationPageController.getCurrentFloorNum()){
                    for (int i = 0; i < hotel.get(reservationPageController.getCurrentDay()-1).getFloors()[room.getFloorNum()-1].getRooms().length ; i++) {
                        if(hotel.get(reservationPageController.getCurrentDay()-1).getFloors()[room.getFloorNum()-1].getRooms()[i] == room){
                            reservationPageController.updatePaneStatus(reservationPageController.getPaneArr()[i]);}
                    }
                }
                room.setCountDownClock(null);
                countDown.stop();

            }
            if(sec == 0){
                min--;
                sec = 60;
            }
            sec--;
            // System.out.println(reservationPageController.getSelectedPane());

        }),
                new KeyFrame(Duration.seconds(1))
        );
        countDown.setCycleCount(Animation.INDEFINITE);
        countDown.play();
        }
        countDownLabel.setText("Time Out   "+min+":"+sec);

    }

    public void setCountDown(Timeline countDown) {
        this.countDown = countDown;
    }

    public void setCountDownLabel(Label countDownLabel) {
        this.countDownLabel = countDownLabel;
    }

    public void setReservationPageController(ReservationPageUI reservationPageController) {
        this.reservationPageController = reservationPageController;
    }
}
