import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome To Your Inventory Management System\n");

        ArrayList<String> items = new ArrayList<>();

        items.add("Sword");
        items.add("Axe");
        items.add("Pickaxe");
        items.add("Shovel");
        items.add("Hoe");
        items.add("Pickaxe");

        System.out.println(items);

    }
}