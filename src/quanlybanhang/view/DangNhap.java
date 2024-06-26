package quanlybanhang.view;

import quanlybanhang.control.Program;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Taskbar;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import quanlybanhang.control.CheckInputMethod;
import static quanlybanhang.control.Program.con;
import quanlybanhang.model.NhatKy;
import quanlybanhang.model.TaiKhoan;

public class DangNhap extends javax.swing.JDialog {

    private static DangNhap Instance;
    private static String user;
    private static int access;
    private static KeyEventDispatcher keyEventDispatcher;

    public static int getAccess() {
        return access;
    }

    public static String getUser() {
        return user;
    }

    public DangNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(GiaoDienThuNgan.class.getResource("/asserts/icons-app.png")).getImage());
        this.setTitle("Quản lý nhà hàng");
        try {
            Taskbar.getTaskbar().setIconImage(new ImageIcon(GiaoDienThuNgan.class.getResource("/asserts/icons-app.png")).getImage());
        } catch (Exception e) {
            System.out.println("The OS does not support set Icon for Taskbar");
        }
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Xử lý sự kiện khi nhấn phím Enter
//                    System.out.println("Enter key pressed in dialog");
                    DangNhap();

                    closeAllOptionPanes(DangNhap.Instance);
                }
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }

    public static synchronized DangNhap getInstance() {
        if (Instance == null) {
            Instance = new DangNhap(null, true);
            Instance.setVisible(true);
        } else {
            Instance.setVisible(true);
        }
        return Instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UsernameTF = new javax.swing.JTextField();
        PasswordTF = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        DangNhapLabel = new javax.swing.JLabel();
        ThoatLabel = new javax.swing.JLabel();
        ForgetPwdBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(127, 199, 217));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        UsernameTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        UsernameTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tên đăng nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N
        UsernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTFActionPerformed(evt);
            }
        });

        PasswordTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N
        PasswordTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PasswordTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordTFMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 247, 201));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        DangNhapLabel.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        DangNhapLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DangNhapLabel.setText("Đăng nhập");
        DangNhapLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DangNhapLabel.setOpaque(true);
        DangNhapLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangNhapLabelMouseClicked(evt);
            }
        });

        ThoatLabel.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        ThoatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThoatLabel.setText("Thoát");
        ThoatLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThoatLabel.setOpaque(true);
        ThoatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThoatLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(DangNhapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(ThoatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DangNhapLabel, ThoatLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangNhapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThoatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DangNhapLabel, ThoatLabel});

        ForgetPwdBtn.setFont(new java.awt.Font("Helvetica", 2, 16)); // NOI18N
        ForgetPwdBtn.setForeground(new java.awt.Color(102, 167, 230));
        ForgetPwdBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ForgetPwdBtn.setText("<html><u>Quên mật khẩu</u></html>");
        ForgetPwdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForgetPwdBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(PasswordTF))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ForgetPwdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ForgetPwdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PasswordTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18)));

        jPanel3.setBackground(new java.awt.Color(249, 247, 201));

        jLabel1.setBackground(new java.awt.Color(249, 247, 201));
        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DangNhapLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangNhapLabelMouseClicked
        DangNhap();
    }//GEN-LAST:event_DangNhapLabelMouseClicked

    private void ThoatLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThoatLabelMouseClicked
        try {
            dispose();
            con.close();
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThoatLabelMouseClicked

    private void UsernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTFActionPerformed

    boolean isAlreadyOneClick = false;
    boolean hidePW = true;
    private void PasswordTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordTFMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                PasswordTF.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                PasswordTF.setEchoChar(ch);
                hidePW = true;
            }
            isAlreadyOneClick = false;
        } else {
            isAlreadyOneClick = true;
            Timer t = new Timer("doubleclickTimer", false);
            t.schedule(new TimerTask() {

                @Override
                public void run() {
                    isAlreadyOneClick = false;
                }
            }, 500);
        }
    }//GEN-LAST:event_PasswordTFMouseClicked

    private void ForgetPwdBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgetPwdBtnMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        JOptionPane.showMessageDialog(this, "Nếu bạn quên mật khẩu, vui lòng liên hệ quản trị viên.", "Quên mật khẩu", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_ForgetPwdBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DangNhapLabel;
    private javax.swing.JLabel ForgetPwdBtn;
    private javax.swing.JPasswordField PasswordTF;
    private javax.swing.JLabel ThoatLabel;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    //Kiểm tra có chứa ký tự đặc biệt
    public static boolean containsSpecialChars(JTextField TF) {
        String input = TF.getText();
        // Biểu thức chính quy kiểm tra xem có ký tự đặc biệt không
        String regex = ".*[\\p{P}].*";
        return Pattern.matches(regex, input);
    }

    //Kiểm tra chứa khoảng trắng
    public static boolean containsWhitespace(JTextField TF) {
        String input = TF.getText();
        // Biểu thức chính quy kiểm tra xem có khoảng trắng không
        String regex = ".*[\\s].*";
        return Pattern.matches(regex, input);
    }

    //Kiểm tra chứa tiếng Việt
    public static boolean containsVietnamese(JTextField TF) {
        String input = TF.getText();
        // Biểu thức chính quy kiểm tra xem có ký tự tiếng Việt không
        String regex = ".*[àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ].*";

        // Sử dụng phương thức matches() để kiểm tra
        return Pattern.matches(regex, input);
    }

//    private void DangNhap() {
//        Icon icon = new ImageIcon(DangNhap.class.getResource("/asserts/X-icon.png"));
//        if (UsernameTF.getText().equals("") || containsSpecialChars(UsernameTF) || containsWhitespace(UsernameTF) || containsVietnamese(UsernameTF) || UsernameTF.getText().length() > 10) {
////            JOptionPane.showMessageDialog(this, "Tên đăng nhập không hợp lệ, vui lòng kiểm tra lại",
////                "Lỗi tên đăng nhập", JOptionPane.ERROR_MESSAGE, icon);
//            UsernameTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Tên đăng nhập"));
//            return;
//        }
//        if (new String(PasswordTF.getPassword()).equals("") || !CheckInputMethod.isValidPass(new String(PasswordTF.getPassword()))) {
////            JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ, vui lòng kiểm tra lại",
////                "Lỗi mật khẩu", JOptionPane.ERROR_MESSAGE, icon);
//            PasswordTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Mật khẩu"));
//            return;
//        }
//
//        try {
//            user = UsernameTF.getText();
//            String pass = new String(PasswordTF.getPassword());
//            Statement s = con.createStatement();
//            String passwd = "";
//            ResultSet rs = s.executeQuery("SELECT passwd, access FROM htql_banhang.taikhoan where usname = '" + user + "';");
//            if (rs.next()) {
//                passwd = (String) rs.getString(1);
//                access = (int) rs.getInt(2);
//            } else {
//                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu chưa đúng, vui lòng kiểm tra lại",
//                        "Không thể đăng nhập", JOptionPane.ERROR_MESSAGE, icon);
//            }
//            s.close();
//
//            if (access == -1) {
//                JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị vô hiệu hóa, vui lòng liên hệ nhân viên quản lý.",
//                        "Tài khoản vô hiệu", JOptionPane.ERROR_MESSAGE, icon);
//                return;
//            }
//            if (pass.equals(passwd)) {
//                this.dispose();
//                NhatKy.writeLog("Đăng nhập", "Đăng nhập thành công");
//                WelcomeUI.getInstance();
//                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyEventDispatcher);
//            } else {
//                NhatKy.writeLog("Đăng nhập", "Đăng nhập không thành công");
//                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu chưa đúng, vui lòng kiểm tra lại",
//                        "Không thể đăng nhập", JOptionPane.ERROR_MESSAGE, icon);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Login unsuccessful!");
//            NhatKy.writeLog("Đăng nhập", "Lỗi đăng nhập");
//            JOptionPane.showMessageDialog(this, "Không thể đăng nhập, vui lòng kiểm tra lại",
//                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
//        }
//    }
    private void DangNhap() {
        Icon icon = new ImageIcon(DangNhap.class.getResource("/asserts/X-icon.png"));
        if (UsernameTF.getText().equals("") || containsSpecialChars(UsernameTF) || containsWhitespace(UsernameTF) || containsVietnamese(UsernameTF) || UsernameTF.getText().length() > 10) {
//            JOptionPane.showMessageDialog(this, "Tên đăng nhập không hợp lệ, vui lòng kiểm tra lại",
//                "Lỗi tên đăng nhập", JOptionPane.ERROR_MESSAGE, icon);
            UsernameTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Tên đăng nhập"));
            return;
        }
        if (new String(PasswordTF.getPassword()).equals("") || !CheckInputMethod.isValidPass(new String(PasswordTF.getPassword()))) {
//            JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ, vui lòng kiểm tra lại",
//                "Lỗi mật khẩu", JOptionPane.ERROR_MESSAGE, icon);
            PasswordTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Mật khẩu"));
            return;
        }
        try {

            user = UsernameTF.getText().trim();
            String pass = new String(PasswordTF.getPassword());
            access = TaiKhoan.DangNhap(user, pass);
            if (access != Integer.MIN_VALUE && access != -1) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyEventDispatcher);
                this.dispose();
                WelcomeUI.getInstance();
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: DangNhap - Method: DangNhap]");
        }
    }

    private static void closeAllOptionPanes(JDialog dia) {
        Window[] windows = dia.getOwnedWindows();
        for (Window ownedWindow : windows) {
            if (ownedWindow instanceof JDialog) {
                JDialog dialog = (JDialog) ownedWindow;
                Component[] components = dialog.getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JOptionPane) {
                        ownedWindow.dispose();
                        break;
                    }
                }
            }
        }
    }
}
