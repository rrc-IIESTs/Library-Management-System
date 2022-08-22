/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author R R Chauhan
 */

public class DBConnection {
    static Connection con =null;
    public static Connection getConnection(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","Chemath@0078");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
