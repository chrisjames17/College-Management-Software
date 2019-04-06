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

public class ResultsController implements Initializable {
    Stage stage;
    String y=null;
    Connection con=dbconn.condb();
    ResultSet rs;
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
     String frst;
    String last;
    String db;
    String usr;
     @FXML
    private JFXButton det;
     @FXML
    private JFXTextField adhr;

    @FXML
    private JFXButton sub;

    @FXML
    private JFXTextField mail;

    @FXML
    private JFXButton log;

    @FXML
    private JFXTextField cst;

    @FXML
    private JFXTextField bg;

    @FXML
    private JFXTextField cat;

    @FXML
    private JFXTextField ph;

    @FXML
    private JFXButton xb;

    @FXML
    private JFXButton prof;

    @FXML
    private JFXButton exa;

    @FXML
    private JFXButton res;

   
    @FXML
    public void start2()
    {
         y=Temp.ret();
        query1 = "select bg,mail,num,adhaar,caste,adcat  from Main where un='"+y+"'";
        try{
                con.setAutoCommit(false);
                pst=con.createStatement();
                rs=pst.executeQuery(query1);
                rs.next();
                frst=rs.getString("bg");
                last=rs.getString("mail");
                db=rs.getString("num");
                ent=rs.getString("adhaar");
                tw=rs.getString("caste");
                usr=rs.getString("adcat");  
           }
           catch(SQLException e)
           {
                System.out.println(e);
           }
        bg.setText(frst);
        mail.setText(last);
        ph.setText(db);
        adhr.setText(ent);
        cst.setText(tw);
        cat.setText(usr); 
    }
    @FXML
    private void clickx(ActionEvent event)
    {
        stage = (Stage) xb.getScene().getWindow();
        stage.close();
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
    void subm(ActionEvent event) throws Exception
    {
        String blah=Temp.ret();
        email=mail.getText();
        phn=ph.getText(); 
        bld=bg.getText();
        adhaar=adhr.getText();
        caste=cst.getText();
        admn=cat.getText();
        System.out.println(blah);
        query = " update main set mail='"+email+"',num='"+phn+"',adhaar='"+adhaar+"',caste='"+caste+"',adcat='"+admn+"',bg='"+bld+"'  where un='"+blah+"'";
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("admin");
                        stage.setScene(new Scene(root1));  
                        stage.show();
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
