/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.model;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlybanhang.control.CheckInputMethod;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.ConnectDB;
import static quanlybanhang.control.Program.con;
import quanlybanhang.control.ThongKe;

/**
 *
 * @author Admin
 */
public class PhieuChi {

    private String MaPC;
    private String NoiDung;
    private Timestamp Time;
    private float SoTien;
    private String NhanVien;

    public String getMaPC() {
        return MaPC;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public Timestamp getTime() {
        return Time;
    }

    public float getSoTien() {
        return SoTien;
    }

    public String getNhanVien() {
        return NhanVien;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public PhieuChi(String ND, float Tien, String NV) {
        NoiDung = ND;
        SoTien = Tien;
        NhanVien = NV;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Time = new Timestamp(sdf.parse(Program.getTimeNow()).getTime());
        } catch (Exception ex) {
            System.out.println("Loi! [Class: PhieuChi - Method: Constructor]: Cannot parse timestamp!");
        }
    }
    
    public PhieuChi(String Ma, String ND, Timestamp time, float Tien, String NV) {
        MaPC = Ma;
        NoiDung = ND;
        SoTien = Tien;
        NhanVien = NV;
        Time = time;
    }

    public static ArrayList<PhieuChi> layDSphieuchi(){
        Program.ConnectDB();
        ConnectDB();
        ArrayList<PhieuChi> RL= new ArrayList<PhieuChi>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.phieuchi ORDER BY TGChi DESC;");
            while(rs.next()){
//                System.out.println(rs.getString(1) +" | "+ rs.getString(2)+ " | "+ Program.formatTimestamp(rs.getTimestamp(3)) +" | "+ rs.getInt(4)+" | "+rs.getString(5));
                RL.add(new PhieuChi(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi! [Class: Ban - Method: layDSban]");
            e.printStackTrace();
        }
        return RL;
    }
    
    public static ArrayList<PhieuChi> layDSphieuchi(String start, String end){
        Program.ConnectDB();
        ArrayList<PhieuChi> list = new ArrayList<PhieuChi>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT mapc AS id, noidungpc AS noidung, tgchi AS thoi_gian, sotien, usname "
                    + "FROM htql_banhang.phieuchi "
                    + "WHERE cast(TGChi as Date) BETWEEN '" + start + "' AND '" + end + "' ORDER BY TGChi DESC;");
            while(rs.next()){
                list.add(new PhieuChi(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getFloat(4), rs.getString(5)));
            }
            s.close();
        } catch (Exception e) {
            Icon icon = new ImageIcon(ThongKe.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: ThongKe - Method: layPhieuChi]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return new ArrayList<PhieuChi>();
        }
        return list;
    }
    
    public static boolean xoaPhieuChi(String MaPC){
        Program.ConnectDB();
        try {
            Statement s = con.createStatement();
            int rs = s.executeUpdate("DELETE FROM `htql_banhang`.`phieuchi` WHERE (`mapc` = '"+MaPC+"');");

            if (rs == 1) {
                NhatKy.writeLog("Xóa phiếu chi", "Xóa phiếu chi: " + MaPC);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: PhieuChi - Method: xoaPhieuChi]");
            Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
        }
        return false;
    }
    
    public static boolean themPhieuChi(String MaPC, String NoiDung, int SoTien, String user) {
        Program.ConnectDB();
        Icon icon = new ImageIcon(Ban.class.getResource("/asserts/X-icon.png"));
        if (CheckInputMethod.containsWhitespace(MaPC) || CheckInputMethod.containsVietnamese(MaPC) || MaPC.length() > 10) {
            JOptionPane.showMessageDialog(null, "Mã phiếu chi phải ít hơn 10 ký tự và không chứa dấu Tiếng Việt, dấu cách.",
                    "Lỗi mã phiếu chi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        if (NoiDung.equals("")) {
            JOptionPane.showMessageDialog(null, "Nội dung không được rỗng.",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
        try {
            Statement s = con.createStatement();
            if (MaPC.equals("")) {
                s.executeUpdate("INSERT INTO htql_banhang.phieuchi "
                        + "(NoiDungPC, SoTien, usname) VALUES (N'" + NoiDung + "','"+SoTien+"','"+user+"');");
                s.close();
                return true;
            } else {
                s.executeUpdate("INSERT INTO htql_banhang.phieuchi "
                        + "(MaPC, NoiDungPC, SoTien, usname) VALUES ('"+MaPC+"',N'" + NoiDung + "','"+SoTien+"','"+user+"');");
                s.close();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Loi! [Class: PhieuChi - Method: themPhieuChi]");
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return false;
        }
    }
}
