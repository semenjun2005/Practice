package pr13;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class task6 {
    public static void main(String[] args) throws IOException {
        String filePath = "I:\\ВУЗ\\Файлы за обучение\\2 курс\\3 семестр\\Алгоритмы и структуры данных\\lab\\src\\resources\\words.txt";

        // Читаем слова из файла
        List<String> words = readWordsFromFile(filePath);

        // Формируем цепочку слов
        String result = getLine(words);

        // Вывод результата
        System.out.println("Результат:");
        System.out.println(result);
    }




    private static List<String> readWordsFromFile(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        return Arrays.asList(content.split("\\s+"));
    }


    private static String getLine(List<String> words) {
        if (words == null || words.isEmpty()) {
            return "";
        }


        List<String> wordList = new ArrayList<>(words);
        StringBuilder result = new StringBuilder();


        while (!wordList.isEmpty()) {
            boolean matchFound = false;


            if (result.length() == 0) {
                result.append(wordList.remove(0));
                continue;
            }


            char lastChar = Character.toLowerCase(result.charAt(result.length() - 1));


            for (int i = 0; i < wordList.size(); i++) {
                if (Character.toLowerCase(wordList.get(i).charAt(0)) == lastChar) {
                    result.append(" ").append(wordList.remove(i));
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                break;
            }
        }

        return result.toString();
    }
}

