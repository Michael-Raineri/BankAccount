package Michael;

public class Statement {
    private String date;
    private String transactionType;
    private double amount;
    private double balance;

    public Statement(String date, String transactionType, double amount, double balance){
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
    }

    public String toString() {
        return "Date: " + date + " , " + "Transaction Type: " + transactionType + " , " +
                "Amount: £" + amount + " , " + "Balance: £" + balance;
    }

    public String getTransactionType() {
        return transactionType;
    }

}
