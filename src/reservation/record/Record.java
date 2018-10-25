package reservation.record;

import Hotel.Customer;
import reservation.room.Room;

public class Record {
    private Customer customer;

    private Room room;

    public Record(Customer customer, Room room){
        this.customer = customer;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }



}
