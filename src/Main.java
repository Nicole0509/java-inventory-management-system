import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Item> items = new ArrayList<>();

    public static void addItem(ArrayList<Item> items) {
        items.add(new Item(1, "Lenovo", 10000, "Laptops"));
        items.add(new Item(2,"HP", 3000,"Laptops"));
        items.add(new Item(3,"Samsung", 5000,"Smartphones"));
        items.add(new Item(4,"Galaxy", 11000,"Smartphones"));
    }

    public static void getAllItems(ArrayList<Item> items) {
        for (Item item : items) {
            System.out.println("\n" + item);
        }
    }

    public static Item getMostExpensiveItems(ArrayList<Item> items) {
        double temporaryPrice = 0;
        Item expensiveItem = null;

        for (Item item : items) {
            temporaryPrice = Math.max(temporaryPrice, item.itemPrice);
            expensiveItem = item;
        }

        return expensiveItem;
    }

    public static Item removeItemById(ArrayList<Item> items, int itemId) {
        int index = -1;

        for (Item item : items) {
            if (item.itemId == itemId) {
                index = items.indexOf(item);
            }
        }
        return items.remove(index);
    }

    public static void main(String[] args) {

        System.out.println("Welcome To Your Inventory Management System\n");

        System.out.println("Pick a choice and Manage Your Inventory");
        System.out.println("1. Get All Items");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Get Most Expensive Item");
        System.out.println("5. Exit");

        int choice = 1;

        switch(choice) {
            case 1:
                if(items.isEmpty()) {
                    System.out.println("There are no items in the inventory yet");
                    System.out.println("Please add an item");
                } else {
                    System.out.println("\nA list of all items in the inventory");
                    getAllItems(items);
                }
                break;
            case 2:
                addItem(items);
                break;
            case 3:
                removeItemById(items, 1);
                break;
            case 4:
                System.out.println("The most expensive item " + getMostExpensiveItems(items) );;
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}