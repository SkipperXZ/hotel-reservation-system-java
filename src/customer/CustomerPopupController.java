package customer;


import Hotel.Customer;
import Hotel.CustomerDatabase;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTreeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static Hotel.CustomerDatabase.customerDatabase;

public class CustomerPopupController {

    @FXML
    private Label fullname;

    @FXML
    private Label customerID;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label ID;

    @FXML
    private Label country;

    @FXML
    private Label tel;

    @FXML
    private Label email;

    @FXML
    private Label adderss;

    @FXML
    private Label totalRes;

    @FXML
    private Label night;

    @FXML
    private Label totolRevenue;

    @FXML
    private Label lastVisit;

    @FXML
    private JFXTreeView<?> historyTable;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDelete;
    @FXML
    private StackPane stackpane;

    private String NameHash;
    private Customer customer;
    @FXML
    public void initialize() {
        NameHash = CustomerPageController.selectName;
        customer =  customerDatabase.get(NameHash);
        fullname.setText(customer.getFirstName()+"  "+customer.getLastName());
        customerID.setText(String.valueOf(customer.getCustomerID()));
        firstName.setText(customer.getFirstName());
        lastName.setText(customer.getLastName());
        ID.setText(customer.getIdNum());
        country.setText(customer.getCountry());
        tel.setText(customer.getTel());
        email.setText(customer.getEmail());
        adderss.setText(customer.getAddress());

        totalRes.setText(String.valueOf(customer.getTotalReserve()));
        night.setText(String.valueOf(customer.getTotalNightStay()));
        totolRevenue.setText(String.valueOf(customer.getTotalRevenue()));
        lastVisit.setText(customer.getLastVisitDayToString());

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("EditCustomer.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) btnEdit.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Edit Information");
                stage.show();
            }
        });

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showJDialog();
            }
        });




    }



    private void showJDialog() {

        JFXDialogLayout dialogContent = new JFXDialogLayout();
        Text text =   new Text("Are you sure you want to delete this customer?");
        text.setFont(new Font(20));
        dialogContent.setHeading(text);
        JFXButton yes = new JFXButton("Yes");
        JFXButton close = new JFXButton("No");
        dialogContent.setActions(yes,close);
        JFXDialog dialog = new JFXDialog(stackpane, dialogContent, JFXDialog.DialogTransition.CENTER);
        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent __) {
                dialog.close();
            }
        });
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (customer.getCustomerID()==Customer.getNumcustomerID())
                     Customer.setNumcustomerID(Customer.getNumcustomerID()-1);
                CustomerDatabase.customerDatabase.remove(NameHash);
                CustomerPageController update = new CustomerPageController();
                update.update();
                Stage stage = (Stage) btnDelete.getScene().getWindow();
                stage.close();
            }
        });

        dialog.show();

    }


}
