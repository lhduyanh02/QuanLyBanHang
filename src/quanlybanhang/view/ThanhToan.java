package quanlybanhang.view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import quanlybanhang.control.Program;
import quanlybanhang.model.Ban;
import quanlybanhang.model.ChiTietHD;
import quanlybanhang.model.HoaDon;
import quanlybanhang.view.item.ChiTietHDItem;
import quanlybanhang.view.item.TableItem;

public class ThanhToan extends javax.swing.JDialog {

    private HoaDon hd;
    
    public ThanhToan(java.awt.Frame parent, boolean modal, HoaDon hd) {
        super(parent, modal);
        initComponents();
        this.hd = hd;
        this.setData(hd.getMaHD());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ThongTinPanel = new javax.swing.JPanel();
        TTHoaDonPanel = new javax.swing.JPanel();
        ComName = new javax.swing.JLabel();
        MaHDLabel = new javax.swing.JLabel();
        NgayLabel = new javax.swing.JLabel();
        MaHDInf = new javax.swing.JLabel();
        NgayInf = new javax.swing.JLabel();
        BanLabel = new javax.swing.JLabel();
        BanInf = new javax.swing.JLabel();
        NhanVienInf = new javax.swing.JLabel();
        NhanVienLabel = new javax.swing.JLabel();
        DSMonPanel = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        ChiTietPanel = new javax.swing.JPanel();
        TongKetPanel = new javax.swing.JPanel();
        TongTienInf = new javax.swing.JLabel();
        NgayLabel1 = new javax.swing.JLabel();
        ChietKhauInf = new javax.swing.JLabel();
        NgayLabel2 = new javax.swing.JLabel();
        NgayLabel3 = new javax.swing.JLabel();
        ThanhTienInf = new javax.swing.JLabel();
        NgayLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GhiChuTA = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        ControlPanel = new javax.swing.JPanel();
        BackBtn = new javax.swing.JLabel();
        ConfirmBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thanh toán đơn hàng");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        TTHoaDonPanel.setBackground(new java.awt.Color(255, 255, 255));

        ComName.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        ComName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComName.setText("NHÀ HÀNG TUYẾT NGÂN");

        MaHDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaHDLabel.setText("Mã HD:");

        NgayLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayLabel.setText("Ngày:");

        MaHDInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaHDInf.setText("<MaHD place>");

        NgayInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NgayInf.setText("<Ngay place>");

        BanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BanLabel.setText("Bàn:");

        BanInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BanInf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        BanInf.setText("<Ban place>");

        NhanVienInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NhanVienInf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NhanVienInf.setText("<NV place>");

        NhanVienLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NhanVienLabel.setText("Nhân viên:");

        javax.swing.GroupLayout TTHoaDonPanelLayout = new javax.swing.GroupLayout(TTHoaDonPanel);
        TTHoaDonPanel.setLayout(TTHoaDonPanelLayout);
        TTHoaDonPanelLayout.setHorizontalGroup(
            TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ComName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TTHoaDonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaHDLabel)
                    .addComponent(NgayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaHDInf, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(NgayInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BanLabel)
                    .addComponent(NhanVienLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BanInf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhanVienInf, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        TTHoaDonPanelLayout.setVerticalGroup(
            TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTHoaDonPanelLayout.createSequentialGroup()
                .addComponent(ComName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TTHoaDonPanelLayout.createSequentialGroup()
                        .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaHDLabel)
                            .addComponent(MaHDInf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TTHoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NgayLabel)
                            .addComponent(NgayInf)))
                    .addGroup(TTHoaDonPanelLayout.createSequentialGroup()
                        .addComponent(BanInf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NhanVienInf))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TTHoaDonPanelLayout.createSequentialGroup()
                        .addComponent(BanLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NhanVienLabel)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        DSMonPanel.setBackground(new java.awt.Color(255, 255, 255));
        DSMonPanel.setMaximumSize(new java.awt.Dimension(460, 32767));

        ScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ChiTietPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ChiTietPanelLayout = new javax.swing.GroupLayout(ChiTietPanel);
        ChiTietPanel.setLayout(ChiTietPanelLayout);
        ChiTietPanelLayout.setHorizontalGroup(
            ChiTietPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        ChiTietPanelLayout.setVerticalGroup(
            ChiTietPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        ScrollPane.setViewportView(ChiTietPanel);

        javax.swing.GroupLayout DSMonPanelLayout = new javax.swing.GroupLayout(DSMonPanel);
        DSMonPanel.setLayout(DSMonPanelLayout);
        DSMonPanelLayout.setHorizontalGroup(
            DSMonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        DSMonPanelLayout.setVerticalGroup(
            DSMonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        TongKetPanel.setBackground(new java.awt.Color(255, 255, 255));

        TongTienInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TongTienInf.setText("<tổng tiền>");

        NgayLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayLabel1.setText("Tổng tiền:");

        ChietKhauInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChietKhauInf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ChietKhauInf.setText("<CK>");

        NgayLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayLabel2.setText("Chiết khấu:");

        NgayLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayLabel3.setText("Thành tiền:");

        ThanhTienInf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTienInf.setText("<thành tiền>");

        NgayLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayLabel4.setText("Ghi chú:");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        GhiChuTA.setEditable(false);
        GhiChuTA.setBackground(new java.awt.Color(255, 255, 255));
        GhiChuTA.setColumns(20);
        GhiChuTA.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        GhiChuTA.setLineWrap(true);
        GhiChuTA.setWrapStyleWord(true);
        GhiChuTA.setBorder(null);
        GhiChuTA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GhiChuTA.setEnabled(false);
        jScrollPane1.setViewportView(GhiChuTA);

        javax.swing.GroupLayout TongKetPanelLayout = new javax.swing.GroupLayout(TongKetPanel);
        TongKetPanel.setLayout(TongKetPanelLayout);
        TongKetPanelLayout.setHorizontalGroup(
            TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TongKetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NgayLabel3)
                    .addComponent(NgayLabel1)
                    .addComponent(NgayLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TongKetPanelLayout.createSequentialGroup()
                        .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TongTienInf, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThanhTienInf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(NgayLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChietKhauInf, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addContainerGap())
        );

        TongKetPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ThanhTienInf, TongTienInf});

        TongKetPanelLayout.setVerticalGroup(
            TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TongKetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NgayLabel1)
                    .addComponent(TongTienInf)
                    .addComponent(NgayLabel2)
                    .addComponent(ChietKhauInf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NgayLabel3)
                    .addComponent(ThanhTienInf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TongKetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TongKetPanelLayout.createSequentialGroup()
                        .addComponent(NgayLabel4)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout ThongTinPanelLayout = new javax.swing.GroupLayout(ThongTinPanel);
        ThongTinPanel.setLayout(ThongTinPanelLayout);
        ThongTinPanelLayout.setHorizontalGroup(
            ThongTinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
            .addGroup(ThongTinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TTHoaDonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DSMonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TongKetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongTinPanelLayout.setVerticalGroup(
            ThongTinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongTinPanelLayout.createSequentialGroup()
                .addGap(0, 708, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ThongTinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ThongTinPanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(TTHoaDonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DSMonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(TongKetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        ControlPanel.setBackground(new java.awt.Color(255, 255, 255));

        BackBtn.setBackground(new java.awt.Color(249, 249, 249));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackBtn.setText("Quay lại");
        BackBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackBtn.setOpaque(true);
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });

        ConfirmBtn.setBackground(new java.awt.Color(204, 255, 204));
        ConfirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConfirmBtn.setText("Thanh Toán");
        ConfirmBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConfirmBtn.setOpaque(true);
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ThongTinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(698, Short.MAX_VALUE)
                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(ThongTinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 47, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        int op = JOptionPane.showConfirmDialog(this, 
                "Xác nhận thanh toán và đóng hóa đơn?","Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
        if(op==0){ // Yes option
            hd.ThanhToan();
            this.dispose();
            GiaoDienThuNgan.resetUI();
        }
    }//GEN-LAST:event_ConfirmBtnMouseClicked

    private void setData(String MaHD) {
        MaHDInf.setText(hd.getMaHD());
        NgayInf.setText(Program.formatTimestamp(hd.getNgayLapHD()));
        BanInf.setText(GiaoDienThuNgan.getSelectedBan().getTenban());
        NhanVienInf.setText(DangNhap.getUser());
        TongTienInf.setText(Float.valueOf(hd.getTongTien()).intValue()+" VND");
        ChietKhauInf.setText(String.valueOf(hd.getChietKhau())+"%");
        ThanhTienInf.setText(Float.valueOf(hd.getTongThanhToan()).intValue()+" VND");
        GhiChuTA.setText(hd.getGhiChu());
        
        ChiTietPanel.removeAll();
        ChiTietPanel.setLayout(new wraplayout.WrapLayout(FlowLayout.CENTER, 2, 5));
        ScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        try {
             ArrayList<ChiTietHD> list = ChiTietHD.layChiTietHD(MaHD);
            if (list.isEmpty()) {
                return;
            }
            
            for (ChiTietHD c : list) {
                ChiTietHDItem item = new ChiTietHDItem(c);
                ChiTietPanel.add(item);
            }
        } catch (Exception e) {
            System.out.println("Loi! [Class: ThanhToan - Method: setData]");
            e.printStackTrace();
        }

        ChiTietPanel.revalidate();
        ChiTietPanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackBtn;
    private javax.swing.JLabel BanInf;
    private javax.swing.JLabel BanLabel;
    private javax.swing.JPanel ChiTietPanel;
    private javax.swing.JLabel ChietKhauInf;
    private javax.swing.JLabel ComName;
    private javax.swing.JLabel ConfirmBtn;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JPanel DSMonPanel;
    private javax.swing.JTextArea GhiChuTA;
    private javax.swing.JLabel MaHDInf;
    private javax.swing.JLabel MaHDLabel;
    private javax.swing.JLabel NgayInf;
    private javax.swing.JLabel NgayLabel;
    private javax.swing.JLabel NgayLabel1;
    private javax.swing.JLabel NgayLabel2;
    private javax.swing.JLabel NgayLabel3;
    private javax.swing.JLabel NgayLabel4;
    private javax.swing.JLabel NhanVienInf;
    private javax.swing.JLabel NhanVienLabel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JPanel TTHoaDonPanel;
    private javax.swing.JLabel ThanhTienInf;
    private javax.swing.JPanel ThongTinPanel;
    private javax.swing.JPanel TongKetPanel;
    private javax.swing.JLabel TongTienInf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
