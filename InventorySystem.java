import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventorySystem {
    private Map<Integer, Item> inventory;
    private int counter;

    public InventorySystem() {
        this.inventory = new HashMap<>();
        this.counter = 1; 
    }

    public void addInv(String name, int quantity, String category) {
        Item newItem = new Item(name, quantity, category);
        int sNo = generatesNo();
        inventory.put(sNo, newItem);
        System.out.println("Item " + name + " has been added to the inventory with Serial Number: " + sNo);
    }

    public void updateInv(int sNo, int quantity, String category) {
        if (inventory.containsKey(sNo)) {
            Item existingItem = inventory.get(sNo);
            existingItem.setQuantity(quantity);
            existingItem.setCategory(category);
            System.out.println("Item " + sNo + "' updated in the inventory.");
        } else {
            System.out.println("Item " + sNo + "' does not exist.");
        }
    }

    public void viewInv() {
        System.out.println("\nCurrent Inventory:");
        
        for (Map.Entry<Integer, Item> entry : inventory.entrySet()) {
            int sNo = entry.getKey();
            Item details = entry.getValue();
            System.out.println("Serial Number: " + sNo + ", Name: " + details.getName() + ", Quantity: " + details.getQuantity() + ", Category: " + details.getCategory());
        }
        
    }

    private int generatesNo() {
        return counter++;
    }
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item\n2. Update Item\n3. View Inventory\n4. EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter item category: ");
                    String addCategory = scanner.next();
                    inventorySystem.addInv(addName, addQuantity, addCategory);
                    break;
                case 2:
                    System.out.print("Enter item Serial Number: ");
                    int updatesNo = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter new category: ");
                    String updateCategory = scanner.next();
                    inventorySystem.updateInv(updatesNo, updateQuantity, updateCategory);
                    break;
                case 3:
                    inventorySystem.viewInv();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close(); 
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}

class Item {
    private String name;
    private int quantity;
    private String category;

    public Item(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}