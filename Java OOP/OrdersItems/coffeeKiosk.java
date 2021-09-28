import javva.util.*;

public class coffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public coffeeKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
       Item newItem = new Item(name, price);
       menu.add(newItem);
       newItem.setIndex(menu.size());
    }

    public void displayMenu(){
        for(Item item : menu){
            System.out.println(i + " " + menu.get(i) + " -- $" + menu.get(i).getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            newOrder.addItem(menu.get(itemNumber));
            // Get the item object from the menu, and add the item to the order
            displayMenu();
            System.out.println("Please enter a enw item index or q to stop");
            itemNumber = System.console().readLine();
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
       orders.add(newOrder);
       newOrder.display();
    	// as the example below. You may use the order's display method.
        
    }
}
