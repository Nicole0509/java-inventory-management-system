import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Item> items = new ArrayList<>();

    public static Item getMostExpensiveItems(ArrayList<Item> items) {
        double temporaryPrice = 0;
        Item expensiveItem = null;

        for (Item item : items) {
            temporaryPrice = Math.max(temporaryPrice, item.itemPrice);
            expensiveItem = item;
        }

        return expensiveItem;
    }


    public static void main(String[] args) {

        System.out.println("Welcome To Your Inventory Management System\n");

        items.add(new Item(1, "Lenovo", 10000, "Laptops"));
        items.add(new Item(2,"HP", 3000,"Laptops"));
        items.add(new Item(3,"Samsung", 5000,"Smartphones"));
        items.add(new Item(4,"Galaxy", 11000,"Smartphones"));

        System.out.println("The most expensive item is " + getMostExpensiveItems(items));



    }
}