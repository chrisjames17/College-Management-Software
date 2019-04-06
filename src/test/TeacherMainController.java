/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class TeacherMainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection con=dbconn.condb();
    Stage stage;
    Statement pst;
    ResultSet rs;
    String fst,lst,id,db,des,dept,query;
    @FXML
    private JFXButton sub;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXButton addusr;

    @FXML
    private JFXButton log;

    @FXML
    private JFXButton exstusr;

    @FXML
    private JFXTextField Dept;

    @FXML
    private JFXTextField fn;

    @FXML
    private JFXButton xb;

    @FXML
    private ImageView dp;

    @FXML
    private JFXButton adt;

    @FXML
    private JFXTextField tid;

    @FXML
    private JFXTextField dob;

    @FXML
    private JFXTextField qual;

    @FXML
    private JFXButton browse;
    @FXML
    void submit(ActionEvent e) throws Exception
    {
        fst=fn.getText();
        lst=ln.getText();
        id=tid.getText();
        db=dob.getText();
        des=qual.getText();
        dept=Dept.getText();
        query = " insert into teachers values('"+fst+"','"+lst+"','"+db+"','"+id+"','"+des+"','"+dept+"','"+db+"')";
        try{
                con.setAutoCommit(false);
                pst=con.createStatement();
                pst.executeUpdate(query);
                con.commit();     
           }
           catch(SQLException ex)
           {
                System.out.println(ex);
           }
         stage = (Stage) sub.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("admin");
                        stage.setScene(new Scene(root1));  
                        stage.show();
    }   
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
        // TODO
    }    
    
}
