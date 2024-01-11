package quanlybanhang;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class AddDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddDialog
     */
    public AddDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //THÊM SỰ KIỆN CHUỘT CHO jlABEL NÚT THÊM
        CapNhatLabel.addMouseListener(new AddDialog.SharedMouseListener());
        DatLaiLabel.addMouseListener(new AddDialog.SharedMouseListener());
        ThoatLabel.addMouseListener(new AddDialog.SharedMouseListener());

        MaMonTF.addKeyListener(new KeyListener() { // KIỂM TRA TEXTFIELD MÃ MÓN
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Kiểm tra nếu ký tự là đặc biệt hoặc dấu cách
                if (isSpecialCharacter(c) || Character.isWhitespace(c)) {
                    // Hiển thị tooltip và không cho phép nhập ký tự
                    MaMonTF.setToolTipText("Không nhập ký tự đặc biệt hoặc dấu cách");
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

        GiaMonTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char typedChar = e.getKeyChar();
                if (!Character.isDigit(typedChar)) {
                    e.consume(); // Loại bỏ ký tự không phải số
                }

                String content = GiaMonTF.getText();
                GiaMonTF.setText(formatWithCustomSeparator(content));
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });
    }

    private static String formatWithCustomSeparator(String input) {
        // Đảm bảo rằng chuỗi không rỗng và là số
        if (input == null || !input.matches("\\d+")) {
            System.out.println("Invalid input: " + input);
            return input;
        }

        // Lấy độ dài của chuỗi
        int length = input.length();

        if (length > 3) {
            input = input.replace(",", "");
            long number = Long.parseLong(input);
            input = String.format("%,d", number);
        }

        return input;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MaMonTF = new javax.swing.JTextField();
        TenMonTF = new javax.swing.JTextField();
        GiaMonTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        CapNhatLabel = new javax.swing.JLabel();
        DatLaiLabel = new javax.swing.JLabel();
        ThoatLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        MaMonTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mã món"));

        TenMonTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TenMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tên món"));

        GiaMonTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GiaMonTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Giá món"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GiaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(MaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(TenMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(GiaMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        CapNhatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatLabel.setText("Cập Nhật");
        CapNhatLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CapNhatLabel.setOpaque(true);

        DatLaiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DatLaiLabel.setText("Đặt Lại");
        DatLaiLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DatLaiLabel.setOpaque(true);
        DatLaiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatLaiLabelMouseClicked(evt);
            }
        });

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
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MÓN");

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
    }//GEN-LAST:event_DatLaiLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapNhatLabel;
    private javax.swing.JLabel DatLaiLabel;
    private javax.swing.JTextField GiaMonTF;
    private javax.swing.JTextField MaMonTF;
    private javax.swing.JTextField TenMonTF;
    private javax.swing.JLabel ThoatLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public class SharedMouseListener extends MouseAdapter {

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

    // Hàm kiểm tra ký tự đặc biệt
    private static boolean isSpecialCharacter(char c) {
        // Bạn có thể thêm hoặc bớt đi các ký tự đặc biệt tùy thuộc vào yêu cầu của bạn
        String specialCharacters = "!@#$%^&*()-_+=<>?";

        return specialCharacters.contains(String.valueOf(c));
    }

//    private static void formatTextField(JTextField textField) {
//        // Sử dụng PlainDocument để kiểm soát nội dung của JTextField
//        PlainDocument document = new PlainDocument() {
//            @Override
//            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
//                // Kiểm tra xem chuỗi mới có phải là số hay không
//                if (isNumeric(str)) {
//                    super.insertString(offs, str, a);
//                    formatText();
//                }
//            }
//
//            @Override
//            public void remove(int offs, int len) throws BadLocationException {
//                super.remove(offs, len);
//                formatText();
//            }
//
//            private void formatText() {
//                // Lấy giá trị hiện tại từ JTextField và định dạng nó với dấu phân cách phần ngàn
//                try {
//                    String text = getText(0, getLength());
//                    NumberFormat format = NumberFormat.getInstance();
//                    String formattedText = format.format(format.parse(text));
//                    replace(0, getLength(), formattedText, null);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            private boolean isNumeric(String str) {
//                return str.matches("\\d*");
//            }
//        };
//
//        textField.setDocument(document);
//
//        // Thêm DocumentListener để lắng nghe sự thay đổi trong JTextField
////        document.addDocumentListener(new DocumentListener() {
////            @Override
////            public void insertUpdate(DocumentEvent e) {
////                changeText();
////            }
////
////            @Override
////            public void removeUpdate(DocumentEvent e) {
////                changeText();
////            }
////
////            @Override
////            public void changedUpdate(DocumentEvent e) {
////                changeText();
////            }
////
////            private void changeText() {
////                
////            }
////        });
//    }
}
