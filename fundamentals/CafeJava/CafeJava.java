
public class CafeJava {
    public static void main(String[] args){
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 3;
        double lattePrice = 4.5;
        double cappiccinoPrice = 5;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

        System.out.println(generalGreeting + customer1);

        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage + ". " + displayTotalMessage + cappiccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(customer2 + ". " + displayTotalMessage + lattePrice*2);
        if(isReadyOrder2){
            System.out.println(customer2 + readyMessage);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(customer3 + ", " + displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}
