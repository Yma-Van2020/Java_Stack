import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Collections;

public class CafeUtil {
    public int getStreakGoal(int numOfWeeks){
        int sum = 0;
        for(int i = 0; i < numOfWeeks + 1; i++){
            sum = sum + i;
        }
        return sum;
    }

    public void printPriceChart(String ProductName, double price, int maxNumber){
        System.out.println(ProductName);
        double oriPrice = price;
        for(int i = 0; i < maxNumber; i++){
            System.out.println(i + 1 + " - " + "$" + price + "\n");
            price = price + oriPrice - 0.5;
        }
    }

    public double getOrderTotal(double[] items){
        double total = 0.0;
        for(double item : items){
            total += item;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> items, ArrayList<Double> prices){
        for(int i = 0; i < items.size(); i++){
            System.out.println(i + " " + items.get(i) + " -- " + "$" + prices.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("What is your name? \n");
        String userName = System.console().readLine(); 
        System.out.println("Hello, " + userName + ". There are " + customers.size() + " people ahead of you.");
        customers.add(userName);
    }

    public void addCustomers(ArrayList<String> customers){
        ArrayList<String> newCustomers = new ArrayList<String>();
        System.out.println("Please input customers, input \"q\" when done: \n");
        String newEntry ="";
        while(!newEntry.equals("q")){
            if (!newEntry.isEmpty()){
                newCustomers.add(newEntry);
                System.out.printf("%s \n",newCustomers);
            }
            newEntry = System.console().readLine();                     
        }
        customers.addAll(newCustomers);

    }
}
