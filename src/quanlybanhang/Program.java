/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Program {
    
    private static void ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://115.74.233.26:33066/htql_banhang";
            String userDB = "user0";
            String passDB = "123Abc@@";
            con = DriverManager.getConnection(dbUrl, userDB, passDB);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Lỗi kết nối dữ liệu");
        }
    }
    
    public static Connection con;
    
    public static void main(String[] args) {
//        new ThucDonMonAn().setVisible(true);
        ConnectDB();
        DangNhap.getInstance();
    }
}
