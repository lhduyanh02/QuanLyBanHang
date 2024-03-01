/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.control;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlybanhang.view.DangNhap;

/**
 *
 * @author Admin
 */
public class Program {

    public static void closeApp() {
        if (JOptionPane.showConfirmDialog(null,
                "Are you sure you want to close this window?", "Close Window?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Program.writeLog(0, DangNhap.user);
                con.close();
                System.exit(0);
            } catch (Exception ex) {
                System.out.println("Lỗi đóng chương trình");
            }
        }
    }

    private static void ConnectDB() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                String dbUrl = "jdbc:mysql://115.74.233.26:33066/htql_banhang";
                String userDB = "user0";
                String passDB = "123Abc@@";
                con = DriverManager.getConnection(dbUrl, userDB, passDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi kết nối dữ liệu");
        }
    }

    public static Connection con;

    public static void writeLog(int x, String us) {
//        Statement s;
//        try {
//            s = con.createStatement();
//            ResultSet rs = s.executeQuery("SELECT sign_log FROM htql_banhang.app_conf where IDConf = 0;");
//            rs.next();
//            String str = rs.getString(1);
//            System.out.println(str);
//        } catch (SQLException ex) {
//            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
//        }

//UPDATE app_conf
//SET sign_log = CONCAT('First\n', sign_log)
//WHERE IDConf = 0;
//        try {
//            // Lấy đường dẫn của thư mục làm việc hiện tại
//            String workingDir = System.getProperty("user.dir");
//
//            // Xây dựng đường dẫn đầy đủ đến tệp văn bản trong thư mục resources
//            String filePath = workingDir + "/src/asserts/sign_in_log.txt";
//            File file = new File(filePath);
//            PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(), true));
//            String str = "";
//            if (x == 1) {
//                str = "Đăng nhập tài khoản " + us + " thành công lúc " + getTimeNow();
//            }
//            if (x == 0) {
//                str = "Đăng xuất tài khoản " + us + " lúc " + getTimeNow();
//            }
//            pw.println(str); //Đẩy data vào bộ nhớ đệm trong file
//            pw.flush(); //Lưu file lại 
//            pw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            String str = "";
            if (x == 1) {
                str = "Đăng nhập tài khoản " + us + " thành công lúc " + getTimeNow();
            }
            if (x == 0) {
                str = "Đăng xuất tài khoản " + us + " lúc " + getTimeNow();
            }

            Statement s = con.createStatement();
            s.executeUpdate("UPDATE app_conf\n"
                    + "SET sign_log = CONCAT('"+ str +"\\n', sign_log)\n"
                    + "WHERE IDConf = 0;");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTimeNow() {
        // Lấy múi giờ "Asia/Ho_Chi_Minh"
        ZoneId VNTimeZone = ZoneId.of("Asia/Ho_Chi_Minh");

        // Lấy thời gian hiện tại theo múi giờ "Asia/Ho_Chi_Minh"
        ZonedDateTime zonedDateTime = ZonedDateTime.now(VNTimeZone);

        // Định dạng thời gian sử dụng DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return formatter.format(zonedDateTime);
    }

    public static void main(String[] args) {
        ConnectDB();
        DangNhap.getInstance();
        
        //Bắt sự kiện kill process
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            Program.writeLog(0, DangNhap.user);
//        }));
    }
}