package reservation;

import Hotel.Customer;
import Hotel.Hotel;
import reservation.room.Room;

public class ReservationHandler {
    public static void booking(Customer customer, int roomIndex, int currentFloorNum, int currentDay) {

        for (int i = 0; i < customer.getNightNum()+1; i++) {
            Room room = Hotel.hotel.get(currentDay-1+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
            room.setCustomer(customer);
            room.setStatus("Reserved");
        }

    }

    public static void cancelBooking(Room room) {
        room.setCustomer(null);
        room.setStatus("Vacant");
    }

    public static void walkInCheckIn(Customer customer, Room room){
        room.setCustomer(customer);
        room.setStatus("In House");
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
    public static void checkOut(Room room){
        room.setCustomer(null);
      //  room.setPreStatus("Vacant");
        room.setStatus("Vacant");
        room.setCountDownClock(new CountDownClock(room));
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
        }
    }

    public static void setOutOfService (Room room){
        room.setStatus("OutOfService");
    }
}