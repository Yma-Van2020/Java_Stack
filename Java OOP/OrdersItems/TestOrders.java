import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args){

        Item item1 = new Item();
        item1.name = "Mocha";
        item1.price = 2.0;

        Item item2 = new Item();
        item2.name = "Latte";
        item2.price = 3.5;

        Item item3 = new Item();
        item3.name = "Capp";
        item3.price = 4.0;

        Item item4 = new Item();
        item4.name = "Drip coffee";
        item4.price = 4.2;

        Order order1 = new Order();
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add(item1);
        order2.total += item2.price;

        Order order3 = new Order();
        order3.name = "Wendy";
        order3.items.add(item3);
        order3.total += item3.price;


        Order order4 = new Order();
        order4.name = "Sam";
        order4.items.add(item2);
        order4.total += item2.price;
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        order1.ready = true;
        order4.ready = true;

        System.out.println(order2.total);
    }
}
