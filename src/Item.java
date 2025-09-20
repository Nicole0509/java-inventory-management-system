import java.text.NumberFormat;

public class Item {
    public int itemId;
    public String itemName;
    public double itemPrice;
    public String itemCategory;

    public Item(int itemId, String itemName, double itemPrice, String itemCategory) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Item " + itemId + " named " + itemName + ", costs " + NumberFormat.getCurrencyInstance().format(itemPrice) + ".\nIt belongs to the " + itemCategory + " category.";
    }

}
