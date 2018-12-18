package staff;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffDeleteUI implements Initializable {
    @FXML
    private JFXButton btnCancel = new JFXButton();

    @FXML
    private JFXButton btnDelete = new JFXButton();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnDelete){
            StaffSystem staffSystem=new StaffSystem();
            staffSystem.deleteStaff();
            StaffPageUI user = new StaffPageUI();
            user.update();
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
        if(event.getSource()==btnCancel){
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCancel.setOnAction(this::handleButtonAction);
        btnDelete.setOnAction(this::handleButtonAction);
    }
}
