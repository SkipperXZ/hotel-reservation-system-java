package Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static Hotel.CustomerDatabase.customerDatabase;

public class Customer implements Serializable {
    private int adultNum;
    private int childNum;
    private String title;
    private String firstName;
    private String lastName;
    private String tel;

    private String email;
    private  int  customerID;



    private String address;
    private String  status;
    private String totolRes;
    private String nightStay;
    private String totalRevenue;
    private String lastVisit;

    private int extraBedNum;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int paymerntPrice;
    boolean isPayment = false;
    private int weekDayNum=0,weekEndNum=0;
    private String country;
    private String idNum;
    private LocalDateTime checkInTime;

    public Customer(int adultNum, int childNum, String title, String firstName, String lastName
            , String tel, LocalDate checkInDate, LocalDate checkOutDate, int extraBedNum, String email, int price, int weekDayNum, int weekEndNum) {
        this.adultNum = adultNum;
        this.childNum = childNum;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.tel = tel;
        this.extraBedNum = extraBedNum;
        this.email =email;
        this.paymerntPrice = price;
        this.weekDayNum =weekDayNum;
        this.weekEndNum = weekEndNum;

        this.customerID = customerDatabase.size()+1;  // add new ID
    }

// for test customerpage

    public Customer( String title, String firstName, String lastName, String tel, String email) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email =email;
    }

    public Customer         (String firstName,
                             String lastName ,
                             int customerID,
                             String tel,
                             String email,
                             String idNum,
                             String country,
                             String address,
                             String status,
                             String totolRes,
                             String nightStay,
                             String totalRevenue,
                             String lastVisit){

            this.firstName = firstName;
            this.lastName = lastName;
            this.customerID = customerID;
            this.tel = tel;
            this.email = email;
            this.idNum=idNum;
            this.country= country;
            this.address = address;
            this.status =  status;
            this.totolRes = totolRes;
            this.nightStay = nightStay;
            this.totalRevenue = totalRevenue;
            this.lastVisit = lastVisit;
    }





    public int getNightNum() {
        return checkOutDate.getDayOfYear()-checkInDate.getDayOfYear();
    }

    public String getTel() {
        return tel;
    }

    public String getTitle() {
        return title;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public int getChildNum() {
        return childNum;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getAdultNum() {
        return adultNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public int getExtraBedNum() {
        return extraBedNum;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPaymerntPrice() {
        return paymerntPrice;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getCountry() {
        return country;
    }

    public int getWeekEndNum() {
        return weekEndNum;
    }

    public int getWeekDayNum() {
        return weekDayNum;
    }

    public boolean isPayment() {
        return isPayment;
    }

    public int getCustomerID() { return customerID; }

    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getStatusCustomer() { return status; }

    public void setStatusCustomer(String status) { this.status = status; }

    public String getTotolRes() { return totolRes; }

    public void setTotolRes(String totolRes) { this.totolRes = totolRes; }

    public String getNightStay() { return nightStay; }

    public void setNightStay(String nightStay) { this.nightStay = nightStay; }

    public String getTotalRevenue() { return totalRevenue; }

    public void setTotalRevenue(String totalRevenue) { this.totalRevenue = totalRevenue; }

    public String getLastVisit() { return lastVisit; }

    public void setLastVisit(String lastVisit) { this.lastVisit = lastVisit; }
}
