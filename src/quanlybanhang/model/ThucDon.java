package quanlybanhang.model;

import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quanlybanhang.control.Program.con;

/**
 *
 * @author Admin
 */
public class ThucDon {

    private static ThucDon instance;

    public static synchronized ThucDon getInstance() {
        if (instance == null) {
            instance = new ThucDon();
            return instance;
        } else {
            return instance;
        }
    }

    public static boolean xoaMon(Object MaSP) {
        try {
            Statement s = con.createStatement();
            int rs = s.executeUpdate("UPDATE `htql_banhang`.`sanpham` SET loaiSP='-1' WHERE (`MaSP` = N'" + MaSP + "');");
            if (rs == 1) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xoá không thành công", "Xoá không thành công", JOptionPane.INFORMATION_MESSAGE);
            }
            s.close();
            return false;
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: xoaMon]");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean themMon(String MaSP, String TenSP, int GiaSP, int LoaiSP, String GhiChu) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO htql_banhang.sanpham "
                    + "(MaSP, TenSP, GiaSP, LoaiSP, GhiChu) VALUES (N'" + MaSP + "', N'" + TenSP + "', '" + GiaSP + "', '" + LoaiSP + "', N'" + GhiChu + "');");
            s.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: themMon]");
            Icon icon = new ImageIcon(ThucDon.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }

    public static boolean suaMon(String MaCu, String MaSP, String TenSP, int GiaSP, String GhiChu) {
        try {
            Statement s = con.createStatement();
            //UPDATE htql_banhang.sanpham SET MaSP = '" + MaSP + "', TenSP = N'" + TenSP + "', GiaSP = '" + GiaSP + "', GhiChu = N'" + GhiChu + "' WHERE (MaSP = '" + MaCu + "');
            s.executeUpdate("UPDATE htql_banhang.sanpham SET "
                    + "MaSP = '" + MaSP + "', TenSP = N'" + TenSP + "', GiaSP = '" + GiaSP + "', GhiChu = N'" + GhiChu + "' WHERE (MaSP = '" + MaCu + "');");
            s.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: themMon]");
            Icon icon = new ImageIcon(ThucDon.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }
}
