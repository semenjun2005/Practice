package pr21;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class task4 {
    public static void printFirstFiveFiles(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            List<Path> files = Files.list(path).toList();

            for (int i = 0; i < Math.min(5, files.size()); i++) {
                System.out.println(files.get(i));
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении каталога: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String directoryPath = "I:\\ВУЗ\\Файлы за обучение\\2 курс\\3 семестр\\Алгоритмы и структуры данных\\lab\\src\\pr21"; // Укажите путь к каталогу
        printFirstFiveFiles(directoryPath);
    }
}
