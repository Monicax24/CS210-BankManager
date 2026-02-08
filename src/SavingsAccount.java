public class SavingsAccount extends BankAccount {
    public static final double interestRate = 2.5;

    public SavingsAccount(int accountNumber, String accountType, double balance) {
        super(accountNumber, accountType, balance);
    }

    public void applyInterest() {
        setBalance(getBalance() + interestRate);
    }

    public double calculateInterest(double interestRate) {
        return getBalance()*interestRate;
    }
}
