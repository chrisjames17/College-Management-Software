/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class TeachController implements Initializable {

    Stage stage;
    Connection con=dbconn.condb();
    @FXML
    private JFXButton hours;

    @FXML
    private JFXButton attend;

    @FXML
    private JFXButton log;

    @FXML
    private JFXButton xb;

    @FXML
    private JFXButton prof;

    @FXML
    private JFXButton studdet;

    @FXML
    void closeButton(ActionEvent event) {
        stage = (Stage) xb.getScene().getWindow();
        stage.close();

    }
    @FXML
    void logout(ActionEvent event) throws Exception {
        
        stage = (Stage) log.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login");
        stage.setScene(new Scene(root1));  
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
}
