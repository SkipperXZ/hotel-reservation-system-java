package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Linker {
    public static Stage primaryStage;
    public static Scene resScene ;
    public static Scene customerScene;
    public static Scene user;
    public static Scene login;
    public static Scene report;


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

    public Scene buildScene (String path){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new Scene(root);
    }

}
