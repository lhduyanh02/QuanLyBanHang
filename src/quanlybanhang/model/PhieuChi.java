/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.model;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.ConnectDB;
import static quanlybanhang.control.Program.con;

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

//    public static void main(String[] args) {
//        PhieuChi a = new PhieuChi("AAA", 500000, "a");
//        System.out.println("ND: "+ a.NoiDung +"\nSo tien: "+ a.Time + "\nNhanVien: "+a.NhanVien);
//        
////        try {
////            ConnectDB();
////            Statement s = con.createStatement();
////
////            Timestamp t;
////            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
////            t = new Timestamp(sdf.parse(Program.getTimeNow()).getTime());
////            System.out.println(t);
////            int x = s.executeUpdate("INSERT INTO htql_banhang.phieuchi (NoiDungPC, TGChi, SoTien, User) VALUES ('aazx', '" + t.toString() + "', '5000', 'a');");
////            if (x != 0) {
////                System.out.println("updated 1 row");
////            }
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
//    }
}
