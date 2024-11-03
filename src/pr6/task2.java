package pr6;

interface Priceable {
    double getPrice();
}

class Product implements Priceable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price + " р";
    }
}

class Service implements Priceable {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Service(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getPrice() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + " р (Hourly Rate: " + hourlyRate + " р for " + hoursWorked + " hours)";
    }
}

public class task2 {
    public static void main(String[] args) {
        Priceable item1 = new Product("Milk", 79.00);
        Priceable item2 = new Product("Sausages", 163.00);
        Priceable service1 = new Service("The saleswoman", 125.00, 3);

        System.out.println(item1);
        System.out.println("Price: " + item1.getPrice() + " р");

        System.out.println(item2);
        System.out.println("Price: " + item2.getPrice() + " р");

        System.out.println(service1);
        System.out.println("Price: " + service1.getPrice() + " р");
    }
}