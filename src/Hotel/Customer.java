package Hotel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String imgFile;




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
    private boolean isLate =false;

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

        this.imgFile = "src\\img\\icon\\photoUser.png";
    }

// for test customerpage

    public Customer( String title, String firstName, String lastName, String tel, String email) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email =email;
        this.imgFile = "src\\img\\icon\\photoUser.png";
    }

    public Customer         (String firstName,
                             String lastName ,
                             String tel,
                             String email,
                             String idNum,
                             String country,
                             String address){

            this.firstName = firstName;
            this.lastName = lastName;
            this.tel = tel;
            this.email = email;
            this.idNum=idNum;
            this.country= country;
            this.address = address;
        if(customerDatabase.size()==0)
            numcustomerID =0;
        numcustomerID+=1;
        this.customerID = numcustomerID;  // add new ID
        this.imgFile = "src\\img\\icon\\photoUser.png";
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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public void setPaymerntPrice(int paymerntPrice) {
        this.paymerntPrice = paymerntPrice;
    }

    public String getLastVisitToString()
    {

        if (lastVisit!=null)
           return lastVisit.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
        else
           return "-";
    }
    public String getLastVisitDayToString()
    {

        if (lastVisit!=null)
            return lastVisit.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        else
            return "-";
    }

    public void setLastVisit(LocalDateTime lastVisit) { this.lastVisit = lastVisit; }

    public static int getNumcustomerID() {    return numcustomerID;   }

    public String getMemo() {
        return memo;
    }

    public static void setNumcustomerID(int numcustomerID) {  Customer.numcustomerID = numcustomerID;   }
    public String getImgfile() { return imgFile;  }
    public void setImgfile(String imgfile) { this.imgFile = imgfile; }
}
