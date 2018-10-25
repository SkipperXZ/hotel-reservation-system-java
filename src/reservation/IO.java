package reservation;
import Hotel.Hotel;
import Hotel.OneDayHotel;
import Hotel.CustomerDatabase;
import Hotel.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class IO{
    public static void saveHotel(ArrayList<OneDayHotel> hotel) {

        File file = new File("hotel.dat");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(hotel);
            writer.close();
        }catch (Exception e){}

    }
    public static ArrayList<OneDayHotel> loadHotel(){
        ArrayList<OneDayHotel> hotel;
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
