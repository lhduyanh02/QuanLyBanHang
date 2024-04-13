package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;

public class ThucDon {

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getLoai() {
        return Loai;
    }

    public void setLoai(int Loai) {
        this.Loai = Loai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public ThucDon(String MaSP, String Ten, int Gia, int Loai, String GhiChu) {
        this.MaSP = MaSP;
        this.Ten = Ten;
        this.Gia = Gia;
        this.Loai = Loai;
        this.GhiChu = GhiChu;
    }


    private String MaSP;
    private String Ten;
    private int Gia;
    private int Loai;
    private String GhiChu;

    public static boolean xoaMon(Object MaSP) {
        Program.ConnectDB();
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
        Program.ConnectDB();
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
        Program.ConnectDB();
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
    
    public static List<ThucDon> layDSThucDon(int loai){
        Program.ConnectDB();
        List<ThucDon> list = new ArrayList<ThucDon>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.sanpham WHERE loaisp = "+loai+";");
            while(rs.next()){
                list.add(new ThucDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: layDSThucDon]");
            e.printStackTrace();
        }
        return list;
    }
    
    public static ArrayList<ThucDon> layDSThucDon(){
        Program.ConnectDB();
        ArrayList<ThucDon> list = new ArrayList<ThucDon>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.sanpham WHERE loaisp <> -1");
            while(rs.next()){
                list.add(new ThucDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThucDon - Method: layDSThucDon]");
            e.printStackTrace();
        }
        return list;
    }
}
