/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class EditController implements Initializable {

    Stage stage;
    @FXML
    private JFXButton adt;

    @FXML
    private JFXButton editusr;

    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton searchb;

    @FXML
    private Label failtext;

    @FXML
    private JFXButton addusr;
    @FXML
    private JFXTextField tdes;
    @FXML
    private JFXButton log;

    @FXML
    private JFXRadioButton rteach;

    @FXML
    private JFXButton xb;

    @FXML
    private JFXRadioButton rstud;
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
    @FXML
    public void t(ActionEvent e)throws Exception
    {
        stage = (Stage) adt.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeacherMain.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("admin");
        stage.setScene(new Scene(root1));  
        stage.show();
    }
    @FXML
    void b(ActionEvent e) throws Exception
    {
        stage = (Stage) addusr.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("admin");
        stage.setScene(new Scene(root1));  
        stage.show();
    }
    @FXML
    void next(ActionEvent e) throws Exception
    {  
        Temp.setTemp(search.getText());
        if(tdes.getText().equals("student"))
        {
        stage = (Stage) searchb.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditStud.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("admin");
        stage.setScene(new Scene(root1));  
        stage.show();
        }
        else if(tdes.getText().equals("teacher")) 
        {
            stage = (Stage) searchb.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditTeach.fxml")); 
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("admin");
            stage.setScene(new Scene(root1));  
            stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
