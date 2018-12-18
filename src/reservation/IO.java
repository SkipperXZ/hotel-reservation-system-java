package reservation;
import Hotel.RoomList;
import Hotel.Customer;
import staff.UserNoButton;
import report.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class IO{
    public static void saveUser(ArrayList<UserNoButton>user) {
        File file = new File("User.dat");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(user);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static ArrayList<UserNoButton> loadUser(){
        ArrayList<UserNoButton> user;
        try
        {
            FileInputStream fis = new FileInputStream("User.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
          //  System.out.println("File Not Found . Create a New Flie");
            ioe.printStackTrace();
            return null;
        }catch(ClassNotFoundException c){
         //   System.out.println("Class not found");

            c.printStackTrace();
            return null;
        }
        return user;
    }

    public static void saveHotel(ArrayList<RoomList> hotel) {

        File file = new File("hotel.dat");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(hotel);
            writer.close();
        }catch (Exception e){}

    }
    public static ArrayList<RoomList> loadHotel(){
        ArrayList<RoomList> hotel;
        try
        {
            FileInputStream fis = new FileInputStream("hotel.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            hotel = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            System.out.println("File Not Found . Create a New Flie");
            return null;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return hotel;
    }

    public static void saveAllBooking(ArrayList<Booking> allbooking) {

        File file = new File("AllBooking.dat");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(allbooking);
            writer.close();
        }catch (Exception e){}

    }
    public static ArrayList<Booking> loadAllBooking(){
        ArrayList<Booking> allbooking;
        try
        {
            FileInputStream fis = new FileInputStream("AllBooking.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            allbooking = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            System.out.println("File Not Found . Create a New Flie");
            return null;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return allbooking;
    }

    public static void saveCustomer(HashMap<String, Customer> customer) {

        File file = new File("customer.dat");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(customer);
            writer.close();
        }catch (Exception e){}

    }
    public static HashMap<String,Customer > loadCustomer(){
        HashMap<String,Customer > Customer;
        try
        {
            FileInputStream fis = new FileInputStream("customer.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Customer = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            System.out.println("File Not Found . Create a New Flie");
            return null;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return Customer;
    }
}
