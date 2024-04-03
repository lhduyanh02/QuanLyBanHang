/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.CheckInputMethod;
import static quanlybanhang.control.Program.con;

/**
 *
 * @author nguyenthituyetngan
 */
public class TaiKhoan {

    private String username;
    private String password;
    private int loai;

    public TaiKhoan(String us, String pw, int l) {
        username = us;
        password = pw;
        loai = l;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public static boolean themTK(TaiKhoan TK) {
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (TK.username.equals("") || CheckInputMethod.containsWhitespace(TK.username) || CheckInputMethod.containsVietnamese(TK.username) || TK.username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Tên Đăng Nhập", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (TK.password.equals("") || TK.password.length() > 30 || TK.password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải lớn hơn 6 ký tự và ít hơn 30 ký tự.",
                    "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO htql_banhang.taikhoan "
                    + "(usname, passwd, access) VALUES (N'" + TK.username + "', N'" + TK.password + "', '" + TK.loai + "');");
            s.close();
            return true;

        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: themTK]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }

    public static boolean suaTaiKhoan(String usname, TaiKhoan TK) {
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (TK.username.equals("") || CheckInputMethod.containsWhitespace(TK.username) || CheckInputMethod.containsVietnamese(TK.username) || TK.username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Tên Đăng Nhập", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        // Nếu người dùng đổi mật khẩu
        if (!TK.password.equals("")) {
            if (TK.password.length() > 30 || TK.password.length() < 6) {
                JOptionPane.showMessageDialog(null, "Mật khẩu mới phải lớn hơn 6 ký tự và ít hơn 30 ký tự.",
                        "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
                return false;
            }
        }

        try {
            Statement s = con.createStatement();
            if (TK.password.equals("")) {
                int rs = s.executeUpdate("UPDATE htql_banhang.taikhoan SET usname = N'" + TK.username + "', access = '" + TK.loai + "' WHERE (usname = '" + usname + "');");
                s.close();
                if (rs == 1) {
                    return true;
                }
            } else {
                int rs = s.executeUpdate("UPDATE htql_banhang.taikhoan SET usname = N'" + TK.username + "', passwd = '" + TK.password + "', access = '" + TK.loai + "' WHERE (usname = '" + usname + "');");
                s.close();
                if (rs == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: suaTaiKhoan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
        }
        return false;
    }

    public static boolean vohieuhoa(String usname) {
        try {
            Statement s = con.createStatement();
            int rs = s.executeUpdate("UPDATE `htql_banhang`.`taikhoan` SET `access` = '-1' WHERE (`usname` = '" + usname + "');");
            s.close();
            if (rs == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: vohieuhoa]");
            Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
        }
        return false;
    }
    
    public static ArrayList<TaiKhoan> layDSTaiKhoan() {
        ArrayList<TaiKhoan> ReturnList = new ArrayList<TaiKhoan>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.taikhoan order by usname ASC;");
            while (rs.next()) {
                ReturnList.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: layDSTaiKhoan]");
            e.printStackTrace();
        }
        return ReturnList;
    }
}
