package Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel implements Serializable {
    public static ArrayList<RoomList> hotel = new ArrayList<RoomList>();

    public Hotel(){
        for (int i = 0; i <30 ; i++) {
            hotel.add(new RoomList(LocalDate.now().plusDays(i)));
        }
    }
}
