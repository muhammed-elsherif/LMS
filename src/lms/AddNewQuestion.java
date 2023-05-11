/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lms;
import java.sql.*;
 import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author A M A
 */
public class AddNewQuestion extends javax.swing.JFrame {

    /**
     * Creates new form AddNewQuestion
     */
    public AddNewQuestion() {
        initComponents();
        this.setLocationRelativeTo(null);
         try
        {
           Connection con = MyConnection.createConnection();
           Statement st = con.createStatement();
           ResultSet rs =st.executeQuery(" select count(id) from question  ");
           if(rs.next())
           {
               int id = rs.getInt(1);
               id = id + 1 ;
               String str = String.valueOf(id);
               IdLabel.setText(str);
           }
        }
        catch (Exception e)
        {
            JFrame jf = new JFrame();           
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf , e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CNameText = new javax.swing.JTextField();
        CNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        QuestionIdLabel = new javax.swing.JLabel();
        QuestionLabel = new javax.swing.JLabel();
        Opt1Label = new javax.swing.JLabel();
        Opt2Label = new javax.swing.JLabel();
        Opt3Label = new javax.swing.JLabel();
        Opt4Label = new javax.swing.JLabel();
        IdLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        AnswerLabel = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 102, 102));
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CNameText.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        getContentPane().add(CNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 700, -1));

        CNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        CNameLabel.setText("Course Name :");
        getContentPane().add(CNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Adventure", 1, 40)); // NOI18N
        jLabel2.setText("Add New Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 10, 329, -1));

        Close.setBackground(new java.awt.Color(255, 255, 255));
        Close.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 51, 51));
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/Close.png"))); // NOI18N
        Close.setText("Close");
        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 82, 1066, -1));

        QuestionIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QuestionIdLabel.setText("Question ID :");
        getContentPane().add(QuestionIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        QuestionLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QuestionLabel.setText("Question :");
        getContentPane().add(QuestionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        Opt1Label.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Opt1Label.setText("Option 1 :");
        getContentPane().add(Opt1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        Opt2Label.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Opt2Label.setText("Option 2 :");
        getContentPane().add(Opt2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        Opt3Label.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Opt3Label.setText("Option 3 :");
        getContentPane().add(Opt3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        Opt4Label.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Opt4Label.setText("Option 4 :");
        getContentPane().add(Opt4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        IdLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        IdLabel.setForeground(new java.awt.Color(255, 0, 0));
        IdLabel.setText("00");
        getContentPane().add(IdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 700, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField2.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 702, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField3.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 702, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField4.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 702, -1));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField5.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 702, -1));

        AnswerLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        AnswerLabel.setText("Answer   :");
        getContentPane().add(AnswerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField6.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 703, -1));

        SaveButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/save.png"))); // NOI18N
        SaveButton.setText("Save");
        SaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        ClearButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/clear.png"))); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        String id = IdLabel.getText();
        String name  = jTextField1.getText();
        String opt1 =  jTextField2.getText();
        String opt2 =  jTextField3.getText();
        String opt3 =  jTextField4.getText();
        String opt4 =  jTextField5.getText();
        String answer =  jTextField6.getText();
        String CourseName =  CNameText.getText();
         try
        {
           Connection con = MyConnection.createConnection();
           PreparedStatement pa = con.prepareStatement("insert into question values(?,?,?,?,?,?,?,?)");
           pa.setString(1, id);
           pa.setString(2, name);
           pa.setString(3, opt1);
           pa.setString(4, opt2 );
           pa.setString(5, opt3 );
           pa.setString(6, opt4 );
           pa.setString(7, answer);
           pa.setString(8, CourseName);
           pa.executeUpdate();
           JFrame jf = new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf , "successfully Updated");
           setVisible(false);
           new AddNewQuestion().setVisible(true);                    
        }
        catch (Exception e)
        {
            JFrame jf = new JFrame();           
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf , e);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        CNameText.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
         QuestionManagement.open=0;
         setVisible(false);
    }//GEN-LAST:event_CloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnswerLabel;
    private javax.swing.JLabel CNameLabel;
    private javax.swing.JTextField CNameText;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton Close;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JLabel Opt1Label;
    private javax.swing.JLabel Opt2Label;
    private javax.swing.JLabel Opt3Label;
    private javax.swing.JLabel Opt4Label;
    private javax.swing.JLabel QuestionIdLabel;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}