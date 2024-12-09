package pr20;

// Обобщенный класс MinMax
class MinMax<T extends Comparable<T>> {
    private T[] array;

    // Конструктор принимает массив
    public MinMax(T[] array) {
        this.array = array;
    }

    // Метод для нахождения минимального элемента
    public T findMin() {
        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    // Метод для нахождения максимального элемента
    public T findMax() {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 8, 1, 9};
        MinMax<Integer> minMax = new MinMax<>(intArray);
        System.out.println("Min: " + minMax.findMin()); // Min: 1
        System.out.println("Max: " + minMax.findMax()); // Max: 9

        String[] strArray = {"apple", "orange", "banana", "grape"};
        MinMax<String> strMinMax = new MinMax<>(strArray);
        System.out.println("Min: " + strMinMax.findMin()); // Min: apple
        System.out.println("Max: " + strMinMax.findMax()); // Max: orange
    }
}

// Класс Calculator с обобщенными статическими методами
public class Calculator {

    // Сложение двух чисел разных типов
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    // Умножение двух чисел разных типов
    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    // Деление двух чисел разных типов
    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

    // Вычитание двух чисел разных типов
    public static <T extends Number, U extends Number> double subtract(T num1, U num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        Integer intNum = 10;
        Double doubleNum = 5.5;

        System.out.println("Sum: " + sum(intNum, doubleNum)); // Sum: 15.5
        System.out.println("Multiply: " + multiply(intNum, doubleNum)); // Multiply: 55.0
        System.out.println("Divide: " + divide(intNum, doubleNum)); // Divide: 1.8181818181818181
        System.out.println("Subtract: " + subtract(intNum, doubleNum)); // Subtract: 4.5
    }
}

