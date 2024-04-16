package quanlybanhang.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import quanlybanhang.control.Program;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import quanlybanhang.model.Ban;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.model.ChiTietHD;
import quanlybanhang.model.ThucDon;
import quanlybanhang.view.item.SearchPanel;
import quanlybanhang.view.item.TableActionCellEditor;
import quanlybanhang.view.item.TableActionCellRenderer;
import quanlybanhang.view.item.TableActionEvent;
import quanlybanhang.view.item.TableItem;

/**
 *
 * @author Admin
 */
public class GiaoDienThuNgan extends javax.swing.JFrame {

    private JPopupMenu menu;
    private SearchPanel searchPanel;
    private int limitData = 8;
    private static GiaoDienThuNgan instance;
    private DrawerController drawer;
    private static Ban ChonBan;

    public static Ban getSelectedBan() {
        return ChonBan;
    }

    public static void setSelectedBan(Ban ban) {
        ChonBan = ban;
        instance.TenBanLabel.setText(ChonBan.getTenban());
    }

    private static ArrayList<ThucDon> thucdon;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = 420;
    int height = screenSize.height;
    boolean isOpen = false;

    public GiaoDienThuNgan() {
        initComponents();
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onAdd(int row) {
                System.out.println("Add row: " + row);
            }

            @Override
            public void onMinus(int row) {
                System.out.println("Minus row: " + row);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Delete row: " + row);
            }
        };

        DonHangTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderer());
        DonHangTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(evt));
        UserTF.setText(DangNhap.getUser());
        TenBanLabel.setText("- BÀN -");

        //SET THUỘC TÍNH CHO SEARCH BAR
        menu = new JPopupMenu();
        searchPanel = new SearchPanel();
        menu.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        menu.add(searchPanel);
        menu.setFocusable(false);

        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        ChuyenBanBtn.addMouseListener(new Program.SharedMouseListener());
        InTTBtn.addMouseListener(new Program.SharedMouseListener());
        ThanhToanBtn.addMouseListener(new Program.SharedMouseListener());
        ReloadBtn.addMouseListener(new Program.SharedMouseListener());

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

    public static synchronized GiaoDienThuNgan getInstance() {
        if (instance == null) {
            instance = new GiaoDienThuNgan();
            Program.ConnectDB();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.reloadTableList();
            instance.reloadThucDon();
            instance.setVisible(true);
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Program.ConnectDB();
            instance.reloadTableList();
            instance.reloadThucDon();
            instance.setVisible(true);
            return instance;
        }
    }

    private static void closeThisUI() {
        instance.dispose();
    }

    public static void reloadChiTietHD(Ban b) {
        instance.searchTextField.setText("");
        try {
            if (b.getTrangthai().equals("free")) {
                ((DefaultTableModel) instance.DonHangTable.getModel()).setRowCount(0);
                return;
            }
            Map<String, String> map = new HashMap<>();
            for (ThucDon t : thucdon) {
                map.put(t.getMaSP(), t.getTen());
            }
            ArrayList<ChiTietHD> list = ChiTietHD.layChiTietHD(b.getTrangthai());
            DefaultTableModel m = ((DefaultTableModel) instance.DonHangTable.getModel());
            m.setRowCount(0);
            int stt = 1;
            for (ChiTietHD c : list) {
                Object[] obj = {stt, map.get(c.getMaSP()), c.getGiaSP(), c.getSoLuong(), c.getThanhTien()};
                m.addRow(obj);
                stt++;
            }
            instance.menu.setVisible(false);
        } catch (Exception e) {
            System.out.println("Loi! [Class: GiaoDienThuNgan - Method: reloadChiTietHD]");
            e.printStackTrace();
        }
    }

    // Khởi tạo bàn 
    private void reloadTableList() {
        ChonBan = null;
        TablePanel.removeAll();
        TablePanel.setLayout(new wraplayout.WrapLayout(FlowLayout.CENTER, 12, 16));
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);

        try {
            ArrayList<Ban> list = Ban.layDSban();
            if (list.isEmpty()) {
                return;
            }
            for (Ban b : list) {
                TableItem tb = new TableItem(b);
                TablePanel.add(tb);
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: GiaoDienThuNgan - Method: reloadTableList]");
            e.printStackTrace();
        }

        TablePanel.revalidate();
        TablePanel.repaint();
    }

    public static void reloadTableList(Ban bancu) {
        ChonBan = null;
        instance.TablePanel.removeAll();
        instance.TablePanel.setLayout(new wraplayout.WrapLayout(FlowLayout.CENTER, 12, 16));
        instance.jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);

        try {
            ArrayList<Ban> list = Ban.layDSban();
            if (list.isEmpty()) {
                return;
            }
            for (Ban b : list) {
                TableItem tb = new TableItem(b);
                instance.TablePanel.add(tb);
                if (b.getMaban().equals(bancu.getMaban())) {
                    bancu = b;
                    reloadChiTietHD(b);
                }
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: GiaoDienThuNgan - Method: reloadTableList]");
            e.printStackTrace();

        }
        setSelectedBan(bancu);
        instance.TablePanel.revalidate();
        instance.TablePanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        MenuLabel = new javax.swing.JLabel();
        UserTF = new javax.swing.JTextField();
        TenBanLabel = new javax.swing.JLabel();
        searchTextField = new quanlybanhang.view.item.SearchTextField();
        jPanel2 = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        leftPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GhiChuTF = new javax.swing.JTextArea();
        TgianTF = new javax.swing.JTextField();
        TongCongTF = new javax.swing.JTextField();
        ChietKhauTF = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        ThanhToanBtn = new javax.swing.JLabel();
        InTTBtn = new javax.swing.JLabel();
        ReloadBtn = new javax.swing.JLabel();
        ChuyenBanBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DonHangTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        MenuLabel.setBackground(new java.awt.Color(255, 255, 255));
        MenuLabel.setFont(MenuLabel.getFont().deriveFont(MenuLabel.getFont().getStyle() | java.awt.Font.BOLD, MenuLabel.getFont().getSize()+11));
        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setText("☰");
        MenuLabel.setAlignmentY(0.0F);
        MenuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuLabel.setMinimumSize(new java.awt.Dimension(15, 15));
        MenuLabel.setOpaque(true);
        MenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuLabelMouseReleased(evt);
            }
        });

        UserTF.setEditable(false);
        UserTF.setBackground(new java.awt.Color(255, 255, 204));
        UserTF.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        UserTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UserTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TenBanLabel.setBackground(new java.awt.Color(255, 255, 255));
        TenBanLabel.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        TenBanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TenBanLabel.setText("- BÀN -");
        TenBanLabel.setOpaque(true);

        searchTextField.setName(""); // NOI18N
        searchTextField.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/search-icon-46.png"))); // NOI18N
        searchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseClicked(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(MenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TenBanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(UserTF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserTF)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenBanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(MenuLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        TablePanel.setBackground(new java.awt.Color(255, 255, 255));
        TablePanel.setMaximumSize(new java.awt.Dimension(450, 32767));

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 14))); // NOI18N

        GhiChuTF.setColumns(20);
        GhiChuTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GhiChuTF.setLineWrap(true);
        GhiChuTF.setRows(5);
        GhiChuTF.setWrapStyleWord(true);
        GhiChuTF.setBorder(null);
        GhiChuTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GhiChuTFKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(GhiChuTF);

        TgianTF.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        TgianTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        TongCongTF.setEditable(false);
        TongCongTF.setBackground(new java.awt.Color(255, 255, 255));
        TongCongTF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TongCongTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TongCongTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng cộng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Helvetica", 1, 14))); // NOI18N

        ChietKhauTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ChietKhauTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chiết khấu (%)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Helvetica", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TgianTF, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(TongCongTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChietKhauTF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChietKhauTF)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TgianTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TongCongTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        java.awt.GridBagLayout jPanel8Layout = new java.awt.GridBagLayout();
        jPanel8Layout.columnWidths = new int[] {0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0};
        jPanel8Layout.rowHeights = new int[] {0, 5, 0};
        jPanel8.setLayout(jPanel8Layout);

        ThanhToanBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        ThanhToanBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThanhToanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-purchase.png"))); // NOI18N
        ThanhToanBtn.setText("Thanh toán");
        ThanhToanBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThanhToanBtn.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel8.add(ThanhToanBtn, gridBagConstraints);

        InTTBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        InTTBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InTTBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons8-print.png"))); // NOI18N
        InTTBtn.setText("In tạm tính");
        InTTBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InTTBtn.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel8.add(InTTBtn, gridBagConstraints);

        ReloadBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        ReloadBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-move.png"))); // NOI18N
        ReloadBtn.setText("Tải lại");
        ReloadBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ReloadBtn.setOpaque(true);
        ReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReloadBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        jPanel8.add(ReloadBtn, gridBagConstraints);

        ChuyenBanBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        ChuyenBanBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChuyenBanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-move.png"))); // NOI18N
        ChuyenBanBtn.setText("Chuyển bàn");
        ChuyenBanBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChuyenBanBtn.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 14;
        jPanel8.add(ChuyenBanBtn, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));

        DonHangTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DonHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên hàng hoá", "Đơn giá", "Số lượng", "Thành tiền", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DonHangTable.setOpaque(false);
        DonHangTable.setRowHeight(42);
        DonHangTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DonHangTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DonHangTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(DonHangTable);
        if (DonHangTable.getColumnModel().getColumnCount() > 0) {
            DonHangTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DonHangTable.getColumnModel().getColumn(0).setMaxWidth(50);
            DonHangTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            DonHangTable.getColumnModel().getColumn(1).setMaxWidth(180);
            DonHangTable.getColumnModel().getColumn(2).setPreferredWidth(90);
            DonHangTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            DonHangTable.getColumnModel().getColumn(3).setMaxWidth(70);
            DonHangTable.getColumnModel().getColumn(4).setPreferredWidth(90);
            DonHangTable.getColumnModel().getColumn(5).setMinWidth(120);
            DonHangTable.getColumnModel().getColumn(5).setPreferredWidth(120);
            DonHangTable.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(leftPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void MenuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLabelMouseExited
        MenuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_MenuLabelMouseExited

    private void MenuLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLabelMouseReleased
        MenuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_MenuLabelMouseReleased

    private void MenuLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLabelMousePressed
        MenuLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_MenuLabelMousePressed

    private void MenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLabelMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_MenuLabelMouseClicked

    private void searchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseClicked
        if (searchPanel.getItemSize() > 0) {
            menu.show(searchTextField, 0, searchTextField.getHeight());
        }
    }//GEN-LAST:event_searchTextFieldMouseClicked

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        String text = searchTextField.getText().trim().toLowerCase();
        searchPanel.setData(searchMenu(text));
        if (searchPanel.getItemSize() > 0) {
            menu.show(searchTextField, 0, searchTextField.getHeight());
            menu.setPopupSize(menu.getWidth(), (searchPanel.getItemSize() * 35) + 2);
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void ReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReloadBtnMouseClicked
        UserTF.setText(DangNhap.getUser());
        TenBanLabel.setText("- BÀN -");
        ChonBan=null;
        ((DefaultTableModel)DonHangTable.getModel()).setRowCount(0);
        reloadThucDon();
        reloadTableList();
    }//GEN-LAST:event_ReloadBtnMouseClicked

    private void GhiChuTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GhiChuTFKeyPressed
        if (GhiChuTF.getText().length() > 10){
            System.out.println("hehêheh");
            evt.consume();
            GhiChuTF.setEditable(false);
        }
    }//GEN-LAST:event_GhiChuTFKeyPressed

    private List<ThucDon> searchMenu(String search) {
        List<ThucDon> list = new ArrayList<>();
        try {
            for (ThucDon td : thucdon) {
                if (td.getTen().toLowerCase().contains(search.trim().toLowerCase())) {
                    list.add(new ThucDon(td.getMaSP(), td.getTen(), td.getGia(), td.getLoai(), td.getGhiChu()));
                    if (list.size() == limitData) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Loi khoi tao du lieu search menu");
            e.printStackTrace();
        }
        return list;
    }

    private void reloadThucDon() {
        try {
            thucdon = ThucDon.layDSThucDon();
        } catch (Exception e) {
            System.out.println("Loi! [Class: GiaoDienThuNgan - Method: reloadThucDon]");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ChietKhauTF;
    private javax.swing.JLabel ChuyenBanBtn;
    private javax.swing.JTable DonHangTable;
    private javax.swing.JTextArea GhiChuTF;
    private javax.swing.JLabel InTTBtn;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JLabel ReloadBtn;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JLabel TenBanLabel;
    private javax.swing.JTextField TgianTF;
    private javax.swing.JLabel ThanhToanBtn;
    private javax.swing.JTextField TongCongTF;
    private javax.swing.JTextField UserTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel leftPanel;
    private quanlybanhang.view.item.SearchTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
