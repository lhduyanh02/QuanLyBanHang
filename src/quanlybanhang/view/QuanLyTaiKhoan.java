/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import quanlybanhang.control.Program;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import quanlybanhang.model.NhatKy;
import quanlybanhang.model.TaiKhoan;

public class QuanLyTaiKhoan extends javax.swing.JFrame {

    private static QuanLyTaiKhoan instance;
    private DrawerController drawer;
    private String act;
    private String OldUsname;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = 420;
    int height = screenSize.height;
    boolean isOpen = false;
    boolean isAlreadyOneClick = false;
    boolean hidePW = true;

    public QuanLyTaiKhoan() {
        initComponents();
        this.setIconImage(new ImageIcon(GiaoDienThuNgan.class.getResource("/asserts/icons-app.png")).getImage());
        this.setTitle("Quản lý nhà hàng");
        try {
            Taskbar.getTaskbar().setIconImage(new ImageIcon(GiaoDienThuNgan.class.getResource("/asserts/icons-app.png")).getImage());
        } catch (Exception e) {
            System.out.println("The OS does not support set Icon for Taskbar");
        }
        add(EditPanel, 0);
        EditPanel.setSize(0, getContentPane().getHeight());

        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        logBtn.addMouseListener(new Program.SharedMouseListener());
        addBtn.addMouseListener(new Program.SharedMouseListener());
        updateBtn.addMouseListener(new Program.SharedMouseListener());
        disableBtn.addMouseListener(new Program.SharedMouseListener());

//        addBtn.setVisible(false);
        MouseAdapter m = table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);

