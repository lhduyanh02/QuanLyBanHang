package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.CheckInputMethod;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.QuanLyBan;

/**
 *
 * @author Admin
 */
public class Ban {

    private String maban;
    private String tenban;
    private String trangthai;

    public Ban(String mb, String tb, String stt) {
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

    public String getTrangthai() {
        return trangthai;
    }

    public static boolean themBan(String MaBan, String TenBan) {
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (CheckInputMethod.containsWhitespace(MaBan) || CheckInputMethod.containsVietnamese(MaBan) || MaBan.length() > 15) {
            JOptionPane.showMessageDialog(null, "Mã bàn phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Mã Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (TenBan.equals("") || TenBan.length() > 45) {
            JOptionPane.showMessageDialog(null, "Tên bàn không được rỗng và phải ít hơn 45 ký tự.",
                    "Lỗi Tên Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            if (MaBan.equals("")) {
                s.executeUpdate("INSERT INTO htql_banhang.ban "
                        + "(tenban) VALUES (N'" + TenBan + "');");
                s.close();
                NhatKy.writeLog("Bàn", "Thêm bàn mới với tên: " + TenBan);
                return true;
            } else {
                s.executeUpdate("INSERT INTO htql_banhang.ban "
                        + "(maban, tenban) VALUES (N'" + MaBan + "', N'" + TenBan + "');");
                s.close();
                NhatKy.writeLog("Bàn", "Thêm bàn mới với mã: " + MaBan + ", tên: " + TenBan);
                return true;
            }

        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: themBan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyBan.paintEditPanel();
            return false;
        }
    }

    public static boolean suaBan(String MBCu, Ban BanMoi) {
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (BanMoi.maban.equals("") || CheckInputMethod.containsWhitespace(BanMoi.maban) || CheckInputMethod.containsVietnamese(BanMoi.maban) || BanMoi.maban.length() > 15) {
            JOptionPane.showMessageDialog(null, "Mã bàn không được rỗng, phải ít hơn 15 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi Mã Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (BanMoi.tenban.equals("") || BanMoi.tenban.length() > 45) {
            JOptionPane.showMessageDialog(null, "Tên bàn phải ít hơn 45 ký tự.",
                    "Lỗi Tên Bàn", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT 1 FROM htql_banhang.ban WHERE maban = '"+MBCu+"' AND trangthai = 'free'");
            if(!r.next()){
                JOptionPane.showMessageDialog(null, "Bàn này hiện không thể sửa, hãy thử lại sau.",
                    "Không thể sửa", JOptionPane.ERROR_MESSAGE, icon);
            return false;
            }
//            int rs = s.executeUpdate("UPDATE htql_banhang.ban SET maban = N'" + BanMoi.maban + "', tenban = '" + BanMoi.tenban + "', trangthai = '" + BanMoi.trangthai + "' WHERE (maban = '" + MBCu + "');");
            int rs = s.executeUpdate("UPDATE htql_banhang.ban SET maban = N'" + BanMoi.maban + "', tenban = '" + BanMoi.tenban + "' WHERE (maban = '" + MBCu + "');");
            s.close();
            if (rs == 1) {
                NhatKy.writeLog("Bàn", "Sửa bàn " + MBCu + " -> " + BanMoi.maban +" - " + BanMoi.tenban);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: suaBan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyBan.paintEditPanel();
        }
        return false;
    }

    public static boolean xoaBan(String MaBan) {
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();

            ResultSet r = s.executeQuery("select trangthai from htql_banhang.ban where maban = '" + MaBan + "';");
            if (r.next()) {
                if (!r.getString(1).equals("free") || MaBan.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Bàn đang được sử dụng, không thể xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                    return false;
                }
            }

            int rs = s.executeUpdate("UPDATE `htql_banhang`.`ban` SET trangthai = '-1' WHERE (maban = '"+MaBan+"');");
            s.close();

            if (rs == 1) {
                NhatKy.writeLog("Bàn", "Xóa bàn: " + MaBan);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: xoaBan]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            QuanLyBan.paintEditPanel();
        }
        return false;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public static ArrayList<Ban> layDSban() {
        ArrayList<Ban> ReturnList = new ArrayList<Ban>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban WHERE trangthai <> '-1' order by tenban ASC;");
            while (rs.next()) {
                ReturnList.add(new Ban(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: layDSban]");
            e.printStackTrace();
        }
        return ReturnList;
    }
}
