/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;

import java.awt.Font;
import quanlybanhang.control.Program;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import table.TableCustom;

/**
 *
 * @author Admin
 */
public class QuanLyPhieuChi extends javax.swing.JFrame {

    private static QuanLyPhieuChi instance;
    private DrawerController drawer;

    public QuanLyPhieuChi() {
        initComponents();
        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        reloadBtn.addMouseListener(new Program.SharedMouseListener());
        addBtn.addMouseListener(new Program.SharedMouseListener());
        deleteBtn.addMouseListener(new Program.SharedMouseListener());

        table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        if (DangNhap.getAccess() == 0) {
            this.buildAdminDrawer();
            deleteBtn.setVisible(true);
        } else {
            this.buildDrawer();
            deleteBtn.setVisible(false);

        }

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Program.closeApp();
            }
        });
    }

    private void buildAdminDrawer() {
        drawer = Drawer.newDrawer(this)
                .header(new HeaderDrawer())
                //                .separator(2, new Color(0, 0, 0))
                .drawerWidth(290)
                .backgroundTransparent(0.5f)
                .addChild(new DrawerItem("Quản lý thực đơn món ăn").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Quản lý thực đơn nước").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Quản lý bàn").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Quản lý phiếu chi").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Quản lý tài khoản").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addChild(new DrawerItem("Thống kê").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
//                        System.out.println(i + " - "+ di);
                        //Nút thoát
                        if (i == 6) {
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
                        if (i == 1) {
                            drawer.hide();
                            closeThisUI();
                            ThucDonNuoc.getInstance();
                        }
                        if (i == 2) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyBan.getInstance();
                        }
                        if (i == 3) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyPhieuChi.getInstance();
                        }
                        if (i == 4) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyTaiKhoan.getInstance();
                        }
                        if (i == 5) {
                            drawer.hide();
                            closeThisUI();
                            ThongKe.getInstance();
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
                /*3*/.addFooter(new DrawerItem("aaa").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                /*4*/.addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
//                        System.out.println(i + " - "+ di);
                        //Nút thoát
                        if (i == 4) {
                            try {
                                Program.closeApp();
                            } catch (Exception ex) {
                                System.out.println("Loi thoat chuong trinh");
                            }
                        }
                        if (i == 3) {
                            System.out.println("Doi mat khau");
                        }
                        if (i == 0) {
                            closeThisUI();
                            ThucDonMonAn.getInstance();
                        }
                    }

                })
                .enableScroll(true)
                .build();
    }

    public static synchronized QuanLyPhieuChi getInstance() {
        if (instance == null) {
            instance = new QuanLyPhieuChi();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.setVisible(true);
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.setVisible(true);
            return instance;
        }
    }

    private static void closeThisUI() {
        instance.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        reloadBtn = new javax.swing.JLabel();
        addBtn = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU CHI");
        jLabel1.setAlignmentY(0.0F);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("☰");
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMinimumSize(new java.awt.Dimension(15, 15));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ PHIẾU CHI", "NỘI DUNG CHI", "THỜI GIAN GIAO DỊCH", "SỐ TIỀN CHI", "NGƯỜI TẠO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(2).setMinWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(3).setMinWidth(180);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setMinWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setMinWidth(120);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
        }
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        reloadBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        reloadBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-reset.png"))); // NOI18N
        reloadBtn.setText("Tải lại");
        reloadBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reloadBtn.setOpaque(true);
        reloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reloadBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(reloadBtn, gridBagConstraints);

        addBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-save.png"))); // NOI18N
        addBtn.setText("Thêm phiếu chi");
        addBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(addBtn, gridBagConstraints);

        deleteBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        deleteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-delete.png"))); // NOI18N
        deleteBtn.setText("Xoá phiếu chi");
        deleteBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(deleteBtn, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabel2MouseReleased

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void reloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadBtnMouseClicked
//        try {
//            ResultSet rs ;
//            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
//            m.setRowCount(0);
//            int stt = 1;
//            while (rs.next()) {
//                Object[] obj = {stt, rs.getString(1), rs.getString(2), rs.getInt(3)};
//                m.addRow(obj);
//                stt++;
//            }
//        } catch (Exception ex) {
//            System.out.println("Loi! [Class: QuanLyBan - Method: reloadBtnMouseClicked]");
//            ex.printStackTrace();
//        }
    }//GEN-LAST:event_reloadBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reloadBtn;
    // End of variables declaration//GEN-END:variables
}
