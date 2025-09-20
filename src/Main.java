import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Item> items = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static int itemId;
    static String itemName;
    static String itemCategory;
    static double itemPrice;

    public static int switchMenu(int choice) {

        System.out.println("\nMenu Options");
        System.out.println("1. Get All Items");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Get Most Expensive Item");
        System.out.println("5. Exit");

        System.out.print("\nPlease choose an option: ");

        try{
            choice =  scanner.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Invalid Input Type");
            System.out.println("Please enter a valid option");
        }

        scanner.nextLine();

        switch(choice) {
            case 1:
                getAllItems(items);
                break;
            case 2:
                addItem(items);
                break;
            case 3:
                if(items.isEmpty()){

                    System.out.println("\nThere are no Items in the Inventory");
                    System.out.println("You have nothing to remove");

                } else {

                    System.out.print("Enter Item ID of the Item you want to remove: ");
                    itemId = scanner.nextInt();

                    System.out.println(
                            (removeItemById(items, itemId) != null)
                            ? "\nSuccessfully removed item with ID " + itemId
                            : "\nNo item with ID " + itemId + " was found in the inventory "
                    );

                    System.out.println("You now have " + items.size() + " item(s) in your inventory!");
                }

                break;
            case 4:
                if(items.isEmpty()) {
                    System.out.println("\nThere are no items in the inventory yet");
                    System.out.println("Please add an item");
                } else {
                    System.out.println("\nThe most expensive " + getMostExpensiveItems(items) );
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

    public static void addItem(ArrayList<Item> items ) {
        System.out.println("\nPlease enter the item you want to add");

        do{
            System.out.print("\nEnter the item ID: ");
            try {
                itemId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input Type. Please enter a number.");
                scanner.nextLine();
            }
        } while(true);

        // Inserting item price

        do{
            System.out.print("Enter the item Name: ");
            itemName = scanner.nextLine().trim();

            if(itemName.isEmpty()) {
                System.out.println("Item name cannot be empty. Please enter a name.");
            }
        } while(itemName.trim().isEmpty());

        // Inserting item price

        do{
            System.out.print("Enter the item price: ");
            try {
                itemPrice = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input Type. Please enter a number.");
                scanner.nextLine();
            }
        } while(true);

        // Inserting item category

        do{
            System.out.print("Enter the item category: ");
            itemCategory = scanner.nextLine().trim();

            if(itemCategory.isEmpty()) {
                System.out.println("\nItem category cannot be empty. Please enter a category.");
            }
        } while(itemCategory.trim().isEmpty());

        //calling the addItem method

        items.add(new Item(itemId,itemName, itemPrice,itemCategory));

        System.out.println("Item added successfully");
        System.out.println("You now have " + items.size() + " item(s) in your inventory!");
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

        for (Item item : items) {
            if (item.itemId == itemId) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Welcome To Your Inventory Management System\n");

        do{
            choice = switchMenu(choice);

        } while(choice != 5);

    }
}