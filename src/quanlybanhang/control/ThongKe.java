/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.control;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quanlybanhang.control.Program.con;

/**
 *
 * @author Admin
 */
public class ThongKe {

    private String ID;
    private String NoiDung;
    private String ThoiGian;
    private int SoTien;
    private String NguoiTao;

    public ThongKe(String id, String nd, Timestamp time, float tien, String us) {
        ID = id;
        NoiDung = nd;
        ThoiGian = Program.formatTimestamp(time);
        SoTien = (int) tien;
        NguoiTao = us;
    }

    public String getID() {
        return ID;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public int getSoTien() {
        return SoTien;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public static ArrayList<ThongKe> layThongKe(String start, String end) {
        ArrayList<ThongKe> list = new ArrayList<ThongKe>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT mahd AS id, '- HÓA ĐƠN -' AS noidung, ngaylaphd AS thoi_gian, tongthanhtoan AS sotien, usname "
                    + "FROM hoadon WHERE CAST(ngaylaphd AS DATE) BETWEEN '" + start + "' AND '" + end + "' "
                    + "UNION ALL\n"
                    + "SELECT mapc AS id, noidungpc AS noidung, tgchi AS thoi_gian, sotien, usname "
                    + "FROM phieuchi WHERE CAST(tgchi AS DATE) BETWEEN '" + start + "' AND '" + end + "' "
                    + "ORDER BY thoi_gian DESC;");
            while(rs.next()){
                list.add(new ThongKe(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getFloat(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            Icon icon = new ImageIcon(ThongKe.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: ThongKe - Method: layThongKe]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new ArrayList<ThongKe>();
        }
        return list;
    }

    public static ArrayList<ThongKe> layPhieuThu(String start, String end) {
        ArrayList<ThongKe> list = new ArrayList<ThongKe>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MaHD, '- HÓA ĐƠN -' as noidung,  NgayLapHD, TongThanhToan, usname "
                    + "FROM htql_banhang.hoadon "
                    + "WHERE cast(NgayLapHD as Date) BETWEEN '"+start+"' AND '"+end+"' AND TrangThai='1' ORDER BY NgayLapHD DESC;");
            while(rs.next()){
                list.add(new ThongKe(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getFloat(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            Icon icon = new ImageIcon(ThongKe.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: ThongKe - Method: layPhieuThu]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new ArrayList<ThongKe>();
        }
        return list;
    }

    public static ArrayList<ThongKe> layPhieuChi(String start, String end) {
        ArrayList<ThongKe> list = new ArrayList<ThongKe>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * "
                    + "FROM htql_banhang.phieuchi "
                    + "WHERE cast(TGChi as Date) BETWEEN '" + start + "' AND '" + end + "' ORDER BY TGChi DESC;");
            while(rs.next()){
                list.add(new ThongKe(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getFloat(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            Icon icon = new ImageIcon(ThongKe.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: ThongKe - Method: layPhieuChi]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new ArrayList<ThongKe>();
        }
        return list;
    }
}
