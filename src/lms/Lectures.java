/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author PC
 */
public class Lectures {
    private int number_of_lectures;
    private String name;
    private String title;
    Assignments ass;

    public Lectures() {
        this.ass = new Assignments();
    }
    public void Lextures(String name, String title){
        this.name = name;
        this.title = title;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getName(){
        return name;
    }
    
    public String getTitle(){
        return title;
    }
}
