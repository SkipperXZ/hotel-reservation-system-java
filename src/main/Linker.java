package main;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Linker {
    public static Stage primaryStage;
    public static Scene DashboardScene ;
    public static Scene resScene ;
    public static Scene customerScene;
    public static Scene user;
    public static Scene login;
    public static Scene report;
    private double xOffset = 0;
    private double yOffset = 0;

    public Scene newDashboardScene (){
        return this.buildScene("../dashboard/Dashboard.fxml") ;
    }
    public Scene newResScene (){
        return this.buildScene("../reservation/page/res.fxml") ;
    }
    public Scene newCustomerScene (){
        return this.buildScene("../customer/CustomerPage.fxml") ;
    }
    public Scene newUserScene (){
        return this.buildScene("../staff/userPageNew.fxml") ;
    }

    public Scene newLoginScene (){
        return this.buildScene("../staff/loginPage.fxml") ;
    }

    public Scene newReportScene (){
        return this.buildScene("../report/ReportPage.fxml") ;
    }
    public Scene newCalendarScene (){return this.buildScene("../calendar/calendar2Table.fxml");}

    public Scene buildScene (String path){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                Linker.primaryStage.setX(event.getScreenX() - xOffset);
                Linker.primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        return  new Scene(root);
    }

}
