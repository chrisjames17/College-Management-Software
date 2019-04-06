/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author chrisjamesjoshy
 */
public class dbconn
    {
        Connection con=null;
        public static Connection condb()
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/test?autoReconnect=true&useSSL=false","root","root");
                return conn;
            
            } catch(Exception e)
            {
                System.out.println(e);
                return null;

            }
        }
    };
            