/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Color;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author R R Chauhan
 */
public class IssueBook extends javax.swing.JFrame {
    Color closeColor = new Color(255,51,51);
    Color closeExitColor = new Color(155,155,155);
    

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
    
    int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id=?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            lbl_bookId.setText(rs.getString("book_id"));
            lbl_bookName.setText(rs.getString("book_name"));
            lbl_author.setText(rs.getString("author"));
            lbl_quantity.setText(rs.getString("quantity"));
            }else{
            lbl_bookError.setText("Invalid Book Id!");
            }
            
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    
    }
    
    public void getStudentDetails(){
    int studentId = Integer.parseInt(txt_studentId.getText());
    
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id =?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
            lbl_studentId.setText(rs.getString("student_id"));
            lbl_studentName.setText(rs.getString("name"));
            lbl_course.setText(rs.getString("course"));
            lbl_branch.setText(rs.getString("branch"));  
            }else{
            lbl_studentError.setText("Invalid Student Id!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    //insert issue details to database
    public boolean issueBook(){
        boolean isIssued = false;
    
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        Date utilIssueDate = date_issueDate.getDatoFecha();
        Date utilDueDate = date_dueDate.getDatoFecha();
        
        long l1 = utilIssueDate.getTime();
        long l2 = utilDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,"+ "issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            
            int rowCount= pst.executeUpdate();
            if(rowCount>0){
            isIssued = true;
            }else{
            isIssued = false;
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        return isIssued;
    }
    
    //update book count
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity-1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
              if(rowCount>0){
            JOptionPane.showMessageDialog(this,"Book count updated");
            int initialCount = Integer.parseInt(lbl_quantity.getText());
            lbl_quantity.setText(Integer.toString(initialCount-1));
            }else{
            JOptionPane.showMessageDialog(this, "Can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // checking whether same book is issued to the student
    
    public boolean isAlreadyIssued(){
    boolean isAlreadyIssued=false;
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id =? and student_id = ? and status= ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3,"pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            isAlreadyIssued=true;
            }else{
            isAlreadyIssued=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        closeIssueBook = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 300, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch  :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 290, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name  :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course  :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Id  :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 280, 50));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 280, 50));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 290, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel4.setText("Student Details");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(102, 0, 0));
        jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 350, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 470, 830));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\R R Chauhan\\Downloads\\drive-download-20220727T165659Z-001\\AddNewBookIcons\\AddNewBookIcons\\back button 50.png")); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("Book Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 300, 5));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 230, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name  :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author  :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Id  :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 230, 50));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 230, 50));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 230, 50));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantity  :");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(102, 0, 0));
        jPanel5.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 300, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 830));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Issue Book");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 120, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 200, 300, 5));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Book Id :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, -1, -1));

        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 300, 330, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Due Date :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 550, -1, -1));

        txt_studentId.setPlaceholder("Enter Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 380, 330, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 540, 340, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Student Id :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Issue Date :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 460, -1, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issueDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 340, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonRectangle1.setText("Issue Book");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 610, 360, -1));

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

        setSize(new java.awt.Dimension(1624, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals(""))
        getBookDetails();
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
        if(!txt_studentId.getText().equals(""))
            getStudentDetails();
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        if(lbl_quantity.getText().equals("0")){
        JOptionPane.showMessageDialog(this, "Book out of stock");
        }else{
        if(!isAlreadyIssued()){
        if(issueBook()){
            JOptionPane.showMessageDialog(this,"Book issued successfully");
            updateBookCount();
        }else{
            JOptionPane.showMessageDialog(this, "Book can't be issued");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Student already has this book");
        }
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeIssueBook;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
