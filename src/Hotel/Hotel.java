package Hotel;

import reservation.RecordDatabase;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel implements Serializable {
    public static ArrayList<OneDayHotel> hotel = new ArrayList<OneDayHotel>();

    public Hotel(){
        for (int i = 0; i <30 ; i++) {
            hotel.add(new OneDayHotel(LocalDate.now().plusDays(i)));
        }
    }
}
