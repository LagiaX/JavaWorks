package BasicJava;
/**
 * Abstraction of a complex number
 */

public class Complex {
    
    private double[] complex = new double[2];

    public Complex(double real, double imagin) {
        complex[0] = real;
        complex[1] = imagin;
    }

    public double getReal() {
        return complex[0];
    }

    public double getImagin() {
        return complex[1];
    }

    public void setReal(double value) {
        complex[0] = value;
    }

    public void setImagin(double value) {
        complex[1] = value;
    }

    public String toString() {
        if (getImagin() >= 0)
            return new String(getReal() + " + " + getImagin() + "i");
        else
            return new String(getReal() + " - " + -getImagin() + "i");
    }

    public Complex addition(Complex b) {
        return new Complex(getReal() + b.getReal(), getImagin() + b.getImagin());
    }

    public Complex product(Complex b) {
        return new Complex(getReal() * b.getReal() - getImagin() * b.getImagin(), getReal() * b.getImagin() + getImagin() * b.getReal());
    }

    public Complex division(Complex b) {
        return new Complex(
            (getReal() * b.getReal() + getImagin() * b.getImagin()) / (Math.pow(b.getReal(), 2) + Math.pow(b.getImagin(), 2)),
            (getImagin() * b.getReal() - getReal() * b.getImagin()) / (Math.pow(b.getReal(), 2) + Math.pow(b.getImagin(), 2))
        );
    }

    public double module() {
        return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImagin(), 2));
    }
}
