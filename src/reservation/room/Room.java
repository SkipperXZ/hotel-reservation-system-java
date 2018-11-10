package reservation.room;

import reservation.CountDownClock;
import Hotel.Customer;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Room implements Serializable {
    private String roomID;
    private String status = "Vacant";
    private Customer customer;
    private int cleaningTimeMinute = 30;
    private LocalDateTime checkInTime;
    private CountDownClock countDownClock;
    private int floorNum;
    private int roomNum;
    private String preStatus;
    public int weekDayRoomPrice;
    public int weekEndRoomPrice;
    public String RoomType;
    private String memo;
    private String abb;

    public Room(int floorNum, int roomNum, String status, Customer customer){
        this.floorNum = floorNum;
        this.roomNum = roomNum;
        if(this instanceof StandardRoom){
            this.RoomType = "Standard";
            this.abb = "A";
        }else if(this instanceof SuperiorRoom){
            this.RoomType = "Superior";
            this.abb ="B";
        }else if(this instanceof DeluxeRoom){
            this.RoomType = "Deluxe";
            this.abb ="D";
        }else if(this instanceof SuiteRoom){
            this.RoomType = "Suite";
            this.abb ="S";
        }
        if(roomNum < 10)
             this.roomID=this.abb+String.valueOf(floorNum)+"0"+String.valueOf(roomNum) ;
        else
             this.roomID =this.abb+String.valueOf(floorNum)+String.valueOf(roomNum) ;
        this.status = status;
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getRoomID() {
        return roomID;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CountDownClock getCountDownClock() {
        return countDownClock;
    }

    public void setCountDownClock(CountDownClock countDownClock) {
        this.countDownClock = countDownClock;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public int getCleaningTimeMinute() {
        return cleaningTimeMinute;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setCleaningTimeMinute(int cleaningTimeMinute) {
        this.cleaningTimeMinute = cleaningTimeMinute;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getWeekDayRoomPrice() {
        return weekDayRoomPrice;
    }

    public int getWeekEndRoomPrice() {
        return weekEndRoomPrice;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }
}
