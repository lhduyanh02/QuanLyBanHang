/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;

import quanlybanhang.control.Program;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import static quanlybanhang.control.Program.con;
import quanlybanhang.control.ThucDon;
import table.TableCustom;

/**
 *
 * @author Admin
 */
public class ThucDonMonAn extends javax.swing.JFrame {

    private static ThucDonMonAn instance;
    private DrawerController drawer;

    public ThucDonMonAn() {
        initComponents();

//        int columnIndex = 3;
//        TableColumnModel columnModel = jTable1.getColumnModel();
//        columnModel.getColumn(columnIndex).setCellRenderer(new CustomTableCellRenderer());

        table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);

        if (DangNhap.getAccess() == 0) {
            this.buildAdminDrawer();
        } else {
            this.buildDrawer();
        }

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Program.closeApp();
            }
        });
        reloadMenu();
    }

    private void buildAdminDrawer() {
        drawer = Drawer.newDrawer(this)
                .header(new HeaderDrawer())
                //                .separator(2, new Color(0, 0, 0))
                .drawerWidth(290)
                .backgroundTransparent(0.5f)
                .addChild(new DrawerItem("Quản lý thực đơn món ăn").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Quản lý thực đơn nước").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
//                        System.out.println(i + " - "+ di);
                        //Nút thoát
                        if (i == 5) {
                            try {
                                Program.closeApp();
                            } catch (Exception ex) {
                                System.out.println("Loi thoat chuong trinh");
                            }
                        }
                        if (i == 1) {
                            drawer.hide();
                            closeThisUI();
                            ThucDonNuoc.getInstance();
                        }
                    }

                })
                .enableScroll(true)
                .build();
    }

    private void buildDrawer() {
        drawer = Drawer.newDrawer(this)
                .header(new HeaderDrawer())
                //                .separator(2, new Color(0, 0, 0))
                .drawerWidth(290)
                .backgroundTransparent(0.5f)
                /*0*/.addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                /*1*/.addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                /*2*/.addChild(new DrawerItem("ItemName").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                /*3*/.addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
//                        System.out.println(i + " - "+ di);
                        //Nút thoát
                        if (i == 3) {
                            try {
                                Program.closeApp();
                            } catch (Exception ex) {
                                System.out.println("Loi thoat chuong trinh");
                            }
                        }
                        if (i == 0) {
                            drawer.hide();
                            closeThisUI();
                            ThucDonMonAn.getInstance();
                        }
                    }

                })
                .enableScroll(true)
                .build();
    }

    private static void closeThisUI() {
        instance.dispose();
    }

    public static synchronized ThucDonMonAn getInstance() {
        if (instance == null) {
            instance = new ThucDonMonAn();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.setVisible(true);
            instance.reloadMenu();
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.setVisible(true);
            instance.reloadMenu();
            return instance;
        }
    }

    public static synchronized ThucDonMonAn getInvisibleInstance() {
        if (instance == null) {
            instance = new ThucDonMonAn();
//            instance.setVisible(false);
            instance.reloadMenu();
            return instance;
        } else {
//            instance.setVisible(false);
            instance.reloadMenu();
            return instance;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMenu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        ReloadButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 247, 201));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Palatino", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THỰC ĐƠN MÓN ĂN");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setFont(jLabelMenu.getFont().deriveFont(jLabelMenu.getFont().getStyle() | java.awt.Font.BOLD, jLabelMenu.getFont().getSize()+11));
        jLabelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu.setText("☰");
        jLabelMenu.setAlignmentY(0.0F);
        jLabelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMenu.setMinimumSize(new java.awt.Dimension(15, 15));
        jLabelMenu.setOpaque(true);
        jLabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ MÓN", "TÊN MÓN", "GIÁ TIỀN", "GHI CHÚ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font customFont = new Font("Segoe UI", Font.BOLD, 18);
        tableHeader.setFont(customFont);
        jTable1.setRowHeight(30);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        }
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        jPanel3.setBackground(new java.awt.Color(249, 247, 201));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 5, 8, 5));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 127));
        jPanel3.setLayout(new java.awt.GridLayout(2, 4, 10, 5));

        AddBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AddBtn.setText("THÊM MỚI SẢN PHẨM");
        AddBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel3.add(AddBtn);

        EditBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EditBtn.setText("CẬP NHẬT");
        EditBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        jPanel3.add(EditBtn);

        DelBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DelBtn.setText("XOÁ SẢN PHẨM");
        DelBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });
        jPanel3.add(DelBtn);

        ReloadButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ReloadButton.setText("TẢI LẠI");
        ReloadButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ReloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadButtonActionPerformed(evt);
            }
        });
        jPanel3.add(ReloadButton);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("jButton1");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jButton5);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setText("jButton1");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jButton6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseExited
        jLabelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabelMenuMouseExited

    private void jLabelMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseReleased
        jLabelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabelMenuMouseReleased

    private void jLabelMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMousePressed
        jLabelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_jLabelMenuMousePressed

    private void jLabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jLabelMenuMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        addMenu();
    }//GEN-LAST:event_AddBtnActionPerformed

    private void ReloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadButtonActionPerformed
        reloadMenu();
    }//GEN-LAST:event_ReloadButtonActionPerformed

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        try {
            int r = jTable1.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Không có món nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá món không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Object MaSP = jTable1.getModel().getValueAt(r, 1);
                    ThucDon.getInstance().xoaMon(MaSP);
//                    Statement s = con.createStatement();
//                    
//                    int x = s.executeUpdate("DELETE FROM `htql_banhang`.`sanpham` WHERE (`MaSP` = N'" + MaSP + "');");
//                    if (x != 0) {
//                        JOptionPane.showMessageDialog(this, "Đã xoá " + x + " món", "Xoá thành công", JOptionPane.INFORMATION_MESSAGE);
//                        reloadMenu();
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Xoá không thành công", "Xoá không thành công", JOptionPane.INFORMATION_MESSAGE);
//                        reloadMenu();
//                    }
//                    s.close();
                }
                reloadMenu();
            }

        } catch (Exception e) {
            System.out.println("Lỗi xoá món");
        }
    }//GEN-LAST:event_DelBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        editMenu();
    }//GEN-LAST:event_EditBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton ReloadButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void addMenu() {
        new AddDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    private void editMenu() {
        int r = jTable1.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Không có món nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            String MaSP = (String) jTable1.getModel().getValueAt(r, 1);
            String TenSP = (String) jTable1.getModel().getValueAt(r, 2);
            int GiaSP = (int) jTable1.getModel().getValueAt(r, 3);
            new EditDialog(this, rootPaneCheckingEnabled).getOldValue(MaSP, TenSP, GiaSP).setVisible(true);

        }

    }

    public void reloadMenu() {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM htql_banhang.sanpham where LoaiSp = '0';");
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            m.setRowCount(0);
            int stt = 1;
            while (rs.next()) {
                Object[] obj = {stt, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(5)};
                m.addRow(obj);
                stt++;
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lớp tùy chỉnh để định dạng cột số int với dấu cách ngăn cách phần ngàn
    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        private DecimalFormat formatter;

        public CustomTableCellRenderer() {
            // Sử dụng ký tự ngăn cách phần ngàn là dấu cách
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(' ');
            formatter = new DecimalFormat("#,###", symbols);
        }

        @Override
        public void setValue(Object value) {
            if (value instanceof Number) {
                setText(formatter.format(value));
            } else {
                super.setValue(value);
            }
        }
    }

}
