package staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import report.Booking;
import report.BookingDatabase;

public class StaffProfileUI implements Initializable {
    StaffSystem staffSystem= new StaffSystem();
    ArrayList<Staff> userArrayList = staffSystem.getStaff();
    int userCur = StaffList.userCur;

    @FXML
    private ImageView ima = new ImageView();

    @FXML
    private Label fullname = new Label();

    @FXML
    private Label employeeId = new Label();

    @FXML
    private Label firstName = new Label();

    @FXML
    private Label lastName = new Label();

    @FXML
    private Label ID = new Label();

    @FXML
    private Label country = new Label();

    @FXML
    private Label tel = new Label();

    @FXML
    private Label email = new Label();

    @FXML
    private Label adderss = new Label();

    @FXML
    private JFXButton cancel = new JFXButton();

    @FXML
    private Label userName = new Label();

    @FXML
    private Label userType = new Label();

    @FXML
    private Label role = new Label();

    @FXML private Text status = new Text();



    static ObservableList<Booking> list;
    ArrayList<Booking> allBooking = BookingDatabase.bookingDatabase;
    ArrayList<Booking> checkinData = new ArrayList<Booking>();

    @FXML private TableView<Booking> table;
    @FXML private TableColumn<Booking, String> reg;
    @FXML private TableColumn<Booking, String> date;
    @FXML private TableColumn<Booking, String> time;
    @FXML private TableColumn<Booking, String> guest;
    @FXML private TableColumn<Booking, String> activity;


    private void handleButtonAction(ActionEvent event) {
        System.out.println("Cancel 5555+");
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fullname.setText(userArrayList.get(userCur).getFirstName()+" "+userArrayList.get(userCur).getLastName());
        employeeId.setText(userArrayList.get(userCur).getEmployeeId());
        firstName.setText(userArrayList.get(userCur).getFirstName());
        lastName.setText(userArrayList.get(userCur).getLastName());
        ID.setText(userArrayList.get(userCur).getPassId());
        country.setText(userArrayList.get(userCur).getCountry());
        tel.setText(userArrayList.get(userCur).getTel());
        email.setText(userArrayList.get(userCur).getEmail());
        adderss.setText(userArrayList.get(userCur).getAddress());
        userName.setText(userArrayList.get(userCur).getUserName());
        userType.setText(userArrayList.get(userCur).getUserType());
        role.setText(userArrayList.get(userCur).getRole());
        status.setText(userArrayList.get(userCur).getUserType());
        cancel.setOnAction(this::handleButtonAction);
        ima.setImage(new Image(userArrayList.get(userCur).getImage()));

        for (Booking e : allBooking) {

            if(e.getUserRecord().equals(userArrayList.get(userCur).getUserName())) {
                checkinData.add(e);
            }
        }
        list = FXCollections.observableArrayList(
                checkinData
        );
        reg.setCellValueFactory(new PropertyValueFactory<Booking,String>("regNum"));
        date.setCellValueFactory(new PropertyValueFactory<Booking,String>("userRecordDate"));
        time.setCellValueFactory(new PropertyValueFactory<Booking,String>("userRecordTime"));
        guest.setCellValueFactory(new PropertyValueFactory<Booking,String>("fullname"));
        activity.setCellValueFactory(new PropertyValueFactory<Booking,String>("activity"));
        table.setItems(list);
    }
}
