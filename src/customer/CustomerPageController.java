package customer;


import Account.Account;
import Hotel.Customer;
import Hotel.CustomerDatabase;
import Hotel.Hotel;
import clock.Clock;
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
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.Linker;
import main.Main;
import report.BookingDatabase;
import reservation.IO;
import staff.StaffList;

import java.io.IOException;
import java.util.ArrayList;


public class CustomerPageController {
    @FXML
    private Label time;
    @FXML
    private Label date;

    @FXML
    private ImageView userPic;

    @FXML
    private Label userLabel;
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
    @FXML private JFXTextField searchBar;
    @FXML private ImageView logOut = new ImageView();
    @FXML private ImageView exit = new ImageView();
    @FXML private Label nameHotel;



    private double xOffset = 0;
    private double yOffset = 0;
    public static String selectName;
    static  ObservableList<CustomerTable> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Clock.clock.setClockLabel(time);
        Clock.clock.setDateLabel(date);
        nameHotel.setText("HOTELLO");


        userLabel.setText(Account.currentUser);
        Linker linker = new Linker();



       //Customer customertest =  new Customer( "Mr", "apirut", "chaokrua","0840995919", "heartmannet");


        calendarButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Linker.primaryStage.setScene(linker.newCalendarScene());
            }
        });


        dashboardButtton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Linker.primaryStage.setScene(linker.newDashboardScene());
           }
       });

        reservationButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newResScene());
            }
        });
        reportButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newReportScene());
            }
        });
        userButtton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Linker.primaryStage.setScene(linker.newUserScene());
            }
        });
        CustomerSystem customerSystem=new CustomerSystem();
        setupHead();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.addAll(customerSystem.getCustomerList());
        list.clear();
        for(Customer customer:customers )
        list.add(new CustomerTable(customer.getFirstName(),customer.getLastName(),customer.getCustomerID(),customer.getTel(),
                customer.getEmail(),String.valueOf(customer.getTotalReserve()),
                String.valueOf(customer.getTotalNightStay()),
                String.valueOf(customer.getTotalRevenue()),
               customer.getLastVisitToString()));

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

        searchBar.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!searchBar.getText().equals(""))
                {
                    list.clear();
                    String fullName;
                    customers.clear();
                    customers.addAll(customerSystem.getCustomerList());
                    for(Customer customer: customers) {
                        fullName = customer.getFirstName()+" "+customer.getLastName();
                        if (fullName.contains(searchBar.getText()))
                            list.add(new CustomerTable(customer.getFirstName(), customer.getLastName(), customer.getCustomerID(), customer.getTel(),
                                    customer.getEmail(), String.valueOf(customer.getTotalReserve()),
                                    String.valueOf(customer.getTotalNightStay()),
                                    String.valueOf(customer.getTotalRevenue()),
                                    customer.getLastVisitToString()));
                    }
                    list.sort((a, b) -> a.firstName.get().compareTo(b.firstName.get()));

                }
                else
                    update();
            }
        });





        final Tooltip tooltip = new Tooltip("Logout");
        tooltip.setStyle("-fx-background-color: #1473e6; -fx-text-fill: white; -fx-font-size: 15; -fx-font-weight: bold; ");
        logOut.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Point2D p = logOut.localToScreen(logOut.getLayoutBounds().getMaxX()-50, logOut.getLayoutBounds().getMaxY()+5);
                tooltip.show(logOut, p.getX(), p.getY());
            }
        });
        logOut.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tooltip.hide();
            }
        });
        // Tooltip.install(logOut, new Tooltip("Logout"));
        logOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IO.saveHotel(Hotel.hotel);
                IO.saveCustomer(CustomerDatabase.customerDatabase);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingDatabase.bookingDatabase);
                System.out.println("Save done");
                Linker.primaryStage.close();
                Stage stage= new Stage();
                Main main = new Main();
                try {
                    main.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IO.saveHotel(Hotel.hotel);
                IO.saveCustomer(CustomerDatabase.customerDatabase);
                IO.saveUser(StaffList.userNoButtons);
                IO.saveAllBooking(BookingDatabase.bookingDatabase);
                System.out.println("Save done");
                System.exit(0);
            }
        });
        final Tooltip tooltipExit = new Tooltip("Exit");
        tooltipExit.setStyle("-fx-background-color: #1473e6; -fx-text-fill: white; -fx-font-size: 15; -fx-font-weight: bold; ");
        exit.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Point2D p = exit.localToScreen(exit.getLayoutBounds().getMaxX()-45, exit.getLayoutBounds().getMaxY()+5);
                tooltipExit.show(exit, p.getX(), p.getY());
            }
        });
        exit.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tooltipExit.hide();
            }
        });


    }

    public void update() {

        list.clear();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.addAll(CustomerDatabase.customerDatabase.values());

        for(Customer customer:customers )
            list.add(new CustomerTable(customer.getFirstName(),customer.getLastName(),customer.getCustomerID(),customer.getTel(),
                    customer.getEmail(),String.valueOf(customer.getTotalReserve()),
                    String.valueOf(customer.getTotalNightStay()),
                    String.valueOf(customer.getTotalRevenue()),
                    customer.getLastVisitToString()));
        list.sort((a, b) -> a.firstName.get().compareTo(b.firstName.get()));
    }

    class CustomerTable extends RecursiveTreeObject<CustomerTable>{
        StringProperty firstName;
        StringProperty lastName;
        IntegerProperty customerID;
        StringProperty tel;
        StringProperty email;
        StringProperty totolRes;
        StringProperty nightStay;
        StringProperty totalRevenue;
        StringProperty lastVisit;

        public CustomerTable(String firstName,
                             String lastName ,
                             int customerID,
                             String tel,
                             String email,
                             String totolRes,
                             String nightStay,
                             String totalRevenue,
                             String lastVisit){

            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.customerID = new SimpleIntegerProperty(customerID);
            this.tel = new SimpleStringProperty(tel);
            this.email = new SimpleStringProperty(email);
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
        lastVisit.setPrefWidth(162*2);
        lastVisit.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerTable, String> param) {
                return param.getValue().getValue().lastVisit;
            }
        });

        table.getColumns().setAll(firstname,lastname,customerID,tel ,email ,totolRes ,nightStay ,totalRevenue ,lastVisit);
    }



}
