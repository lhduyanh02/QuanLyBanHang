package quanlybanhang.view.search_suggestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class SearchMenuItem extends javax.swing.JPanel {
    private MenuDataSearch data;
    public SearchMenuItem(MenuDataSearch d) {
        initComponents();
        data = d;
        setData(data);
        addSeparatorLabel(PriceLabel);
    }

    private void setData(MenuDataSearch data){
        addEventMouse(this);
        NameLabel.setText(data.getName());
        PriceLabel.setText(String.valueOf(data.getPrice()));
        if(data.getType() == 0){
            IconLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons8-meal-30.png")));
        } else if(data.getType() == 1){
            IconLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/icons8-drink-30.png")));
        }
    }
    
    private void addEventMouse(Component com){
        com.addMouseListener(new MouseAdapter(){
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
                System.out.println(data.getID());
            }
            
        });
    }
    
    public void addSeparatorLabel(JLabel label){
        String content = label.getText();
        if(content.equals("")){
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
                .addGap(1, 1, 1)
                .addComponent(IconLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
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
