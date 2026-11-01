import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println("Item \"" + item + "\" already in the list.");
            return;
        }
        groceryList.add(item);
    }

    public boolean removeItem(String item) {
        if (!groceryList.contains(item)) {
            System.out.println("Item \"" + item + "\" not found.");
            return false;
        }
        groceryList.remove(item);
        return true;
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("(empty list)");
            return;
        }
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        System.out.println("Grocery List:");
        manager.displayList();

        System.out.println();
        System.out.println("Is \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.println();
        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println();
        System.out.println("Updated Grocery List:");
        manager.displayList();
    }
}