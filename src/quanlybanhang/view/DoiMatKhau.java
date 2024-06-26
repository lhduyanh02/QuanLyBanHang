package quanlybanhang.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import quanlybanhang.control.CheckInputMethod;
import quanlybanhang.control.Program;
import quanlybanhang.model.TaiKhoan;
import static quanlybanhang.view.DangNhap.containsVietnamese;

public class DoiMatKhau extends javax.swing.JDialog {

    private static DoiMatKhau instance;
    private boolean isAlreadyOneClick = false;
    private boolean hidePW = true;

    public static synchronized DoiMatKhau getInstance() {
        if (instance == null) {
            instance = new DoiMatKhau(null, true);
            instance.resetPwd();
            instance.setVisible(true);
            Program.ConnectDB();
        } else {
            instance.resetPwd();
            instance.setVisible(true);
            Program.ConnectDB();
        }
        return instance;
    }

    public DoiMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void resetPwd() {
        OldPass.setText("");
        NewPass.setText("");
        ConfirmPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        OldPass = new javax.swing.JPasswordField();
        NewPass = new javax.swing.JPasswordField();
        ConfirmPass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        ConfirmBtn = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 247, 201));

        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        OldPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OldPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật khẩu hiện tại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N
        OldPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OldPassMouseClicked(evt);
            }
        });

        NewPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NewPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật khẩu mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N
        NewPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewPassMouseClicked(evt);
            }
        });

        ConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConfirmPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập lại mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N
        ConfirmPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(OldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(249, 247, 201));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        ConfirmBtn.setBackground(new java.awt.Color(240, 240, 240));
        ConfirmBtn.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        ConfirmBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConfirmBtn.setText("Xác nhận");
        ConfirmBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConfirmBtn.setOpaque(true);
        ConfirmBtn.setPreferredSize(new java.awt.Dimension(90, 25));
        ConfirmBtn.addMouseListener(new Program.SharedMouseListener());
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 35);
        jPanel3.add(ConfirmBtn, gridBagConstraints);

        ExitBtn.setBackground(new java.awt.Color(240, 240, 240));
        ExitBtn.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        ExitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitBtn.setText("Hủy");
        ExitBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExitBtn.setOpaque(true);
        ExitBtn.setPreferredSize(new java.awt.Dimension(90, 25));
        ExitBtn.addMouseListener(new Program.SharedMouseListener());
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 0);
        jPanel3.add(ExitBtn, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (OldPass.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không hợp lệ, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
        if (!CheckInputMethod.isValidPass(new String(NewPass.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không chứa các ký tự đặc biệt ngoại trừ @!#$%&, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
        if (NewPass.getPassword().equals("") || containsVietnamese(NewPass) || new String(NewPass.getPassword()).length() > 30 || new String(NewPass.getPassword()).length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới phải lớn hơn 6 và nhỏ hơn 30 ký tự, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
        if (!new String(NewPass.getPassword()).equals(new String(ConfirmPass.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không trùng khớp, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
        if (ConfirmPass.getPassword().equals("") || containsVietnamese(ConfirmPass) || new String(ConfirmPass.getPassword()).length() > 30 || new String(ConfirmPass.getPassword()).length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không hợp lệ, vui lòng kiểm tra lại",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }
        try {
            boolean rslt = TaiKhoan.doiMatKhau(DangNhap.getUser(), new String(OldPass.getPassword()), new String(NewPass.getPassword()));
            if (rslt) {
                Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE, scicon);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: DoiMatKhau - Method: ConfirmBtnMouseClicked]");
            e.printStackTrace();
        }

    }//GEN-LAST:event_ConfirmBtnMouseClicked

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void OldPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OldPassMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                OldPass.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                OldPass.setEchoChar(ch);
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
    }//GEN-LAST:event_OldPassMouseClicked

    private void NewPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewPassMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                NewPass.setEchoChar((char) 0);
                ConfirmPass.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                NewPass.setEchoChar(ch);
                ConfirmPass.setEchoChar(ch);
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
    }//GEN-LAST:event_NewPassMouseClicked

    private void ConfirmPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmPassMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                NewPass.setEchoChar((char) 0);
                ConfirmPass.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                NewPass.setEchoChar(ch);
                ConfirmPass.setEchoChar(ch);
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
    }//GEN-LAST:event_ConfirmPassMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfirmBtn;
    private javax.swing.JPasswordField ConfirmPass;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPasswordField NewPass;
    private javax.swing.JPasswordField OldPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
