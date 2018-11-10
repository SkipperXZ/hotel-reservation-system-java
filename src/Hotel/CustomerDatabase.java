package Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {
     public static HashMap<String,Customer> customerDatabase = new HashMap<String, Customer>();


//

    public static void updateCustomer(Customer customer){

        if (customerDatabase.get(customer.getFirstName()+customer.getLastName()) == null){
            customerDatabase.put(customer.getFirstName()+customer.getLastName(),customer);
        }else {
            if(customer.getIdNum() != null && customer.getCountry()!=null){
                customerDatabase.get(customer.getFirstName()+customer.getLastName()).setCountry(customer.getCountry());
                customerDatabase.get(customer.getFirstName()+customer.getLastName()).setIdNum(customer.getIdNum());
            }
        }
    }

}


