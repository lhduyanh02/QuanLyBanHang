package quanlybanhang.view.item;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import quanlybanhang.model.ChiTietHD;
import quanlybanhang.model.HoaDon;
import quanlybanhang.model.ThucDon;
import quanlybanhang.view.GiaoDienThuNgan;

public class SearchMenuItem extends javax.swing.JPanel {

    private ThucDon data;

    public SearchMenuItem(ThucDon d) {
        initComponents();
        data = d;
        setData(data);
        addSeparatorLabel(PriceLabel);
    }

    private void setData(ThucDon data) {
        addEventMouse(this);
        NameLabel.setText(data.getTen());
        PriceLabel.setText(String.valueOf(data.getGia()));
        if (data.getLoai() == 0) {
            IconLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons8-meal-30.png")));
        } else if (data.getLoai() == 1) {
            IconLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons8-drink-30.png")));
        }
    }

    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(240, 240, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (GiaoDienThuNgan.getSelectedBan() == null) {
                    Icon icon = new ImageIcon(SearchMenuItem.class.getResource("/asserts/X-icon.png"));
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn trước khi thêm món",
                            "Không có bàn được chọn", JOptionPane.ERROR_MESSAGE, icon);
                    return;
                }
                if (GiaoDienThuNgan.getSelectedBan().getTrangthai().equals("free")) {
                    String mahd = HoaDon.taoHoaDon(new HoaDon("", GiaoDienThuNgan.getSelectedBan().getMaban(), 90));
                    ChiTietHD.themChiTietHD(new ChiTietHD(mahd, data.getMaSP(), 1));
                } else {
                    ChiTietHD.themChiTietHD(new ChiTietHD(GiaoDienThuNgan.getSelectedBan().getTrangthai(), data.getMaSP(), 1));
                    GiaoDienThuNgan.reloadChiTietHD(GiaoDienThuNgan.getSelectedBan());
                }
            }

        });
    }

    public void addSeparatorLabel(JLabel label) {
        String content = label.getText();
        if (content.equals("")) {
            return;
        }
        content = content.replaceAll("[.,]", "");
        int l = Integer.parseInt(content);
        content = String.format("%,d", l);
        label.setText(content);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        IconLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(430, 35));

        NameLabel.setText("Item...");

        PriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        IconLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/search-item-30.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconLbl;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel PriceLabel;
    // End of variables declaration//GEN-END:variables
}
