package BasicJava;
/**
 * Simulation of a database for a hospital
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class usingPatient {
    
    public static ArrayList<Patient> patients = new ArrayList<Patient>();

    public static void insert(Patient p) {
        patients.add(p);
    }

    public static boolean remove(Patient p) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient q = (Patient)it.next();
            if (p.getID() == q.getID() && p.getName() == q.getName()) {
                return patients.remove(p);
            }
        }
        return false;
    }

    public static Patient find(String id) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient q = (Patient)it.next();
            if (id.equals(q.getID())) {
                return q;
            }
        }
        return new Patient("-", "-", 0, "-", "-");
    }

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;

        System.out.println("--PATIENTS DATABASE--");

        do {
            System.out.println("\n    1.Find patient.\n    2.Insert new patient.\n    3.Remove patient.\n    4.Exit.");
            int option = keyboard.nextInt();
            keyboard.nextLine(); // Clear buffer
            
            switch (option) {
                case 1: // Find
                    System.out.print("Patient ID: ");
                    String arg1 = keyboard.nextLine();
                    Patient q = find(arg1);
                    if (q.getPhoneNum() != 0)
                        System.out.println("\nPatient data:\n    Name: "+q.getName()+"\n    ID: "+q.getID()+"\n    Phone Number: "+q.getPhoneNum()+"\n    Address: "+q.getAddress()+"\n    Insurance: "+q.getInsurance());
                    else
                        System.out.println("Patient not found");
                    break;

                case 2: // Insert
                    System.out.println("Insert patient data.");
                    System.out.print("    Name: ");
                    String name = keyboard.nextLine();
                    System.out.print("    ID: ");
                    String id = keyboard.nextLine();
                    System.out.print("    Phone number: ");
                    int phoneNumber = keyboard.nextInt();
                    keyboard.nextLine(); // Clear buffer
                    System.out.print("    Address: ");
                    String address = keyboard.nextLine();
                    System.out.print("    Insurance company: ");
                    String insurance = keyboard.nextLine();
                    insert(new Patient(name, id, phoneNumber, address, insurance));
                    break;

                case 3: // Remove
                    System.out.print("Patient full name or ID: ");
                    String arg2 = keyboard.nextLine();
                    Patient r = find(arg2);
                    if (remove(r))
                        System.out.println("\nSuccessfully removed\n");
                    else
                        System.out.println("\nError removing patient\n");
                    break;

                case 4: // Exit
                    flag = false;
                    break;
            }

            if (flag) {
                System.out.println("\n--Press enter to continue--");
                keyboard.nextLine();
            }
        } while (flag);

        System.out.println("    ( ( Bye bye~! ) )");
        keyboard.close();
    }
}
