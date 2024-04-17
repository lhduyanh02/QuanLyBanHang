package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;

public class ChiTietHD {
    
    private String MaHD;
    private String MaSP;
    private int SoLuong;
    private float GiaSP;
    private float ThanhTien;
    
    public static boolean themChiTietHD(ChiTietHD c) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(ChiTietHD.class.getResource("/asserts/X-icon.png"));
        if (c.MaHD.equals("") || c.MaHD.isBlank() || c.MaHD.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã hóa đơn, không thể thêm món vào hóa đơn",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (c.MaSP.equals("") || c.MaSP.isBlank() || c.MaSP.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm, không thể thêm món vào hóa đơn",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CASE\n"
                    + " WHEN EXISTS (SELECT 1 FROM HoaDon WHERE MaHD = '" + c.MaHD + "' AND TrangThai = 0)"
                    + " AND EXISTS (SELECT 1 FROM SanPham WHERE MaSP = '" + c.MaSP + "' AND LoaiSP != -1)"
                    + " THEN 'true'"
                    + " ELSE 'false'"
                    + " END AS Result;");
            if (!rs.next() || !rs.getString(1).equals("true")) {
                JOptionPane.showMessageDialog(null, "Hóa đơn hoặc sản phẩm không hợp lệ, vui lòng kiểm tra lại",
                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                s.close();
                return false;
            } else {
                int AffectedRows = s.executeUpdate("INSERT INTO htql_banhang.chitiet_hd (MaHD, MaSP, SoLuong) "
                        + "VALUES ('" + c.MaHD + "', '" + c.MaSP + "', '" + c.SoLuong + "') ON DUPLICATE KEY UPDATE SoLuong = SoLuong + 1;;");
                if (AffectedRows == 0) {
                    JOptionPane.showMessageDialog(null, "Lỗi thêm món vào hóa đơn, hãy thử lại",
                            "Lỗi thêm món", JOptionPane.ERROR_MESSAGE, icon);
                    s.close();
                    return false;
                }
                s.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: ChiTietHD - Method: themChiTietHD]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }
    
    public static ArrayList<ChiTietHD> layChiTietHD(String mahd) {
        Program.ConnectDB();
        ArrayList<ChiTietHD> list = new ArrayList<ChiTietHD>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.chitiet_hd WHERE MaHD = '" + mahd + "';");
            while (rs.next()) {
                list.add(new ChiTietHD(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getFloat(4), rs.getFloat(5)));
            }
            s.close();
        } catch (Exception e) {
            Icon icon = new ImageIcon(ChiTietHD.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: ChiTietHD - Method: layChiTietHD]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể lấy chi tiết hóa đơn này!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new ArrayList<>();
        }
        return list;
    }
    
    public ChiTietHD(String MaHD, String MaSP, int SoLuong) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
    }
    
    public ChiTietHD(String MaHD, String MaSP, int SoLuong, float GiaSP, float ThanhTien) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.GiaSP = GiaSP;
        this.ThanhTien = ThanhTien;
    }
    
    public static void themSoLuong(String mahd, String masp) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(ChiTietHD.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int AffectedRows = s.executeUpdate("UPDATE htql_banhang.chitiet_hd "
                    + "SET SoLuong = SoLuong + 1 "
                    + "WHERE MaHD = '"+mahd+"' AND MaSP = '"+masp+"';");
            if(AffectedRows<1){
                JOptionPane.showMessageDialog(null, "Không thể thêm số lượng, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
            s.executeUpdate("DELETE FROM chitiet_hd WHERE MaHD = '"+mahd+"' AND SoLuong <= 0;");
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ChiTietHD - Method: themSoLuong]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Không thể thêm số lượng, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
    }
    
    public static void xoaChiTietHD(String mahd, String masp) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(ChiTietHD.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int AffectedRows = s.executeUpdate("DELETE FROM htql_banhang.chitiet_hd WHERE (MaHD = '"+mahd+"') and (MaSP = '"+masp+"');");
            if(AffectedRows<1){
                JOptionPane.showMessageDialog(null, "Không thể xóa, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ChiTietHD - Method: xoaChiTietHD]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Không thể xóa chi tiết hóa đơn, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
    }
    
    public static void giamSoLuong(String mahd, String masp) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(ChiTietHD.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int AffectedRows = s.executeUpdate("UPDATE htql_banhang.chitiet_hd "
                    + "SET SoLuong = SoLuong - 1 "
                    + "WHERE MaHD = '"+mahd+"' AND MaSP = '"+masp+"';");
            if(AffectedRows<1){
                JOptionPane.showMessageDialog(null, "Không thể thêm số lượng, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
            s.executeUpdate("DELETE FROM chitiet_hd WHERE MaHD = '"+mahd+"' AND SoLuong <= 0;");
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ChiTietHD - Method: giamSoLuong]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Không thể giảm số lượng, vui lòng tải lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
    }
    
    public String getMaHD() {
        return MaHD;
    }
    
    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    
    public String getMaSP() {
        return MaSP;
    }
    
    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    
    public int getSoLuong() {
        return SoLuong;
    }
    
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public float getGiaSP() {
        return GiaSP;
    }
    
    public void setGiaSP(float GiaSP) {
        this.GiaSP = GiaSP;
    }
    
    public float getThanhTien() {
        return ThanhTien;
    }
    
    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
}
