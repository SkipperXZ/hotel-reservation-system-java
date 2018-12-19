package customer;

import Hotel.Customer;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static Hotel.CustomerList.customerList;

public class EditCustomerUI {

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
    private ImageView customerPic;
    @FXML
    private JFXButton addImg;

    private  File fileInput;
    File des;
    private  Boolean isAddImg = false;
    private  Image image;

    @FXML
    public void initialize() {
        String NameHash = CustomerPageUI.selectName;
        Customer customer = customerList.get(NameHash);


        customerID.setText(String.valueOf(customer.getCustomerID()));
        firstName.setText(customer.getFirstName());
        lastName.setText(customer.getLastName());
        ID.setText(customer.getIdNum());
        country.setText(customer.getCountry());
        tel.setText(customer.getTel());
        email.setText(customer.getEmail());
        address.setText(customer.getAddress());
        File file = new File(customer.getImgfile()) ;
        customerPic.setImage(new Image(file.toURI().toString()));
        if(!file.exists())
            customerPic.setImage(new Image(new File("src\\img\\icon\\photoUser.png").toURI().toString()));

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

                   if(isAddImg)
                   {
                       try{
                           des = new File("src\\img\\customer\\user"+customer.getCustomerID()+".jpg");  //output file path
                           Files.copy(fileInput.toPath(),des.toPath(), StandardCopyOption.REPLACE_EXISTING);
                           //  System.out.println("Writing complete.");
                       }catch(IOException e){
                           System.out.println("Error: "+e);
                       }
                   }
                   if(isAddImg){
                       customer.setImgfile(des.getPath());
                      // System.out.println(des.getPath());
                   }

                   CustomerSystem customerSystem = new CustomerSystem();
                   customerSystem.deleteCustomer(NameHash);
                   customerSystem.addCustomer(customer);
                   CustomerPageUI.selectName =firstNameInput+lastNameInput;
                   CustomerPageUI update = new CustomerPageUI();
                   update.update();

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


        addImg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) addImg.getScene().getWindow();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select Image");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                fileInput = fileChooser.showOpenDialog(stage);
                if (fileInput != null) {
//                System.out.println(fileInput.toURI().toString());
                    String a = fileInput.toURI().toString();
                    image = new Image(a);
                    customerPic.setImage(image);
                    isAddImg = true;
                }
            }
        });

    }



}
