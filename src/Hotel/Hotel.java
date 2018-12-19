package Hotel;

import report.Booking;
import report.BookingList;
import staff.Staff;
import staff.StaffList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Hotel implements Serializable {
    public static ArrayList<RoomList> hotel = new ArrayList<RoomList>();

    public Hotel(){
        for (int i = 0; i <30 ; i++) {
            hotel.add(new RoomList(LocalDate.now().plusDays(i)));
        }
    }

    public  ArrayList<Booking> getBookingList() {
        return BookingList.bookingList;
    }
    public Collection<Customer> getCustomerList() {
        return CustomerList.customerList.values();
    }
    public  ArrayList<Staff> getStaff() {
        return StaffList.userArrayList;
    }
}
