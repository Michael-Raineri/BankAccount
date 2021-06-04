package Michael;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String output = null;
        double number = 0.0;
        boolean isQuit = false;
        ArrayList<Statement> statementsCurrentAcc = new ArrayList<Statement>();
        ArrayList<Statement> statementsSavingsAcc = new ArrayList<Statement>();
        BankAccount cust1Current = new BankAccount("Current");
        BankAccount cust1Savings = new BankAccount("Savings");

        System.out.println("Welcome to your bank account. You currently have two accounts:");
        System.out.println("Main Account: Current account: With a balance of " + cust1Current.getBalance());
        System.out.println("Savings account: With a balance of " + cust1Savings.getBalance());
        System.out.println();
        System.out.println("The commands that can be use are as follows:");
        System.out.println("D - Deposit to your main account");
        System.out.println("W - Withdraw from you main account");
        System.out.println("S - Show you bank statement");
        System.out.println("TS - Transfer from your main account to your savings account");
        System.out.println("TC - Transfer from your savings account to you main account");
        System.out.println("H - List all available commands");
        System.out.println("Q - Quit the bank account");

        while (!isQuit) {

            try {

                output = scanner.next();
                switch (output) {
                    case "D":
                        System.out.print("Enter deposit amount: £");
                        number = scanner.nextDouble();
                        cust1Current.deposit(number);
                        statementsCurrentAcc.add(new Statement(cust1Current.getDate(), cust1Current.getTransactionType(),
                                cust1Current.getTransactionAmount(), cust1Current.getBalance()));
                        break;

                    case "W":
                        System.out.print("Enter Withdrawal amount: £");
                        number = scanner.nextDouble();
                        cust1Current.withdraw(number);
                        statementsCurrentAcc.add(new Statement(cust1Current.getDate(), cust1Current.getTransactionType(),
                                cust1Current.getTransactionAmount(), cust1Current.getBalance()));
                        break;

                    case "S":
                        System.out.println("Savings account('Savings') or Current account('Current')");
                        output = scanner.next();
                        ArrayList<Statement> allStatements = new ArrayList<Statement>();

                        if (output.equals("Savings")|output.equals("Current")){

                            if (output.equals("Savings")){
                                allStatements = statementsSavingsAcc;
                            }

                            else if (output.equals("Current")){
                                allStatements = statementsCurrentAcc;
                            }

                            System.out.println("Filter by: All(SA), Deposits(SD), Withdrawals(SW)");
                            output = scanner.next();
                            switch (output) {
                                case "SA":
                                    for (Statement statement : allStatements) {
                                        System.out.println(statement.toString());
                                    }
                                    System.out.println("------------------------------");
                                    break;

                                case "SD":
                                    for (Statement statement : allStatements) {
                                        if (statement.getTransactionType().equals("Deposit")) {
                                            System.out.println(statement.toString());
                                        }
                                    }
                                    System.out.println("------------------------------");
                                    break;

                                case "SW":
                                    for (Statement statement : allStatements) {
                                        if (statement.getTransactionType().equals("Withdraw")) {
                                            System.out.println(statement.toString());
                                        }
                                    }
                                    System.out.println("------------------------------");
                                    break;

                                default:
                                    System.out.println("Command not recognised. Transaction Terminated");
                                    break;

                            }
                        }

                        else {
                            System.out.println("Command not recognised. Transaction Terminated");
                        }
                        break;

                    case "TS":
                        System.out.print("Enter amount to transfer to savings account: £");
                        number = scanner.nextDouble();
                        cust1Current.transfer(number);
                        statementsCurrentAcc.add(new Statement(cust1Current.getDate(), cust1Current.getTransactionType(),
                                cust1Current.getTransactionAmount(), cust1Current.getBalance()));
                        cust1Savings.deposit(number);
                        statementsSavingsAcc.add(new Statement(cust1Savings.getDate(), cust1Savings.getTransactionType(),
                                cust1Savings.getTransactionAmount(), cust1Savings.getBalance()));
                        break;

                    case "TC":
                        System.out.print("Enter amount to transfer to current account: £");
                        number = scanner.nextDouble();
                        cust1Savings.transfer(number);
                        statementsSavingsAcc.add(new Statement(cust1Savings.getDate(), cust1Savings.getTransactionType(),
                                cust1Savings.getTransactionAmount(), cust1Savings.getBalance()));
                        cust1Current.deposit(number);
                        statementsSavingsAcc.add(new Statement(cust1Current.getDate(), cust1Current.getTransactionType(),
                                cust1Current.getTransactionAmount(), cust1Current.getBalance()));
                        break;

                    case "H":
                        System.out.println("D - Deposit to your main account");
                        System.out.println("W - Withdraw from you main account");
                        System.out.println("S - Show you bank statement");
                        System.out.println("TS - Transfer from your main account to your savings account");
                        System.out.println("TC - Transfer from your savings account to you main account");
                        System.out.println("H - List all available commands");
                        System.out.println("Q - Quit the bank account");
                        break;

                    case "Q":
                        isQuit = true;
                        break;

                    default:
                        System.out.println("Try a different command. Press H for a list of commands");
                        break;

                }
            } catch (Exception e) {}
        }
    }
}