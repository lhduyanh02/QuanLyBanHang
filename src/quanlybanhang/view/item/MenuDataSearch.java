package quanlybanhang.view.item;

public class MenuDataSearch {
    private String ID;
    private String Name;
    private int Price;
    private int Type;

    public MenuDataSearch() {
    }

    public MenuDataSearch(String ID, String Name, int Price, int Type) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Type = Type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
}
