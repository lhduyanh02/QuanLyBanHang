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
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.DoiMatKhau;
import quanlybanhang.view.QuanLyTaiKhoan;

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
        Program.ConnectDB();
        Icon icon = new ImageIcon(TaiKhoan.class.getResource("/asserts/X-icon.png"));
        if (TK.username.equals("") || CheckInputMethod.containsWhitespace(TK.username) || CheckInputMethod.containsVietnamese(TK.username) || TK.username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Tên Đăng Nhập", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
            return false;
        }
        if (TK.password.equals("") || TK.password.length() > 30 || TK.password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải lớn hơn 6 ký tự và ít hơn 30 ký tự.",
                    "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
            return false;
        }
        try {
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO htql_banhang.taikhoan "
                    + "(usname, passwd, access) VALUES (N'" + TK.username + "', N'" + TK.password + "', '" + TK.loai + "');");
            s.close();
            NhatKy.writeLog("Tài khoản", "Thêm tài khoản: " + TK.username + " - Loại: " + TK.loai);
            return true;

        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: themTK]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
            return false;
        }
    }

    public static boolean suaTaiKhoan(String usname, TaiKhoan TK) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(TaiKhoan.class.getResource("/asserts/X-icon.png"));
        if (TK.username.equals("") || CheckInputMethod.containsWhitespace(TK.username) || CheckInputMethod.containsVietnamese(TK.username) || TK.username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Tên Đăng Nhập", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
            return false;
        }
        // Nếu người dùng đổi mật khẩu
        if (!TK.password.equals("")) {
            if (TK.password.length() > 30 || TK.password.length() < 6) {
                JOptionPane.showMessageDialog(null, "Mật khẩu mới phải lớn hơn 6 ký tự và ít hơn 30 ký tự.",
                        "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
                QuanLyTaiKhoan.paintEditPanel();
                return false;
            }
        }

        try {
            Statement s = con.createStatement();
            if (TK.password.equals("")) {
                int rs = s.executeUpdate("UPDATE htql_banhang.taikhoan SET usname = N'" + TK.username + "', access = '" + TK.loai + "' WHERE (usname = '" + usname + "');");
                s.close();
                if (rs == 1) {
                    NhatKy.writeLog("Tài khoản", "Sửa tài khoản: " + usname + " -> " + TK.username + " - " + TK.loai);
                    return true;
                }
            } else {
                int rs = s.executeUpdate("UPDATE htql_banhang.taikhoan SET usname = N'" + TK.username + "', passwd = '" + TK.password + "', access = '" + TK.loai + "' WHERE (usname = '" + usname + "');");
                s.close();
                if (rs == 1) {
                    NhatKy.writeLog("Tài khoản", "Sửa tài khoản và mật khẩu: " + usname + " -> " + TK.username + " - " + TK.loai);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: suaTaiKhoan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
        }
        return false;
    }

    public static boolean vohieuhoa(String usname) {
        Program.ConnectDB();
        try {
            Statement s = con.createStatement();
            int rs = s.executeUpdate("UPDATE `htql_banhang`.`taikhoan` SET `access` = '-1' WHERE (`usname` = '" + usname + "');");
            s.close();
            if (rs == 1) {
                NhatKy.writeLog("Tài khoản", "Vô hiệu hóa tài khoản: " + usname);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: vohieuhoa]");
            Icon icon = new ImageIcon(TaiKhoan.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyTaiKhoan.paintEditPanel();
        }
        return false;
    }

    public static ArrayList<TaiKhoan> layDSTaiKhoan() {
        Program.ConnectDB();
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

    public static boolean doiMatKhau(String usname, String oldpass, String newpass) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(TaiKhoan.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int rs = 0;
            ResultSet r = s.executeQuery("SELECT passwd FROM htql_banhang.taikhoan WHERE usname = '" + usname + "';");
            r.next();
            String x = r.getString(1);
            if (x.equals(oldpass)) {
                rs = s.executeUpdate("UPDATE htql_banhang.taikhoan SET passwd = '" + newpass + "' WHERE (usname = '" + usname + "');");
                s.close();
            } else {
                JOptionPane.showMessageDialog(DoiMatKhau.getInstance(), "Sai mật khẩu, vui lòng kiểm tra lại!", "Sai mật khẩu", JOptionPane.ERROR_MESSAGE, icon);
                return false;
            }
            if (rs == 1) {
                NhatKy.writeLog("Tài khoản", "Đổi mật khẩu tài khoản: " + usname);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: doiMatKhau]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            e.printStackTrace();
        }
        return false;
    }
}
