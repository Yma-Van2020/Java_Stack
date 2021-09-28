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
}
