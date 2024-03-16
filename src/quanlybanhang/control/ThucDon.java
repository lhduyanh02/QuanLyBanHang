package quanlybanhang.control;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.ThucDonMonAn;

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

    public void xoaMon(Object MaSP) {
        try {
            Statement s = con.createStatement();
            int x = s.executeUpdate("DELETE FROM `htql_banhang`.`sanpham` WHERE (`MaSP` = N'" + MaSP + "');");
            if (x != 0) {
                JOptionPane.showMessageDialog(null, "Đã xoá " + x + " món", "Xoá thành công", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Xoá không thành công", "Xoá không thành công", JOptionPane.INFORMATION_MESSAGE);

            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: xoaMon]");
            e.printStackTrace();
        }
    }

    public void themMon(String MaSP, String TenSP, int GiaSP, int LoaiSP, String GhiChu) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO htql_banhang.sanpham "
                    + "(MaSP, TenSP, GiaSP, LoaiSP, GhiChu) VALUES (N'" + MaSP + "', N'" + TenSP + "', '" + GiaSP + "', '" + LoaiSP + "', N'" + GhiChu + "');");
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: themMon]");
            e.printStackTrace();
        }
    }
}
