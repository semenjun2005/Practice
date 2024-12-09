package pr20;

import java.io.Serializable;

// Обобщенный класс с ограничениями на типы
public class GenericClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T value1;
    private V value2;
    private K value3;

    // Конструктор
    public GenericClass(T value1, V value2, K value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    // Методы для получения значений переменных
    public T getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

    public K getValue3() {
        return value3;
    }

    // Метод, выводящий имена классов для трех переменных
    public void printClassNames() {
        System.out.println("Class of value1: " + value1.getClass().getName());
        System.out.println("Class of value2: " + value2.getClass().getName());
        System.out.println("Class of value3: " + value3.getClass().getName());
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", value3=" + value3 +
                '}';
    }

    public static void main(String[] args) {
        // Пример использования обобщенного класса
        Dog dog = new Dog();
        GenericClass<Integer, Dog, String> obj = new GenericClass<>(42, dog, "Hello");

        // Вывод значений переменных
        System.out.println("Value1: " + obj.getValue1());
        System.out.println("Value2: " + obj.getValue2());
        System.out.println("Value3: " + obj.getValue3());

        // Вывод классов переменных
        obj.printClassNames();
    }
}


