import java.util.HashMap;

public class GroceryCostManager {

    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (groceryList.containsKey(item)) {
            System.out.println("Item \"" + item + "\" already in the list.");
            return;
        }
        groceryList.put(item, cost);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public void displayList() {
        for (String item : groceryList.keySet()) {
            System.out.println("- " + item + ": " + groceryList.get(item));
        }
    }

    public static void main(String[] args) {
        GroceryCostManager manager = new GroceryCostManager();

        manager.addItem("Apples", 1.20);
        manager.addItem("Milk",   2.50);
        manager.addItem("Bread",  3.10);

        System.out.println("Grocery List with costs:");
        manager.displayList();

        System.out.println();
        System.out.println("Total cost: " + manager.calculateTotalCost());
    }
}