package staff;

import java.util.ArrayList;

public class StaffSystem {
    ArrayList<Staff> userArrayList = StaffList.userArrayList;
    ArrayList<UserNoButton>userNoButtons= StaffList.userNoButtons;
    public void newStaff(Staff a,UserNoButton b){
        userArrayList.add(a);
        userNoButtons.add(b);
    }
    public void deleteStaff(){
        userArrayList.remove(StaffList.userCur);
        userNoButtons.remove(StaffList.userCur);
    }
    public ArrayList<Staff> getStaff(){
        return userArrayList;
    }
}
