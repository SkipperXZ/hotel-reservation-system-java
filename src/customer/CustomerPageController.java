package customer;


import Hotel.Customer;
import Hotel.CustomerDatabase;
import clock.Clock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.Linker;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomerPageController {
    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private JFXButton  dashboardButtton;
    @FXML
    private JFXButton  calendarButtton;
    @FXML
    private JFXButton  reservationButtton;
    @FXML
    private JFXButton  customerButtton;
    @FXML
    private JFXButton  reportButtton;
    @FXML
    private JFXButton  userButtton;

    @FXML
    private JFXTreeTableView<CustomerTable> table;

    @FXML
    private JFXButton btnNewCustomer;



    private double xOffset = 0;
    private double yOffset = 0;
    public static String selectName;

    @FXML
    public void initialize() {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);

       Customer customertest =  new Customer( "Mr", "apirut", "chaokrua","0840995919", "heartmannet");


        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(Linker.resScene);
            }
        });

        setupHead();
        ObservableList<CustomerTable> list = FXCollections.observableArrayList();
        List<String> names = Arrays.asList("sadsadas", "sadsadup2", "asdcefdvadfasf","sdacxczcxc");
        DecimalFormat phoneNum3 = new DecimalFormat("000");
        DecimalFormat phoneNum4 = new DecimalFormat("0000");
        ArrayList<Customer> customers = new ArrayList<Customer>();
//        {{
//            for(int i= 0 ; i<30;i++)
//                add(new Customer(names.get((int)(Math.random()*names.size())),names.get((int)(Math.random()*names.size())),i,
//                        phoneNum3.format(Math.random()*1000)+"-"+phoneNum3.format(Math.random()*1000)+"-"+phoneNum4.format(Math.random()*10000),
//                        "email","21111","thailand","smutprakarn 10270","in house","5","5","2,00","12/12/12"));
//
//
//        }};
//        for (Customer e: CustomerDatabase.customerDatabase.values() ) {
//            customers.add(e);
//        }
        customers.addAll(CustomerDatabase.customerDatabase.values());


        for(Customer customer:customers )
        list.add(new CustomerTable(customer.getFirstName(),customer.getLastName(),customer.getCustomerID(),customer.getTel(),
                customer.getEmail(),customer.getStatusCustomer(),customer.getTotolRes(),customer.getNightStay(),customer.getTotalRevenue(),customer.getLastVisit()));

        list.sort((a, b) -> a.firstName.get().compareTo(b.firstName.get()));
        final TreeItem<CustomerTable> root = new RecursiveTreeItem<CustomerTable>(list,RecursiveTreeObject::getChildren);

        table.setRoot(root);
        table.setShowRoot(false);

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2)
                {
                    TreeItem<CustomerTable> item = table.getSelectionModel().getSelectedItem();
                    selectName = item.getValue().firstName.get()+item.getValue().lastName.get();

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("CustomerPopup.fxml"));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage= new Stage();
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UTILITY);

                    root.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        }
                    });
                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        }
                    });

                    stage.setScene(new Scene(root));
                    stage.setTitle(item.getValue().firstName.get()+" "+item.getValue().lastName.get());
                    stage.show();


                }
            }
        });



        btnNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("NewCustomer.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage= new Stage();
                stage.setResizable(false);
                 stage.initStyle(StageStyle.UTILITY);

                root.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        }
                    });
                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        }
                    });

                stage.setScene(new Scene(root));
                stage.setTitle("New Customer");

                stage.show();


            }


        });




    }
    class CustomerTable extends RecursiveTreeObject<CustomerTable>{
        StringProperty firstName;
        StringProperty lastName;
        IntegerProperty customerID;
        StringProperty tel;
        StringProperty email;
        StringProperty status;
        StringProperty totolRes;
        StringProperty nightStay;
        StringProperty totalRevenue;
        StringProperty lastVisit;

        public CustomerTable(String firstName,
                             String lastName ,
                             int customerID,
                             String tel,
                             String email,
                             String status,
                             String totolRes,
                             String nightStay,
                             String totalRevenue,
                             String lastVisit){

            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.customerID = new SimpleIntegerProperty(customerID);
            this.tel = new SimpleStringProperty(tel);
            this.email = new SimpleStringProperty(email);
            this.status = new SimpleStringProperty(status);
            this.totolRes = new SimpleStringProperty(totolRes);
            this.nightStay = new SimpleStringProperty(nightStay);
            this.totalRevenue = new SimpleStringProperty(totalRevenue);
            this.lastVisit = new SimpleStringProperty(lastVisit);
        }


    }

    private void setupHead(){

       JFXTreeTableColumn<CustomerTable,String> firstname = new JFXTreeTableColumn("Firstname");
        firstname.setPrefWidth(162);
        firstname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().firstName;
            }
        });

        JFXTreeTableColumn<CustomerTable,String> lastname = new JFXTreeTableColumn("Lastname");
        lastname.setPrefWidth(162);
        lastname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().lastName;
            }
        });

        JFXTreeTableColumn<CustomerTable,Number> customerID = new JFXTreeTableColumn("customer ID");
        customerID.setPrefWidth(162);
        customerID.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<CustomerTable, Number> param) {
                return  param.getValue().getValue().customerID;
            }
        });

        JFXTreeTableColumn<CustomerTable,String> tel = new JFXTreeTableColumn("Tel.");
        tel.setPrefWidth(162);
        tel.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().tel;
            }
        });

        JFXTreeTableColumn<CustomerTable,String> email  = new JFXTreeTableColumn("Email");
        email.setPrefWidth(162);
        email .setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().email ;
            }
        });
        JFXTreeTableColumn<CustomerTable,String> status  = new JFXTreeTableColumn("Status");
        status.setPrefWidth(162);
        status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().status ;
            }
        });
        JFXTreeTableColumn<CustomerTable,String> totolRes = new JFXTreeTableColumn("Total Reservation");
        totolRes.setPrefWidth(162);
        totolRes.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().totolRes ;
            }
        });
        JFXTreeTableColumn<CustomerTable,String> nightStay  = new JFXTreeTableColumn("Night stayed");
        nightStay.setPrefWidth(162);
        nightStay.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().nightStay ;
            }
        });
        JFXTreeTableColumn<CustomerTable,String> totalRevenue  = new JFXTreeTableColumn("Total Revenue");
        totalRevenue.setPrefWidth(162);
        totalRevenue.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().totalRevenue;
            }
        });
        JFXTreeTableColumn<CustomerTable,String> lastVisit = new JFXTreeTableColumn("Last Visited");
        lastVisit.setPrefWidth(162);
        lastVisit.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().lastVisit;
            }
        });

        table.getColumns().setAll(firstname,lastname,customerID,tel ,email ,status ,totolRes ,nightStay ,totalRevenue ,lastVisit);
    }



}
