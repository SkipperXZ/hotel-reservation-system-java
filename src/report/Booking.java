package report;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking implements Serializable {
    private String firstname;
    private String lastname;
    private int regNum;
    private String tel;
    private String roomNum;
    private String roomType;
    private int price;
    private LocalDateTime recordTime;
    private LocalDate recordDate;
    private int operation;

    public  Booking(int regNum, int operation, String firstname, String lastname, String tel, String roomNum, String roomType, int price, LocalDateTime recordTime, LocalDate recordDate){ /// Check-IN
        this.firstname = firstname;
        this.lastname = lastname;
        this.regNum = regNum;
        this.tel = tel;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.price = price;
        this.recordTime = recordTime;
        this.recordDate = recordDate;
        this.operation = operation;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRegNum() {
        return regNum;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

}


