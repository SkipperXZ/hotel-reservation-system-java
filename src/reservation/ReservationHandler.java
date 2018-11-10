package reservation;

import Hotel.Customer;
import Hotel.Hotel;
import Hotel.OneDayHotel;
import report.AllBooking;
import report.Booking;
import reservation.room.Room;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationHandler {
    public static void booking(Customer customer, int roomIndex, int currentFloorNum, int currentDay) {

        for (int i = 0; i < customer.getNightNum()+1; i++) {
            Room room = Hotel.hotel.get(currentDay-1+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
            room.setCustomer(customer);
            room.setStatus("Reserved");

            Booking booking = new Booking((AllBooking.allBooking.get(AllBooking.allBooking.size()-1).getRegNum()+1),4, customer.getFirstName(), customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(), customer.getCheckInDate());
            System.out.println("booking done");
            AllBooking.addBooking(booking);
            System.out.println("Add done");
        }

    }

    public static void cancelBooking(Customer customer, int roomIndex, int currentFloorNum, int currentDay) {
        customer = Hotel.hotel.get(currentDay-1).getFloors()[currentFloorNum-1].getRooms()[roomIndex].getCustomer();
        int index = 0;
        for (OneDayHotel e: Hotel.hotel
             ) {
            if(e.getDate().equals(customer.getCheckInDate())){
                System.out.println("kkkk");
                for (int i = 0; i < customer.getNightNum()+1; i++) {
                    Room room = Hotel.hotel.get(index).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
                    room.setCustomer(null);
                    room.setStatus("Vacant");
                }
                break;
            }
            index++;

        }


    }

    public static void cleaning(Room room,int cleanigTimeMin){
        room.setPreStatus(room.getStatus());
        room.setStatus("Cleaning");
        room.setCleaningTimeMinute(cleanigTimeMin);
        room.setCountDownClock(new CountDownClock(room));
    }
    public static void doneCleaning(Room room){
        room.setStatus(room.getPreStatus());
        room.getCountDownClock().skipCleaning();
    }
    public static void checkOut(Room room, Customer customer){
        room.setCustomer(null);
      //  room.setPreStatus("Vacant");
        room.setStatus("Vacant");
        room.setCountDownClock(new CountDownClock(room));

        Booking booking = new Booking((AllBooking.allBooking.get(AllBooking.allBooking.size()-1).getRegNum()+1),2, customer.getFirstName(), customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(), customer.getCheckInDate());
        System.out.println("booking done");
        AllBooking.addBooking(booking);
        System.out.println("Add done");
    }
    public static void outOfService(Room room){
        room.setStatus("Out Of Service");
    }
    public static void cancleOutOfService(Room room){
        room.setStatus("Vacant");
    }
    public static void roomBlock(Room room){
        room.setStatus("Room Block");
    }
    public static void payment(Room room){
        room.getCustomer().setPayment(true);
    }

    public static void checkIn(Customer customer, int roomIndex, int currentFloorNum, int currentDay){
        for (int i = 0; i < customer.getNightNum()+1; i++) {
            Room room = Hotel.hotel.get(currentDay-1+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
            room.setStatus("In House");
            if(Hotel.hotel.get(currentDay-1+i).getDate().equals(customer.getCheckOutDate()))
                break;
           if(i==0){
                Booking booking = new Booking((AllBooking.allBooking.get(AllBooking.allBooking.size()-1).getRegNum()+1),1, customer.getFirstName(), customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(), customer.getCheckInDate());
                System.out.println("Check-in done");
                AllBooking.addBooking(booking);
                System.out.println("Add done");
            }
        }
    }

    public static void setOutOfService (Room room){
        room.setStatus("OutOfService");
    }
}