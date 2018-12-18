package customer;

import Hotel.Customer;
import Hotel.CustomerList;
import report.Booking;
import report.BookingDatabase;

import java.util.ArrayList;
import java.util.Collection;

import static Hotel.CustomerList.customerDatabase;

public class CustomerSystem
{
    public  Collection<Customer> getCustomerList() {
    return CustomerList.customerDatabase.values();
    }
    public Customer getCustomer(String NameHash){
     return customerDatabase.get(NameHash);
    }
    public  void addCustomer(Customer customer){
        CustomerList.updateCustomer(customer);
    }

    public void deleteCustomer(String NameHash){
       CustomerList.customerDatabase.remove(NameHash);
    }
    public ArrayList<Booking> getBookingCustomer(String name){
        ArrayList<Booking> arrayList = new ArrayList<>();
        for (Booking booking: BookingDatabase.bookingDatabase) {
            if (booking.getOperation() == 1 || booking.getOperation() == 2) {
                if (booking.getFullname().equals(name)){
                    arrayList.add(booking);
                }
            }
        }

        return  arrayList;
    }

}
