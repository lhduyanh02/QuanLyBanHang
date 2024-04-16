package quanlybanhang.view.item;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import quanlybanhang.model.Ban;
import quanlybanhang.model.HoaDon;
import quanlybanhang.view.GiaoDienThuNgan;

public class TableItem extends javax.swing.JPanel {

    private Ban ban;

    public TableItem(Ban b) {
        ban = b;
        initComponents();
        MaBanlbl.setText(ban.getMaban());
        TenBanlbl.setText(ban.getTenban());
        if (ban.getTrangthai().equals("free")) {
            setBackground(new Color(204, 255, 204));
        } else {
            setBackground(new Color(255, 153, 153));
        }
        addMouseEvent(this);
    }

    private void addMouseEvent(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GiaoDienThuNgan.setSelectedBan(ban);
                GiaoDienThuNgan.reloadChiTietHD(GiaoDienThuNgan.getSelectedBan());
//                if(ban.getTrangthai().equals("free")){
//                    HoaDon.taoHoaDon(new HoaDon("", ban.getMaban(), 15));
//                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (ban.getTrangthai().equals("free")) {
                    setBackground(new Color(153, 255, 153));
                } else {
                    setBackground(new Color(255, 102, 51));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (ban.getTrangthai().equals("free")) {
                    setBackground(new Color(204, 255, 204));
                } else {
                    setBackground(new Color(255, 153, 153));
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MaBanlbl = new javax.swing.JLabel();
        TenBanlbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 3));

        MaBanlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MaBanlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaBanlbl.setText("Mã bàn");

        TenBanlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TenBanlbl.setText("Tên bàn");

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MaBanlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
            .addComponent(TenBanlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MaBanlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenBanlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MaBanlbl;
    private javax.swing.JLabel TenBanlbl;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
