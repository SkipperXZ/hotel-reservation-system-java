package staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

import java.io.Serializable;

public class UserNoButton implements Serializable {
    //SimpleStringProperty
    private String employeeId;
    private String userName;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String country;
    private String tel;
    private String email;
    private String address;
    private String userType;
    private String passId;
    private String role;
    private String passWord;
    private String image;

    public UserNoButton(String employeeId,String userName,String firstName,String lastName,String idCardNumber,String country,String tel,String email,String address,
                String userType,String role,String passId,String passWord,String image){
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
        this.passId=passId;
        this.passWord = passWord;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassId() {
        return passId;
    }

    public String getRole() {
        return role;
    }

    public String getPassWord() {
        return passWord;
    }
}
