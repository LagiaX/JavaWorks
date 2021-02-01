/**
 * Using Complex type objects
 */
import java.util.Scanner;

public class usingComplex {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        boolean sameNumbers = true;
        double a, b, c, d;

        do {
            System.out.println("\n--Complex calculator--\n  Input complex numbers to execute:\n    1.Add complex: (a+bi) + (c+di)\n    2.Multiply complex: (a+bi) x (c+di)\n    3.Divide complex: (a+bi) / (c+di)\n    4.Find module: |a+bi| |c+di|\n    5.Exit\n");
            
            System.out.print("    a + bi: ");
            a = keyboard.nextDouble();
            b = keyboard.nextDouble();
            System.out.print("    c + di: ");
            c = keyboard.nextDouble();
            d = keyboard.nextDouble();
            Complex c1 = new Complex(a, b);
            Complex c2 = new Complex(c, d);

            do {
                System.out.println("Operation: ");
                int option = keyboard.nextInt();
                keyboard.nextLine(); // Clear buffer

                switch(option) {
                    case 1:
                        System.out.println("Answer: " + (c1.addition(c2).toString()));
                        break;
    
                    case 2:
                        System.out.println("Answer: " + (c1.product(c2).toString()));
                        break;
    
                    case 3:
                        System.out.println("Answer: " + (c1.division(c2).toString()));
                        break;
    
                    case 4:
                        System.out.println("Answer: " + c1.module() + "    " + c2.module());
                        break;

                    case 5:
                        flag = false;
                        break;
                }
                
                if (flag) {
                    System.out.println("Use same values? y/n \n    a + bi: " + c1.toString() + "    c + di: " + c2.toString());
                    if (keyboard.nextLine().equals("y"))
                        sameNumbers = true;
                    else
                        sameNumbers = false;
                }
                
            } while (sameNumbers);
        } while (flag);

        System.out.println("    ( ( Bye bye~! ) )");
    }
}
