package quanlybanhang.model;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import quanlybanhang.control.CheckInputMethod;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.DangNhap;
import quanlybanhang.view.DoiMatKhau;
import quanlybanhang.view.QuanLyTaiKhoan;
import quanlybanhang.view.WelcomeUI;

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
        if (TK.username.equals("") || CheckInputMethod.containsWhitespace(TK.username) || CheckInputMethod.containsVietnamese(TK.username) || TK.username.length() > 15 || CheckInputMethod.containsSpecialChars(TK.username)) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách và các ký tự đặc biệt.",
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
        // Nếu mật khẩu chứa các ký tự đặc biệt
        if (!CheckInputMethod.isValidPass(TK.password)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không chứa các ký tự đặc biệt ngoại trừ @!#$%&, vui lòng kiểm tra lại",
                    "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            PreparedStatement s = con.prepareStatement("INSERT INTO htql_banhang.taikhoan "
                    + "(usname, passwd, access) VALUES (?, ?, ?);");
            s.setString(1, TK.username);
            s.setString(2, passwordHash(TK.password));
            s.setInt(3, TK.loai);
            s.executeUpdate();
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
            // Nếu mật khẩu chứa các ký tự đặc biệt
            if (!CheckInputMethod.isValidPass(TK.password)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không chứa các ký tự đặc biệt ngoại trừ @!#$%&, vui lòng kiểm tra lại",
                        "Lỗi Mật Khẩu", JOptionPane.ERROR_MESSAGE, icon);
                return false;
            }
        }

        try {
            PreparedStatement s;
            if (TK.password.equals("")) {
                s = con.prepareStatement("UPDATE htql_banhang.taikhoan SET usname = ?, access = ? WHERE (usname = ?);");
                s.setString(1, TK.username);
                s.setInt(2, TK.loai);
                s.setString(3, usname);
                int rs = s.executeUpdate();
                s.close();
                if (rs == 1) {
                    NhatKy.writeLog("Tài khoản", "Sửa tài khoản: " + usname + " -> " + TK.username + " - " + TK.loai);
                    return true;
                }
            } else {
                s = con.prepareStatement("UPDATE htql_banhang.taikhoan SET usname = ?, passwd = ?, access = ? WHERE (usname = ?);");
                s.setString(1, TK.username);
                s.setString(2, passwordHash(TK.password));
                s.setInt(3, TK.loai);
                s.setString(4, usname);
                int rs = s.executeUpdate();
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
            PreparedStatement s = con.prepareStatement("SELECT passwd FROM htql_banhang.taikhoan WHERE usname = ?;");
            int rs = 0;
            s.setString(1, usname);
            ResultSet r = s.executeQuery();
            r.next();
            String x = r.getString(1);
            if (x.equals(passwordHash(oldpass))) {
                s = con.prepareStatement("UPDATE htql_banhang.taikhoan SET passwd = ? WHERE (usname = ?);");
                s.setString(1, passwordHash(newpass));
                s.setString(2, usname);
                rs = s.executeUpdate();
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

    public static String passwordHash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pass.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : rbt) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: passwordHash]");
            e.printStackTrace();
        }
        return null;
    }

    public static int DangNhap(String us, String pass) {
        Icon icon = new ImageIcon(TaiKhoan.class.getResource("/asserts/X-icon.png"));
        try {
            Program.ConnectDB();
            PreparedStatement s = con.prepareStatement("SELECT passwd, access FROM htql_banhang.taikhoan WHERE usname = ?;");
            s.setString(1, us);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                String passwd = rs.getString(1);
                int access = rs.getInt(2);
                String HashedPass = passwordHash(pass);
                if (access != -1) {
                    if (passwd.equals(HashedPass)) {
                        WelcomeUI.getInstance();
                        NhatKy.writeLog("Đăng nhập", "Đăng nhập thành công");
                        return access;
                    } else {
                        final JDialog d = new JDialog();
                        d.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(d, "Tên đăng nhập hoặc mật khẩu chưa đúng, vui lòng kiểm tra lại",
                                "Không thể đăng nhập", JOptionPane.ERROR_MESSAGE, icon);
                        NhatKy.writeLog("Đăng nhập", "Đăng nhập không thành công");
                        return Integer.MIN_VALUE;
                    }
                } else {
                    final JDialog d = new JDialog();
                    d.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(d, "Tài khoản của bạn đã bị vô hiệu hóa, vui lòng liên hệ quản trị viên.",
                            "Tài khoản vô hiệu", JOptionPane.ERROR_MESSAGE, icon);
                    NhatKy.writeLog("Đăng nhập", "Tài khoản vô hiệu hóa đăng nhập");
                    return -1;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: TaiKhoan - Method: DangNhap]");
            NhatKy.writeLog("Đăng nhập", "Lỗi trong quá trình đăng nhập");
            final JDialog d = new JDialog();
            d.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(d, "Không thể đăng nhập, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }
}
