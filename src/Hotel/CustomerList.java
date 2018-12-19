package Hotel;

import java.util.HashMap;

public class CustomerList {
     public static HashMap<String,Customer> customerList = new HashMap<String, Customer>();


//

    public static void updateCustomer(Customer customer){

        if (customerList.get(customer.getFirstName()+customer.getLastName()) == null){
            customerList.put(customer.getFirstName()+customer.getLastName(),customer);
        }else {
            if(customer.getIdNum() != null && customer.getCountry()!=null){
                customerList.get(customer.getFirstName()+customer.getLastName()).setCountry(customer.getCountry());
                customerList.get(customer.getFirstName()+customer.getLastName()).setIdNum(customer.getIdNum());
                customerList.get(customer.getFirstName()+customer.getLastName()).setAddress(customer.getAddress());
            }
        }
    }

}


