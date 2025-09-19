public class Item {
    private int itemId;
    private String itemName;
    private double itemPrice;
    private String itemCategory;

    public Item(int itemId, String itemName, double itemPrice, String itemCategory) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Item: " + itemId + " is named " + itemName + " and costs " + itemPrice + ". It belongs to the " + itemCategory + " category.";
    }

}
