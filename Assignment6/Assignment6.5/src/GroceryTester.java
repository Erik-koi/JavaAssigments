import java.util.ArrayList;

public class GroceryTester {

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

    public double calculateTotalCost() {
        double total = 0;
        for (Item it : groceryList) {
            total += it.cost * it.quantity;
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category \"" + category + "\":");
        boolean found = false;
        for (Item it : groceryList) {
            if (it.category.equals(category)) {
                System.out.println("- " + it.name + " (x" + it.quantity + ")");
                found = true;
            }
        }
        if (!found) System.out.println("(none)");
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
        GroceryTester tester = new GroceryTester();

        System.out.println("===== Total cost test =====");
        tester.addItem("Apples", 1.20, "Fruits", 5);
        tester.addItem("Milk",   2.50, "Dairy",  2);
        tester.addItem("Bread",  3.10, "Bakery", 1);
        System.out.println("Total cost: " + tester.calculateTotalCost());

        System.out.println();
        System.out.println("===== Category test =====");
        tester.displayByCategory("Fruits");
        System.out.println();
        tester.displayByCategory("Dairy");
        System.out.println();
        tester.displayByCategory("Bakery");

        System.out.println();
        System.out.println("===== Quantity test =====");
        tester.displayAvailableItems();

        System.out.println();
        System.out.println("Updating quantity of \"Milk\" to 7...");
        tester.updateQuantity("Milk", 7);

        System.out.println();
        tester.displayAvailableItems();

        System.out.println();
        System.out.println("Total cost after update: " + tester.calculateTotalCost());
    }
}