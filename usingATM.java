/**
 * Example of concurrency problem. Various threads operating on a single shared resource without mutual exclusion management
 */
import java.util.Scanner;

public class usingATM {
    
    public static void main(String[] args) throws InterruptedException {

        Scanner keyboard = new Scanner(System.in);
        int size = 5000;
        ATM[] atms = new ATM[size];
        Thread[] threads = new Thread[size];

        for (int i = 0; i < atms.length; i++) {
            if (i % 2 != 0)
                atms[i] = new ATM(1);
            else
                atms[i] = new ATM(2);
        }

        ATM.account.deposit(100000);

        System.out.println("Initial funds: " + atms[0].balance(23654) + "\n\nEnter to start..."); // Let us know the account number
        keyboard.nextLine();

        for (int i = 0; i < size; i++)
            threads[i] = new Thread(atms[i]);
            
        for (int i = 0; i < size; i++)
            threads[i].start();

        for (int i = 0; i < size; i++)
            threads[i].join();

        System.out.println("Funds after " + size + " operations: " + atms[0].balance(23654));
    }
}
