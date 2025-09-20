import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Item> items = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static int switchMenu(int choice) {
        int itemId;

        System.out.println("\nMenu Options");
        System.out.println("1. Get All Items");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Get Most Expensive Item");
        System.out.println("5. Exit");

        System.out.print("\nPlease choose an option: ");
        choice = scanner.nextInt();

        switch(choice) {
            case 1:
                getAllItems(items);
                break;
            case 2:
                System.out.println("\nPlease enter the item you want to add");

                System.out.print("Enter the item ID: ");
                itemId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the item Name: ");
                String itemName = scanner.nextLine();

                System.out.print("Enter the item price: ");
                double itemPrice = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter the item category: ");
                String itemCategory = scanner.next();

                addItem(items,itemId,itemName,itemPrice,itemCategory);

                System.out.println("Item added successfully");
                System.out.println("You now have " + items.size() + " item(s) in your inventory!");
                break;
            case 3:
                itemId = scanner.nextInt();
                removeItemById(items, itemId);
                break;
            case 4:
                if(items.isEmpty()) {
                    System.out.println("\nThere are no items in the inventory yet");
                    System.out.println("Please add an item");
                } else {
                    System.out.println("\nThe most expensive item " + getMostExpensiveItems(items) );
                }
                break;
            case 5:
                System.out.println("\nExit");
                System.out.println("The System Says Goodbye!");
                break;
            default:
                System.out.println("\nInvalid choice");
                break;
        }

        return choice;
    }

    public static void addItem(ArrayList<Item> items, int itemId, String itemName, double itemPrice, String itemCategory ) {
        items.add(new Item(itemId,itemName, itemPrice,itemCategory));
    }

    public static void getAllItems(ArrayList<Item> items) {

        if(items.isEmpty()) {
            System.out.println("\nThere are no items in the inventory yet");
            System.out.println("Please add an item");
        } else {
            System.out.println("\nA list of all items in the inventory");
            for (Item item : items) {
                System.out.println("\n" + item);
            }
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

        do{
            choice = switchMenu(choice);

        } while(choice != 5);

    }
}