package pr21;

import java.util.Arrays;

public class task2<T> {
    private Object[] array;
    private int size;

    public task2(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size < array.length) {
            array[size++] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("Array is full");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) array[index]; // Приведение типа
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public static void main(String[] args) {
        task2<Integer> intArray = new task2<>(5);
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);
        System.out.println(intArray); // [10, 20, 30]

        task2<Long> longArray = new task2<>(3);
        longArray.add(100L);
        longArray.add(200L);
        System.out.println(longArray); // [100, 200]

        task2<String> stringArray = new task2<>(2);
        stringArray.add("Hello");
        stringArray.add("World");
        System.out.println(stringArray); // [Hello, World]
    }
}
