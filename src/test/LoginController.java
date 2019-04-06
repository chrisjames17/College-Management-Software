/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author chrisjamesjoshy
 */
public class LoginController implements Initializable {
    Connection con=dbconn.condb();
    ResultSet rs=null;
    Statement pst=null;
    String des;
    String user;
    String pass;
    Stage stage;
    String ps,query;
    
    @FXML
    private Text ltext;

    @FXML
    private AnchorPane imgbg;

    @FXML
    private AnchorPane bg;

    @FXML
    private JFXPasswordField passtext;

    @FXML
    private AnchorPane textbg;
    
    @FXML
    private Label failtext;
    
    @FXML
    private ImageView owlpng;

    @FXML
    private JFXButton closeb;

    @FXML
    private JFXTextField untext;

    @FXML
    private JFXButton lbutton;

    
    @FXML
    void closeButton(ActionEvent event) {
        stage = (Stage) closeb.getScene().getWindow();
        stage.close();

    }

    

    @FXML
    void handleButtonAction(ActionEvent event) throws Exception {
           user= untext.getText();
           pass=passtext.getText();
           Temp.setTemp(user);
           query ="select pass,desig from main where un='"+user+"';";
           try{
                con.setAutoCommit(false);
                pst=con.createStatement();
                rs=pst.executeQuery(query);
                rs.next();
                ps=rs.getString("pass");
                des=rs.getString("desig");
           }
           catch(SQLException e)
           {
                System.out.println(e);
           }
           if(pass.equals(ps))
           {
                if(des.equals("student"))
                {
                        stage = (Stage) lbutton.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile.fxml")); 
                        Parent root1 = (Parent) fxmlLoader.load();
                        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("Profile");
                        stage.setScene(new Scene(root1));  
                        stage.show();
                }
                else if(des.equals("admin"))
                {
                        stage = (Stage) lbutton.getScene().getWindow();
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
                else if(des.equals("teacher"))
                {
                        stage = (Stage) lbutton.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teach.fxml")); 
                        Parent root1 = (Parent) fxmlLoader.load();
                        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("Profile");
                        stage.setScene(new Scene(root1));  
                        stage.show();
                }
           }
           else
           {
                    failtext.setText("Invalid Credentials!");
           }
           
           
      
    }

    
    @Override
      public void initialize(URL location, ResourceBundle resources) {
        con = dbconn.condb();
       
        
        

    }

    
}
