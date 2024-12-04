package pr14;

import java.util.regex.*;

public class task1{
    public static void main(String[] args) {
        String pattern = "^abcdefghijklmnopqrstuv18340$";

        // Примеры строк
        String correct = "abcdefghijklmnopqrstuv18340";
        String incorrect = "abcdefghijklmnoasdfasdpqrstuv18340";

        // Проверка
        System.out.println(correct.matches(pattern));  // true
        System.out.println(incorrect.matches(pattern)); // false
    }
}

