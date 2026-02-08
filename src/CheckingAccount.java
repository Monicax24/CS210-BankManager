public class CheckingAccount extends BankAccount {
    private final double overdraftLimit;

    public CheckingAccount(int accountNumber, String accountType, double balance, double overDraftLimit) {
        super(accountNumber, accountType, balance);
        this.overdraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return overdraftLimit;
    }

    public boolean withdraw(double amount) {
        double balance = getBalance();
        if (balance + overdraftLimit < amount){
            return false;
        }
        if (balance < 0){
            return false;
        }
        setBalance(balance - amount);
        return true;
    }
}

