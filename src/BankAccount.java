public abstract class BankAccount {
    private int accountNumber;
    private String accountType;
    private double balance;

    public BankAccount(int accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;

    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public boolean deposit(double amount){
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public String getAccountNumber(){
        return "AC" + accountNumber;
    }

    public boolean withdraw(double amount){
        if (balance > 0){
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getAccountType(){
        return accountType;
    }

}
