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
import reservation.IO;
import staff.User;
import staff.UserDatabase;
import staff.UserNoButton;

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
        Parent root2 = FXMLLoader.load(getClass().getResource("../reservation/page/CustomerPage.fxml"));
        Linker.customerScene = new Scene(root2,1920, 1080);
        Parent root3 = FXMLLoader.load(getClass().getResource("../staff/userPageNew.fxml"));
        Linker.user = new Scene(root3,1920,1080);
        Parent loginPa = FXMLLoader.load(getClass().getResource("../staff/loginPage.fxml"));
        Linker.login = new Scene(loginPa,1920,1080);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(Linker.login);
        primaryStage.setOnCloseRequest(event -> closeFuncion());
        primaryStage.show();
//show
    }
    public void closeFuncion(){
        stopClock();
        IO.saveHotel(Hotel.hotel);
        IO.saveCustomer(CustomerDatabase.customerDatabase);
        IO.saveUser(UserDatabase.userNoButtons);

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

        if(hotel==null){
            new Hotel();
         }
        else{
            Hotel.hotel =hotel;
        }
        if(customer != null){
            CustomerDatabase.customerDatabase = customer;
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


    }

    public static void main(String[] args) {
        load();
        launch(args);
    }
}
