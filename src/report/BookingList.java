package report;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingList implements Serializable{
    public static ArrayList<Booking> bookingList = new ArrayList<Booking>();

    public static void addBooking(Booking booking){
        bookingList.add(booking);
    }
}