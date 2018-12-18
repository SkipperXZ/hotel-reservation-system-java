package clock;
import Hotel.RoomList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import Hotel.Hotel;
import main.Linker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static Clock clock = new Clock();
    private Label clockLabel;
    private Label dateLabel;
    private int month;
    private int day;
    private int year;

    private int minute;
    private int hour;
    private int second;

    public Clock(){
             Linker linker = new Linker();
             day = LocalDateTime.now().getDayOfMonth();
             month = LocalDateTime.now().getMonthValue();
             year = LocalDateTime.now().getYear();
             Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
                second = LocalDateTime.now().getSecond();
                minute = LocalDateTime.now().getMinute();
                hour = LocalDateTime.now().getHour();
                if(clockLabel != null) {
                    clockLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                }
                 while(!Hotel.hotel.get(0).getDate().equals(LocalDate.now())){
                     Hotel.hotel.add(new RoomList(Hotel.hotel.get(Hotel.hotel.size()-1).getDate().plusDays(1)));
                     Hotel.hotel.remove(Hotel.hotel.get(0));
                     if(Linker.primaryStage.getScene() == Linker.resScene){
                         Linker.primaryStage.setScene(linker.newCustomerScene());
                     }
                 }

            }),
                    new KeyFrame(Duration.seconds(1))
            );
            Timeline calendar = new Timeline(new KeyFrame(Duration.ZERO, e -> {

                //day = LocalDateTime.now().getDayOfMonth();
                //month = LocalDateTime.now().getMonthValue();
                //year = LocalDateTime.now().getYear();
                // System.out.println(day+"/"+month+"/"+year);
                dateLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")).toUpperCase());

            }),
                    new KeyFrame(Duration.seconds(1))
            );
            clock.setCycleCount(Animation.INDEFINITE);
            clock.play();
            calendar.setCycleCount(Animation.INDEFINITE);
            calendar.play();


        }

    public void setClockLabel(Label clockLabel) {
        this.clockLabel = clockLabel;
        clockLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public void setDateLabel(Label dateLabel) {
        this.dateLabel = dateLabel;
        dateLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")).toUpperCase());
    }
}
