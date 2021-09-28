public class BankAccount {
    private double checking;
    private double saving;
    private static int accountsCreated;
    private static double accountsTotal;

    public BankAccount(){
        accountsCreated++;
        checking = 0;
        saving = 0;
    }

    //getter for the checkung acc balance
    public double getCheckingBalance(){
        return checking;
    }

    public static int getAccountsCreated(){
        return accountsCreated;
    }

    public double getSavingBalance(){
        return saving;
    }

    public static double getAccountsTotal(){
        return accountsTotal;
    }

    public void depositeMoney(String account, double amount){
        if(account.equals("checking")){
            checking += amount;
        } else if(account.equals("saving")){
            saving += amount;
        }
        accountsTotal += amount;
    }

    public void withdrawFund(String account, double amount){
        if(account.equals("checking") && checking >= amount){
            checking -= amount;
        } else if(account.equals("saving") && checking >= amount){
            saving -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
        accountsTotal -= amount;
    }

    public void displayTotalFunds(){
        System.out.println("Saving: " + saving + ". Checking: " + checking);
    }
}
