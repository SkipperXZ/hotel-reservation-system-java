package Hotel;

import java.io.Serializable;
import java.time.LocalDate;

public class RoomList implements Serializable {

    private Floor[] floors ;
    private LocalDate date;

    public RoomList(LocalDate date){
        this.date = date;
        floors = new Floor[]{new Floor(1),new Floor(2),new Floor(3),new Floor(4),new Floor(5)};
    }

    public LocalDate getDate() {
        return date;
    }

    public Floor[] getFloors() {
        return floors;
    }
}
