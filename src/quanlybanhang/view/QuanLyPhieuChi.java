/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.control.Program;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import quanlybanhang.control.CheckInputMethod;
import quanlybanhang.model.Ban;
import quanlybanhang.model.PhieuChi;
import table.TableCustom;

/**
 *
 * @author Admin
 */
public class QuanLyPhieuChi extends javax.swing.JFrame {

    private static QuanLyPhieuChi instance;
    private DrawerController drawer;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = 420;
    int height = screenSize.height;
    boolean isOpen = false;

    public QuanLyPhieuChi() {
        initComponents();
        if(DangNhap.getAccess()!=0){
            deleteBtn.setVisible(false);
        }
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
        reloadBtn.addMouseListener(new Program.SharedMouseListener());
        addBtn.addMouseListener(new Program.SharedMouseListener());
        deleteBtn.addMouseListener(new Program.SharedMouseListener());

        MouseAdapter m = table.TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);

        MouseMotionListener[] mouseMotionListeners = jTable1.getMouseMotionListeners();
        for (MouseMotionListener listener : mouseMotionListeners) {
            jTable1.removeMouseMotionListener(listener);
        }
        jTable1.removeMouseListener(m);

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

        // RÀNG BUỘC GIÁ MÓN
        SoTienTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char typedChar = e.getKeyChar();
                if (!Character.isDigit(typedChar) || SoTienTF.getText().length() > 10) {
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
                if (!SoTienTF.getText().equals("")) {
                    AddDialog.addSeparator(SoTienTF);
                }
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
                .addChild(new DrawerItem("Giao diện thu ngân").icon(new ImageIcon(getClass().getResource("/asserts/icons-cart.png"))).build())
                .addChild(new DrawerItem("Quản lý phiếu chi").icon(new ImageIcon(getClass().getResource("/asserts/icons-cost.png"))).build())
                .addChild(new DrawerItem("Thống kê").icon(new ImageIcon(getClass().getResource("/asserts/icons-stocks-growth.png"))).build())
                .addFooter(new DrawerItem("Đổi mật khẩu").icon(new ImageIcon(getClass().getResource("/asserts/icons-password.png"))).build())
                .addFooter(new DrawerItem("Thoát").icon(new ImageIcon(getClass().getResource("/asserts/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
                        //Nút thoát
                        if (i == 4) {
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
                            QuanLyPhieuChi.getInstance();
                        }
                        
                        if (i == 2) {
                            drawer.hide();
                            closeThisUI();
                            GiaoDienThongKe.getInstance();
                        }
                        if (i == 3) { //ĐỔI MẬT KHẨU
                            drawer.hide();
                            DoiMatKhau.getInstance();
                        }
                    }

                })
                .enableScroll(true)
                .build();
    }

    public static synchronized QuanLyPhieuChi getInstance() {
        Program.ConnectDB();
        if (instance == null) {
            instance = new QuanLyPhieuChi();
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.reset();
            instance.setVisible(true);
            return instance;
        } else {
            instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
            instance.reset();
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
        MaPCTF = new javax.swing.JTextField();
        NoiDungTF = new javax.swing.JTextField();
        SoTienTF = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        LuuLabel = new javax.swing.JLabel();
        DatLaiLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        searchTextField1 = new quanlybanhang.view.item.SearchTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        StartDate = new com.toedter.calendar.JDateChooser();
        EndDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
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

        EditPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EditPanel.setMinimumSize(new java.awt.Dimension(420, 800));
        EditPanel.setPreferredSize(new Dimension(420, getContentPane().getHeight()));
        EditPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditPanelMouseEntered(evt);
            }
        });

        MaPCTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MaPCTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mã phiếu chi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N

        NoiDungTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NoiDungTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Nội dung chi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N

        SoTienTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SoTienTF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Số tiền ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 1, 18))); // NOI18N

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 40);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        jPanel7.add(DatLaiLabel, gridBagConstraints);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NoiDungTF)
                            .addComponent(MaPCTF)
                            .addComponent(SoTienTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(MaPCTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(NoiDungTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(SoTienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout EditPanelLayout = new javax.swing.GroupLayout(EditPanel);
        EditPanel.setLayout(EditPanelLayout);
        EditPanelLayout.setHorizontalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditPanelLayout.setVerticalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

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

        jPanel8.setOpaque(false);

        searchTextField1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/search-item-30.png"))); // NOI18N
        searchTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel9.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Từ ngày");

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

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Đến ngày");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        ((JTextFieldDateEditor) EndDate.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) EndDate.getDateEditor()).setBackground(Color.WHITE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
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
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(addBtn, gridBagConstraints);

        deleteBtn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        deleteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons-delete.png"))); // NOI18N
        deleteBtn.setText("Xoá phiếu chi");
        deleteBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.setOpaque(true);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(EditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 580, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(EditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
        );

        EditPanel.getAccessibleContext().setAccessibleParent(this);

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
        reload();
    }//GEN-LAST:event_reloadBtnMouseClicked

    private void EditPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPanelMouseEntered

    }//GEN-LAST:event_EditPanelMouseEntered

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        if (isOpen == false) {
            openEditPanel();
        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        if (isOpen) {
            return;
        } else {
            int r = jTable1.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Không có phiếu chi nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá phiếu chi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    boolean rslt = PhieuChi.xoaPhieuChi((String) jTable1.getModel().getValueAt(r, 1));
                    if (rslt) {
                        Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
                        JOptionPane.showMessageDialog(this, "Xóa phiếu chi thành công!", "Đã xóa", JOptionPane.INFORMATION_MESSAGE, scicon);
                        closeEditPanel();
                    }
                }
            }
            reload();
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void LuuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LuuLabelMouseClicked
        Icon icon = new ImageIcon(getClass().getResource("/asserts/X-icon.png"));
        int sotien;
        if (SoTienTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền cho phiếu chi.",
                    "Lỗi", JOptionPane.ERROR_MESSAGE, icon);
            return;
        } else {
            sotien = Integer.parseInt(SoTienTF.getText().replaceAll("[.,]", ""));
        }

        boolean rslt;
        rslt = PhieuChi.themPhieuChi(MaPCTF.getText(), NoiDungTF.getText(), sotien, DangNhap.getUser());
        if (rslt) {
            Icon scicon = new ImageIcon(getClass().getResource("/asserts/success-icon.png"));
            JOptionPane.showMessageDialog(this, "Thêm phiếu chi thành công!", "Đã thêm", JOptionPane.INFORMATION_MESSAGE, scicon);
            closeEditPanel();
        }
        reload();
    }//GEN-LAST:event_LuuLabelMouseClicked

    private void reset(){
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        MaPCTF.setText("");
        NoiDungTF.setText("");
        SoTienTF.setText("");
        searchTextField1.setText("");
        ((JTextFieldDateEditor) StartDate.getDateEditor()).setText("");
        ((JTextFieldDateEditor) EndDate.getDateEditor()).setText("");
        StartDate.setCalendar(null);
        EndDate.setCalendar(null);
    }
    
    private void DatLaiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatLaiLabelMouseClicked
        reset();
    }//GEN-LAST:event_DatLaiLabelMouseClicked

    private void searchTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField1KeyTyped
        DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> rs = new TableRowSorter<>(m);
        jTable1.setRowSorter(rs);

        // Lấy văn bản từ ô nhập liệu
        String searchText = searchTextField1.getText().trim();

        // Thiết lập bộ lọc cho mỗi cột
        rs.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }//GEN-LAST:event_searchTextField1KeyTyped

    private void StartDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_StartDatePropertyChange
        if (evt.getPropertyName().equals("date") && (evt.getOldValue() != evt.getNewValue())
                && !Objects.isNull(StartDate.getDate()) && !Objects.isNull(EndDate.getDate())) {
            if (StartDate.getDate().before(EndDate.getDate())) {
                reload();
            } else {
//                System.out.println("Khong hop le");
            }
        }
    }//GEN-LAST:event_StartDatePropertyChange

    private void EndDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_EndDatePropertyChange
        if (evt.getPropertyName().equals("date") && (evt.getOldValue() != evt.getNewValue())
                && !Objects.isNull(StartDate.getDate()) && !Objects.isNull(EndDate.getDate())) {
            if (StartDate.getDate().before(EndDate.getDate())) {
                reload();
            } else {
//                System.out.println("Khong hop le");
            }
        }
    }//GEN-LAST:event_EndDatePropertyChange

    private void reload() {
        Program.ConnectDB();
        if (Objects.isNull(StartDate.getDate()) || Objects.isNull(EndDate.getDate())) {
            try {
                ArrayList<PhieuChi> list = PhieuChi.layDSphieuchi();
                DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
                m.setRowCount(0);
                int stt = 1;
                for (PhieuChi pc : list) {
                    Object[] obj = {stt, pc.getMaPC(), pc.getNoiDung(),
                        Program.formatTimestamp(pc.getTime()), (int) pc.getSoTien(), pc.getNhanVien()};
                    m.addRow(obj);
                    stt++;
                }
            } catch (Exception ex) {
                System.out.println("Loi! [Class: QuanLyPhieuChi - Method: reload]");
                ex.printStackTrace();
            }
            return;
        } else if (!Objects.isNull(StartDate.getDate()) && !Objects.isNull(EndDate.getDate())) {
            if (StartDate.getDate().before(EndDate.getDate())) {
                try {
                    ArrayList<PhieuChi> list = PhieuChi.layDSphieuchi(Program.formatDate(StartDate.getDate()), Program.formatDate(EndDate.getDate()));
                    DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
                    m.setRowCount(0);
                    int stt = 1;
                    for (PhieuChi pc : list) {
                        Object[] obj = {stt, pc.getMaPC(), pc.getNoiDung(),
                            Program.formatTimestamp(pc.getTime()), (int) pc.getSoTien(), pc.getNhanVien()};
                        m.addRow(obj);
                        stt++;
                    }
                } catch (Exception ex) {
                    System.out.println("Loi! [Class: QuanLyPhieuChi - Method: reload]");
                    ex.printStackTrace();
                }
                return;
            }
        }

    }

    public static void paintEditPanel() {
        instance.EditPanel.repaint();
        instance.EditPanel.revalidate();
    }

    private void openEditPanel() {
        if (!isOpen) {
            isOpen = true;
            searchTextField1.setFocusable(false);
            EditPanel.setVisible(true);
            add(EditPanel, 0);
            MaPCTF.setText("");
            NoiDungTF.setText("");
            SoTienTF.setText("");
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
                    for (int i = 0; i <= width; i += 5) {
                        EditPanel.setSize(i, getContentPane().getHeight());
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(QuanLyBan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }).start();
        }
    }

    private void closeEditPanel() {
        if (isOpen) {
            isOpen = false;
            searchTextField1.setFocusable(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 420; i >= 0; i -= 5) {
                        EditPanel.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(QuanLyBan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    EditPanel.setVisible(false);
                    getContentPane().remove(EditPanel);
                }
            }).start();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DatLaiLabel;
    private javax.swing.JPanel EditPanel;
    private com.toedter.calendar.JDateChooser EndDate;
    private javax.swing.JLabel LuuLabel;
    private javax.swing.JTextField MaPCTF;
    private javax.swing.JTextField NoiDungTF;
    private javax.swing.JTextField SoTienTF;
    private com.toedter.calendar.JDateChooser StartDate;
    private javax.swing.JLabel addBtn;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reloadBtn;
    private quanlybanhang.view.item.SearchTextField searchTextField1;
    // End of variables declaration//GEN-END:variables
}
