package quanlybanhang.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import quanlybanhang.control.Program;
import quanlybanhang.control.Program.SharedMouseListener;
import static quanlybanhang.control.Program.con;
import quanlybanhang.model.ThucDon;

public class EditDialog extends javax.swing.JDialog {
    private String MaSanPham = "";
    /**
     * Creates new form AddDialog
     */
    public EditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Program.ConnectDB();
        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        CapNhatLabel.addMouseListener(new SharedMouseListener());
        DatLaiLabel.addMouseListener(new SharedMouseListener());
        ThoatLabel.addMouseListener(new SharedMouseListener());

        // RÀNG BUỘC MÃ MÓN
        MaMonTF.addKeyListener(new KeyListener() { // KIỂM TRA TEXTFIELD MÃ MÓN
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Kiểm tra nếu ký tự là đặc biệt hoặc dấu cách
                if (isSpecialCharacter(c) || Character.isWhitespace(c) || MaMonTF.getText().length() > 9) {
                    // Hiển thị tooltip và không cho phép nhập ký tự
                    MaMonTF.setToolTipText("Chỉ nhập 10 ký tự, không nhập ký tự đặc biệt hoặc dấu cách");
                    e.consume(); // Ngăn chặn ký tự được nhập vào
                } else {
                    // Nếu ký tự hợp lệ, đặt tooltip thành null
                    MaMonTF.setToolTipText(null);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // không cần xử lý
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // không cần xử lý
            }
        });

        // RÀNG BUỘC TÊN MÓN
        TenMonTF.addKeyListener(new KeyListener() { // KIỂM TRA TEXTFIELD MÃ MÓN
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Kiểm tra nếu ký tự là đặc biệt hoặc dấu cách
                if (isSpecialCharacter(c) || TenMonTF.getText().length() > 49) {
                    // Hiển thị tooltip và không cho phép nhập ký tự
                    TenMonTF.setToolTipText("Chỉ nhập 50 ký tự, không nhập ký tự đặc biệt");
                    e.consume(); // Ngăn chặn ký tự được nhập vào
                } else {
                    // Nếu ký tự hợp lệ, đặt tooltip thành null
                    TenMonTF.setToolTipText(null);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // không cần xử lý
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // không cần xử lý
            }
        });

