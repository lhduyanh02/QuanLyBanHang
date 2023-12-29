/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang;

import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class Program {
    
    //CHẠY CHƯƠNG TRÌNH QUẢN LÝ BÁN HÀNG
    public static Connection con;
    
    public static void main(String[] args) {
        new ThucDon().setVisible(true);
    }
}
