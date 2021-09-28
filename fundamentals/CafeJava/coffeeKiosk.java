import javva.util.*;

public class coffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public coffeeKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public ArrayList<Item> addMenuItem(String name, double price){
        newItem = new Item();
        newItem.name = name;
        newItem.price = price;
        menu.add(newItem);
    }

    public void displayMenu(){
        for(int i =0; i < menu.size(); i++){
            System.out.println(i + " " + menu.get(i) + " -- $" + menu.get(i).price);
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        newOrder = new ArrayList<Order>();
        // Show the user the menu, so they can choose items to add.
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        
    }
}
