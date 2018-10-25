package Hotel;

import reservation.room.*;

import java.io.Serializable;

public class Floor implements Serializable {

        private Room[] rooms ;
        private String floorName;

        public Floor(int floorNum){
            this.floorName = floorName;
            if(floorNum == 1){
                    rooms = new Room[]{new StandardRoom(floorNum,1,"Vacant",null)
                            ,new StandardRoom(floorNum,2,"Vacant",null)
                            ,new StandardRoom(floorNum,3,"Vacant",null)
                            ,new StandardRoom(floorNum,4,"Vacant",null)
                            ,new StandardRoom(floorNum,5,"Vacant",null)
                            ,new StandardRoom(floorNum,6,"Vacant",null)
                            ,new SuperiorRoom(floorNum,7,"Vacant",null)
                            ,new SuperiorRoom(floorNum,8,"Vacant",null)
                            ,new SuperiorRoom(floorNum,9,"Vacant",null)
                            ,new SuperiorRoom(floorNum,10,"Vacant",null)
                            ,new SuperiorRoom(floorNum,11,"Vacant",null)
                            ,new SuperiorRoom(floorNum,12,"Vacant",null)};}
            else if(floorNum == 2){
                rooms = new Room[]{new DeluxeRoom(floorNum,2,"Vacant",null)
                        ,new DeluxeRoom(floorNum,2,"Vacant",null)
                        ,new DeluxeRoom(floorNum,3,"Vacant",null)
                        ,new DeluxeRoom(floorNum,4,"Vacant",null)
                        ,new StandardRoom(floorNum,5,"Vacant",null)
                        ,new StandardRoom(floorNum,6,"Vacant",null)
                        ,new StandardRoom(floorNum,7,"Vacant",null)
                        ,new StandardRoom(floorNum,8,"Vacant",null)
                        ,new SuperiorRoom(floorNum,9,"Vacant",null)
                        ,new SuperiorRoom(floorNum,10,"Vacant",null)
                        ,new SuperiorRoom(floorNum,11,"Vacant",null)
                        ,new SuperiorRoom(floorNum,12,"Vacant",null)};}

            else if(floorNum == 3){
                rooms = new Room[]{new SuiteRoom(floorNum,3,"Vacant",null)
                        ,new SuiteRoom(floorNum,2,"Vacant",null)
                        ,new DeluxeRoom(floorNum,3,"Vacant",null)
                        ,new DeluxeRoom(floorNum,4,"Vacant",null)
                        ,new SuperiorRoom(floorNum,5,"Vacant",null)
                        ,new SuperiorRoom(floorNum,6,"Vacant",null)
                        ,new SuperiorRoom(floorNum,7,"Vacant",null)
                        ,new SuperiorRoom(floorNum,8,"Vacant",null)
                        ,new DeluxeRoom(floorNum,9,"Vacant",null)
                        ,new DeluxeRoom(floorNum,10,"Vacant",null)
                        ,new SuiteRoom(floorNum,11,"Vacant",null)
                        ,new SuiteRoom(floorNum,12,"Vacant",null)};}

            else if(floorNum == 4){
                rooms = new Room[]{new SuiteRoom(floorNum,4,"Vacant",null)
                        ,new SuiteRoom(floorNum,2,"Vacant",null)
                        ,new DeluxeRoom(floorNum,3,"Vacant",null)
                        ,new DeluxeRoom(floorNum,4,"Vacant",null)
                        ,new DeluxeRoom(floorNum,5,"Vacant",null)
                        ,new SuperiorRoom(floorNum,6,"Vacant",null)
                        ,new SuperiorRoom(floorNum,7,"Vacant",null)
                        ,new DeluxeRoom(floorNum,8,"Vacant",null)
                        ,new DeluxeRoom(floorNum,9,"Vacant",null)
                        ,new DeluxeRoom(floorNum,10,"Vacant",null)
                        ,new SuiteRoom(floorNum,11,"Vacant",null)
                        ,new SuiteRoom(floorNum,12,"Vacant",null)};}

            else{
                rooms = new Room[]{new SuiteRoom(floorNum,5,"Vacant",null)
                        ,new SuiteRoom(floorNum,2,"Vacant",null)
                        ,new SuiteRoom(floorNum,3,"Vacant",null)
                        ,new SuiteRoom(floorNum,4,"Vacant",null)
                        ,new DeluxeRoom(floorNum,5,"Vacant",null)
                        ,new DeluxeRoom(floorNum,6,"Vacant",null)
                        ,new DeluxeRoom(floorNum,7,"Vacant",null)
                        ,new DeluxeRoom(floorNum,8,"Vacant",null)
                        ,new SuiteRoom(floorNum,9,"Vacant",null)
                        ,new SuiteRoom(floorNum,10,"Vacant",null)
                        ,new SuiteRoom(floorNum,11,"Vacant",null)
                        ,new SuiteRoom(floorNum,12,"Vacant",null)};}
        }

    public String getFloorName() {
        return floorName;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
