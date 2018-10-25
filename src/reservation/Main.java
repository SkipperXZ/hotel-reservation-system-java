package reservation;

import Hotel.Hotel;
import Hotel.Customer;
import Hotel.CustomerDatabase;
import Hotel.OneDayHotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("page/res.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.setOnCloseRequest(event -> closeFuncion());
///test git hub
        primaryStage.show();
//show
    }
    public void closeFuncion(){
        stopClock();
        IO.saveHotel(Hotel.hotel);
        IO.saveCustomer(CustomerDatabase.customerDatabase);
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

        if(hotel==null){
            new Hotel();
         }
        else{
            Hotel.hotel =hotel;
        }
        if(customer != null){
            CustomerDatabase.customerDatabase = customer;
        }


    }

    public static void main(String[] args) {
        load();

        launch(args);
    }
}
