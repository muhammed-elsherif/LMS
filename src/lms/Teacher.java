/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Mohammed
 */
public class Teacher extends User {
    
    private int semester;
    public Teacher(String name, String email, String password, String gender){
        super(name, email, password, gender);
    }
    
    public int getSemester(){
        return semester;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public String getEmail(){
        return email;
    }
    
    @Override
    public String getPassword(){
        return password;
    }
    
    @Override
    public String getGender(){
        return gender;
    }
}