        MouseMotionListener[] mouseMotionListeners = jTable1.getMouseMotionListeners();
        for (MouseMotionListener listener : mouseMotionListeners) {
            jTable1.removeMouseMotionListener(listener);
        }
        jTable1.removeMouseListener(m);

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
    }

    private void buildAdminDrawer() {
        drawer = Drawer.newDrawer(this)
                .header(new HeaderDrawer())
                //                .separator(2, new Color(0, 0, 0))
                .drawerWidth(290)
                .backgroundTransparent(0.5f)
                .addChild(new DrawerItem("Giao diện thu ngân").icon(new ImageIcon(getClass().getResource("/asserts/icons-cart.png"))).build())
                .addChild(new DrawerItem("Quản lý thực đơn món ăn").icon(new ImageIcon(getClass().getResource("/asserts/icons-food-menu.png"))).build())
                .addChild(new DrawerItem("Quản lý thực đơn nước").icon(new ImageIcon(getClass().getResource("/asserts/icons-menu.png"))).build())
                .addChild(new DrawerItem("Quản lý bàn").icon(new ImageIcon(getClass().getResource("/asserts/icons-desk.png"))).build())
                .addChild(new DrawerItem("Quản lý phiếu chi").icon(new ImageIcon(getClass().getResource("/asserts/icons-cost.png"))).build())
                .addChild(new DrawerItem("Quản lý tài khoản").icon(new ImageIcon(getClass().getResource("/asserts/icons-account.png"))).build())
                .addChild(new DrawerItem("Thống kê").icon(new ImageIcon(getClass().getResource("/asserts/icons-stocks-growth.png"))).build())
                .addFooter(new DrawerItem("Đổi mật khẩu").icon(new ImageIcon(getClass().getResource("/asserts/icons-password.png"))).build())
                .addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
//                        System.out.println(i + " - "+ di);
                        //Nút thoát
                        if (i == 8) {
                            try {
                                Program.closeApp();
                            } catch (Exception ex) {
                                System.out.println("Loi thoat chuong trinh");
                            }
                        }
                        if (i == 0) {
                            drawer.hide();
                            closeThisUI();
                            GiaoDienThuNgan.getInstance();
                        }
                        if (i == 1) {
                            drawer.hide();
                            closeThisUI();
                            ThucDonMonAn.getInstance();
                        }
                        if (i == 2) {
                            drawer.hide();
                            closeThisUI();
                            ThucDonNuoc.getInstance();
                        }
                        if (i == 3) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyBan.getInstance();
                        }
                        if (i == 4) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyPhieuChi.getInstance();
                        }
                        if (i == 5) {
                            drawer.hide();
                            closeThisUI();
                            QuanLyTaiKhoan.getInstance();
                        }
                        if (i == 6) {
                            drawer.hide();
                            closeThisUI();
                            GiaoDienThongKe.getInstance();
                        }
                        if (i == 7) { //ĐỔI MẬT KHẨU
                            drawer.hide();
                            DoiMatKhau.getInstance();
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

    public static synchronized QuanLyTaiKhoan getInstance() {
        Program.ConnectDB();
        if (instance == null) {
            instance = new QuanLyTaiKhoan();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.reload();
            instance.setVisible(true);
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.reload();
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

        EditPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        TenDNhapTF = new javax.swing.JTextField();
        QTVRadioButton = new javax.swing.JRadioButton();
        NVRadioButton = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        LuuLabel = new javax.swing.JLabel();
        DatLaiLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        MatKhauTF = new javax.swing.JPasswordField();
        NhapLaiMKTF = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        addBtn = new javax.swing.JLabel();
        updateBtn = new javax.swing.JLabel();
        disableBtn = new javax.swing.JLabel();
        logBtn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LogPanel = new javax.swing.JPanel();
        LogScrollPane = new javax.swing.JScrollPane();
        LogTextArea = new javax.swing.JTextArea();
        CloseLog = new javax.swing.JLabel();
        LogComboBox = new javax.swing.JComboBox<>();
        LogReload = new javax.swing.JLabel();

        EditPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EditPanel.setMinimumSize(new java.awt.Dimension(420, 800));
        EditPanel.setPreferredSize(new Dimension(420, getContentPane().getHeight()));
        EditPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditPanelMouseEntered(evt);
            }
        });

        TenDNhapTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TenDNhapTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tên đăng nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N

        buttonGroup1.add(QTVRadioButton);
        QTVRadioButton.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        QTVRadioButton.setText("Quản trị viên");
        QTVRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        buttonGroup1.add(NVRadioButton);
        NVRadioButton.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        NVRadioButton.setText("Nhân viên");
        NVRadioButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NVRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jPanel7.setBackground(new java.awt.Color(240, 240, 240));
        jPanel7.setMinimumSize(new java.awt.Dimension(420, 81));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        LuuLabel.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        LuuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LuuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-save.png"))); // NOI18N
        LuuLabel.setText("Lưu");
        LuuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LuuLabel.setOpaque(true);
        LuuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LuuLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel7.add(LuuLabel, gridBagConstraints);

        DatLaiLabel.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel7.add(DatLaiLabel, gridBagConstraints);

        MatKhauTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MatKhauTF.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N
        MatKhauTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MatKhauTFMouseClicked(evt);
            }
        });

        NhapLaiMKTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NhapLaiMKTF.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nhập lại mật khẩu ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N
        NhapLaiMKTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhapLaiMKTFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NhapLaiMKTF)
                    .addComponent(MatKhauTF)
                    .addComponent(TenDNhapTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(QTVRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NVRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(TenDNhapTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(MatKhauTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(NhapLaiMKTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NVRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QTVRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout EditPanelLayout = new javax.swing.GroupLayout(EditPanel);
        EditPanel.setLayout(EditPanelLayout);
        EditPanelLayout.setHorizontalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        EditPanelLayout.setVerticalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE))
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
                "STT", "TÊN ĐĂNG NHẬP", "PHÂN QUYỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(70);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(110);
            jTable1.getColumnModel().getColumn(1).setMinWidth(400);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(300);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
        jPanel4Layout.rowHeights = new int[] {0};
        jPanel4.setLayout(jPanel4Layout);

        addBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-save.png"))); // NOI18N
        addBtn.setText("Thêm mới");
        addBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.setOpaque(true);
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 130;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(addBtn, gridBagConstraints);

        updateBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        updateBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-edit.png"))); // NOI18N
        updateBtn.setText("Cập nhật");
        updateBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.setOpaque(true);
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 118;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(updateBtn, gridBagConstraints);

        disableBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        disableBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-denied.png"))); // NOI18N
        disableBtn.setText("Vô hiệu hoá ");
        disableBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        disableBtn.setOpaque(true);
        disableBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(disableBtn, gridBagConstraints);

        logBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        logBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-log.png"))); // NOI18N
        logBtn.setText("Xem nhật ký");
        logBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logBtn.setOpaque(true);
        logBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(logBtn, gridBagConstraints);

        LogScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        LogScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        LogTextArea.setEditable(false);
        LogTextArea.setBackground(new java.awt.Color(255, 255, 255));
        LogTextArea.setColumns(20);
        LogTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LogTextArea.setRows(5);
        LogScrollPane.setViewportView(LogTextArea);

        CloseLog.setBackground(new java.awt.Color(240, 240, 240));
        CloseLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CloseLog.setText("Đóng nhật ký");
        CloseLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CloseLog.setOpaque(true);
        CloseLog.addMouseListener(new Program.SharedMouseListener());
        CloseLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLogMouseClicked(evt);
            }
        });

        LogComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        LogComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LogComboBoxItemStateChanged(evt);
            }
        });

        LogReload.setBackground(new java.awt.Color(240, 240, 240));
        LogReload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogReload.setText("Tải lại");
        LogReload.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogReload.setOpaque(true);
        LogReload.addMouseListener(new Program.SharedMouseListener());
        LogReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogReloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LogPanelLayout = new javax.swing.GroupLayout(LogPanel);
        LogPanel.setLayout(LogPanelLayout);
        LogPanelLayout.setHorizontalGroup(
            LogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(LogScrollPane)
            .addGroup(LogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogComboBox, 0, 508, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogReload, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseLog, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LogPanelLayout.setVerticalGroup(
            LogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogPanelLayout.createSequentialGroup()
                .addComponent(LogScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogComboBox)
                    .addComponent(LogReload, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CloseLog, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        LogPanel.setVisible(false);

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

    private void logBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logBtnMouseClicked
        if (!isOpen) {
            LogPanel.setVisible(true);
            jPanel4.setVisible(false);
            jPanel2.setComponentZOrder(LogPanel, 0);
            reloadLogCombobox();
            reloadLog();
        }
    }//GEN-LAST:event_logBtnMouseClicked

    private void disableBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableBtnMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (isOpen == true) {
            return;
        } else {
            int r = jTable1.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Không có tài khoản nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn vô hiệu hoá tài khoản không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    boolean rslt = TaiKhoan.vohieuhoa((String) jTable1.getModel().getValueAt(r, 1));
                    if (rslt) {
                        Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
                        JOptionPane.showMessageDialog(this, "Vô hiệu hoá tài khoản thành công!", "Đã vô hiệu hoá", JOptionPane.INFORMATION_MESSAGE, scicon);
                        closeEditPanel();
                    }
                }
            }
            reload();
        }
    }//GEN-LAST:event_disableBtnMouseClicked

    private void LuuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LuuLabelMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại tài khoản.",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        }

        int acc = 1;
        if (QTVRadioButton.isSelected()) {
            acc = 0;
        } else if (NVRadioButton.isSelected()) {
            acc = 1;
        }

        boolean rslt;

        if (act.equals("add")) {
            if (!new String(MatKhauTF.getPassword()).equals(new String(NhapLaiMKTF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp.",
                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                return;
            }

            rslt = TaiKhoan.themTK(new TaiKhoan(TenDNhapTF.getText(), new String(MatKhauTF.getPassword()), acc));
            if (rslt) {
                Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!", "Đã thêm", JOptionPane.INFORMATION_MESSAGE, scicon);
                closeEditPanel();
            }
        }

        if (act.equals("edit")) {
            if (!new String(MatKhauTF.getPassword()).equals(new String(NhapLaiMKTF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp.",
                        "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
                return;
            }
            TaiKhoan TK = new TaiKhoan(TenDNhapTF.getText(), new String(MatKhauTF.getPassword()), acc);
            rslt = TaiKhoan.suaTaiKhoan(OldUsname, TK);
            if (rslt) {
                Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công!", "Đã cập nhật", JOptionPane.INFORMATION_MESSAGE, scicon);
                closeEditPanel();
            }
        }
        reload();
    }//GEN-LAST:event_LuuLabelMouseClicked

    private void EditPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_EditPanelMouseEntered

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        if (isOpen == false) {
            act = "add";
            openEditPanel();
            QTVRadioButton.setVisible(true);
            NVRadioButton.setVisible(true);
        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (isOpen == true) {
            return;
        } else {
            int r = jTable1.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Không có tài khoản nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            } else {
                act = "edit";
                openEditPanel();
                QTVRadioButton.setVisible(true);
                NVRadioButton.setVisible(true);

                OldUsname = (String) jTable1.getModel().getValueAt(r, 1);
                TenDNhapTF.setText(OldUsname);
                if (jTable1.getModel().getValueAt(r, 2).toString().equals("Nhân viên")) {
                    NVRadioButton.setSelected(true);
                } else if (jTable1.getModel().getValueAt(r, 2).toString().equals("Quản trị viên")) {
                    QTVRadioButton.setSelected(true);
                }
            }

        }
    }//GEN-LAST:event_updateBtnMouseClicked

    private void CloseLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLogMouseClicked
        LogPanel.setVisible(false);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_CloseLogMouseClicked

    private void LogReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogReloadMouseClicked
        reloadLogCombobox();
        reloadLog();
    }//GEN-LAST:event_LogReloadMouseClicked

    private void LogComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LogComboBoxItemStateChanged
        if (LogComboBox.getSelectedItem() != null) {
            reloadLog();
        }
    }//GEN-LAST:event_LogComboBoxItemStateChanged

    private void MatKhauTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MatKhauTFMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                MatKhauTF.setEchoChar((char) 0);
                NhapLaiMKTF.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                MatKhauTF.setEchoChar(ch);
                NhapLaiMKTF.setEchoChar(ch);
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
    }//GEN-LAST:event_MatKhauTFMouseClicked

    private void NhapLaiMKTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapLaiMKTFMouseClicked
        if (isAlreadyOneClick) {
            if (hidePW == true) {
                MatKhauTF.setEchoChar((char) 0);
                NhapLaiMKTF.setEchoChar((char) 0);
                hidePW = false;
            } else {
                char ch = 0x25cf;
                MatKhauTF.setEchoChar(ch);
                NhapLaiMKTF.setEchoChar(ch);
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
    }//GEN-LAST:event_NhapLaiMKTFMouseClicked

    private void DatLaiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatLaiLabelMouseClicked
        TenDNhapTF.setText(null);
        MatKhauTF.setText(null);
        NhapLaiMKTF.setText(null);
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_DatLaiLabelMouseClicked

    private void reload() {
        Program.ConnectDB();
        try {
            ArrayList<TaiKhoan> list = TaiKhoan.layDSTaiKhoan();
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            m.setRowCount(0);

            int stt = 1;
            for (TaiKhoan tk : list) {
                Object[] obj = {stt, tk.getUsername(), convert(tk.getLoai())};
                m.addRow(obj);
                stt++;
            }
        } catch (Exception ex) {
            System.out.println("Loi! [Class: QuanLyTaiKhoan - Method: reload]");
            ex.printStackTrace();
        }
    }

    private void reloadLog() {
        String act = LogComboBox.getSelectedItem().toString();
        ArrayList<String> list;
        if (act.equals("Tất cả")) {
            list = NhatKy.getLog();
            String log = "";
            for (String str : list) {
                log += str;
            }
            LogTextArea.setText(log);
        } else {
            list = NhatKy.getLogOf(act);
            String log = "";
            for (String str : list) {
                log += str;
            }
            LogTextArea.setText(log);
        }
    }

    private void reloadLogCombobox() {
        LogComboBox.removeAllItems();
        LogComboBox.addItem("Tất cả");
        ArrayList<String> actions = NhatKy.getAction();
        for (String act : actions) {
            LogComboBox.addItem(act);
        }
        LogComboBox.setSelectedItem("Tất cả");
    }

    private String convert(int x) {
        try {
            if (x == 1) {
                return "Nhân viên";
            }
            if (x == 0) {
                return "Quản trị viên";
            }
            if (x == -1) {
                return "Tài khoản bị vô hiệu hoá";
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: QuanLyTaiKhoan - Method: convert]");
        }
        return "Không xác định";
    } //Convert trạng thái bàn -> đang sử dụng hoặc không

    private void openEditPanel() {
        if (!isOpen) {
            isOpen = true;
            EditPanel.setVisible(true);
            add(EditPanel, 0);
            TenDNhapTF.setText("");
            MatKhauTF.setText("");
            NhapLaiMKTF.setText("");
            buttonGroup1.clearSelection();

            MouseAdapter a = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    closeEditPanel();
                }
            };
            jScrollPane1.addMouseListener(a);
            jTable1.addMouseListener(a);
            jLabel1.addMouseListener(a);
            jPanel4.addMouseListener(a);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    jTable1.setEnabled(false);
                    for (int i = 0; i <= width; i += 5) {
                        EditPanel.setSize(i, getContentPane().getHeight());
                        try {
                            Thread.sleep(1);

                        } catch (InterruptedException ex) {
                            Logger.getLogger(QuanLyBan.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }).start();
        }
    }

    public static void paintEditPanel() {
        instance.EditPanel.repaint();
        instance.EditPanel.revalidate();
    }

    private void closeEditPanel() {
        if (isOpen) {
            isOpen = false;
            jTable1.setEnabled(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 420; i >= 0; i -= 5) {
                        EditPanel.setSize(i, height);
                        try {
                            Thread.sleep(1);

                        } catch (InterruptedException ex) {
                            Logger.getLogger(QuanLyBan.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    EditPanel.setVisible(false);
                    getContentPane().remove(EditPanel);
                }
            }).start();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseLog;
    private javax.swing.JLabel DatLaiLabel;
    private javax.swing.JPanel EditPanel;
    private javax.swing.JComboBox<String> LogComboBox;
    private javax.swing.JPanel LogPanel;
    private javax.swing.JLabel LogReload;
    private javax.swing.JScrollPane LogScrollPane;
    private javax.swing.JTextArea LogTextArea;
    private javax.swing.JLabel LuuLabel;
    private javax.swing.JPasswordField MatKhauTF;
    private javax.swing.JRadioButton NVRadioButton;
    private javax.swing.JPasswordField NhapLaiMKTF;
    private javax.swing.JRadioButton QTVRadioButton;
    private javax.swing.JTextField TenDNhapTF;
    private javax.swing.JLabel addBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel disableBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logBtn;
    private javax.swing.JLabel updateBtn;
    // End of variables declaration//GEN-END:variables
}
