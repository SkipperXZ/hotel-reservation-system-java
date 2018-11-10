package report;

import java.io.Serializable;
import java.util.ArrayList;

public class AllBooking implements Serializable {
    public static ArrayList<Booking> allBooking = new ArrayList<Booking>();

    public static void addBooking(Booking booking){
        allBooking.add(booking);

        for (Booking number : allBooking) {
            System.out.println("Reg Number = " + number.getRegNum()+"       Num Operation"+ number.getOperation());
        }
    }
}
