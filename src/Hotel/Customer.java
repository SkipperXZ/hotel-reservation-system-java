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



    static int numcustomerID;

    private int totalReserve=0;
    private int totalNightStay=0;
    private int totalRevenue=0;
    private LocalDateTime lastVisit;

    private String status;
    private String address;
    private int extraBedNum;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int paymerntPrice;
    boolean isPayment = false;
    private int weekDayNum=0,weekEndNum=0;
    private String country;
    private String idNum;
    private LocalDateTime checkInTime;
    private String memo;

    public Customer(int adultNum, int childNum, String title, String firstName, String lastName
            , String tel, LocalDate checkInDate, LocalDate checkOutDate, int extraBedNum, String email, int price, int weekDayNum, int weekEndNum,String memo) {
        this.memo = memo;
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

        if(customerDatabase.size()==0)
           numcustomerID =0;
        numcustomerID+=1;
        this.customerID = numcustomerID;  // add new ID
        //System.out.println(numcustomerID+1);
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
                             int totalReserve,
                             int nightStay,
                             int totalRevenue,
                             LocalDateTime lastVisit){

            this.firstName = firstName;
            this.lastName = lastName;
            this.customerID = customerID;
            this.tel = tel;
            this.email = email;
            this.idNum=idNum;
            this.country= country;
            this.address = address;
            this.totalReserve = totalReserve;
            this.totalNightStay = nightStay;
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

    public String getStatus() {
        return status;
    }

    public int getTotalReserve() { return totalReserve; }

    public void setTotalReserve(int totalReserve) { this.totalReserve = totalReserve; }

    public int getTotalNightStay() { return totalNightStay; }

    public void setTotalNightStay(int nightStay) { this.totalNightStay = nightStay; }

    public int getTotalRevenue() { return totalRevenue; }

    public void setTotalRevenue(int totalRevenue) { this.totalRevenue = totalRevenue; }

    public LocalDateTime getLastVisit() { return lastVisit; }

    public void setLastVisit(LocalDateTime lastVisit) { this.lastVisit = lastVisit; }

    public static int getNumcustomerID() {    return numcustomerID;   }

    public String getMemo() {
        return memo;
    }

    public static void setNumcustomerID(int numcustomerID) {  Customer.numcustomerID = numcustomerID;   }
}
