package reservation.room;

import Hotel.Customer;

public class SuperiorRoom extends Room{

    private int weekDayRoomPrice = 1599;
    private int weekEndRoomPrice = 1899;

    public SuperiorRoom(int floorNum, int roomNum, String status, Customer customer){
        super(floorNum,roomNum, status, customer);
        super.weekDayRoomPrice =this.weekDayRoomPrice;
        super.weekEndRoomPrice = this.weekEndRoomPrice;
        super.RoomType = "Superior";
    }
}
