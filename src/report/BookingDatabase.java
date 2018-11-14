package report;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingDatabase implements Serializable{
    public static ArrayList<Booking> bookingDatabase = new ArrayList<Booking>();

    public static void addBooking(Booking booking){
        bookingDatabase.add(booking);
    }
}