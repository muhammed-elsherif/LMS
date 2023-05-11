package lms;

import java.awt.print.PrinterException;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CourseMangnment extends javax.swing.JFrame {
    /**
     * Creates new form CourseMangnment
     */
 Connection con;
 DefaultTableModel CourseTable1;
  DefaultTableModel Model1;
  DefaultTableModel Model2;
      ArrayList<Integer> lec_id=new ArrayList<>();
      ArrayList<Integer> assign_id=new ArrayList<>();
    public CourseMangnment() {
    initComponents();  
    con = MyConnection.createConnection();
     this.setLocationRelativeTo(null); 
    CourseTable1 =new DefaultTableModel();
    
        CourseTable1.addColumn("Id");
        CourseTable1.addColumn("Student Name");
        CourseTable1.addColumn("Semester");
        CourseTable1.addColumn("Course (1)");
        CourseTable1.addColumn("Course (2)");
        CourseTable1.addColumn("Course (3)");
        CourseTable1.addColumn("Course (4)");

         Model1 =new DefaultTableModel();
         Model1.addColumn("Week Number");
         Model1.addColumn("Course");
         Model1.addColumn("Content");
         Model1.addColumn("Lecture Tittle");
         
         Model2 =new DefaultTableModel();
         Model2.addColumn("Week Number");
         Model2.addColumn("Course");
         Model2.addColumn("Content");
         Model2.addColumn("Lecture Tittle");
       
//     try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmsdb", "root", "root");
//            
//        }
//        catch (ClassNotFoundException | SQLException e){
//            JOptionPane.showMessageDialog(this, "Connection Failed");
//        }
     
     FillTableModelc();
     FillTableModel1();
     FillTableModel2();
    }
    
   private void FillTableModelc(){
        try{
            CourseTable1.setRowCount(0);
            
          PreparedStatement stmt=con.prepareStatement("select id,name,semester,course1,course2,course3,course4 from student;");
          
          ResultSet rs = stmt.executeQuery();
        while(rs.next()){
         CourseTable1.addRow(new Object[]{
                                          rs.getString(1),rs.getString(2),
                                          rs.getString(3),rs.getString(4),
                                          rs.getString(5),rs.getString(6),
                                          rs.getString(7)});
                                         }

        CourseTable.setModel(CourseTable1);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, " Failed");
        }

    }
    private void FillTableModel1(){
        try{
            Model1.setRowCount(0);
            
          PreparedStatement stmt=con.prepareStatement("select * from lecturetable;");
          
          ResultSet rs = stmt.executeQuery();
        while(rs.next()){
         Model1.addRow(new Object[]{
                                          rs.getInt(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getString(4)
                                         });
                                          lec_id.add(rs.getInt(5));
                                         }

       CourseTable2.setModel(Model1);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, " Failed");
        }
    }
          private void FillTableModel2(){
        try{
            Model2.setRowCount(0);
            
          PreparedStatement stmt=con.prepareStatement("select * from assign;");
          
          ResultSet rs = stmt.executeQuery();
        while(rs.next()){
         Model2.addRow(new Object[]{
                                          rs.getInt(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getString(4)
                                         });
                                          assign_id.add(rs.getInt(5));
                                         }

       CourseTable3.setModel(Model2);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, " Failed");
        }

    }
   
      private void FillSearchBox(){
        try{
            CourseTable1.setRowCount(0);
            
          PreparedStatement stmt=con.prepareStatement("select id,name,semester,course1,course2,course3,course4 from student where id =?;");
         int ID =Integer.parseInt(StdSearchField.getText());
          stmt.setInt(1, ID);
          
          ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {CourseTable1.addRow(new Object[]{rs.getString(1),rs.getString(2),
                                          rs.getString(3),rs.getString(4),
                                          rs.getString(5),rs.getString(6),
                                          rs.getString(7)});
                    }

        CourseTable.setModel(CourseTable1);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, " Failed");
        }

    }
    
    public int isEmpSearch(){
    if(StdIDSearchField.getText().isEmpty())
    { JOptionPane.showMessageDialog(this, "Student's ID is missing");
       return 1;}
    else
        return 0;
    }
    
    public int isEmpty(){
            if(   ( IdTextField.getText().isEmpty() || StdName.getText().isEmpty()  )    || 
                C1Box.getSelectedItem().toString().equals("-") && 
                C2Box.getSelectedItem().toString().equals("-") &&  
                C3Box.getSelectedItem().toString().equals("-") && 
                C4Box.getSelectedItem().toString().equals("-"))
                return 1;
     return 0;

            
    }
    
