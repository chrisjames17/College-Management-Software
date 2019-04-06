/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author chrisjamesjoshy
 */
public class EditStudController implements Initializable {

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
    PreparedStatement preparedStmt;
    JFileChooser f;
    BufferedImage image;
    JDialog dialog = new JDialog(); 
    private File file;
    int k=0;
     @FXML
    private JFXButton addusr;

    @FXML
    private JFXButton exstusr;
    @FXML
    private JFXButton adt;
    @FXML
    private JFXButton log;
    @FXML
    private JFXTextField ln;
    @FXML
    private JFXTextField fn;

    @FXML
    private JFXTextField un;
     @FXML
    private JFXButton nxt;
    @FXML
    private JFXButton xb;
     @FXML
    private JFXButton edits;
    @FXML
    private JFXButton resup;
   
    @FXML
    private JFXTextField mail;

    
    @FXML
    private JFXTextField bg;

    
    @FXML
    private JFXTextField er;

    @FXML
    private JFXTextField dob;

    @FXML
    private JFXTextField ph;

    @FXML
    private JFXTextField per;

     @FXML
    private JFXTextField adhr;

    @FXML
    private JFXButton sub;

    @FXML
    private JFXTextField reg;

    @FXML
    private JFXTextField cst;

    @FXML
    private JFXTextField cat;
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
    void addD(ActionEvent event) throws Exception 
    {
        frst=fn.getText();
        last=ln.getText();
        db=dob.getText();
        ent=er.getText();
        tw=per.getText();
        uni=reg.getText();
        System.out.println(uni);
        Temp.setTemp(uni);

        query = " update main set fn='"+frst+"',ln='"+last+"',dob='"+db+"',rank='"+ent+"',perc='"+tw+"',un='"+uni+"'  where un='"+uni+"'";
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
        stage = (Stage) log.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditStud2.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Admin");
        stage.setScene(new Scene(root1));  
        stage.show();
        
    }
    @FXML
    void subm(ActionEvent event) throws Exception
    {
        y=Temp.ret();
        email=mail.getText();
        phn=ph.getText(); 
        bld=bg.getText();
        adhaar=adhr.getText();
        caste=cst.getText();
        admn=cat.getText();
        System.out.println(y);
        query = " update main set mail='"+email+"',num='"+phn+"',adhaar='"+adhaar+"',caste='"+caste+"',adcat='"+admn+"',bg='"+bld+"'  where un='"+y+"'";
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
    void b(ActionEvent e) throws Exception
    {
         stage = (Stage) sub.getScene().getWindow();
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
    public void edit(ActionEvent e) throws Exception
    {
        stage = (Stage) exstusr.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Edit.fxml")); 
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
    }
   
    
}
