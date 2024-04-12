package quanlybanhang.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import quanlybanhang.control.Program;
import static quanlybanhang.control.Program.con;
import quanlybanhang.view.item.MenuDataSearch;
import quanlybanhang.view.item.SearchPanel;
import java.sql.Statement;
import java.sql.ResultSet;

public class DemoSearching extends javax.swing.JFrame {

    private JPopupMenu menu;
    private SearchPanel searchPanel;
    private int limitData = 8;

    public DemoSearching() {
        initComponents();
        menu = new JPopupMenu();
        searchPanel = new SearchPanel();
        menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 153)));
        menu.add(searchPanel);
        menu.setFocusable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchTextField = new quanlybanhang.view.item.SearchTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        searchTextField.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/asserts/search.png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private List<MenuDataSearch> searchMenu(String search) {
        List<MenuDataSearch> list = new ArrayList<>();
        try {
            Program.ConnectDB();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MaSP, TenSP, GiaSP, LoaiSP FROM htql_banhang.sanpham WHERE LOWER(TenSP) LIKE LOWER('%" + search.trim() + "%') AND LoaiSP <> -1;");
            while (rs.next()) {
                list.add(new MenuDataSearch(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                if (list.size() == limitData) {
                    break;
                }
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Loi khoi tao du lieu search menu");
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        new DemoSearching().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private quanlybanhang.view.item.SearchTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
