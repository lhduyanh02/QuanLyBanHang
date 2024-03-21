/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quanlybanhang.control.Program.con;

/**
 *
 * @author Admin
 */
public class Ban {
    private static Ban instance;
    private String maban;
    private String tenban;
    private int trangthai;
    
    public Ban(String mb, String tb, int stt){
        maban = mb;
        tenban = tb;
        trangthai = stt;
    }
    
    public Ban(){
    }

    public String getMaban() {
        return maban;
    }

    public String getTenban() {
        return tenban;
    }

    public int getTrangthai() {
        return trangthai;
    }
    
    
    
    public static synchronized Ban getInstance() {
        if (instance == null) {
            instance = new Ban();
            return instance;
        } else {
            return instance;
        }
    }
    
    public static boolean themBan(String MaBan, String TenBan) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("");
            while(rs.next())
            s.executeUpdate("INSERT INTO htql_banhang.ban "
                    + "(maban, tenban) VALUES (N'" + MaBan + "', N'" + TenBan + "');");
            s.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: themBan]");
            Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }
    
//    public static ResultSet layDSban() {
//        ResultSet rs = null;
//        try {
//            Statement s = con.createStatement();
//            rs = s.executeQuery("SELECT * FROM htql_banhang.ban;");
//            return rs;
//        } catch (Exception e) {
//            System.out.println("Loi! [Class: Ban - Method: layDSban]");
//            e.printStackTrace();
//        }
//        return rs;
//    }
    
    public static ArrayList<Ban> layDSban() {
        ArrayList<Ban> ReturnList= new ArrayList<Ban>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban order by trangthai DESC;");
            while(rs.next()){
                ReturnList.add(new Ban(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: layDSban]");
            e.printStackTrace();
        }
        return ReturnList;
    }
}
