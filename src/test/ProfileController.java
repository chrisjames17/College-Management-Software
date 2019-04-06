/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class ProfileController implements Initializable {
    
    Stage stage;
    String y=null;
    String query1;
    String fun;
    Statement pst;
    ResultSet rs;
    Connection con=dbconn.condb();
    String frst,last,db1,ent,tw,usr,bgp,mail,phn,ad,cas,adc,uni;
    @FXML
    private Label adhr;
    @FXML
    private JFXButton det;
    @FXML
    private JFXButton res;

    @FXML
    private JFXButton log;

    @FXML
    private Label bg;

    @FXML
    private JFXButton xb;

    @FXML
    private JFXButton prof;

    @FXML
    private Label phno;

    @FXML
    private JFXButton exa;

    @FXML
    private Label cast;

    @FXML
    private Label erank;

    @FXML
    private Label cat;

    @FXML
    private Label name;

    @FXML
    private Label tp;

    @FXML
    private Label db;

    @FXML
    private Label email;

    @FXML
    private void clickx(ActionEvent event)
    {
        stage = (Stage) xb.getScene().getWindow();
        stage.close();
    }  
    @FXML
    public void setD()
    {
        y=Temp.ret();
        query1 = "select un,fn,ln,dob,rank,perc,bg,mail,num,adhaar,caste,adcat from Main where un='"+y+"'";
        try{
                con.setAutoCommit(false);
                pst=con.createStatement();
                rs=pst.executeQuery(query1);
                rs.next();
                frst=rs.getString("fn");
                last=rs.getString("ln");
                db1=rs.getString("dob");
                ent=rs.getString("rank");
                tw=rs.getString("perc");
                bgp=rs.getString("bg"); 
                mail=rs.getString("mail"); 
                ad=rs.getString("adhaar");
                cas=rs.getString("caste");
                phn=rs.getString("num");
                adc=rs.getString("adcat");
                uni=rs.getString("un");
                
           }
           catch(SQLException e)
           {
                System.out.println(e);
           }
           fun=frst+" "+last;
           name.setText(fun);
           db.setText(db1);
           erank.setText(ent);
           tp.setText(tw);
           email.setText(mail);
           phno.setText(phn);
           adhr.setText(ad);
           cast.setText(cas);
           cat.setText(adc);
           bg.setText(bgp);
           
    }
    @FXML
    private void logout(ActionEvent event) throws Exception
    {
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
    private void exmp(ActionEvent event) throws Exception
    {
        stage = (Stage) exa.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Exams.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Exams");
        stage.setScene(new Scene(root1));  
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
