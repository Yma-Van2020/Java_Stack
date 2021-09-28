public class TestBank {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();
     
        System.out.println(BankAccount.getAccountsCreated());
        account1.depositeMoney("checking", 1200);
        account1.depositeMoney("saving", 500);
        // account1.withdrawFund("checking", 1300);
        account1.withdrawFund("checking", 1000);
        account1.displayTotalFunds();
        System.out.println(BankAccount.getAccountsTotal());
    }
}
