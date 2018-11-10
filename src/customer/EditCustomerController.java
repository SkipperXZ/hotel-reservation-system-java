package customer;

import Hotel.Customer;
import Hotel.CustomerDatabase;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static Hotel.CustomerDatabase.customerDatabase;

public class EditCustomerController {

    @FXML
    private Label customerID;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField ID;

    @FXML
    private TextField country;

    @FXML
    private TextField tel;

    @FXML
    private TextField email;

    @FXML
    private TextArea address;

    @FXML
    public void initialize() {
        String NameHash = CustomerPageController.selectName;
        Customer customer = customerDatabase.get(NameHash);

        customerID.setText(String.valueOf(customer.getCustomerID()));
        firstName.setText(customer.getFirstName());
        lastName.setText(customer.getLastName());
        ID.setText(customer.getIdNum());
        country.setText(customer.getCountry());
        tel.setText(customer.getTel());
        email.setText(customer.getEmail());
        address.setText(customer.getAddress());

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("CustomerPopup.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle(customer.getFirstName()+" "+customer.getLastName());
                stage.show();
            }
        });

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String firstNameInput, lastNameInput, IDInput, countryInput, telInput, emailInput,addressInput  ;
                firstNameInput = firstName.getText();
                lastNameInput =  lastName.getText();
                IDInput = ID.getText();
                countryInput = country.getText();
                telInput = tel.getText();
                emailInput = email.getText();
                addressInput = address.getText();

   if(!firstNameInput.trim().equals("") && !lastNameInput.trim().equals("") && !telInput.trim().equals("") ) {
       customer.setFirstName(firstNameInput);
       customer.setLastName(lastNameInput);
       customer.setIdNum(IDInput);
       customer.setCountry(countryInput);
       customer.setTel(telInput);
       customer.setEmail(emailInput);
       customer.setAddress(addressInput);
       //CustomerDatabase.customerDatabase.re

       Parent root = null;
       try {
           root = FXMLLoader.load(getClass().getResource("CustomerPopup.fxml"));

       } catch (IOException e) {
           e.printStackTrace();
       }
       Stage stage = (Stage) btnCancel.getScene().getWindow();
       stage.setScene(new Scene(root));
       stage.setTitle(customer.getFirstName() + " " + customer.getLastName());
       stage.show();
   }




            }
        });

    }



}
