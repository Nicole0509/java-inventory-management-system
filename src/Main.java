import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome To Your Inventory Management System\n");

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(1, "Lenovo", 10000, "Laptops"));
        items.add(new Item(2,"HP", 3000,"Laptops"));

        double temporaryPrice = 0;
        Item expensiveItem = null;

        for (Item item : items) {
            temporaryPrice = Math.max(temporaryPrice, item.itemPrice);
            expensiveItem = item;
        }

        System.out.println("The most expensive item is " + expensiveItem);



    }
}