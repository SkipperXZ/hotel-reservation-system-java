package staff;
import Hotel.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase implements Serializable {
    public static HashMap<String,User> userDatabase = new HashMap<String, User>();
    public static ArrayList<User> userArrayList = new ArrayList<User>();
    public static ArrayList<UserNoButton>userNoButtons =new ArrayList<UserNoButton>();

    public static int userCur;
    public static int employeeId=1;
    public static void updateUser(User user){

        if (userDatabase.get(user.getFirstName()+user.getLastName()) == null){
            userDatabase.put(user.getFirstName()+user.getLastName(),user);
        }else {
            if(user.getEmployeeId() != null && user.getCountry()!=null){
                userDatabase.put(user.getFirstName()+user.getLastName(),user).setCountry(user.getCountry());
                userDatabase.put(user.getFirstName()+user.getLastName(),user).setEmployeeId(user.getEmployeeId());
            }
        }
        System.out.println(userDatabase);
    }
}
