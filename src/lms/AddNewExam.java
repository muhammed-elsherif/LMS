package lms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author A M A
 */
public class AddNewExam extends javax.swing.JFrame {

    /**
     * Creates new form AddNewExam
     */
    public AddNewExam() {
        initComponents();
        this.setLocationRelativeTo(null);
          try
        {
           Connection con = MyConnection.createConnection();
           Statement st = con.createStatement();
           ResultSet rs =st.executeQuery(" select count(id) from quiz  ");
           if(rs.next())
           {
               int id = rs.getInt(1);
               id = id + 1 ;
               String str = String.valueOf(id);
               EIDLabel.setText(str);
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

        ClearButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CloseButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EIDLabel = new javax.swing.JLabel();
        CNameText = new javax.swing.JTextField();
        QID1Text = new javax.swing.JTextField();
        QID2Text = new javax.swing.JTextField();
        QID3Text = new javax.swing.JTextField();
        QID4Text = new javax.swing.JTextField();
        QID5Text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClearButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/clear.png"))); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, -1));

        SaveButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/save.png"))); // NOI18N
        SaveButton.setText("Save");
        SaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        jLabel2.setFont(new java.awt.Font("Adventure", 1, 40)); // NOI18N
        jLabel2.setText("Add New Exam");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        CloseButton.setBackground(new java.awt.Color(255, 255, 255));
        CloseButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(255, 0, 0));
        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/Close.png"))); // NOI18N
        CloseButton.setText("Close");
        CloseButton.setToolTipText("");
        CloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 78, 1066, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Course Name :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Exam ID :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Question ID 1 :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setText("Question ID 2 :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setText("Question ID 3 :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setText("Question ID 4 :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("Question ID 5 :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        EIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        EIDLabel.setText("00");
        getContentPane().add(EIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        CNameText.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        CNameText.setToolTipText("");
        getContentPane().add(CNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 700, -1));

        QID1Text.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QID1Text.setToolTipText("");
        getContentPane().add(QID1Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 700, -1));

        QID2Text.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QID2Text.setToolTipText("");
        getContentPane().add(QID2Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 700, -1));

        QID3Text.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QID3Text.setToolTipText("");
        getContentPane().add(QID3Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 700, -1));

        QID4Text.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QID4Text.setToolTipText("");
        getContentPane().add(QID4Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 700, -1));

        QID5Text.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        QID5Text.setToolTipText("");
        getContentPane().add(QID5Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        // TODO add your handling code here:
         ExamManagement.open=0;
        setVisible(false);
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        String id = EIDLabel.getText();
        String Qid1 =  QID1Text.getText();
        String Qid2 =  QID2Text.getText();
        String Qid3  = QID3Text.getText();
        String Qid4  =  QID4Text.getText();
        String Qid5  =  QID5Text.getText();
        String CourseName =  CNameText.getText();
          try
        {
           Connection con = MyConnection.createConnection();
           PreparedStatement pa = con.prepareStatement("insert into quiz values(?,?,?,?,?,?,?)");
           pa.setString(1, id);
           pa.setString(2, Qid1);
           pa.setString(3, Qid2);
           pa.setString(4, Qid3 );
           pa.setString(5, Qid4 );
           pa.setString(6, Qid5);
           pa.setString(7, CourseName);  
           pa.executeUpdate();
           JFrame jf = new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf , "successfully Updated");
           setVisible(false);
           new AddNewExam().setVisible(true);                    
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
         EIDLabel.setText("");
         QID1Text.setText("");
         QID2Text.setText("");
         QID3Text.setText("");
         QID4Text.setText("");
         QID5Text.setText("");
         CNameText.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNameText;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel EIDLabel;
    private javax.swing.JTextField QID1Text;
    private javax.swing.JTextField QID2Text;
    private javax.swing.JTextField QID3Text;
    private javax.swing.JTextField QID4Text;
    private javax.swing.JTextField QID5Text;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