        // RÀNG BUỘC GIÁ MÓN
        GiaMonTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char typedChar = e.getKeyChar();
                if (!Character.isDigit(typedChar) || GiaMonTF.getText().length() > 10) {
                    e.consume(); // Loại bỏ ký tự không phải số
                    return;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                addSeparator(GiaMonTF);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!GiaMonTF.getText().equals("")) {
                    addSeparator(GiaMonTF);
                }
            }

        });
    }

    // Thêm dấu phẩy vào sau mỗi 3 chữ số
    private static void addSeparator(JTextField TF) {
        String content = TF.getText();
        content = content.replaceAll("[.,]", "");
        int l = Integer.parseInt(content);
        content = String.format("%,d", l);
        TF.setText(content);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MaMonTF = new javax.swing.JTextField();
        TenMonTF = new javax.swing.JTextField();
        GiaMonTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        GhiChuTF = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        CapNhatLabel = new javax.swing.JLabel();
        DatLaiLabel = new javax.swing.JLabel();
        ThoatLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        MaMonTF.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        MaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mã món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N

        TenMonTF.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        TenMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tên món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N

        GiaMonTF.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        GiaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Giá món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ghi chú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 2, 18))); // NOI18N

        GhiChuTF.setColumns(20);
        GhiChuTF.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        GhiChuTF.setRows(5);
        GhiChuTF.setWrapStyleWord(true);
        GhiChuTF.setBorder(null);
        jScrollPane1.setViewportView(GhiChuTF);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(MaMonTF, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(TenMonTF, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(GiaMonTF, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(MaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TenMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GiaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(249, 247, 201));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        CapNhatLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        CapNhatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-edit.png"))); // NOI18N
        CapNhatLabel.setText("Cập Nhật");
        CapNhatLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CapNhatLabel.setOpaque(true);
        CapNhatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CapNhatLabelMouseClicked(evt);
            }
        });

        DatLaiLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        DatLaiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DatLaiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-reset.png"))); // NOI18N
        DatLaiLabel.setText("Đặt Lại");
        DatLaiLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DatLaiLabel.setOpaque(true);
        DatLaiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatLaiLabelMouseClicked(evt);
            }
        });

        ThoatLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        ThoatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThoatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-undo.png"))); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapNhatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(DatLaiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThoatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CapNhatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DatLaiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThoatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(249, 247, 201));

        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỬA MÓN");

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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ThoatLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThoatLabelMouseClicked
        dispose();
    }//GEN-LAST:event_ThoatLabelMouseClicked

    private void DatLaiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatLaiLabelMouseClicked
        GiaMonTF.setText("");
        MaMonTF.setText("");
        TenMonTF.setText("");
        MaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mã món"));
        TenMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tên món"));
        GiaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Giá món"));

    }//GEN-LAST:event_DatLaiLabelMouseClicked

    private void CapNhatLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CapNhatLabelMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (MaMonTF.getText().equals("") || containsSpecialChars(MaMonTF) || containsWhitespace(MaMonTF) || containsVietnamese(MaMonTF) || MaMonTF.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Mã món không hợp lệ, vui lòng kiểm tra lại",
                    "Lỗi Mã Món", JOptionPane.ERROR_MESSAGE, icon);
            MaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Mã món"));
            return;
        }
        if (TenMonTF.getText().equals("") || containsSpecialChars(TenMonTF) || TenMonTF.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Tên món không hợp lệ, vui lòng kiểm tra lại",
                    "Lỗi Tên Món", JOptionPane.ERROR_MESSAGE, icon);
            TenMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Tên món"));
            return;
        }
        if (GiaMonTF.getText().equals("") || !isValidPrice(GiaMonTF) || GiaMonTF.getText().length() > 11) {
            JOptionPane.showMessageDialog(this, "Giá món không hợp lệ, vui lòng kiểm tra lại",
                    "Lỗi Giá Món", JOptionPane.ERROR_MESSAGE, icon);
            GiaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Giá món"));
            return;
        }

        try {
            Statement s = con.createStatement();
            int gia = Integer.parseInt(GiaMonTF.getText().replaceAll("[.,]", ""));
            boolean re = ThucDon.suaMon(MaSanPham, MaMonTF.getText(), TenMonTF.getText(), gia, GhiChuTF.getText());
            if (re == true) {
                updateNoti(1, this);
            }
        } catch (SQLException ex) {
            System.out.println("Data is not valid!");
            updateNoti(0, this);
        }
    }//GEN-LAST:event_CapNhatLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapNhatLabel;
    private javax.swing.JLabel DatLaiLabel;
    private javax.swing.JTextArea GhiChuTF;
    private javax.swing.JTextField GiaMonTF;
    private javax.swing.JTextField MaMonTF;
    private javax.swing.JTextField TenMonTF;
    private javax.swing.JLabel ThoatLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    // Hàm kiểm tra ký tự đặc biệt
    private static boolean isSpecialCharacter(char c) {
        // Bạn có thể thêm hoặc bớt đi các ký tự đặc biệt tùy thuộc vào yêu cầu của bạn
        String specialCharacters = "!@#$%^&*()-_+=<>?";
        return specialCharacters.contains(String.valueOf(c));
    }

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

    //Kiểm tra giá hợp lệ
    public static boolean isValidPrice(JTextField TF) {
        String input = TF.getText();
        // Biểu thức chính quy kiểm tra xem chuỗi chỉ chứa số và dấu chấm
        String regex = "^[0-9.,]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Kiểm tra xem chuỗi có khớp với biểu thức chính quy không
        return matcher.matches();
    }

    private void updateNoti(int state, JDialog dialog) {
        if (state == 1) {
            Icon icon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
            JOptionPane.showMessageDialog(this, "Cập nhật món thành công!", "Đã cập nhật", JOptionPane.INFORMATION_MESSAGE, icon);
            dialog.dispose();
            ThucDonMonAn.getInvisibleInstance().reloadMenu();
            ThucDonNuoc.getInvisibleInstance().reloadMenu();

        }
        if (state == 0) {
            Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!", "Không thể thêm món", JOptionPane.INFORMATION_MESSAGE, icon);
//            dialog.dispose();
        }
    }

    public EditDialog getOldValue(String MM, String TM, int GM) {
        MaSanPham = MM;
        MaMonTF.setText(MM);
        TenMonTF.setText(TM);
        GiaMonTF.setText(String.valueOf(GM));
        return this;
    }
}
