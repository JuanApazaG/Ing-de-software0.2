public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        double realPart = this.real + other.real;
        double imaginaryPart = this.imaginary + other.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex subtract(Complex other) {
        double realPart = this.real - other.real;
        double imaginaryPart = this.imaginary - other.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex multiply(Complex other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    public static void main(String[] args) {
        Complex x = new Complex(5, 3);
        Complex y = new Complex(-2, 1);

        Complex z = x.add(y);
        System.out.println("Suma:");
        System.out.println("Complex x");
        System.out.println(x);
        System.out.println("Complex y");
        System.out.println(y);
        System.out.println("Resultado");
        System.out.println(z);

        z = x.subtract(y);
        System.out.println("\nRestar:");
        System.out.println("Complex x");
        System.out.println(x);
        System.out.println("Complex y");
        System.out.println(y);
        System.out.println("Resultado");
        System.out.println(z);

        z = x.multiply(y);
        System.out.println("\nMultiplicar:");
        System.out.println("Complex x");
        System.out.println(x);
        System.out.println("Complex y");
        System.out.println(y);
        System.out.println("Resultado");
        System.out.println(z);
    }
}
