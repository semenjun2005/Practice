package pr21;

public class task3 {

    public static <T> T getElementByIndex(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }

    public static void main(String[] args) {
        String[] stringArray = {"apple", "banana", "cherry"};
        System.out.println(getElementByIndex(stringArray, 1)); // banana

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println(getElementByIndex(intArray, 3)); // 4

        Long[] longArray = {100L, 200L, 300L};
        System.out.println(getElementByIndex(longArray, 2)); // 300
    }
}

