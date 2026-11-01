import java.util.ArrayList;

public class GroceryCategoryManager {

    private static class Item {
        String name;
        double cost;
        String category;

        Item(String name, double cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }
    }

    private ArrayList<Item> groceryList = new ArrayList<>();

    public void addItem(String item, double cost, String category) {
        for (Item it : groceryList) {
            if (it.name.equals(item)) {
                System.out.println("Item \"" + item + "\" already in the list.");
                return;
            }
        }
        groceryList.add(new Item(item, cost, category));
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category \"" + category + "\":");
        boolean found = false;
        for (Item it : groceryList) {
            if (it.category.equals(category)) {
                System.out.println("- " + it.name);
                found = true;
            }
        }
        if (!found) System.out.println("(none)");
    }

    public static void main(String[] args) {
        GroceryCategoryManager manager = new GroceryCategoryManager();

        manager.addItem("Banana", 0.90, "Fruits");
        manager.addItem("Apple",  1.10, "Fruits");
        manager.addItem("Milk",   2.40, "Dairy");
        manager.addItem("Cheese", 4.50, "Dairy");
        manager.addItem("Bread",  2.30, "Bakery");

        manager.displayByCategory("Fruits");
        System.out.println();
        manager.displayByCategory("Dairy");
        System.out.println();
        manager.displayByCategory("Bakery");
    }
}