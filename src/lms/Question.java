/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author A M A
 */
public class Question {
    protected String CourseName,Qname,opt1,opt2,opt3,opt4,answer;
    protected long QuestionD;
    
    public long getID(){
        return  QuestionD;
    }
    
    public String getopt1(){
        return opt1;
    }
    
     public String getopt2(){
        return opt2;
    }
     
     
    public String getopt3(){
        return opt3;
    }
    
    public String getopt4(){
        return opt4;
    }
    
     public String answer(){
        return answer;
    }
    
     public String Qname(){
        return Qname;
    }
    
    public String getCourseName(){
        return CourseName;
    }
    
    public void setopt1(String opt1){
        this.opt1 = opt1;
    }
    
     public void setopt2(String opt2){
        this.opt2 = opt2;
    }
        
      public void setopt3(String QID3){
        this.opt3 = opt3;
    }
            
     public void setopt4(String opt4){
        this.opt4= opt4;
    }
                

       
    public void setCourseName(String CourseName){
        this.CourseName = CourseName;
    }
      public void setanswer(String answer){
        this.answer = answer;
    }
      
            public void setQname(String Qname){
        this.Qname = Qname;
    }
    
    
}
