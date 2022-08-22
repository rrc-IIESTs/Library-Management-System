/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R R Chauhan
 */
public class IssueBookDetails extends javax.swing.JFrame {
    Color closeColor = new Color(255, 51, 51);
    Color closeExitColor = new Color(155, 155, 155);
    /**
     * Creates new form IssueBookDetails
     */
    DefaultTableModel model;
    public IssueBookDetails() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
     public void setIssueBookDetailsToTable() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details where status = '"+"pending"+"'");

            while (rs.next()) {
                String Id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                Object[] obj = {Id, bookName, studentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojerusan.RSTableMetro();
        jLabel11 = new javax.swing.JLabel();
        closeIssueBook = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("  Issue Book Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 380, 5));

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(51, 51, 255));
        tbl_issueBookDetails.setColorBordeFilas(new java.awt.Color(51, 51, 255));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(155, 155, 155));
        tbl_issueBookDetails.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_issueBookDetails.setFuenteHead(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_issueBookDetails.setRowHeight(40);
        tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 1360, 500));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\R R Chauhan\\Downloads\\drive-download-20220727T165659Z-001\\AddNewBookIcons\\AddNewBookIcons\\back button 50.png")); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        closeIssueBook.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        closeIssueBook.setForeground(new java.awt.Color(155, 155, 155));
        closeIssueBook.setText("X");
        closeIssueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeIssueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeIssueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeIssueBookMouseExited(evt);
            }
        });
        jPanel1.add(closeIssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 830));

        setSize(new java.awt.Dimension(1630, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked

    }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void closeIssueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIssueBookMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeIssueBookMouseClicked

    private void closeIssueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIssueBookMouseEntered
        // TODO add your handling code here:
        closeIssueBook.setForeground(closeColor);
    }//GEN-LAST:event_closeIssueBookMouseEntered

    private void closeIssueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIssueBookMouseExited
        // TODO add your handling code here:
        closeIssueBook.setForeground(closeExitColor);
    }//GEN-LAST:event_closeIssueBookMouseExited

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
            java.util.logging.Logger.getLogger(IssueBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeIssueBook;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}