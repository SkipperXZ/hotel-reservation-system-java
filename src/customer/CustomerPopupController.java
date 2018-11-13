package customer;


import Hotel.Customer;
import Hotel.CustomerDatabase;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import report.AllBooking;
import report.Booking;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Hotel.CustomerDatabase.customerDatabase;
import static java.time.temporal.ChronoUnit.DAYS;

public class CustomerPopupController {

    @FXML private Label fullname;
    @FXML private Label customerID;
    @FXML private Label firstName;
    @FXML private Label lastName;
    @FXML private Label ID;
    @FXML private Label country;
    @FXML private Label tel;
    @FXML private Label email;
    @FXML private Label adderss;
    @FXML private Label totalRes;
    @FXML private Label night;
    @FXML private Label totolRevenue;
    @FXML private Label lastVisit;
    @FXML private JFXTreeTableView<CustomerHistory> historyTable;
    @FXML private JFXButton btnEdit;
    @FXML private JFXButton btnDelete;
    @FXML private StackPane stackpane;
    @FXML
    private ImageView customerPic;


    private String NameHash;
    private Customer customer;


    static ObservableList<CustomerHistory> list = FXCollections.observableArrayList();

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
        File file = new File(customer.getImgfile()) ;
        customerPic.setImage(new Image(file.toURI().toString()));
        if(!file.exists())
            customerPic.setImage(new Image(new File("src\\img\\icon\\photoUser.png").toURI().toString()));



        totalRes.setText(String.valueOf(customer.getTotalReserve()));
        night.setText(String.valueOf(customer.getTotalNightStay()));
        totolRevenue.setText("฿"+String.valueOf(customer.getTotalRevenue()));
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

        setupHead();
        // ObservableList<CustomerTable> list = FXCollections.observableArrayList();
       // String tmpCheck
        ArrayList<Integer> tmpRegCheckIn= new ArrayList<>();
        ArrayList<LocalDate> tmpCheckIn = new ArrayList<>();
        ArrayList<String> tmproomtmp    = new ArrayList<>();

        list.clear();
        for (Booking Booking: AllBooking.allBooking ) {
            if(Booking.getOperation()==1 ||Booking.getOperation()==2) {
                if (Booking.getFullname().equals(customer.getFirstName() + " " + customer.getLastName())) {
                    if(Booking.getOperation()==1){
                        tmpRegCheckIn.add(Booking.getRegNum());
                        tmpCheckIn.add(Booking.getRecordDate());
                        tmproomtmp.add(Booking.getRoomNum());
                    }
                    else
                    {
                        int i;
                        for ( i=0;i<tmproomtmp.size();i++){
                            if (tmproomtmp.get(i).equals(Booking.getRoomNum()))
                            {
                                break;
                            }
                        }

                        list.add(new CustomerHistory(String.valueOf(tmpRegCheckIn.get(i)),tmpCheckIn.get(i).toString(),
                                String.valueOf(Booking.getRegNum()), Booking.getRecordDate().toString(),
                                Booking.getRoomNum(), String.valueOf(DAYS.between(tmpCheckIn.get(i), Booking.getRecordDate())), String.valueOf(Booking.getPrice())));
                        tmpRegCheckIn.remove(i);
                        tmpCheckIn.remove(i);
                        tmproomtmp.remove(i);

                    }


                }
            }
        }
//        ArrayList<Customer> customers = new ArrayList<Customer>()
//        {{
//            for(int i= 0 ; i<30;i++)
//                add(new Customer(names.get((int)(Math.random()*names.size())),names.get((int)(Math.random()*names.size())),i,
//                       "112221",
//                        "email","21111","thailand","smutprakarn 10270","5","5","2,00","12/12/12"));
//
//
//        }};
//        for (Customer e: CustomerDatabase.customerDatabase.values() ) {
//            customers.add(e);
//        }
      //  customers.addAll(CustomerDatabase.customerDatabase.values());
//        for( int i=0;i<10;i++ )
//            list.add(new CustomerHistory("l","","","","","",""));

        //list.sort((a, b) -> a.firstName.get().compareTo(b.firstName.get()));
        final TreeItem<CustomerHistory> root = new RecursiveTreeItem<CustomerHistory>(list,RecursiveTreeObject::getChildren);

        historyTable.setRoot(root);
        historyTable.setShowRoot(false);





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

    class CustomerHistory extends RecursiveTreeObject<CustomerHistory> {
        StringProperty regCheckIn;
        StringProperty checkIn;
        StringProperty regCheckOut;
        StringProperty checkOut;
        StringProperty room;
        StringProperty night;
        StringProperty revenue;

        public CustomerHistory(
                String regCheckIn,
                String checkIn,
                String regCheckOut,
                String checkOut,
                String room,
                String night,
                String revenue){

            this.regCheckIn = new SimpleStringProperty(regCheckIn);
            this.checkIn = new SimpleStringProperty(checkIn);
            this.regCheckOut = new SimpleStringProperty(regCheckOut);
            this.checkOut = new SimpleStringProperty(checkOut);
            this.room = new SimpleStringProperty(room);
            this.night = new SimpleStringProperty(night);
            this.revenue = new SimpleStringProperty(revenue);

        }


    }

    private void setupHead(){

        JFXTreeTableColumn<CustomerHistory,String> regCheckIn = new JFXTreeTableColumn("Reg No.");
        regCheckIn.setPrefWidth(100);
        regCheckIn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().regCheckIn;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> checkIn = new JFXTreeTableColumn("Check In");
        checkIn.setPrefWidth(160);
        checkIn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().checkIn;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> regCheckOut = new JFXTreeTableColumn("Reg No.");
        regCheckOut.setPrefWidth(100);
        regCheckOut.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().regCheckOut;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> checkOut = new JFXTreeTableColumn("Check Out");
        checkOut.setPrefWidth(160);
        checkOut.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().checkOut;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> room = new JFXTreeTableColumn("Room");
        room.setPrefWidth(160);
        room.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().room;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> night = new JFXTreeTableColumn("Night");
        night.setPrefWidth(160);
        night.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().night;
            }
        });
        JFXTreeTableColumn<CustomerHistory,String> revenue = new JFXTreeTableColumn("Revenue");
        revenue.setPrefWidth(160);
        revenue.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerHistory, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerHistory, String> param) {
                return param.getValue().getValue().revenue;
            }
        });

        historyTable.getColumns().setAll(regCheckIn,checkIn,regCheckOut,checkOut,room,night,revenue);
    }


}
