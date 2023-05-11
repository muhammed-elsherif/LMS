/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MyConnection {
//    Connection con;
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmsDB", "root", "root");
            return con;
//        }catch (ClassNotFoundException | SQLException e){
//            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
