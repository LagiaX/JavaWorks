/**
 * Codifies a string using the Cesar method
 */

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Cesar {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Input integer number:");
        int n = keyboard.nextInt();
        keyboard.nextLine(); // Clear buffer

        System.out.println("Input string to codify:");
        String string = keyboard.nextLine();

        System.out.println("Codification: ");
        for (int i = 0; i < string.length(); i++) {
            char index = string.charAt(i);
            if (Character.isUpperCase(index))      // Upper case character
                System.out.print(upperCase.charAt((upperCase.indexOf(index) + n) % 26));
            else if (Character.isLowerCase(index)) // Lower case character
                System.out.print(lowerCase.charAt((lowerCase.indexOf(index) + n) % 26));
            else                                   // Any other character
                System.out.print(string.charAt(i));
        }
    }
}
