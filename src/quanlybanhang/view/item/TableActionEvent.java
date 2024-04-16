package quanlybanhang.view.item;

public interface TableActionEvent {
    
    public void onAdd(int row);
    
    public void onMinus(int row);
    
    public void onDelete(int row);
}
