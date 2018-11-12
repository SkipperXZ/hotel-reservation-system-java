package main;

import Hotel.Hotel;
import Hotel.Customer;
import Hotel.CustomerDatabase;
import Hotel.OneDayHotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import report.AllBooking;
import report.Booking;
import reservation.IO;
import staff.User;
import staff.UserDatabase;
import staff.UserNoButton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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


        Linker linker = new Linker();
        Linker.primaryStage.setScene(linker.newLoginScene());


        primaryStage.setTitle("Hotel");
        //primaryStage.setScene(Linker.resScene);
        primaryStage.setOnCloseRequest(event -> closeFuncion());
        primaryStage.show();
//show
    }
    public void closeFuncion(){
        stopClock();
        IO.saveHotel(Hotel.hotel);
        IO.saveCustomer(CustomerDatabase.customerDatabase);
        IO.saveUser(UserDatabase.userNoButtons);

        IO.saveAllBooking(AllBooking.allBooking);
        System.out.println("Save done");
    }
    public void stopClock(){
        for (OneDayHotel e:Hotel.hotel
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
        ArrayList<OneDayHotel> hotel = IO.loadHotel();
        HashMap<String, Customer> customer = IO.loadCustomer();
        ArrayList<UserNoButton>user = IO.loadUser();

        ArrayList<Booking> allbooking = IO.loadAllBooking();

        if(hotel==null){
            new Hotel();
         }
        else{
            Hotel.hotel =hotel;
        }
        if(customer != null){
            CustomerDatabase.customerDatabase = customer;
            int max = 0 ;
            for(Customer cus :customer.values()){
                if (max<cus.getCustomerID())
                max = cus.getCustomerID();
            }
            Customer.setNumcustomerID(max);
        }
        if(user != null){
            System.out.println("Loadddd");
            UserDatabase.userNoButtons=user;
            for(int i=0;i<user.size();i++){
                UserDatabase.userArrayList.add(new User(user.get(i).getEmployeeId(),user.get(i).getUserName(),user.get(i).getFirstName(),user.get(i).getLastName(),
                        user.get(i).getIdCardNumber(),user.get(i).getCountry(),user.get(i).getTel(),user.get(i).getEmail(),user.get(i).getAddress(),
                        user.get(i).getUserType(),user.get(i).getRole(),new Button(),new Button(),user.get(i).getPassId(),user.get(i).getPassWord()));
            }
            if(UserDatabase.userNoButtons.get(UserDatabase.userNoButtons.size()-1).getEmployeeId()!=null) {
                UserDatabase.employeeId = Integer.parseInt(UserDatabase.userNoButtons.get(UserDatabase.userNoButtons.size() - 1).getEmployeeId()) + 1;
            }
        }
        if(allbooking != null){
            AllBooking.allBooking = allbooking;
            System.out.println("Load Done");
        }
        else{
            Booking booking = new Booking(0,-1, null, null, null, null, null, -1, LocalDateTime.now(),LocalDate.now(), 0);
            AllBooking.addBooking(booking);
            System.out.println("Initial done");
        }
    }




    public static void main(String[] args) {
        load();
        launch(args);
    }
}
