package main;

import Account.Account;
import Hotel.Hotel;
import Hotel.Customer;
import Hotel.CustomerList;
import Hotel.RoomList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import report.Booking;
import report.BookingList;
import reservation.IO;
import staff.Staff;
import staff.StaffList;
import staff.UserNoButton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    //Scene resScene =
    Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Linker.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../reservation/page/res.fxml"));
        Linker.resScene =new Scene(root, 1920, 1080);
        Parent root2 = FXMLLoader.load(getClass().getResource("../customer/CustomerPage.fxml"));
        Linker.customerScene = new Scene(root2,1920, 1080);
        Parent root3 = FXMLLoader.load(getClass().getResource("../staff/userPageNew.fxml"));
        Linker.user = new Scene(root3,1920,1080);
        Parent loginPa = FXMLLoader.load(getClass().getResource("../staff/loginPage.fxml"));
        Linker.login = new Scene(loginPa);

        primaryStage.setScene(Linker.login);
        Parent root4 = FXMLLoader.load(getClass().getResource("../report/ReportPage.fxml"));
        Linker.report = new Scene(root4);
        //primaryStage.setScene(Linker.customerScene);
        Parent root5 = FXMLLoader.load(getClass().getResource("../calendar/calendar2Table.fxml"));
        Linker.calendar = new Scene(root5);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Linker linker = new Linker();
        Linker.primaryStage.setScene(linker.newLoginScene());


        primaryStage.setTitle("Hotel");
        //primaryStage.setScene(Linker.resScene);
        primaryStage.setOnCloseRequest(event -> closeFuncion());
        primaryStage.show();

    }
    public void closeFuncion(){
        stopClock();
        IO.saveHotel(Hotel.hotel);
        IO.saveCustomer(CustomerList.customerDatabase);
        IO.saveUser(StaffList.userNoButtons);

        IO.saveAllBooking(BookingList.bookingDatabase);
        System.out.println("Save done");
        System.exit(0);
    }
    public void stopClock(){
        for (RoomList e:Hotel.hotel
        ) {
            for (int i = 0; i <e.getFloors().length ; i++) {
                for (int j = 0; j <e.getFloors()[i].getRooms().length ; j++) {
                    if(e.getFloors()[i].getRooms()[j].getCountDownClock() != null){
                        e.getFloors()[i].getRooms()[j].setCountDownClock(null);
                        e.getFloors()[i].getRooms()[j].setStatus(e.getFloors()[i].getRooms()[j].getPreStatus());
                    }
                }
            }
        }
    }
    public static void load(){
        ArrayList<RoomList> hotel = IO.loadHotel();
        HashMap<String, Customer> customer = IO.loadCustomer();
        ArrayList<UserNoButton>user = IO.loadUser();

        ArrayList<Booking> allbooking = IO.loadAllBooking();

        if(hotel==null){
            new Hotel();
         }
        else{
            while(!hotel.get(0).getDate().equals(LocalDate.now())){
                hotel.add(new RoomList(hotel.get(hotel.size()-1).getDate().plusDays(1)));
                hotel.remove(hotel.get(0));
            }
            System.out.println(hotel.size());
            Hotel.hotel =hotel;
        }
        if(customer != null){
            CustomerList.customerDatabase = customer;
            int max = 0 ;
            for(Customer cus :customer.values()){
                if (max<cus.getCustomerID())
                max = cus.getCustomerID();
            }
            Customer.setNumcustomerID(max);
        }
        if(user != null && user.size()>0){
            StaffList.userNoButtons=user;
            for(int i=0;i<user.size();i++){
                StaffList.userArrayList.add(new Staff(user.get(i).getEmployeeId(),user.get(i).getUserName(),user.get(i).getFirstName(),user.get(i).getLastName(),
                        user.get(i).getIdCardNumber(),user.get(i).getCountry(),user.get(i).getTel(),user.get(i).getEmail(),user.get(i).getAddress(),
                        user.get(i).getUserType(),user.get(i).getRole(),new Button(),new Button(),user.get(i).getPassId(),user.get(i).getPassWord(),user.get(i).getImage()));
            }
            if(StaffList.userNoButtons.get(StaffList.userNoButtons.size()-1).getEmployeeId()!=null) {
                StaffList.employeeId = Integer.parseInt(StaffList.userNoButtons.get(StaffList.userNoButtons.size() - 1).getEmployeeId()) + 1;
            }
        }
        if(allbooking != null){
            BookingList.bookingDatabase = allbooking;
        }
        else{
            Booking booking = new Booking(Account.currentUser, 0,-1, null, null, null, null, null, -1, LocalDateTime.now(),LocalDate.now(), 0);
           BookingList.addBooking(booking);
        }
    }




    public static void main(String[] args) {
        load();
        launch(args);

    }
}
