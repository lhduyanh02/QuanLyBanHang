/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

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
                con.close();
                Program.writeLog(0, DangNhap.user);
                System.exit(0);
            } catch (Exception ex) {
                System.out.println("Lỗi đóng chương trình");
            }
        }
    }
    
    private static void ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://115.74.233.26:33066/htql_banhang";
            String userDB = "user0";
            String passDB = "123Abc@@";
            con = DriverManager.getConnection(dbUrl, userDB, passDB);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Lỗi kết nối dữ liệu");
        }
    }

    public static Connection con;

    public static void writeLog(int x, String us) {
        try {
            // Lấy đường dẫn của thư mục làm việc hiện tại
            String workingDir = System.getProperty("user.dir");

            // Xây dựng đường dẫn đầy đủ đến tệp văn bản trong thư mục resources
            String filePath = workingDir + "/src/asserts/sign_in_log.txt";
            File file = new File(filePath);
            PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(), true));
            String str = "";
            if (x == 1) {
                str = "Đăng nhập tài khoản " + us + " thành công lúc " + getTimeNow();
            }
            if (x == 0) {
                str = "Đăng xuất tài khoản " + us + " lúc " + getTimeNow();
            }
            pw.println(str); //Đẩy data vào bộ nhớ đệm trong file
            pw.flush(); //Lưu file lại 
            pw.close();
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
//        new ThucDonMonAn().setVisible(true);
        ConnectDB();
        DangNhap.getInstance();
    }
}
