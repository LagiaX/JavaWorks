package BasicJava;
/**
 * Abstraction of a hospital patient
 */

public class Patient {
    private String name;
    private String id;
    private int phoneNumber;
    private String address;
    private String insurance;

    public Patient(String name, String id, int phoneNumber, String address, String insurance) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.insurance = insurance;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public int getPhoneNum() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getInsurance() {
        return insurance;
    }
}
