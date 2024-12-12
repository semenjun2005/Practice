package pr24;


interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int imaginary);
}

class Complex {
    private int real; // Действительная часть
    private int imaginary; // Мнимая часть

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex(); // Создает комплексное число по умолчанию (0 + 0i)
    }

    @Override
    public Complex createComplex(int real, int imaginary) {
        return new Complex(real, imaginary); // Создает комплексное число с указанными параметрами
    }
}

public class task1 {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        Complex defaultComplex = factory.createComplex();
        System.out.println("Default Complex Number: " + defaultComplex);

        Complex customComplex = factory.createComplex(5, -3);
        System.out.println("Custom Complex Number: " + customComplex);
    }
}
