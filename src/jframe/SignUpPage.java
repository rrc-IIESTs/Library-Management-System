package jframe;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author R R Chauhan
 */

import java.sql.*;
import javax.swing.JOptionPane;
import jframe.DBConnection;
import jframe.LoginPage;

public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    public SignUpPage() {
        initComponents();
    }
    
    //method to insert values into users table
    
    public void insertSignUpDetails(){
    String name= txt_username.getText();
    String pwd = txt_password.getText();
    String email= txt_email.getText();
    String contact = txt_contact.getText();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into users(name, password,email,contact) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pwd);
            pst.setString(3, email);
            pst.setString(4, contact);
            
            int updatedRowCount = pst.executeUpdate();
            if(updatedRowCount>0){
                JOptionPane.showMessageDialog(this,"Sign Up successfull, Please login");
                LoginPage page = new LoginPage();
                page.setVisible(true);
                dispose();
            }else{
            JOptionPane.showMessageDialog(this, "Sign Up failed, Retry");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    
    }
    
    //validation
    
    public boolean validateSignup(){
    String name= txt_username.getText();
    String pwd = txt_password.getText();
    String email= txt_email.getText();
    String contact = txt_contact.getText();
    if(name.equals("")){
    JOptionPane.showMessageDialog(this,"please enter username");
    return false;
    }
    if(pwd.length()<8){
    JOptionPane.showMessageDialog(this,"Password must have more that 8 characters");
    return false;
    }
    if(pwd.equals("")){
    JOptionPane.showMessageDialog(this,"Please enter password");
    return false;
    }
    if(email.equals("") || !email.matches("^.+@.+\\..+$")){
    JOptionPane.showMessageDialog(this,"Please enter valid email id");
    return false;
    }

    if(contact.length()!=10){
    JOptionPane.showMessageDialog(this,"Contact Number must be 10 digits");
    return false;
    }
    
    return true;
    }
    
    //check dupicate users
    public boolean checkDuplicateUser(){
        String name = txt_username.getText();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst= con.prepareStatement("select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CloseSignUpButton = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/logo.zlibrary.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 820, 180));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("A Library Genesis Project");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 410, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/homepage cloud icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 990, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 830));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CloseSignUpButton.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        CloseSignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        CloseSignUpButton.setText("X");
        CloseSignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseSignUpButtonMouseClicked(evt);
            }
        });
        jPanel2.add(CloseSignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txt_username.setPlaceholder("Enter username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 250, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 50));

        txt_password.setPlaceholder("Enter Password");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 250, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        txt_email.setPlaceholder("something@domainname");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 250, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 50, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        txt_contact.setPlaceholder("+91 ....................");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 250, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 50, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Contact");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Already have an Account?");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 300, -1));

        rSMaterialButtonRectangle1.setText("Sign Up");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 300, -1));

        rSMaterialButtonRectangle2.setText("Log In");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Create New Account");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        setSize(new java.awt.Dimension(1523, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        if(validateSignup())
            if(!checkDuplicateUser())
        insertSignUpDetails();
        else
                JOptionPane.showMessageDialog(this,"Username exists try another username");
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void CloseSignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseSignUpButtonMouseClicked

        System.exit(0);
    }//GEN-LAST:event_CloseSignUpButtonMouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
       if(checkDuplicateUser()){
       JOptionPane.showMessageDialog(this, "Username exists try another username");
       }
    }//GEN-LAST:event_txt_usernameFocusLost

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseSignUpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}