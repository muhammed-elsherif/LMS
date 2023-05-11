package lms;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class User {

    protected String name, email, gender, password;
    protected long userID;
    protected boolean admin; 
    
    public User(String name, String email, String password, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    
    public long getID(){
        return userID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean isAdmin(){
        Connection con =  MyConnection.createConnection();
        try{
        Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select admin from users where email = '" + this.email + "'");
            if(rs.next()){
                boolean Admin = rs.getBoolean("admin");
                return Admin;
            }
        }catch(SQLException e){
           Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
//    public abstract void active();
//    public abstract void deActive();
            
    public void deleteUser(User u) {
//        Connection con =  MyConnection.createConnection();
//        try{
//            Statement smt = con.createStatement();
//            String email = emailS.getText();
//            smt.executeUpdate("delete from student where email = '" + email + "'");
//            smt.executeUpdate("delete from users where email = '" + email + "'");
//            FillTableModel();
//            smt.close();
//        }
//        catch(SQLException e){
//            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
//        }
    }
}