//      public int isEmptyLecture(){
////            if(  WeekNoLD.getText().isEmpty()
////                || LectTittle.getText().isEmpty()
////                ||  Conetent1.getText().isEmpty())
//               
//                return 1;
//     return 0;
//
//            
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CourseTab = new javax.swing.JTabbedPane();
        CoursePanel = new javax.swing.JPanel();
        AddCoursesPanel = new javax.swing.JPanel();
        StdIdSearchPanel = new javax.swing.JPanel();
        StdIdLabel = new javax.swing.JLabel();
        StdIDSearchField = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        IdTextField = new javax.swing.JTextField();
        StdName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        C1Box = new javax.swing.JComboBox<>();
        C2Box = new javax.swing.JComboBox<>();
        C3Box = new javax.swing.JComboBox<>();
        SemesterLabel = new javax.swing.JLabel();
        Course1Label = new javax.swing.JLabel();
        Course2Label = new javax.swing.JLabel();
        Course3Label = new javax.swing.JLabel();
        Course4Label = new javax.swing.JLabel();
        C4Box = new javax.swing.JComboBox<>();
        SemesterTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        SearchStdPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        StdSearchField = new javax.swing.JTextField();
        SearchStdBtn = new javax.swing.JButton();
        RefreshStdBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        PrintBtn = new javax.swing.JButton();
        LecturePanel = new javax.swing.JPanel();
        AddCoursesPanel1 = new javax.swing.JPanel();
        IdTextField1 = new javax.swing.JTextField();
        StdName1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Course1Label1 = new javax.swing.JLabel();
        Course4Label1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CourseTable2 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        AddLecture = new javax.swing.JButton();
        DeleteLecture = new javax.swing.JButton();
        PrintLecture = new javax.swing.JButton();
        UpdateLecture1 = new javax.swing.JButton();
        AssignmentsPanel = new javax.swing.JPanel();
        LecturePanel1 = new javax.swing.JPanel();
        AddCoursesPanel2 = new javax.swing.JPanel();
        IdTextField2 = new javax.swing.JTextField();
        StdName2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Course1Label2 = new javax.swing.JLabel();
        Course4Label2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CourseTable3 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        AddAssignment = new javax.swing.JButton();
        DeleteAssignment = new javax.swing.JButton();
        PrintAssignment = new javax.swing.JButton();
        AddLecture2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jLabel1.setText("course mangement");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1099, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        CourseTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CourseTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CourseTab.setPreferredSize(new java.awt.Dimension(1280, 720));

        AddCoursesPanel.setBackground(new java.awt.Color(153, 255, 255));

        StdIdSearchPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        StdIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        StdIdLabel.setText("student's ID");

        StdIDSearchField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        StdIDSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdIDSearchFieldActionPerformed(evt);
            }
        });
        StdIDSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StdIDSearchFieldKeyTyped(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(204, 0, 51));
        SearchBtn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StdIdSearchPanelLayout = new javax.swing.GroupLayout(StdIdSearchPanel);
        StdIdSearchPanel.setLayout(StdIdSearchPanelLayout);
        StdIdSearchPanelLayout.setHorizontalGroup(
            StdIdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdIdSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StdIdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StdIdSearchPanelLayout.createSequentialGroup()
                        .addComponent(StdIdLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(StdIdSearchPanelLayout.createSequentialGroup()
                        .addComponent(StdIDSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        StdIdSearchPanelLayout.setVerticalGroup(
            StdIdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdIdSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StdIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StdIdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StdIDSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IdTextField.setEditable(false);
        IdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextFieldActionPerformed(evt);
            }
        });
        IdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdTextFieldKeyTyped(evt);
            }
        });

        StdName.setEditable(false);
        StdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Student_name");

        C1Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "logic", "pl", "ds", "maths" }));
        C1Box.setToolTipText("select  course");
        C1Box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        C1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1BoxActionPerformed(evt);
            }
        });

        C2Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "logic", "pl", "ds", "maths" }));
        C2Box.setToolTipText("select  course");
        C2Box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        C2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2BoxActionPerformed(evt);
            }
        });

        C3Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "logic", "pl", "ds", "maths" }));
        C3Box.setToolTipText("select  course");
        C3Box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SemesterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SemesterLabel.setText("Semester");

        Course1Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course1Label.setText("Course 1");

        Course2Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course2Label.setText("Course 2");

        Course3Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course3Label.setText("Course 3");

        Course4Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course4Label.setText("Course 4");

        C4Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "logic", "pl", "ds", "maths" }));
        C4Box.setToolTipText("select  course");
        C4Box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SemesterTextField.setEditable(false);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Exam Statistics");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddCoursesPanelLayout = new javax.swing.GroupLayout(AddCoursesPanel);
        AddCoursesPanel.setLayout(AddCoursesPanelLayout);
        AddCoursesPanelLayout.setHorizontalGroup(
            AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StdIdSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AddCoursesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(StdName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddCoursesPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SemesterLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Course1Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Course2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Course3Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Course4Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddCoursesPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(SemesterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddCoursesPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(C1Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C2Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C3Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C4Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddCoursesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddCoursesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        AddCoursesPanelLayout.setVerticalGroup(
            AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StdIdSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(StdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SemesterLabel)
                    .addComponent(SemesterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Course1Label)
                    .addComponent(C1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Course2Label))
                .addGap(30, 30, 30)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C3Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Course3Label))
                .addGap(27, 27, 27)
                .addGroup(AddCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Course4Label)
                    .addComponent(C4Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));

        SearchStdPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchStdPanel.setForeground(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("Search Student");

        StdSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdSearchFieldActionPerformed(evt);
            }
        });

        SearchStdBtn.setBackground(new java.awt.Color(51, 102, 255));
        SearchStdBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchStdBtn.setText("Search");
        SearchStdBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchStdBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchStdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStdBtnActionPerformed(evt);
            }
        });

        RefreshStdBtn.setBackground(new java.awt.Color(51, 102, 255));
        RefreshStdBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshStdBtn.setText("Refresh");
        RefreshStdBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RefreshStdBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RefreshStdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshStdBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchStdPanelLayout = new javax.swing.GroupLayout(SearchStdPanel);
        SearchStdPanel.setLayout(SearchStdPanelLayout);
        SearchStdPanelLayout.setHorizontalGroup(
            SearchStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchStdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StdSearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchStdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefreshStdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        SearchStdPanelLayout.setVerticalGroup(
            SearchStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchStdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchStdPanelLayout.createSequentialGroup()
                        .addComponent(StdSearchField)
                        .addGap(2, 2, 2))
                    .addGroup(SearchStdPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SearchStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchStdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshStdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );

        CourseTable.setAutoCreateRowSorter(true);
        CourseTable.setBackground(new java.awt.Color(204, 204, 204));
        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student Name", "Semester", "Course 1", "Course 2", "Course 3", "Course 4"
            }
        ));
        CourseTable.setGridColor(new java.awt.Color(102, 204, 255));
        CourseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CourseTable);

        jPanel10.setBackground(new java.awt.Color(102, 204, 255));

        UpdateBtn.setBackground(new java.awt.Color(51, 153, 255));
        UpdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateBtn.setText("Add Courses");
        UpdateBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeleteBtn.setText("Delete Courses");
        DeleteBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setBackground(new java.awt.Color(51, 153, 255));
        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LogoutBtn.setText("Log out");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        PrintBtn.setBackground(new java.awt.Color(51, 153, 255));
        PrintBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PrintBtn.setText("Print");
        PrintBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PrintBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(UpdateBtn)
                .addGap(144, 144, 144)
                .addComponent(DeleteBtn)
                .addGap(100, 100, 100)
                .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchStdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchStdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout CoursePanelLayout = new javax.swing.GroupLayout(CoursePanel);
        CoursePanel.setLayout(CoursePanelLayout);
        CoursePanelLayout.setHorizontalGroup(
            CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCoursesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CoursePanelLayout.setVerticalGroup(
            CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddCoursesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        CourseTab.addTab("         Courses            ", CoursePanel);

        AddCoursesPanel1.setBackground(new java.awt.Color(153, 255, 255));

        IdTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextField1ActionPerformed(evt);
            }
        });
        IdTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdTextField1KeyTyped(evt);
            }
        });

        StdName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdName1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("week number");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Course");

        Course1Label1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course1Label1.setText("Content path");

        Course4Label1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course4Label1.setText("Lecture Tittle");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Lecture Regesrtration");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddCoursesPanel1Layout = new javax.swing.GroupLayout(AddCoursesPanel1);
        AddCoursesPanel1.setLayout(AddCoursesPanel1Layout);
        AddCoursesPanel1Layout.setHorizontalGroup(
            AddCoursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanel1Layout.createSequentialGroup()
                .addGroup(AddCoursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddCoursesPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(AddCoursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Course1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StdName1)
                            .addComponent(Course4Label1)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(IdTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(AddCoursesPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AddCoursesPanel1Layout.setVerticalGroup(
            AddCoursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(StdName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Course1Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Course4Label1)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CourseTable2.setAutoCreateRowSorter(true);
        CourseTable2.setBackground(new java.awt.Color(204, 204, 204));
        CourseTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Week Number", "Course", "Content", "Lecture Tittle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CourseTable2.setGridColor(new java.awt.Color(102, 204, 255));
        CourseTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CourseTable2);

        jPanel12.setBackground(new java.awt.Color(102, 204, 255));

        AddLecture.setBackground(new java.awt.Color(51, 153, 255));
        AddLecture.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddLecture.setText("Add Lecture");
        AddLecture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddLecture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddLecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLectureActionPerformed(evt);
            }
        });

        DeleteLecture.setBackground(new java.awt.Color(51, 153, 255));
        DeleteLecture.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeleteLecture.setText("Delete Lecture");
        DeleteLecture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteLecture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteLecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLectureActionPerformed(evt);
            }
        });

        PrintLecture.setBackground(new java.awt.Color(51, 153, 255));
        PrintLecture.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PrintLecture.setText("Print");
        PrintLecture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PrintLecture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintLecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintLectureActionPerformed(evt);
            }
        });

        UpdateLecture1.setBackground(new java.awt.Color(51, 153, 255));
        UpdateLecture1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateLecture1.setText("Update Lecture");
        UpdateLecture1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateLecture1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateLecture1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateLecture1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(AddLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(UpdateLecture1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(DeleteLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(PrintLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintLecture, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateLecture1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout LecturePanelLayout = new javax.swing.GroupLayout(LecturePanel);
        LecturePanel.setLayout(LecturePanelLayout);
        LecturePanelLayout.setHorizontalGroup(
            LecturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturePanelLayout.createSequentialGroup()
                .addComponent(AddCoursesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LecturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LecturePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(LecturePanelLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        LecturePanelLayout.setVerticalGroup(
            LecturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCoursesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LecturePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CourseTab.addTab("                 Lectures           ", LecturePanel);

        AddCoursesPanel2.setBackground(new java.awt.Color(153, 255, 255));

        IdTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextField2ActionPerformed(evt);
            }
        });
        IdTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdTextField2KeyTyped(evt);
            }
        });

        StdName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdName2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("week number");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Course");

        Course1Label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course1Label2.setText("Content path");

        Course4Label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course4Label2.setText("Lecture Tittle");

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Assignment Regesrtration");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AddCoursesPanel2Layout = new javax.swing.GroupLayout(AddCoursesPanel2);
        AddCoursesPanel2.setLayout(AddCoursesPanel2Layout);
        AddCoursesPanel2Layout.setHorizontalGroup(
            AddCoursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanel2Layout.createSequentialGroup()
                .addGroup(AddCoursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddCoursesPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(AddCoursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(StdName2)
                            .addComponent(Course4Label2)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(IdTextField2)
                            .addComponent(jTextField4)
                            .addComponent(Course1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddCoursesPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AddCoursesPanel2Layout.setVerticalGroup(
            AddCoursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCoursesPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IdTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StdName2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Course1Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Course4Label2)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CourseTable3.setAutoCreateRowSorter(true);
        CourseTable3.setBackground(new java.awt.Color(204, 204, 204));
        CourseTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Week Number", "Course", "Content", "Lecture Tittle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CourseTable3.setGridColor(new java.awt.Color(102, 204, 255));
        CourseTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CourseTable3);
        if (CourseTable3.getColumnModel().getColumnCount() > 0) {
            CourseTable3.getColumnModel().getColumn(3).setHeaderValue("Lecture Tittle");
        }

        jPanel13.setBackground(new java.awt.Color(102, 204, 255));

        AddAssignment.setBackground(new java.awt.Color(51, 153, 255));
        AddAssignment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddAssignment.setText("Add Assignment");
        AddAssignment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddAssignment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAssignmentActionPerformed(evt);
            }
        });

        DeleteAssignment.setBackground(new java.awt.Color(51, 153, 255));
        DeleteAssignment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeleteAssignment.setText("Delete Assignment");
        DeleteAssignment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteAssignment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAssignmentActionPerformed(evt);
            }
        });

        PrintAssignment.setBackground(new java.awt.Color(51, 153, 255));
        PrintAssignment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PrintAssignment.setText("Print");
        PrintAssignment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PrintAssignment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintAssignmentActionPerformed(evt);
            }
        });

        AddLecture2.setBackground(new java.awt.Color(51, 153, 255));
        AddLecture2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddLecture2.setText("Update Assignment");
        AddLecture2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddLecture2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddLecture2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLecture2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(AddAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(AddLecture2)
                .addGap(45, 45, 45)
                .addComponent(DeleteAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PrintAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddLecture2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout LecturePanel1Layout = new javax.swing.GroupLayout(LecturePanel1);
        LecturePanel1.setLayout(LecturePanel1Layout);
        LecturePanel1Layout.setHorizontalGroup(
            LecturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturePanel1Layout.createSequentialGroup()
                .addComponent(AddCoursesPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LecturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LecturePanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(LecturePanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        LecturePanel1Layout.setVerticalGroup(
            LecturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCoursesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LecturePanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AssignmentsPanelLayout = new javax.swing.GroupLayout(AssignmentsPanel);
        AssignmentsPanel.setLayout(AssignmentsPanelLayout);
        AssignmentsPanelLayout.setHorizontalGroup(
            AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1355, Short.MAX_VALUE)
            .addGroup(AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AssignmentsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LecturePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        AssignmentsPanelLayout.setVerticalGroup(
            AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AssignmentsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LecturePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        CourseTab.addTab("                Assignments               ", AssignmentsPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CourseTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CourseTab, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StdIDSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdIDSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdIDSearchFieldActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
     isEmpSearch();
     boolean flag=true;
     int StdID =Integer.parseInt(StdIDSearchField.getText());
     try {
         PreparedStatement stmt=con.prepareStatement("select id,name,semester from student where id =?;");
          stmt.setInt(1, StdID);
          
          ResultSet rs = stmt.executeQuery();
          
        while(rs.next()){
            
            IdTextField.setText(rs.getString(1));
            StdName.setText(rs.getString(2));
            SemesterTextField.setText(rs.getString(3));
            flag=false;}
     
     if(!rs.next()&& flag )
            JOptionPane.showMessageDialog(this, "not found");
          
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "Error");
     }
        
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void IdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextFieldActionPerformed

    private void StdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdNameActionPerformed

    private void SearchStdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStdBtnActionPerformed
        // TODO add your handling code here:
 
       if (StdSearchField.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Please enter a student ID");
       } else{ 
           FillSearchBox();
           
       }
        
    }//GEN-LAST:event_SearchStdBtnActionPerformed

    private void C1BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C1BoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C1BoxActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    int a = JOptionPane.showConfirmDialog(this,"Do you want to logout now?","logout",JOptionPane.YES_NO_OPTION);
    if(a==0){
    this.dispose();
    new SignIn().setVisible(true);}
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void IdTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextFieldKeyPressed

    private void IdTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextFieldKeyTyped
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
    }//GEN-LAST:event_IdTextFieldKeyTyped
    }
    
    private void StdIDSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StdIDSearchFieldKeyTyped
        // TODO add your handling code here:
              if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
    }   
    }//GEN-LAST:event_StdIDSearchFieldKeyTyped

    private void C2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2BoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C2BoxActionPerformed

    private void CourseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseTableMouseClicked
        // TODO add your handling code here:
     IdTextField.setText((String) CourseTable.getValueAt(CourseTable.getSelectedRow(),0));
     StdName.setText((String) CourseTable.getValueAt(CourseTable.getSelectedRow(),1));
     SemesterTextField.setText((String) CourseTable.getValueAt(CourseTable.getSelectedRow(),2));
     C1Box.setSelectedItem(CourseTable.getValueAt(CourseTable.getSelectedRow(),3));
     C2Box.setSelectedItem(CourseTable.getValueAt(CourseTable.getSelectedRow(),4));
     C3Box.setSelectedItem(CourseTable.getValueAt(CourseTable.getSelectedRow(),5));
     C4Box.setSelectedItem(CourseTable.getValueAt(CourseTable.getSelectedRow(),6));
    }//GEN-LAST:event_CourseTableMouseClicked

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
       if(isEmpty()==0){
        try{
            
                    int ID =Integer.parseInt(IdTextField.getText());
                    String StudentName=StdName.getText();
                    int Semester = Integer.parseInt(SemesterTextField.getText());
                    String Course1 =C1Box.getSelectedItem().toString();
                    String Course2 =C2Box.getSelectedItem().toString();
                    String Course3 =C3Box.getSelectedItem().toString();
                    String Course4 =C4Box.getSelectedItem().toString();
         
                    PreparedStatement stmt=con.prepareStatement("update student set course1=?,course2=?,course3=?,course4=? where id=?;");
                    

                    
                    stmt.setString(1, Course1);
                    stmt.setString(2, Course2);
                    stmt.setString(3, Course3);
                    stmt.setString(4, Course4);
                    stmt.setInt(5,Integer.parseInt(IdTextField.getText()) );
                    stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "updated succsefully");         
                    
                FillTableModelc();
     
        }   catch (SQLException ex) {
              /*  Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);*/
                 JOptionPane.showMessageDialog(this, "Error Id is Dublicate! ");  
        }
       }
        else
           JOptionPane.showMessageDialog(this, "Empty fields! ");
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        if(isEmpty()==0){
         try{
             PreparedStatement stmt=con.prepareStatement("update student set course1='-',course2='-',course3='-',course4='-' where id=?;");   
                    stmt.setInt(1,Integer.parseInt(IdTextField.getText()) );
                    stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Deleted succsefully");         
                    
                FillTableModelc();
     
        }   catch (SQLException ex) {
              /*  Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);*/
                 JOptionPane.showMessageDialog(this, "Error: Empty Fields!");  
            }}
         else
           JOptionPane.showMessageDialog(this, "No fields are selected !");
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void StdSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdSearchFieldActionPerformed

    private void RefreshStdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshStdBtnActionPerformed
        // TODO add your handling code here:
          FillTableModelc();
    }//GEN-LAST:event_RefreshStdBtnActionPerformed

    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Course Regestration");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try {
        CourseTable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch (PrinterException ex) {
         Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_PrintBtnActionPerformed

    private void IdTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField1ActionPerformed

    private void IdTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField1KeyPressed

    private void IdTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField1KeyTyped

    private void StdName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdName1ActionPerformed

    private void CourseTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseTable2MouseClicked
        // TODO add your handling code here:
        IdTextField1.setText( CourseTable2.getValueAt(CourseTable2.getSelectedRow(), 0).toString());
        StdName1.setText( CourseTable2.getValueAt(CourseTable2.getSelectedRow(), 1).toString());
        jTextField1.setText( CourseTable2.getValueAt(CourseTable2.getSelectedRow(), 2).toString());
        jTextField2.setText( CourseTable2.getValueAt(CourseTable2.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_CourseTable2MouseClicked

    private void AddLectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLectureActionPerformed
        // TODO add your handling code here:
             try {
            // TODO add your handling code here:
            int week_no= Integer.parseInt(IdTextField1.getText());
            String crs=StdName1.getText();
            String cnt_path= jTextField1.getText();
            String lec_tittle=jTextField2.getText();
            PreparedStatement stm= con.prepareStatement("insert into lecturetable(week_no,course,lec_path,lec_tittle) values(?,?,?,?)");

            stm.setInt(1,week_no );
            stm.setString(2,crs );
            stm.setString(3,cnt_path );
            stm.setString(4,lec_tittle );
            stm.executeUpdate();
            JOptionPane.showMessageDialog(this, "addition succeds");
            FillTableModel1();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "addition Failed");
        }
    }//GEN-LAST:event_AddLectureActionPerformed

    private void DeleteLectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLectureActionPerformed
        // TODO add your handling code here:
                try {
            // TODO add your handling code here:
            PreparedStatement stm= con.prepareStatement("delete from lecturetable where id=?");

            stm.setInt(1, lec_id.get(CourseTable2.getSelectedRow()));
            stm.executeUpdate();
            JOptionPane.showMessageDialog(this, "delete succeds");
            FillTableModel1();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "delete Failed");
        }
    }//GEN-LAST:event_DeleteLectureActionPerformed

    private void PrintLectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintLectureActionPerformed
        // TODO add your handling code here:
           MessageFormat header = new MessageFormat("Course Regestration");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try {
        CourseTable2.print(JTable.PrintMode.NORMAL, header, footer);
        }catch (PrinterException ex) {
         Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_PrintLectureActionPerformed

    private void IdTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField2ActionPerformed

    private void IdTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField2KeyPressed

    private void IdTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextField2KeyTyped

    private void StdName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdName2ActionPerformed

    private void CourseTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseTable3MouseClicked
        // TODO add your handling code here:
         IdTextField2.setText( CourseTable3.getValueAt(CourseTable3.getSelectedRow(), 0).toString());
        StdName2.setText( CourseTable3.getValueAt(CourseTable3.getSelectedRow(), 1).toString());
        jTextField3.setText( CourseTable3.getValueAt(CourseTable3.getSelectedRow(), 2).toString());
        jTextField4.setText( CourseTable3.getValueAt(CourseTable3.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_CourseTable3MouseClicked

    private void AddAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAssignmentActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            int week_no= Integer.parseInt(IdTextField2.getText());
            String crs=StdName2.getText();
            String cnt_path= jTextField3.getText();
            String lec_tittle=jTextField4.getText();
            PreparedStatement stm= con.prepareStatement("insert into assign(week_no,course,assign_path,assign_tittle) values(?,?,?,?)");

            stm.setInt(1,week_no );
            stm.setString(2,crs );
            stm.setString(3,cnt_path );
            stm.setString(4,lec_tittle );
            stm.executeUpdate();
            JOptionPane.showMessageDialog(this, "addition succeds");
             FillTableModel2();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "addition Failed");
        }
       
    }//GEN-LAST:event_AddAssignmentActionPerformed

    private void DeleteAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAssignmentActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            PreparedStatement stm= con.prepareStatement("delete from assign where id=?");

            stm.setInt(1, assign_id.get(CourseTable3.getSelectedRow()));
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "delete succeds");
            FillTableModel2();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "delete Failed");
        }
        
    }//GEN-LAST:event_DeleteAssignmentActionPerformed

    private void PrintAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintAssignmentActionPerformed
        // TODO add your handling code here:
           MessageFormat header = new MessageFormat("Course Regestration");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try {
        CourseTable3.print(JTable.PrintMode.NORMAL, header, footer);
        }catch (PrinterException ex) {
         Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_PrintAssignmentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Precentage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateLecture1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateLecture1ActionPerformed
        // TODO add your handling code here:
//               if(isEmpty()==0){
        try{
            
                    int week_n =Integer.parseInt(IdTextField1.getText());
                    String crs=StdName1.getText();
                    String cnt_path = jTextField1.getText();
                    String lec_tittle = jTextField2.getText();
                    
            
         
                    PreparedStatement stmt=con.prepareStatement("update lecturetable set week_no=?,course=?,lec_path=?,lec_tittle=? where id=?;");
                    

                    
                    stmt.setInt(1, week_n);
                    stmt.setString(2, crs);
                    stmt.setString(3, cnt_path);
                    stmt.setString(4, lec_tittle);
                    stmt.setInt(5,lec_id.get(CourseTable2.getSelectedRow()) );
                    stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "updated succsefully");         
                    
                FillTableModel1();
     
        }   catch (SQLException ex) {
              /*  Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);*/
                 JOptionPane.showMessageDialog(this, "Error Id is Dublicate! ");  
        }
       
