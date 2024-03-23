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
import quanlybanhang.control.CheckInputMethod;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.AddDialog;
import static quanlybanhang.view.AddDialog.containsSpecialChars;
import static quanlybanhang.view.AddDialog.containsVietnamese;
import static quanlybanhang.view.AddDialog.containsWhitespace;

/**
 *
 * @author Admin
 */
public class Ban {

    private static Ban instance;
    private String maban;
    private String tenban;
    private int trangthai;

    public Ban(String mb, String tb, int stt) {
        maban = mb;
        tenban = tb;
        trangthai = stt;
    }

    public Ban() {
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
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (CheckInputMethod.containsWhitespace(MaBan) || CheckInputMethod.containsVietnamese(MaBan) || TenBan.length() > 10) {
            JOptionPane.showMessageDialog(null, "Mã bàn phải ít hơn 10 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Mã Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (TenBan.equals("") || TenBan.length() > 45) {
            JOptionPane.showMessageDialog(null, "Tên bàn phải ít hơn 45 ký tự.",
                    "Lỗi Tên Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            if (MaBan.equals("")) {
                s.executeUpdate("INSERT INTO htql_banhang.ban "
                        + "(tenban) VALUES (N'" + TenBan + "');");
                s.close();
                return true;
            } else {
                s.executeUpdate("INSERT INTO htql_banhang.ban "
                        + "(maban, tenban) VALUES (N'" + MaBan + "', N'" + TenBan + "');");
                s.close();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: themBan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }

    public static int suaBan(String MBCu, String MBMoi, String TBMoi, int TTMoi) {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
        ArrayList<Ban> ReturnList = new ArrayList<Ban>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban order by trangthai DESC;");
            while (rs.next()) {
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
