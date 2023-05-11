/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Mohammed
 */
public class Student extends User {
    private int semester;
    
    public Student(String name, String email, String password, String gender, int semester){
        super(name, email, password, gender);
        this.semester = semester;
    }
    
    public int getSemester(){
        return semester;
    }
}
