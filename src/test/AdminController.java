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
import javafx.scene.image.ImageView;
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
 
public class AdminController implements Initializable {
    Connection con=dbconn.condb();
    ResultSet rs;
    Stage stage;
    String frst;
    String last;
    String db;
    String query;
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
    private JFXButton resup;
   
    @FXML
    private JFXTextField mail;

    
    @FXML
    private JFXTextField bg;

    
    @FXML
    private ImageView dp;

    
    @FXML
    private JFXTextField er;

    @FXML
    private JFXTextField dob;

    @FXML
    private JFXTextField ph;

    @FXML
    private JFXTextField per;

    @FXML
    private JFXButton browse;
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
    void pic(ActionEvent event) throws Exception
    {
        /*f=new JFileChooser();
        //f.getExtensionFilters().addAll( new ExtensionFilter("image","*jpg","*png","*jpeg"));
        //file=f.showOpenDialog(stage);
        f.setFileFilter(new JPEGImageFileFilter());
        int returnVal = f.showOpenDialog(dialog);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
        file=new File(f.getSelectedFile().getAbsolutePath());}
        //frame.getContentPane().add(new ImagePanel(file, frame));
        image= ImageIO.read(file);
        Image img=(Image) image;
        dp.setImage(img);
         
    }*/
       
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

        query = " insert into main values ('"+uni+"','"+db+"','student','"+frst+"','"+last+"','"+db+"','NULL','"+ent+"','"+tw+"','NULL','NULL','NULL','NULL','NULL')";
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin2.fxml")); 
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
        
        
        // TODO
    }    
    
}
