package reservation;

import Account.Account;
import Hotel.Customer;
import Hotel.Hotel;
import Hotel.CustomerList;
import Hotel.OneDayHotel;
import report.BookingDatabase;
import reservation.room.Room;
import report.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HotelSystem {
    public static void booking(Customer customer, int roomIndex, int currentFloorNum, int currentDay) {
        Customer databaseCustomer =  CustomerList.customerDatabase.get(customer.getFirstName()+customer.getLastName());
        for (int i = 0; i < customer.getNightNum()+1; i++) {
            Room room = Hotel.hotel.get(currentDay-1+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
            room.setCustomer(customer);
            room.setStatus("Reserved");

            if(i==0) {
                Booking booking = new Booking(Account.currentUser, (BookingDatabase.bookingDatabase.get(BookingDatabase.bookingDatabase.size() - 1).getRegNum() + 1), 4, customer.getFirstName(),
                        customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(),
                        LocalDate.now(),LocalDateTime.now().plusDays(currentDay-1+i), LocalDateTime.now().plusDays(currentDay-1+i+customer.getNightNum()), customer.getNightNum());
                BookingDatabase.addBooking(booking);
            }
        }
        databaseCustomer.setTotalNightStay(databaseCustomer.getTotalNightStay()+customer.getNightNum());
        databaseCustomer.setTotalReserve(databaseCustomer.getTotalReserve()+1);
        /*System.out.println(databaseCustomer.getTotalReserve());
        System.out.println(databaseCustomer.getTotalRevenue());
        System.out.println(databaseCustomer.getTotalNightStay());
        System.out.println(databaseCustomer.getLastVisit());
        System.out.println("------------------------------");*/
    }

    public static void cancelBooking(int roomIndex, int currentFloorNum, int currentDay) {
        Customer customer = Hotel.hotel.get(currentDay-1).getFloors()[currentFloorNum-1].getRooms()[roomIndex].getCustomer();
        int index =0;
        for (OneDayHotel e:Hotel.hotel) {

            if(e.getDate().equals(customer.getCheckInDate())){
                for (int i = 0; i < customer.getNightNum()+1; i++) {
                    Room room = Hotel.hotel.get(index + i).getFloors()[currentFloorNum - 1].getRooms()[roomIndex];
                    room.setCustomer(null);
                    room.setStatus("Vacant");

                    if(i==0){
                        Booking booking = new Booking(Account.currentUser, (BookingDatabase.bookingDatabase.get(BookingDatabase.bookingDatabase.size() - 1).getRegNum() + 1),3, customer.getFirstName(),
                                customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(),
                                LocalDate.now(), LocalDateTime.now().plusDays(currentDay-1+i), LocalDateTime.now().plusDays(currentDay-1+i+customer.getNightNum()), customer.getNightNum());
                        BookingDatabase.addBooking(booking);
                    }
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
    public static void checkOut(int roomIndex, int currentFloorNum, int currentDay){
        Customer customer = Hotel.hotel.get(currentDay-1).getFloors()[currentFloorNum-1].getRooms()[roomIndex].getCustomer();
        CustomerList.customerDatabase.get(customer.getFirstName()+customer.getLastName()).setLastVisit(LocalDateTime.now());
        int index =0;
        for (OneDayHotel e:Hotel.hotel) {
            if(e.getDate().equals(LocalDate.now())){
                for (int i = 0; i < customer.getCheckOutDate().getDayOfYear()-LocalDateTime.now().getDayOfYear()+1; i++) {
                    Room room = Hotel.hotel.get(index + i).getFloors()[currentFloorNum - 1].getRooms()[roomIndex];
                    room.setCustomer(null);
                    room.setStatus("Vacant");
                    room.setPreStatus("Vacant");
                }
            }
            index++;
        }
        Room room = Hotel.hotel.get(currentDay-1).getFloors()[currentFloorNum - 1].getRooms()[roomIndex];
        room.setCountDownClock(new CountDownClock(room));

        int servicePrice =(customer.getPaymerntPrice()-(customer.getExtraBedNum()*316* customer.getNightNum()))/10;
        int vatPrice =(((customer.getPaymerntPrice()+servicePrice)*7)/100);

        Booking booking = new Booking(Account.currentUser, (BookingDatabase.bookingDatabase.get(BookingDatabase.bookingDatabase.size() - 1).getRegNum() + 1),2, customer.getFirstName(),
                customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice()+vatPrice+servicePrice, LocalDateTime.now(), LocalDate.now(),0);
        BookingDatabase.addBooking(booking);

        int total = customer.getPaymerntPrice()+vatPrice+servicePrice;
        if(customer.isLate())
            total*=1.1;
        Customer databaseCustomer =  CustomerList.customerDatabase.get(customer.getFirstName()+customer.getLastName());
        databaseCustomer.setTotalRevenue(databaseCustomer.getTotalRevenue()+total);



    }
    public static void outOfService(int roomIndex, int currentFloorNum, int currentDay,LocalDate startDate,LocalDate finishDate){
        int index=0;
        for (OneDayHotel e:Hotel.hotel
        ) {
            if (e.getDate().equals(startDate)){
                String memo = e.getFloors()[currentFloorNum-1].getRooms()[roomIndex].getMemo();
                for (int i = 0; i < finishDate.getDayOfYear()-startDate.getDayOfYear()+1; i++) {
                    Hotel.hotel.get(index+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex].setStatus("Out Of Service");
                    Hotel.hotel.get(index+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex].setMemo(memo);
                }
            }
            index++;
        }
    }
    public static void cancel(Room room){
        room.setStatus("Vacant");
    }
    public static void roomBlock(int roomIndex, int currentFloorNum, int currentDay,LocalDate startDate,LocalDate finishDate){
        int index=0;
        for (OneDayHotel e:Hotel.hotel
             ) {
            if (e.getDate().equals(startDate)){
                String memo = e.getFloors()[currentFloorNum-1].getRooms()[roomIndex].getMemo();
                for (int i = 0; i < finishDate.getDayOfYear()-startDate.getDayOfYear()+1; i++) {
                    Hotel.hotel.get(index+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex].setStatus("Room Block");
                    Hotel.hotel.get(index+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex].setMemo(memo);
                }
            }



            index++;
        }

    }
    public static void payment(Room room){
        Customer customer = room.getCustomer();
        customer.setPayment(true);
    }

    public static void checkIn(Customer customer, int roomIndex, int currentFloorNum, int currentDay){
        for (int i = 0; i < customer.getNightNum()+1; i++) {
            Room room = Hotel.hotel.get(currentDay-1+i).getFloors()[currentFloorNum-1].getRooms()[roomIndex];
            room.setStatus("In House");
            if(Hotel.hotel.get(currentDay-1+i).getDate().equals(customer.getCheckOutDate()))
                break;
            if(i==0){
                Booking booking = new Booking(Account.currentUser, (BookingDatabase.bookingDatabase.get(BookingDatabase.bookingDatabase.size() - 1).getRegNum() + 1),1, customer.getFirstName(),
                        customer.getLastName(), customer.getTel(), room.getRoomID(), room.getRoomType(), customer.getPaymerntPrice(), LocalDateTime.now(), LocalDate.now(), 0);
                BookingDatabase.addBooking(booking);
            }
        }

    }
}