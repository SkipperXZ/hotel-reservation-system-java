package report;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private int operation;
    private String fullname;
    private int nightNum;
    private String summaryTopic;
    private int total;
    private String timeFormet;
    private String arrivalTimeFormet;
    private String departureTimeFormet;
    private String userRecord;
    private String userRecordTime;
    private String userRecordDate;
    private String activity;

    public  Booking(String userRecord, int regNum, int operation, String firstname, String lastname, String tel, String roomNum, String roomType, int price, LocalDateTime recordTime, LocalDate recordDate, int nightNum){ /// Check-IN
        this.userRecord = userRecord;
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
        this.nightNum = nightNum;
        fullname = firstname+" "+lastname;
        timeFormet = recordTime.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
        userRecordTime = recordTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        userRecordDate = recordTime.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        if(operation == 1){ activity="Check in"; }
        else if(operation == 2){ activity="Check out"; }
        else if(operation == 3){ activity="Cancel"; }
        else if(operation == 4){ activity="Booking"; }
    }

    public  Booking(String userRecord, int regNum, int operation, String firstname, String lastname, String tel, String roomNum, String roomType, int price,LocalDateTime recordTime,LocalDate recordDate, LocalDateTime arrivalDate, LocalDateTime departureDate, int nightNum){ /// Check-IN
        this.userRecord = userRecord;
        this.firstname = firstname;
        this.lastname = lastname;
        this.regNum = regNum;
        this.tel = tel;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.price = price;
        this.recordTime = recordTime;
        this.recordDate = recordDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.operation = operation;
        this.nightNum = nightNum;
        fullname = firstname+" "+lastname;
        arrivalTimeFormet = arrivalDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        departureTimeFormet = departureDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        userRecordTime = recordTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        userRecordDate = recordTime.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        if(operation == 1){ activity="Check in"; }
        else if(operation == 2){ activity="Check out"; }
        else if(operation == 3){ activity="Cancel"; }
        else if(operation == 4){ activity="Booking"; }
    }

    public Booking(String summaryTopic, int total) {
        this.summaryTopic = summaryTopic;
        this.total= total;
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

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNightNum() {
        return nightNum;
    }

    public void setNightNum(int nightNum) {
        this.nightNum = nightNum;
    }

    public String getSummaryTopic() {
        return summaryTopic;
    }

    public void setSummaryTopic(String summaryTopic) {
        this.summaryTopic = summaryTopic;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTimeFormet() {
        return timeFormet;
    }

    public void setTimeFormet(String timeFormet) {
        this.timeFormet = timeFormet;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getArrivalTimeFormet() {
        return arrivalTimeFormet;
    }

    public void setArrivalTimeFormet(String arrivalTimeFormet) {
        this.arrivalTimeFormet = arrivalTimeFormet;
    }

    public String getDepartureTimeFormet() {
        return departureTimeFormet;
    }

    public void setDepartureTimeFormet(String departureTimeFormet) { this.departureTimeFormet = departureTimeFormet; }

    public String getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(String userRecord) {
        this.userRecord = userRecord;
    }

    public String getUserRecordTime() {
        return userRecordTime;
    }

    public void setUserRecordTime(String userRecordTime) {
        this.userRecordTime = userRecordTime;
    }

    public String getUserRecordDate() {
        return userRecordDate;
    }

    public void setUserRecordDate(String userRecordDate) {
        this.userRecordDate = userRecordDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}


