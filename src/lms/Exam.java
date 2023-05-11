/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author A M A
 */
public class Exam {
    protected String CourseName;
    protected long ExamID,QID1, QID2,QID3, QID4,QID5;
    
    public long getID(){
        return ExamID;
    }
    
    public long getQID1(){
        return QID1;
    }
    
     public long getQID2(){
        return QID2;
    }
     
     
    public long getQID3(){
        return QID3;
    }
    
    public long getQID4(){
        return QID4;
    }
    
     public long getQID5(){
        return QID5;
    }
    
    public String getCourseName(){
        return CourseName;
    }
    
    public void setQID1(int QID1){
        this.QID1 = QID1;
    }
    
     public void setQID2(int QID2){
        this.QID2 = QID2;
    }
        
      public void setQID3(int QID3){
        this.QID3 = QID3;
    }
            
     public void setQID4(int QID4){
        this.QID4= QID4;
    }
                
       public void setQID5(int QID5){
        this.QID5 = QID5;
    }
       
    public void setCourseName(String CourseName){
        this.CourseName = CourseName;
    }
    

   
    

}
