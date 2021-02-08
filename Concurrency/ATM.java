package Concurrency;
/**
 * Runnable object with a shared resource
 */

public class ATM implements Runnable {

    public static BankAccount account = new BankAccount(23654, "John Doe", "9785412J", 0);

    int option;

    public ATM(int option) {
        this.option = option;
    }

    public double balance(int code) {
        if (account.getAccNumber() == code)
            return account.getBalance();
        else
            return -1;
    }

    public void run() {
        switch(option) {
            case 1:
                account.deposit(25000);
                break;
                
            case 2:
                account.withdraw(25000);
                break;
        }
    }
}
