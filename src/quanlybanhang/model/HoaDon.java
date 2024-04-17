package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.DangNhap;
import quanlybanhang.view.GiaoDienThuNgan;

public class HoaDon {

    private String MaHD;
    private String usname;
    private int TrangThai;
    private String GhiChu;
    private String MaBan;
    private float TongTien;
    private float ChietKhau;
    private float TongThanhToan;
    private Timestamp NgayLapHD;

    public HoaDon() {
    }

    public HoaDon(String MaHD, int TrangThai, String GhiChu, String MaBan, float TongTien, float ChietKhau, Timestamp NgayLapHD) {
        this.MaHD = MaHD;
        this.usname = DangNhap.getUser();
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
        this.MaBan = MaBan;
        this.TongTien = TongTien;
        this.ChietKhau = ChietKhau;
        this.TongThanhToan = TongTien - (TongTien * ChietKhau / 100);
        this.NgayLapHD = NgayLapHD;
    }

    public HoaDon(String GhiChu, String MaBan, float ChietKhau) {
        this.MaHD = "";
        this.usname = DangNhap.getUser();
        this.TrangThai = 0;
        this.GhiChu = GhiChu;
        this.MaBan = MaBan;
        this.ChietKhau = ChietKhau;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            this.NgayLapHD = new Timestamp(sdf.parse(Program.getTimeNow()).getTime());
        } catch (ParseException ex) {
            System.out.println("Loi convert timestamp tai constructor class HoaDon");
            ex.printStackTrace();
        }
    }

    public static String taoHoaDon(HoaDon hd) {
        Program.ConnectDB();
        String NewInvoice = "";
        Icon icon = new ImageIcon(HoaDon.class.getResource("/asserts/X-icon.png"));
        if (hd.MaBan.equals("") || hd.MaBan.isBlank() || hd.MaBan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã bàn, không thể tạo hóa đơn",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return "";
        }
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban WHERE maban = '" + hd.MaBan + "' AND trangthai = 'free';");
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Bàn này không có sẵn, không thể tạo hóa đơn",
                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                s.close();
                return "";
            } else {
                int AffectedRows = s.executeUpdate("INSERT INTO htql_banhang.hoadon (usname, maban, ChietKhau)"
                        + " VALUES ('" + DangNhap.getUser() + "', '" + hd.MaBan + "', '" + hd.ChietKhau + "');");
                if (AffectedRows == 0) {
                    JOptionPane.showMessageDialog(null, "Không tạo được hóa đơn, hãy thử lại",
                            "Lỗi tạo hóa đơn", JOptionPane.ERROR_MESSAGE, icon);
                    s.close();
                    return "";
                }
                rs = s.executeQuery("SELECT MaHD FROM htql_banhang.hoadon "
                        + "WHERE usname = '" + DangNhap.getUser() + "' AND maban = '" + hd.MaBan + "' AND ChietKhau = '" + hd.ChietKhau + "' AND TrangThai = '0' ORDER BY NgayLapHD Desc Limit 1;");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Không thể lấy được mã hóa đơn mới",
                            "Lỗi lấy mã hóa đơn", JOptionPane.ERROR_MESSAGE, icon);
                    s.close();
                    return "";
                } else {
                    NewInvoice = rs.getString(1);
                    s.executeUpdate("UPDATE htql_banhang.ban SET trangthai = '" + NewInvoice + "' WHERE (maban = '" + hd.MaBan + "');");
                }
                GiaoDienThuNgan.reloadTableList(GiaoDienThuNgan.getSelectedBan());
                s.close();
                System.out.println(NewInvoice);
                return NewInvoice;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: HoaDon - Method: taoHoaDon]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return "";
        }
    }

    public static HoaDon layThongTinHD(String mahd) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(HoaDon.class.getResource("/asserts/X-icon.png"));
        HoaDon hd = new HoaDon();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.hoadon WHERE MaHD = '" + mahd + "';");
            if (rs.next()) {
                hd.setMaHD(rs.getString(1));
                hd.setUsname(rs.getString(2));
                hd.setTrangThai(rs.getInt(3));
                hd.setGhiChu(rs.getString(4));
                hd.setMaBan(rs.getString(5));
                hd.setTongTien(rs.getFloat(6));
                hd.setChietKhau(rs.getFloat(7));
                hd.setTongThanhToan(rs.getFloat(8));
                hd.setNgayLapHD(rs.getTimestamp(9));
            } else {
                JOptionPane.showMessageDialog(null,
                        "Không tìm thấy mã hóa đơn", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
            s.close();

        } catch (Exception e) {
            System.out.println("Loi! [Class: HoaDon - Method: layThongTinHD]");
            JOptionPane.showMessageDialog(null,
                    "Không thể lấy thông tin hóa đơn", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new HoaDon();
        }
        return hd;
    }

    public void capNhatGhiChu(String note) {
        if (this == null) {
            return;
        }
        Program.ConnectDB();
        Icon icon = new ImageIcon(HoaDon.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int AffectedRows = s.executeUpdate("UPDATE `htql_banhang`.`hoadon` SET "
                    + "`GhiChu` = '" + note + "' WHERE (`MaHD` = '" + this.getMaHD() + "');");
            if (AffectedRows != 1) {
                JOptionPane.showMessageDialog(null,
                        "Không thể cập nhật ghi chú", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: HoaDon - Method: capNhatGhiChu]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Không thể cập nhật ghi chú", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
    }

    public void capNhatChietKhau(float discount) {
        if (this == null) {
            return;
        }
        Program.ConnectDB();
        Icon icon = new ImageIcon(HoaDon.class.getResource("/asserts/X-icon.png"));
        try {
            Statement s = con.createStatement();
            int AffectedRows = s.executeUpdate("UPDATE `htql_banhang`.`hoadon` SET "
                    + "`ChietKhau` = '" + discount + "' WHERE (`MaHD` = '" + this.getMaHD() + "');");
            if (AffectedRows != 1) {
                JOptionPane.showMessageDialog(null,
                        "Không thể cập nhật chiết khấu", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: HoaDon - Method: capNhatChietKhau]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Không thể cập nhật chiết khấu", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
    }

    public static void doiBan(HoaDon hd, String MBmoi) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(HoaDon.class.getResource("/asserts/X-icon.png"));
//        try {
//            Statement s = con.createStatement();
//            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban WHERE maban = '" + MBmoi + "' AND trangthai = 'free';");
//            if(!rs.next()){
//                JOptionPane.showMessageDialog(null, "Bàn này không có sẵn, không thể chuyển bàn",
//                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
//                s.close();
//                return;
//            }
//            int AffectedRows = s.executeUpdate("UPDATE htql_banhang.hoadon "
//                    + "SET maban = '"+MBmoi+"' WHERE (MaHD = '"+hd.getMaHD()+"');");
//            if (AffectedRows!=1) {
//                JOptionPane.showMessageDialog(null, "Đổi bàn không thành công, hãy thử lại sau!",
//                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
//                s.close();
//                return;
//            } else{
//                AffectedRows = s.executeUpdate("UPDATE htql_banhang.ban SET trangthai = '"+hd.getMaHD()+"' WHERE (maban = '"+MBmoi+"');");
//            }
//        } catch (Exception e) {
//        }

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.ban WHERE maban = '" + MBmoi + "' AND trangthai = 'free';");
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Bàn này không có sẵn, không thể chuyển bàn",
                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                return;
            }
            s.close();
            try {
                con.setAutoCommit(false);
                s = con.createStatement();
                s.executeUpdate("UPDATE htql_banhang.ban SET trangthai = 'free' WHERE (maban = '"+hd.getMaBan()+"');");
                s.executeUpdate("UPDATE htql_banhang.hoadon "
                    + "SET maban = '"+MBmoi+"' WHERE (MaHD = '"+hd.getMaHD()+"');");
                s.executeUpdate("UPDATE htql_banhang.ban SET trangthai = '"+hd.getMaHD()+"' WHERE (maban = '"+MBmoi+"');");
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            }finally{
                con.setAutoCommit(true);
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: HoaDon - Method: doiBan]");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Không thể đổi bàn", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;

        }
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public float getChietKhau() {
        return ChietKhau;
    }

    public void setChietKhau(float ChietKhau) {
        this.ChietKhau = ChietKhau;
    }

    public float getTongThanhToan() {
        return TongThanhToan;
    }

    public void setTongThanhToan(float TongThanhToan) {
        this.TongThanhToan = TongThanhToan;
    }

    public Timestamp getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(Timestamp NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }
}
