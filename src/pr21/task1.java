package pr21;

import java.util.ArrayList;
import java.util.List;

public class task1 {

    public static <T> List<T> convertToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        // Пример для массива строк
        String[] stringArray = {"apple", "banana", "cherry"};
        List<String> stringList = convertToList(stringArray);
        System.out.println(stringList);

        // Пример для массива чисел
        Integer[] integerArray = {1, 2, 3, 4};
        List<Integer> integerList = convertToList(integerArray);
        System.out.println(integerList);
    }
}
