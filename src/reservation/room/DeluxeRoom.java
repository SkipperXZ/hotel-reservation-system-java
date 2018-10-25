package reservation.room;

import Hotel.Customer;

public class DeluxeRoom extends Room {
    private int weekDayRoomPrice = 2599;
    private int weekEndRoomPrice = 2899;

    public DeluxeRoom(int floorNum, int roomNum, String status, Customer customer){
        super(floorNum,roomNum, status, customer);
        super.weekDayRoomPrice =this.weekDayRoomPrice;
        super.weekEndRoomPrice = this.weekEndRoomPrice;
        super.RoomType = "Deluxe";
    }
}
