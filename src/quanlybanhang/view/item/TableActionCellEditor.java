package quanlybanhang.view.item;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent evt;
    
    public TableActionCellEditor(TableActionEvent evt) {
        super(new JCheckBox());
        this.evt = evt;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ActionPanel action = new ActionPanel();
        action.initEvent(evt, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }

}
