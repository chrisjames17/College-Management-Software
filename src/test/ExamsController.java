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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class ExamsController implements Initializable {
   String y=null;
    Connection con=dbconn.condb();
    ResultSet rs;
    Stage stage;
    String frst;
    String last;
    String db;
    String usr;
    String query,query1;
    String bld;
    String ent;
    String tw;
    String email;
    String phn; 
    public static String uni;
    String adhaar;
    String caste;
    String admn;
    String temp;
    Statement pst;
      @FXML
    private JFXTextField ln;

    @FXML
    private JFXButton log;

    @FXML
    private JFXTextField reg;

    @FXML
    private JFXTextField dob;

    @FXML
    private JFXTextField fn;

    @FXML
    private JFXButton xb;
    @FXML
    private JFXButton det;

    @FXML
    private JFXButton nxt;

    @FXML
    private JFXTextField per;

    @FXML
    private JFXButton prof;

    @FXML
    private JFXTextField er;

    @FXML
    private JFXButton exa;

    @FXML
    private JFXButton res;
    @FXML
    private void clickx(ActionEvent event)
    {
        stage = (Stage) xb.getScene().getWindow();
        stage.close();
    }  
    @FXML
    public void start1()
    {
        y=Temp.ret();
        query1 = "select un,fn,ln,dob,rank,perc from Main where un='"+y+"'";
        try{
                con.setAutoCommit(false);
                pst=con.createStatement();
                rs=pst.executeQuery(query1);
                rs.next();
                frst=rs.getString("fn");
                last=rs.getString("ln");
                db=rs.getString("dob");
                ent=rs.getString("rank");
                tw=rs.getString("perc");
                usr=rs.getString("un");  
           }
           catch(SQLException e)
           {
                System.out.println(e);
           }
        fn.setText(frst);
        ln.setText(last);
        dob.setText(db);
        er.setText(ent);
        per.setText(tw);
        reg.setText(usr);    
    }
    
    @FXML
    void prof(ActionEvent event) throws Exception{
        stage = (Stage) prof.getScene().getWindow();
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

    
    @FXML
    void Resp(ActionEvent event) throws Exception {
        stage = (Stage) log.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Results.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Results");
        stage.setScene(new Scene(root1));  
        stage.show();
        

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
