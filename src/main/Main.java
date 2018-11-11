package main;

import Hotel.Hotel;
import Hotel.Customer;
import Hotel.CustomerDatabase;
import Hotel.OneDayHotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import report.AllBooking;
import report.Booking;
import reservation.IO;

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
        Parent root4 = FXMLLoader.load(getClass().getResource("../report/ReportPage.fxml"));
        Linker.report = new Scene(root4,1920,1080);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(Linker.report);
        //primaryStage.setScene(Linker.resScene);
        primaryStage.setOnCloseRequest(event -> closeFuncion());
        primaryStage.show();
//show
    }
    public void closeFuncion(){
        stopClock();
        IO.saveHotel(Hotel.hotel);
        IO.saveCustomer(CustomerDatabase.customerDatabase);
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
        ArrayList<Booking> allbooking = IO.loadAllBooking();

        if(hotel==null){
            new Hotel();
         }
        else{
            Hotel.hotel =hotel;
        }
        if(customer != null){
            CustomerDatabase.customerDatabase = customer;
            int max = customer.values().stream().max(Comparator.comparing(Customer::getCustomerID)).get().getCustomerID();
            Customer.setNumcustomerID(max);

        }
        if(allbooking != null){
            AllBooking.allBooking = allbooking;
            System.out.println("Load Done");
        }
        else{
            Booking booking = new Booking(0,-1, null, null, null, null, null, -1, null, null, false);
            AllBooking.addBooking(booking);
            System.out.println("Initial done");
        }

    }

    public static void main(String[] args) {
        load();
        launch(args);
    }
}
