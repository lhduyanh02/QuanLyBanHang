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
public class ThongKe extends javax.swing.JFrame {

    private static ThongKe instance;
    private DrawerController drawer;

    public ThongKe() {
        initComponents();
        ExportBtn.addMouseListener(new Program.SharedMouseListener());
        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        PhieuThuBtn.addMouseListener(new Program.SharedMouseListener());
//        addBtn.addMouseListener(new Program.SharedMouseListener());
//        deleteBtn.addMouseListener(new Program.SharedMouseListener());

        table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        if (DangNhap.getAccess() == 0) {
            this.buildAdminDrawer();
//            deleteBtn.setVisible(true);
        } else {
            this.buildDrawer();
//           deleteBtn.setVisible(false);

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

    public static synchronized ThongKe getInstance() {
        if (instance == null) {
            instance = new ThongKe();
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

        ControlPanel = new javax.swing.JPanel();
        PhieuThuBtn = new javax.swing.JLabel();
        PhieuChiBtn = new javax.swing.JLabel();
        TatCaBtn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ExportBtn = new javax.swing.JLabel();
        TopPanel = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        RightPanel = new javax.swing.JPanel();
        TongThuPanel = new javax.swing.JPanel();
        TongThuLabel = new javax.swing.JLabel();
        TongThuTF = new javax.swing.JTextField();
        TongChiPanel = new javax.swing.JPanel();
        TongChiLabel = new javax.swing.JLabel();
        TongChiTF = new javax.swing.JTextField();
        LoiNhuanPanel = new javax.swing.JPanel();
        LoiNhuanLabel = new javax.swing.JLabel();
        LoiNhuanTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        ControlPanel.setBackground(new java.awt.Color(255, 255, 204));

        PhieuThuBtn.setBackground(new java.awt.Color(255, 255, 255));
        PhieuThuBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhieuThuBtn.setText("PHIẾU THU");
        PhieuThuBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        PhieuThuBtn.setOpaque(true);
        PhieuThuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuThuBtnMouseClicked(evt);
            }
        });

        PhieuChiBtn.setBackground(new java.awt.Color(255, 255, 255));
        PhieuChiBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhieuChiBtn.setText("PHIẾU CHI");
        PhieuChiBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        PhieuChiBtn.setOpaque(true);
        PhieuChiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuChiBtnMouseClicked(evt);
            }
        });

        TatCaBtn.setBackground(new java.awt.Color(255, 255, 255));
        TatCaBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TatCaBtn.setText("TẤT CẢ");
        TatCaBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        TatCaBtn.setOpaque(true);
        TatCaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TatCaBtnMouseClicked(evt);
            }
        });

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

        ExportBtn.setBackground(new java.awt.Color(255, 255, 255));
        ExportBtn.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        ExportBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ExportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-print.png"))); // NOI18N
        ExportBtn.setText("Export");
        ExportBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        ExportBtn.setOpaque(true);

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PhieuThuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PhieuChiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TatCaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(PhieuThuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(PhieuChiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(TatCaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TopPanel.setBackground(new java.awt.Color(255, 255, 255));

        LeftPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel1.setText("Từ ngày");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel3.setText("Đến ngày");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        RightPanel.setBackground(new java.awt.Color(255, 255, 255));
        RightPanel.setLayout(new java.awt.GridLayout(1, 0));

        TongThuPanel.setBackground(new java.awt.Color(255, 255, 255));
        TongThuPanel.setLayout(new java.awt.GridLayout(0, 1));

        TongThuLabel.setBackground(new java.awt.Color(153, 204, 255));
        TongThuLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TongThuLabel.setForeground(new java.awt.Color(102, 102, 102));
        TongThuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TongThuLabel.setText("TỔNG THU");
        TongThuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 204, 255), new java.awt.Color(153, 204, 255), null, null));
        TongThuLabel.setOpaque(true);
        TongThuPanel.add(TongThuLabel);
        TongThuPanel.add(TongThuTF);

        RightPanel.add(TongThuPanel);

        TongChiPanel.setBackground(new java.awt.Color(255, 255, 255));
        TongChiPanel.setLayout(new java.awt.GridLayout(0, 1));

        TongChiLabel.setBackground(new java.awt.Color(255, 204, 204));
        TongChiLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TongChiLabel.setForeground(new java.awt.Color(102, 102, 102));
        TongChiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TongChiLabel.setText("TỔNG CHI");
        TongChiLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), null, null));
        TongChiLabel.setOpaque(true);
        TongChiPanel.add(TongChiLabel);
        TongChiPanel.add(TongChiTF);

        RightPanel.add(TongChiPanel);

        LoiNhuanPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoiNhuanPanel.setLayout(new java.awt.GridLayout(0, 1));

        LoiNhuanLabel.setBackground(new java.awt.Color(255, 204, 153));
        LoiNhuanLabel.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        LoiNhuanLabel.setForeground(new java.awt.Color(102, 102, 102));
        LoiNhuanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoiNhuanLabel.setText("LỢI NHUẬN");
        LoiNhuanLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 153), new java.awt.Color(255, 204, 153), null, null));
        LoiNhuanLabel.setOpaque(true);
        LoiNhuanPanel.add(LoiNhuanLabel);
        LoiNhuanPanel.add(LoiNhuanTF);

        RightPanel.add(LoiNhuanPanel);

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ PHIẾU ", "NỘI DUNG", "THỜI GIAN GIAO DỊCH", "SỐ TIỀN ", "NGƯỜI TẠO"
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1)
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void PhieuThuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuThuBtnMouseClicked

    }//GEN-LAST:event_PhieuThuBtnMouseClicked

    private void PhieuChiBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuChiBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PhieuChiBtnMouseClicked

    private void TatCaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TatCaBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TatCaBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JLabel ExportBtn;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel LoiNhuanLabel;
    private javax.swing.JPanel LoiNhuanPanel;
    private javax.swing.JTextField LoiNhuanTF;
    private javax.swing.JLabel PhieuChiBtn;
    private javax.swing.JLabel PhieuThuBtn;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel TatCaBtn;
    private javax.swing.JLabel TongChiLabel;
    private javax.swing.JPanel TongChiPanel;
    private javax.swing.JTextField TongChiTF;
    private javax.swing.JLabel TongThuLabel;
    private javax.swing.JPanel TongThuPanel;
    private javax.swing.JTextField TongThuTF;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