//        else
//           JOptionPane.showMessageDialog(this, "Empty fields! ");
    }//GEN-LAST:event_UpdateLecture1ActionPerformed

    private void AddLecture2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLecture2ActionPerformed
        // TODO add your handling code here:
          try{
            
                    int week_n =Integer.parseInt(IdTextField2.getText());
                    String crs=StdName2.getText();
                    String cnt_path = jTextField3.getText();
                    String lec_tittle = jTextField4.getText();
            
         
                    PreparedStatement stmt=con.prepareStatement("update assign set week_no=?,course=?,assign_path=?,assign_tittle=? where id=?;");
                    

                    
                    stmt.setInt(1, week_n);
                    stmt.setString(2, crs);
                    stmt.setString(3, cnt_path);
                    stmt.setString(4, lec_tittle);
                    stmt.setInt(5,assign_id.get(CourseTable3.getSelectedRow()) );
                    stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "updated succsefully");         
                    
                FillTableModel2();
     
        }   catch (SQLException ex) {
              /*  Logger.getLogger(CourseMangnment.class.getName()).log(Level.SEVERE, null, ex);*/
                 JOptionPane.showMessageDialog(this, "Error Id is Dublicate! ");  
        }
    }//GEN-LAST:event_AddLecture2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseMangnment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseMangnment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseMangnment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseMangnment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CourseMangnment().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAssignment;
    private javax.swing.JPanel AddCoursesPanel;
    private javax.swing.JPanel AddCoursesPanel1;
    private javax.swing.JPanel AddCoursesPanel2;
    private javax.swing.JButton AddLecture;
    private javax.swing.JButton AddLecture2;
    private javax.swing.JPanel AssignmentsPanel;
    private javax.swing.JComboBox<String> C1Box;
    private javax.swing.JComboBox<String> C2Box;
    private javax.swing.JComboBox<String> C3Box;
    private javax.swing.JComboBox<String> C4Box;
    private javax.swing.JLabel Course1Label;
    private javax.swing.JLabel Course1Label1;
    private javax.swing.JLabel Course1Label2;
    private javax.swing.JLabel Course2Label;
    private javax.swing.JLabel Course3Label;
    private javax.swing.JLabel Course4Label;
    private javax.swing.JLabel Course4Label1;
    private javax.swing.JLabel Course4Label2;
    private javax.swing.JPanel CoursePanel;
    private javax.swing.JTabbedPane CourseTab;
    private javax.swing.JTable CourseTable;
    private javax.swing.JTable CourseTable2;
    private javax.swing.JTable CourseTable3;
    private javax.swing.JButton DeleteAssignment;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteLecture;
    private javax.swing.JTextField IdTextField;
    private javax.swing.JTextField IdTextField1;
    private javax.swing.JTextField IdTextField2;
    private javax.swing.JPanel LecturePanel;
    private javax.swing.JPanel LecturePanel1;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton PrintAssignment;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JButton PrintLecture;
    private javax.swing.JButton RefreshStdBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchStdBtn;
    private javax.swing.JPanel SearchStdPanel;
    private javax.swing.JLabel SemesterLabel;
    private javax.swing.JTextField SemesterTextField;
    private javax.swing.JTextField StdIDSearchField;
    private javax.swing.JLabel StdIdLabel;
    private javax.swing.JPanel StdIdSearchPanel;
    private javax.swing.JTextField StdName;
    private javax.swing.JTextField StdName1;
    private javax.swing.JTextField StdName2;
    private javax.swing.JTextField StdSearchField;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton UpdateLecture1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
