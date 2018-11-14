package customer;

import Hotel.Customer;
import Hotel.CustomerDatabase;
import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public class NewCustomerController{

        @FXML
        private StackPane stack;

        @FXML
        private Label customerID;

        @FXML
        private JFXButton btnCancel;

        @FXML
        private JFXButton btnCreate;

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

        private  File file;
        File des;
        private  Boolean isAddImg = false;
        private  Image image;

        @FXML
    public void initialize() {
                String newNumber = String.valueOf(Customer.getNumcustomerID()+1);
                customerID.setText(newNumber);
                ID.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue,
                                        String newValue) {
                            if (!newValue.matches("\\d*")) {
                                    ID.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                    }
                });
                tel.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue,
                                        String newValue) {
                            if (!newValue.matches("\\d*")) {
                                    tel.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                    }
                });

                btnCreate.setOnAction(new EventHandler<ActionEvent>() {
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

                           if(!firstNameInput.trim().equals("") && !lastNameInput.trim().equals("") && !telInput.trim().equals("")  ) {

                                   if(CustomerDatabase.customerDatabase.get(firstNameInput+lastNameInput)!=null)
                                   {
                                           showJDialog(firstNameInput+" "+lastNameInput+" already exists");
                                           return;
                                   }
                                   if(isAddImg)
                                   {
                                           try{
                                                   des = new File("src\\img\\customer\\user"+newNumber+".jpg");  //output file path
                                                   Files.copy(file.toPath(),des.toPath());
                                                 //  System.out.println("Writing complete.");
                                           }catch(IOException e){
                                                   System.out.println("Error: "+e);
                                           }
                                   }
                                   Customer  customer  = new Customer(firstNameInput, lastNameInput,telInput,
                                           emailInput, IDInput, countryInput,addressInput);
                                   if(isAddImg) {
                                           customer.setImgfile(des.getPath());
                                         //  System.out.println(des.getPath());
                                   }



                                   CustomerDatabase.updateCustomer(customer);

                                   CustomerPageController update = new CustomerPageController();
                                   update.update();
                                   Stage stage = (Stage) btnCreate.getScene().getWindow();
                                   stage.close();

                           }
                           else
                                   showJDialog("Please enter First name ,Last name and telephone");
                    }
                });


                btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            Stage stage = (Stage) btnCancel.getScene().getWindow();
                            stage.close();
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
                            file = fileChooser.showOpenDialog(stage);
                            if (file!=null) {
                                    // System.out.println(file.toURI().toString());
                                    String a = file.toURI().toString();
                                    image = new Image(a);
                                    customerPic.setImage(image);
                                    isAddImg = true;
                            }
                    }
                });

    }

    private void showJDialog(String str) {

                JFXDialogLayout dialogContent = new JFXDialogLayout();
                Text text =   new Text(str);
                text.setFont(new Font(20));
                dialogContent.setHeading(text);
                JFXButton close = new JFXButton("close");
                dialogContent.setActions(close);
                JFXDialog dialog = new JFXDialog(stack, dialogContent, JFXDialog.DialogTransition.CENTER);
                close.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent __) {
                                dialog.close();
                        }
                });
                dialog.show();

        }

}
