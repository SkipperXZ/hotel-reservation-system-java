package staff;
import Hotel.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaffList implements Serializable {
    public static ArrayList<Staff> userArrayList = new ArrayList<Staff>();
    public static ArrayList<UserNoButton>userNoButtons =new ArrayList<UserNoButton>();

    public static int userCur;
    public static int employeeId=1;
}
