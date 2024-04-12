/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.DangNhap;

/**
 *
 * @author Admin
 */
public class NhatKy {

    private int id;
    private Timestamp time;
    private String user;
    private String action;
    private String description;

    public NhatKy(int id, Timestamp time, String user, String action, String description) {
        this.id = id;
        this.time = time;
        this.user = user;
        this.action = action;
        this.description = description;
    }

    public static ArrayList<String> getLogOf(String act) {
        Program.ConnectDB();
        ArrayList<String> list = new ArrayList<String>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.activity_log WHERE action = '" + act + "' ORDER BY id ASC;");
            while (rs.next()) {
                String str = "ID:" + rs.getInt(1) + " | Time:" + rs.getString(2) + " | User:"
                        + rs.getString(3) + " | " + "Action:" + rs.getString(4) + " | " + rs.getString(5) + ".\n";
                list.add(str);
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: NhatKy - Method: getLogOf]");
            Icon icon = new ImageIcon(NhatKy.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Không thể lấy nhật ký hoạt động!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            e.printStackTrace();
            return new ArrayList<String>();
        }
        return list;
    }
    public static ArrayList<String> getLog() {
        Program.ConnectDB();
        ArrayList<String> list = new ArrayList<String>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.activity_log ORDER BY id ASC;");
            while (rs.next()) {
                String str = "ID:" + rs.getInt(1) + " | Time:" + rs.getString(2) + " | User:"
                        + rs.getString(3) + " | " + "Action:" + rs.getString(4) + " | " + rs.getString(5) + "\n";
                list.add(str);
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: NhatKy - Method: getLog]");
            Icon icon = new ImageIcon(NhatKy.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Không thể lấy nhật ký tất cả hoạt động!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            e.printStackTrace();
            return new ArrayList<String>();
        }
        return list;
    }
    
    public static void writeLog(String act, String des){
        Program.ConnectDB();
        try {
            String us = DangNhap.getUser();
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO htql_banhang.activity_log (user, action, description) VALUES ('"+us+"', '"+act+"', '"+des+"');");
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: NhatKy - Method: writeLog]");
            Icon icon = new ImageIcon(NhatKy.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Không thể ghi nhật ký hoạt động!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            e.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAction() {
        Program.ConnectDB();
        ArrayList<String> actions = new ArrayList<>();

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT action from htql_banhang.activity_log;");

            while (rs.next()) {
                actions.add(rs.getString("action"));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: NhatKy - Method: getAction]");
            Icon icon = new ImageIcon(NhatKy.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Không thể lấy loại hoạt động!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            e.printStackTrace();
            return new ArrayList<String>();
        }
        return actions;
    }
}
