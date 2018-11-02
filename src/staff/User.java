package staff;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class User implements Serializable {
    private  String employeeId;
    private String userName;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String country;
    private String tel;
    private String email;
    private String address;
    private String userType;
    private String role;

    public User(String employeeId,String userName,String firstName,String lastName,String idCardNumber,String country,String tel,String email,String address,
                String userType,String role){
        this.employeeId=employeeId;
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.idCardNumber=idCardNumber;
        this.country=country;
        this.tel=tel;
        this.email=email;
        this.address=address;
        this.userType=userType;
        this.role=role;
    }

    public String getEmployeeId(){return employeeId;}
    public void setEmployeeId(String employeeId){this.employeeId=employeeId;}

    public String getUserName(){return userName;}
    public void setUserName(String userName){this.userName=userName;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
