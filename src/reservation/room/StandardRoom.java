package reservation.room;

import Hotel.Customer;

public class StandardRoom extends Room {
    private int weekDayRoomPrice = 699;
    private int weekEndRoomPrice = 899;

    public StandardRoom(int floorNum, int roomNum, String status, Customer customer){
        super(floorNum,roomNum, status, customer);
        super.weekDayRoomPrice =this.weekDayRoomPrice;
        super.weekEndRoomPrice = this.weekEndRoomPrice;
        super.RoomType = "Standard";
    }



}
