package hw3;

/**
 * @author Tiancheng Xu
 */

import java.text.DecimalFormat;

public class Complex{
    
    private double real, imag;
    DecimalFormat dcmp = new DecimalFormat("0.00");

    public Complex(double real, double imag) {
        this.real = Double.parseDouble(dcmp.format(real));
        this.imag = Double.parseDouble(dcmp.format(imag));;
    }

    public Complex add(Complex c) {
        return new Complex(this.real+c.real, this.imag+c.imag);
    }
    
    public Complex sub(Complex c) {
        return new Complex(this.real-c.real, this.imag-c.imag);
    }

    public Complex mult(Complex c) {
        return new Complex(this.real*c.real-this.imag*c.imag, this.imag*c.real+this.real*c.imag);
    }

    public Complex div(Complex c) {
        return new Complex((this.real*c.real+this.imag*c.imag)/(c.real*c.real+c.imag*c.imag)
                        , (this.imag*c.real-this.real*c.imag)/(c.real*c.real+c.imag*c.imag));
    }

    public Complex neg() {
        return new Complex(-this.real, -this.imag);
    }

    public boolean eql(Complex c) {
        if (this.real == c.real && this.imag == c.imag) {
            return true;
        } else {
            return false;
        }
    }

    public double abs() {
        return Double.parseDouble(dcmp.format(Math.sqrt(this.real*this.real + this.imag*this.imag)));
    }

    public double magSq() {
        return Double.parseDouble(dcmp.format(this.real*this.real + this.imag*this.imag));
    }

    public Complex conju() {
        return new Complex(this.real, -this.imag);
    }

    public String toString() {
        // String r = String.format(%.1f, this.real);
        if (this.imag < 0) {
            return this.real + "" + this.imag + "i";
        } else {
            return this.real + "+" + this.imag + "i";
        }
    }
    
    public static void main(String[] args) {
        Complex c1 = new Complex(2.5, 3.1); // r,i, real, imag  re, im
        System.out.println(c1);
        Complex c2 = new Complex(2.7, -1.7);
        Complex c8 = new Complex(2.5, 3.1);
        System.out.println(c2);
        Complex c3 = c1.add(c2); // add them   c1 and c2 should not change
        System.out.println(c3);
        Complex c4 = c1.sub(c2); // subtract them
        System.out.println(c4);
        Complex c5 = c1.mult(c2);
        System.out.println(c5);
        Complex c6 = c1.neg(); // -c1
        System.out.println(c6);
        double m = c1.abs(); // magnitude of the number
        System.out.println(m);
        double m2 = m*m;
        System.out.println(m2);
        double msq = c1.magSq(); // square of the abs()
        System.out.println(msq);

        // add your own methods (at least double) to double your score to 200%
        Complex c7 = c1.div(c2);
        System.out.println(c7);
        
        System.out.println(c1.eql(c2));
        System.out.println(c1.eql(c8));

        Complex c9 = c1.conju();
        System.out.println(c9);
    }
}