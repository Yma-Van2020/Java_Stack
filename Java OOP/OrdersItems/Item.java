public class Item {
    private String name;
    private double price;

    //constructor
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    //getter for name
    public String getName(){
        return name;
    }

    //setter for price
    public void setName(String nameToSet){
        name = nameToSet;
    }

    //getter for price
    public double getPrice(){
        return price;
    }

    //setter for price
    public void setPrice(double priceToSet){
        price = priceToSet;
    }
}
