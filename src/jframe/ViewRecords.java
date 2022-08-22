/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author R R Chauhan
 */
public class ViewRecords extends javax.swing.JFrame {

    Color closeColor = new Color(255, 51, 51);
    Color closeExitColor = new Color(155, 155, 155);
    /**
     * Creates new form ViewRecords
     */
    DefaultTableModel model;

    public ViewRecords() {
        initComponents();
        setIssueBookDetailsToTable();
    }

    public void setIssueBookDetailsToTable() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

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

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }

    // to fetch the record using date fields
    public void search() {

        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();

        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            } else {

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
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel14 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        closeIssueBook = new javax.swing.JLabel();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 370, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("View All Record");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_fromDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_fromDate.setPlaceholder("Select From Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 340, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("From Date :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        date_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_toDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_toDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_toDate.setPlaceholder("Select To Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 340, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("To Date :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

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

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle3.setText("Search");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 150, 180, -1));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle2.setForeground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonRectangle2.setText("View all records");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 150, 350, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 250));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 1360, 500));

        setSize(new java.awt.Dimension(1630, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        clearTable();
        setIssueBookDetailsToTable();
        
        
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

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

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
        
        if(date_fromDate.getDatoFecha()!=null && date_toDate.getDatoFecha()!=null){
        clearTable();
        search();
        }else{
        JOptionPane.showMessageDialog(this, "Please select a date range");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeIssueBook;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}