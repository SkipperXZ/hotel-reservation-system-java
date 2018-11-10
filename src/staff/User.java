package staff;

import javafx.beans.property.SimpleStringProperty;

import java.awt.*;
import java.io.Serializable;
import javafx.scene.control.Button;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class User implements Serializable {
    //SimpleStringProperty
    private SimpleStringProperty employeeId;
    private SimpleStringProperty userName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty idCardNumber;
    private SimpleStringProperty country;
    private SimpleStringProperty tel;
    private SimpleStringProperty email;
    private SimpleStringProperty address;
    private SimpleStringProperty userType;
    private SimpleStringProperty passId;
    private SimpleStringProperty role;
    private SimpleStringProperty passWord;
    private Button buttonE;
    private Button buttonD;

    public User(String employeeId,String userName,String firstName,String lastName,String idCardNumber,String country,String tel,String email,String address,
                String userType,String role,Button buttonE,Button buttonD,String passId,String passWord){
        this.employeeId=new SimpleStringProperty(employeeId);
        this.userName=new SimpleStringProperty(userName);
        this.firstName=new SimpleStringProperty(firstName);
        this.lastName=new SimpleStringProperty(lastName);
        this.idCardNumber=new SimpleStringProperty(idCardNumber);
        this.country=new SimpleStringProperty(country);
        this.tel=new SimpleStringProperty(tel);
        this.email=new SimpleStringProperty(email);
        this.address=new SimpleStringProperty(address);
        this.userType=new SimpleStringProperty(userType);
        this.role=new SimpleStringProperty(role);
        this.buttonE=buttonE;
        this.buttonE.setText("Edit");
        this.buttonD=buttonD;
        this.buttonD.setText("Delete");
        this.passId=new SimpleStringProperty(passId);
        this.passWord = new SimpleStringProperty(passWord);
    }

    public SimpleStringProperty passIdProperty() {
        return passId;
    }

    public String getPassWord() {
        return passWord.get();
    }

    public void setPassId(String passId) {
        this.passId.set(passId);
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }

    public SimpleStringProperty passWordProperty() {
        return passWord;
    }

    public String getPassId() {
        return passId.get();
    }

    public void setPass(String pass) {
        this.passId.set(pass);
    }

    public SimpleStringProperty passProperty() {
        return passId;
    }

    public Button getButtonD() {
        return buttonD;
    }

    public void setButtonD(Button buttonD) {
        this.buttonD = buttonD;
        this.buttonD.setText("Delete");
    }

    public Button getButtonE() {
        return buttonE;
    }

    public void setButtonE(Button button) {
        this.buttonE = button;
        this.buttonE.setText("Edit");
    }

    public String getEmployeeId() {
        return employeeId.get();
    }

    public SimpleStringProperty employeeIdProperty() {
        return employeeId;
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getIdCardNumber() {
        return idCardNumber.get();
    }

    public SimpleStringProperty idCardNumberProperty() {
        return idCardNumber;
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public String getTel() {
        return tel.get();
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public String getUserType() {
        return userType.get();
    }

    public SimpleStringProperty userTypeProperty() {
        return userType;
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId.set(employeeId);
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber.set(idCardNumber);
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setUserType(String userType) {
        this.userType.set(userType);
    }

    public void setRole(String role) {
        this.role.set(role);
    }
}
