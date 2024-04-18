/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import quanlybanhang.control.Program;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.control.ThongKe;
import quanlybanhang.model.PhieuChi;
import table.TableCustom;

/**
 *
 * @author Admin
 */
public class GiaoDienThongKe extends javax.swing.JFrame {

    private static GiaoDienThongKe instance;
    private DrawerController drawer;
    private String selected = "";

    public GiaoDienThongKe() {
        initComponents();
        ExportBtn.addMouseListener(new Program.SharedMouseListener());
        //THÊM SỰ KIỆN CHUỘT CHO JLABEL BTN
        PhieuThuBtn.addMouseListener(new Program.SharedMouseListener());
        PhieuChiBtn.addMouseListener(new Program.SharedMouseListener());
        TatCaBtn.addMouseListener(new Program.SharedMouseListener());

        MouseAdapter m = table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
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

    public static synchronized GiaoDienThongKe getInstance() {
        Program.ConnectDB();
        if (instance == null) {
            instance = new GiaoDienThongKe();
            instance.resetUI();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.setVisible(true);
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.resetUI();
            instance.setVisible(true);
            return instance;
        }
    }

    private static void closeThisUI() {
        instance.dispose();
    }

    private void resetUI() {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        ((JTextFieldDateEditor) StartDate.getDateEditor()).setText("");
        ((JTextFieldDateEditor) EndDate.getDateEditor()).setText("");
        selected="";
        TongThuTF.setText("");
        TongChiTF.setText("");
        LoiNhuanTF.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ControlPanel = new javax.swing.JPanel();
        PhieuThuBtn = new javax.swing.JLabel();
        PhieuChiBtn = new javax.swing.JLabel();
        TatCaBtn = new javax.swing.JLabel();
        DrawerLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ExportBtn = new javax.swing.JLabel();
        TopPanel = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StartDate = new com.toedter.calendar.JDateChooser();
        EndDate = new com.toedter.calendar.JDateChooser();
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

        PhieuThuBtn.setBackground(new java.awt.Color(240, 240, 240));
        PhieuThuBtn.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        PhieuThuBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhieuThuBtn.setText("PHIẾU THU");
        PhieuThuBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PhieuThuBtn.setOpaque(true);
        PhieuThuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuThuBtnMouseClicked(evt);
            }
        });

        PhieuChiBtn.setBackground(new java.awt.Color(240, 240, 240));
        PhieuChiBtn.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        PhieuChiBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhieuChiBtn.setText("PHIẾU CHI");
        PhieuChiBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PhieuChiBtn.setOpaque(true);
        PhieuChiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuChiBtnMouseClicked(evt);
            }
        });

        TatCaBtn.setBackground(new java.awt.Color(240, 240, 240));
        TatCaBtn.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        TatCaBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TatCaBtn.setText("TẤT CẢ");
        TatCaBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TatCaBtn.setOpaque(true);
        TatCaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TatCaBtnMouseClicked(evt);
            }
        });

        DrawerLabel.setBackground(new java.awt.Color(255, 255, 255));
        DrawerLabel.setFont(DrawerLabel.getFont().deriveFont(DrawerLabel.getFont().getStyle() | java.awt.Font.BOLD, DrawerLabel.getFont().getSize()+11));
        DrawerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DrawerLabel.setText("☰");
        DrawerLabel.setAlignmentY(0.0F);
        DrawerLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DrawerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DrawerLabel.setMinimumSize(new java.awt.Dimension(15, 15));
        DrawerLabel.setOpaque(true);
        DrawerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrawerLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DrawerLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DrawerLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DrawerLabelMouseReleased(evt);
            }
        });

        ExportBtn.setBackground(new java.awt.Color(240, 240, 240));
        ExportBtn.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        ExportBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-print.png"))); // NOI18N
        ExportBtn.setText("Export");
        ExportBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExportBtn.setOpaque(true);

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(DrawerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
            .addComponent(PhieuThuBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PhieuChiBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TatCaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(DrawerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        StartDate.setBackground(new java.awt.Color(255, 255, 255));
        StartDate.setToolTipText("Chọn ngày bắt đầu");
        StartDate.setDateFormatString("dd/MM/yyyy");
        StartDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        StartDate.setMaxSelectableDate(new java.util.Date(253370743307000L));
        StartDate.setMinSelectableDate(new java.util.Date(-631173493000L));
        ((JTextFieldDateEditor) StartDate.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) StartDate.getDateEditor()).setBackground(Color.WHITE);
        StartDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                StartDatePropertyChange(evt);
            }
        });

        EndDate.setBackground(new java.awt.Color(255, 255, 255));
        EndDate.setToolTipText("Chọn ngày kết thúc");
        EndDate.setDateFormatString("dd/MM/yyyy");
        EndDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EndDate.setMinSelectableDate(new java.util.Date(-631173534000L));
        EndDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                EndDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(StartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        ((JTextFieldDateEditor) EndDate.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) EndDate.getDateEditor()).setBackground(Color.WHITE);

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

        TongThuTF.setEditable(false);
        TongThuTF.setBackground(new java.awt.Color(255, 255, 255));
        TongThuTF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TongThuTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TongThuTF.setFocusable(false);
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

        TongChiTF.setEditable(false);
        TongChiTF.setBackground(new java.awt.Color(255, 255, 255));
        TongChiTF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TongChiTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TongChiTF.setFocusable(false);
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

        LoiNhuanTF.setEditable(false);
        LoiNhuanTF.setBackground(new java.awt.Color(255, 255, 255));
        LoiNhuanTF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoiNhuanTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LoiNhuanTF.setFocusable(false);
        LoiNhuanPanel.add(LoiNhuanTF);

        RightPanel.add(LoiNhuanPanel);

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
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

    private void DrawerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawerLabelMouseExited
        DrawerLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    }//GEN-LAST:event_DrawerLabelMouseExited

    private void DrawerLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawerLabelMouseReleased
        DrawerLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_DrawerLabelMouseReleased

    private void DrawerLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawerLabelMousePressed
        DrawerLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_DrawerLabelMousePressed

    private void DrawerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawerLabelMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_DrawerLabelMouseClicked

    private void PhieuThuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuThuBtnMouseClicked
        selected = "PhieuThu";
        reload();
    }//GEN-LAST:event_PhieuThuBtnMouseClicked

    private void PhieuChiBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuChiBtnMouseClicked
        selected = "PhieuChi";
        reload();
    }//GEN-LAST:event_PhieuChiBtnMouseClicked

    private void TatCaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TatCaBtnMouseClicked
        selected = "TatCa";
        reload();
    }//GEN-LAST:event_TatCaBtnMouseClicked

    private void StartDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_StartDatePropertyChange
        if (evt.getPropertyName().equals("date") && (evt.getOldValue() != evt.getNewValue())
                && !Objects.isNull(StartDate.getDate()) && !Objects.isNull(EndDate.getDate())) {
            if (StartDate.getDate().before(EndDate.getDate())) {

            } else {
//                System.out.println("Khong hop le");
            }
        }
    }//GEN-LAST:event_StartDatePropertyChange

    private void EndDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_EndDatePropertyChange
        if (evt.getPropertyName().equals("date") && (evt.getOldValue() != evt.getNewValue())
                && !Objects.isNull(StartDate.getDate()) && !Objects.isNull(EndDate.getDate())) {
            if (StartDate.getDate().before(EndDate.getDate())) {

            } else {
//                System.out.println("Khong hop le");
            }
        }
    }//GEN-LAST:event_EndDatePropertyChange

    private void reload() {
        if(Objects.isNull(StartDate.getDate()) || Objects.isNull(EndDate.getDate())){
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            return;
        }
        try {
            LoiNhuanTF.setText("");
            TongChiTF.setText("");
            TongThuTF.setText("");
            ArrayList<ThongKe> list = new ArrayList<ThongKe>();
        if(selected.equals("PhieuThu")){
            list = ThongKe.layPhieuThu(Program.formatDate(StartDate.getDate()), Program.formatDate(EndDate.getDate()));
        } else if(selected.equals("PhieuChi")){
            list = ThongKe.layPhieuChi(Program.formatDate(StartDate.getDate()), Program.formatDate(EndDate.getDate()));
        } else if(selected.equals("TatCa")){
            list = ThongKe.layThongKe(Program.formatDate(StartDate.getDate()), Program.formatDate(EndDate.getDate()));
        }else return;
        
        DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            m.setRowCount(0);
            int stt = 1;
            int thu = 0;
            int chi = 0;
            for (ThongKe tk : list) {
                Object[] obj = {stt, tk.getID(), tk.getNoiDung(), tk.getThoiGian(), tk.getSoTien(), tk.getNguoiTao()};
                m.addRow(obj);
                if(tk.getSoTien()>=0){
                    thu+=tk.getSoTien();
                } else{
                    chi+=tk.getSoTien();
                }
                stt++;
            }
            TongThuTF.setText(String.valueOf(thu));
            TongChiTF.setText(String.valueOf(chi));
            LoiNhuanTF.setText(String.valueOf(thu+chi));
            AddDialog.addSeparator(TongThuTF);
            AddDialog.addSeparator(TongChiTF);
            AddDialog.addSeparator(LoiNhuanTF);
        } catch (Exception e) {
            System.out.println("Loi! [Class: GiaoDienThongKe - Method: reload]");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JLabel DrawerLabel;
    private com.toedter.calendar.JDateChooser EndDate;
    private javax.swing.JLabel ExportBtn;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel LoiNhuanLabel;
    private javax.swing.JPanel LoiNhuanPanel;
    private javax.swing.JTextField LoiNhuanTF;
    private javax.swing.JLabel PhieuChiBtn;
    private javax.swing.JLabel PhieuThuBtn;
    private javax.swing.JPanel RightPanel;
    private com.toedter.calendar.JDateChooser StartDate;
    private javax.swing.JLabel TatCaBtn;
    private javax.swing.JLabel TongChiLabel;
    private javax.swing.JPanel TongChiPanel;
    private javax.swing.JTextField TongChiTF;
    private javax.swing.JLabel TongThuLabel;
    private javax.swing.JPanel TongThuPanel;
    private javax.swing.JTextField TongThuTF;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
