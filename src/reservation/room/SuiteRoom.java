package reservation.room;

import Hotel.Customer;

public class SuiteRoom extends Room{
    private int weekDayRoomPrice = 3899;
    private int weekEndRoomPrice = 4899;
    public SuiteRoom(int floorNum, int roomNum, String status, Customer customer){
        super(floorNum,roomNum, status, customer);
        super.weekDayRoomPrice =this.weekDayRoomPrice;
        super.weekEndRoomPrice = this.weekEndRoomPrice;
        super.RoomType = "Suite";
    }
}
