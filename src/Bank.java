import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private int nextAccountNumber = 1;
    private BankAccount[] bankAccounts = new BankAccount[10]; //Array of bank accounts

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        bank.displayMenu();
        int input = 0;
        while (true) { //checks for incorrect input
            try{
                input = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Enter a number from 1 to 6.");
                scan.nextLine(); //clear input
                continue; //Skips everything else and waits for user to input again
            }

            if (input == 1){ //creates account based on user input of s or c
                System.out.println("Enter 'S' for Saving or 'C' for Checking: ");
                String account = scan.nextLine().toLowerCase(); //No case sensitivity
                if (account.equals("s")){
                    System.out.println("Enter initial balance: ");
                    double initialBalance = scan.nextDouble();
                    bank.createSavingsAccount(initialBalance);
                }
                else if (account.equals("c")){
                    System.out.println("Enter initial balance: ");
                    double initialBalance = scan.nextDouble();
                    System.out.println("Enter overdraft limit: ");
                    double overdraftLimit = scan.nextDouble();
                    scan.nextLine();
                    bank.createCheckingAccount(initialBalance, overdraftLimit);
                }
            } else if (input == 2) { //deposits amount into account if input = 2
                System.out.println("Enter account number: ");
                String accountNumber = scan.nextLine();
                System.out.println("Enter deposit amount: ");
                double depositAmount = scan.nextDouble();
                bank.deposit(accountNumber, depositAmount);

            } else if (input == 3) { //withdraws amount into account if input = 3
                System.out.println("Enter account number: ");
                String accountNumber = scan.nextLine();
                System.out.println("Enter withdraw amount: ");
                double withdrawAmount = scan.nextDouble();
                bank.withdraw(accountNumber, withdrawAmount);

            } else if (input == 4) { //displays all accounts if input = 4
                bank.displayAllAccounts();

            } else if (input == 5) { //applies interest rate to account if input = 5
                bank.applyInterestRate();
                System.out.println("Successful Process, Interest Rate was applied to all Saving Accounts.");

            } else if(input == 6){
                System.out.println("Exiting");
                break; //exit
            }else{
                System.out.println("Invalid input. Try again.");
            }
            bank.displayMenu();
        }
    }





    public void createSavingsAccount(double balance){ //creates savings account
        BankAccount savingsAccount = new SavingsAccount(nextAccountNumber, "SavingsAccount", balance);
        bankAccounts[nextAccountNumber - 1] = savingsAccount; //first account is AC1
        nextAccountNumber++;
        System.out.println("Account created. Account number: " + savingsAccount.getAccountNumber() + ". Account Balance: " + savingsAccount.getBalance());
    }

    public void createCheckingAccount(double balance, double overDraftLimit){ //creates checking account
        BankAccount checkingAccount = new CheckingAccount(nextAccountNumber, "CheckingAccount", balance, overDraftLimit);
        bankAccounts[nextAccountNumber - 1] = checkingAccount; //first account is AC1
        nextAccountNumber++;
        System.out.println("Account created. Account number: " + checkingAccount.getAccountNumber() + ". Account Balance: " + checkingAccount.getBalance());
    }

    public void deposit(String accountNumber, double amount){ //deposits money if account exists
        for (int i = 0; i < 10; i++){
             if(bankAccounts[i] != null && bankAccounts[i].getAccountNumber().equals(accountNumber)){ //first check not null to prevent nullpointerexception
                if (bankAccounts[i].deposit(amount)){
                    System.out.println("Deposit successful");
                    return;
                } else {
                    System.out.println("Deposit failed  - Must Deposit More than $0");
                }
            }
        } System.out.println("Account not found");
    }

    public void withdraw(String accountNumber, double amount){ //withdraws money if account exists
        for (int i = 0; i < 10; i++){
            String currBankNumber = bankAccounts[i].getAccountNumber();
            if (bankAccounts[i] != null && bankAccounts[i].getAccountNumber().equals(accountNumber)){
                if (bankAccounts[i].withdraw(amount)){
                    System.out.println("Withdraw successful");
                } else {
                    System.out.println("Failed Withdrawal, Insufficient Saving Account Balance");
                }
            }
        } System.out.println("Account not found");
    }

    public void applyInterestRate(){ //applies interest rate to account if it exists
        for (int i = 0; i < 10; i++){
            if (bankAccounts[i] != null && bankAccounts[i] instanceof SavingsAccount){
                ((SavingsAccount) bankAccounts[i]).applyInterest();
            }
        }
    }

    public void displayAllAccounts(){
        for (int i = 0; i < 10; i++){
            if (bankAccounts[i] != null) {
                System.out.println("Account Number: " + bankAccounts[i].getAccountNumber() + ", Type: " + bankAccounts[i].getAccountType() + ", Balance: " + bankAccounts[i].getBalance());
            }
        }
    }

    public void displayMenu(){
        System.out.println("1. Create Account\n 2. Deposit\n 3. Withdraw\n 4. Display All Accounts\n 5. ApplyInterestRateToAccounts\n 6. Exit\n Choose an option: ");
    }
}
