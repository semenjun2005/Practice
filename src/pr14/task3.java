package pr14;

import java.util.regex.*;

public class task3 {
    public static void main(String[] args) {
        String text1 = "(1 + 8) - 9 / 4";
        String text2 = "6 / 5 - 2 * 9";
        System.out.println("Текст 1: " + containsNumberWithoutPlus(text1)); // true
        System.out.println("Текст 2: " + containsNumberWithoutPlus(text2)); // false
    }

    private static boolean containsNumberWithoutPlus(String text) {
        String regex = "\\b\\d+\\b(?!\\s*\\+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}

//Объяснение:
//        \b\d+\b — Находим целое число:
//        \b — граница слова, чтобы убедиться, что мы захватываем только числа, а не часть слов.
//        \d+ — одна или более цифр.
//        \b — граница слова, чтобы убедиться, что число ограничено пробелами или знаками.
//        (?!\s*\+) — негативный просмотр вперёд:
//Проверяем, что после числа нет пробелов и знака +.

