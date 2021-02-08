package BasicJava;
/**
 * Prints n random numbers, depending on an argument passed via command line
 */

public class Random {
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        for (int i = 0; i <= n; i++)
            System.out.println((int)Math.floor(Math.random() * 100));
    }
}
