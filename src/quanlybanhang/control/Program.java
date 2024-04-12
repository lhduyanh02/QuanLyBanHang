/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import quanlybanhang.model.NhatKy;
import quanlybanhang.view.DangNhap;

/**
 *
 * @author Admin
 */
public class Program {

    public static Connection con;

    public static class SharedMouseListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            ((JLabel) e.getSource()).setBackground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((JLabel) e.getSource()).setBackground(new Color(242, 242, 242));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ((JLabel) e.getSource()).setBorder((javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ((JLabel) e.getSource()).setBorder((javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        }
    }

    public static Properties ReadFileProperties() {
        Properties properties = new Properties();
        try {
//            properties.load(new FileInputStream("src/properties/Setting.properties"));
            properties.load(Program.class.getResourceAsStream("/properties/Setting.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void closeApp() {
        if (JOptionPane.showConfirmDialog(null,
                "Are you sure you want to close this window?", "Close Window?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                NhatKy.writeLog("Đăng xuất", "Đăng xuất thành công");
                con.close();
                System.exit(0);
            } catch (Exception ex) {
                System.out.println("Lỗi đóng chương trình");
            }
        }
    }

    public static void ConnectDB() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                Properties prop = ReadFileProperties();
                String dbUrl = prop.getProperty("DBURL");
                String userDB = prop.getProperty("DBusername");
                String passDB = prop.getProperty("DBpassword");
                con = DriverManager.getConnection(dbUrl, userDB, passDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi kết nối dữ liệu");
            Icon icon = new ImageIcon(Program.class.getResource("/asserts/X-icon.png"));
            System.out.println("Loi! [Class: Program - Method: ConnectDB]");
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại kết nối Internet và cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
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

    public static String formatTimestamp(Timestamp timestamp) {
        // Tạo đối tượng Date từ timestamp
        Date date = new Date(timestamp.getTime());

        // Định dạng lại timestamp theo định dạng mới
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDate(Date date) { //Dùng để truyền vào so sánh trong Mysql 
        // Định dạng lại timestamp theo định dạng mới
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        ConnectDB();
        if (con != null) {
            DangNhap.getInstance();
        }
        //Bắt sự kiện kill process
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            Program.writeLog(0, DangNhap.user);
//        }));
    }
}
