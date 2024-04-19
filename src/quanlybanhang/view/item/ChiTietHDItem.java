package quanlybanhang.view.item;

import net.miginfocom.swing.MigLayout;
import quanlybanhang.model.ChiTietHD;
import quanlybanhang.view.GiaoDienThuNgan;

public class ChiTietHDItem extends javax.swing.JPanel {
    public ChiTietHDItem(ChiTietHD c, int stt) {
        initComponents();
        TenMonLabel.setText(stt+". "+GiaoDienThuNgan.getSanPhamMap().get(c.getMaSP()));
        GiaLabel.setText(Float.valueOf(c.getGiaSP()).intValue()+" VND");
        SoLuongLabel.setText(String.valueOf(c.getSoLuong()));
        ThanhTienLabel.setText(Float.valueOf(c.getThanhTien()).intValue()+" VND");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TenMonLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GiaLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SoLuongLabel = new javax.swing.JLabel();
        ThanhTienLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        TenMonLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        TenMonLabel.setText("Tên món");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setText("Giá:");

        GiaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GiaLabel.setText("<giá món>");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("SL:");

        SoLuongLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SoLuongLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SoLuongLabel.setText("<SL>");

        ThanhTienLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTienLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ThanhTienLabel.setText("<thành tiền>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SoLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addComponent(ThanhTienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TenMonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TenMonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(GiaLabel)
                    .addComponent(jLabel2)
                    .addComponent(SoLuongLabel)
                    .addComponent(ThanhTienLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GiaLabel;
    private javax.swing.JLabel SoLuongLabel;
    private javax.swing.JLabel TenMonLabel;
    private javax.swing.JLabel ThanhTienLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
