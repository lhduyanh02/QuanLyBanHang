package quanlybanhang.view.item;

import java.util.List;
import net.miginfocom.swing.MigLayout;

public class SearchPanel extends javax.swing.JPanel {

    public SearchPanel() {
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }

    public void setData(List<MenuDataSearch> data){
        this.removeAll();
        for(MenuDataSearch d : data){
            SearchMenuItem item = new SearchMenuItem(d);
            this.add(item, "wrap");
        }
        repaint();
        revalidate();
    }
    
    public int getItemSize(){
        return getComponentCount();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
