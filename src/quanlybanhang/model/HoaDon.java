package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
        String NewInvoice = "";
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
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
                        + "WHERE usname = '" + DangNhap.getUser() + "' AND maban = '" + hd.MaBan + "' AND ChietKhau = '" + hd.ChietKhau + "' ORDER BY NgayLapHD Desc Limit 1;");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Không thể lấy được mã hóa đơn mới",
                            "Lỗi lấy mã hóa đơn", JOptionPane.ERROR_MESSAGE, icon);
                    s.close();
                    return "";
                } else {
                    NewInvoice = rs.getString(1);
                    s.executeUpdate("UPDATE htql_banhang.ban SET trangthai = '"+NewInvoice+"' WHERE (maban = '" + hd.MaBan + "');");
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
