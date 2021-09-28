import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    //constructor
    public Order(){
        name = "Guest";
        items = new ArrayList<Item>();
    }

    //overload constructor
    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }

    //getter for name
    public String getName(){
        return name;
    }

    //setter for name
    public void setName(String name){
        this.name = name;
    }

    //getter for ready
    public Boolean getReady(){
        return ready;
    }

    //setter for ready
    public void setReady(Boolean ready){
        this.ready = ready;
    }

    //getter for items
    public ArrayList<Item> getItem(){
        return items;
    }

    //setter for items
    public void setItem(ArrayList<Item> items){
        this.items = items;
    }

    public void addItem(Item item){
         items.add(item);
    }

    public String getStatusMessage(){
        if(ready){
            return "Your order is ready";
        } else {
            return "Thank you for waitin. Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0;
        for(Item item:items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
            System.out.println("Customer name: " + name);
            for(Item item:items){
                System.out.println(item.getName() + " - $" + item.getPrice());
             }
            System.out.println("Total: $" + getOrderTotal());
    }
}
