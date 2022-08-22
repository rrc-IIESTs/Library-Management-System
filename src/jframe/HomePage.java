/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author R R Chauhan
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);
    Color closeColor = new Color(255, 51, 51);
    Color closeExitColor = new Color(155, 155, 155);
    DefaultTableModel model;

    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToBoxes();
    }

    public void setStudentDetailsToTable() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");

                Object[] obj = {studentId, studentName, course, branch};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBookDetailsToTable() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");

                Object[] obj = {bookId, bookName, author, quantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataToBoxes() {

        Statement st = null;
        ResultSet rs = null;

        long l = System.currentTimeMillis();
        Date todaysDate = new Date(l);

        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select count(*) from book_details");
            rs.next();
            lbl_noOfBooks.setText(Integer.toString(rs.getInt("count(*)")));
            
            rs = st.executeQuery("select count(*) from student_details ");
            rs.next();
            lbl_noOfStudents.setText(Integer.toString(rs.getInt("count(*)")));
            
            rs = st.executeQuery("select count(*) from issue_book_details ");
            rs.next();
            lbl_issuedBooks.setText(Integer.toString(rs.getInt("count(*)")));
            
            rs = st.executeQuery("select count(*) from issue_book_details where due_date < '"+todaysDate+"' and status ='"+"pending"+"' ");
            rs.next();
            lbl_defaulterList.setText(Integer.toString(rs.getInt("count(*)")));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql ="select book_name, count(*) as issue_count from issue_book_details group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Most Popular Books", barDataset, true, true, true);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

       

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CloseAdminPanel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_issuedBooks = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 70, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome, Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ZLibrary Management Console");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        CloseAdminPanel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        CloseAdminPanel.setForeground(new java.awt.Color(155, 155, 155));
        CloseAdminPanel.setText("X");
        CloseAdminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseAdminPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseAdminPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseAdminPanelMouseExited(evt);
            }
        });
        jPanel1.add(CloseAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 10, 30, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1905, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(240, 240, 240));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel4.setText("  Home Page");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 340, 60));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel6.setText("  Logout");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 340, 60));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Features");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 190, 50));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel9.setText("  Dashboard");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel10.setText("  Dashboard");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel11.setText("  Manage Books");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel7.setText("  Manage Students");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel12.setText("  Issue Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel13.setText(" Return Book");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel14.setText("  View Records");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel15.setText("  View Issued Books");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel16.setText("  Defaulter List");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 50));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");
        jPanel6.add(lbl_noOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 260, 140));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Student Details");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfStudents.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        lbl_noOfStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");
        jPanel16.add(lbl_noOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 260, 140));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("No Of Students");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issuedBooks.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        lbl_issuedBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_issuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issuedBooks.setText("10");
        jPanel17.add(lbl_issuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Issued Books");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Defaulter List");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        lbl_defaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel18.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 260, 140));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(51, 51, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(51, 51, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(155, 155, 155));
        tbl_studentDetails.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 560, 240));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("No Of Books");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book Details");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(51, 51, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(51, 51, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(155, 155, 155));
        tbl_bookDetails.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 560, 240));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel5.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 540, 450));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1310, 960));

        setSize(new java.awt.Dimension(1650, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseAdminPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseAdminPanelMouseClicked

        System.exit(0);
    }//GEN-LAST:event_CloseAdminPanelMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ManageBooks books = new ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jPanel12.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:

        jPanel12.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        ViewRecords record = new ViewRecords();
        record.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:

        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jPanel14.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:

        jPanel14.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:

        jPanel15.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        jPanel15.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void CloseAdminPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseAdminPanelMouseEntered
        // TODO add your handling code here:

        CloseAdminPanel.setForeground(closeColor);
    }//GEN-LAST:event_CloseAdminPanelMouseEntered

    private void CloseAdminPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseAdminPanelMouseExited
        // TODO add your handling code here:
        CloseAdminPanel.setForeground(closeExitColor);
    }//GEN-LAST:event_CloseAdminPanelMouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        ManageStudents manageStudents = new ManageStudents();
        manageStudents.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        IssueBook book = new IssueBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        ReturnBook book = new ReturnBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        IssueBookDetails record = new IssueBookDetails();
        record.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        DefaulterList list = new DefaulterList();
        list.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(this, "Logged out successfully");
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseAdminPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issuedBooks;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JPanel panelPieChart;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private rojerusan.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
