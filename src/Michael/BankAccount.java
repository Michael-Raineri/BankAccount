package Michael;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private String date;
    private String transactionType;
    private double transactionAmount;
    private double balance;
    private String accountType;

    public BankAccount(String accountType){
        this.accountType = accountType;
    }

    public void deposit(double amount){
        if (amount > 0){
            transactionAmount = amount;
            balance = balance + amount;
            transactionType = "Deposit";
            System.out.println("You have deposited £" + amount);
            System.out.println("Your balance is in your " + accountType + " account is £" + balance);
            System.out.println("------------------------------");
        }

        else {
            System.out.println("You must deposit a amount greater than £0. Deposit Terminated");
        }
    }

    public void withdraw(double amount){
        if (balance < amount){
            System.out.println("Insufficient funds. Withdrawal terminated");
        }

        else if (amount > 0){
            transactionAmount = amount;
            balance = balance - amount;
            transactionType = "Withdrawal";
            System.out.println("you have withdrew £" + amount);
            System.out.println("Your balance is in your " + accountType + " account is £" + balance);
            System.out.println("------------------------------");
        }

        else {
            System.out.println("You must withdraw a amount greater than £0. Withdrawal terminated");
        }
    }

    public void transfer(double amount){
        if (balance < amount){
            System.out.println("Insufficient funds. transfer terminated");
        }

        else if (amount > 0){
            transactionAmount = amount;
            balance = balance - amount;
            transactionType = "Transfer";
            System.out.println("you have transferred £" + amount);
            System.out.println("Your balance is in your " + accountType + " account is £" + balance);
            System.out.println("------------------------------");
        }

        else {
            System.out.println("You must withdraw a amount greater than £0. Withdrawal terminated");
        }
    }

    public double getBalance(){
        return balance;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getDate(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

}
