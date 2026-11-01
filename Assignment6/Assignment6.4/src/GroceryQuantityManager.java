import java.util.ArrayList;

public class GroceryQuantityManager {

    private static class Item {
        String name;
        double cost;
        String category;
        int quantity;

        Item(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    private ArrayList<Item> groceryList = new ArrayList<>();

    public void addItem(String item, double cost, String category, int quantity) {
        for (Item it : groceryList) {
            if (it.name.equals(item)) {
                it.quantity += quantity;
                it.cost = cost;
                it.category = category;
                return;
            }
        }
        groceryList.add(new Item(item, cost, category, quantity));
    }

    public boolean updateQuantity(String item, int newQuantity) {
        for (Item it : groceryList) {
            if (it.name.equals(item)) {
                it.quantity = newQuantity;
                return true;
            }
        }
        System.out.println("Item \"" + item + "\" not found.");
        return false;
    }

    public void displayAvailableItems() {
        System.out.println("Available items (quantity > 0):");
        boolean found = false;
        for (Item it : groceryList) {
            if (it.quantity > 0) {
                System.out.println("- " + it.name + " x" + it.quantity);
                found = true;
            }
        }
        if (!found) System.out.println("(none)");
    }

    public static void main(String[] args) {
        GroceryQuantityManager manager = new GroceryQuantityManager();

        manager.addItem("Apples", 1.20, "Fruits", 5);
        manager.addItem("Milk",   2.50, "Dairy",  2);
        manager.addItem("Bread",  3.10, "Bakery", 0);

        manager.displayAvailableItems();

        System.out.println();
        System.out.println("Updating quantity of \"Milk\" to 7...");
        manager.updateQuantity("Milk", 7);

        System.out.println();
        manager.displayAvailableItems();
    }
}