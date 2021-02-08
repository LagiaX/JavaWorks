package Concurrency;
/**
 * Abstraction of a bank account
 */

public class BankAccount {
    
    private int accNumber;
    private String ownerName;
    private String ownerID;
    private double balance;

    public BankAccount(int accNumber, String ownerName, String ownerID, double balance) {
        this.accNumber = accNumber;
        this.ownerName = ownerName;
        this.ownerID = ownerID;
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String value) {
        ownerName = value;
    }

    public void setOwnerID(String value) {
        ownerID = value;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        if (balance >= value)
            balance -= value;
        else
            System.out.println("Error in withdrawal operation. Not enough funds.");
    }
}
