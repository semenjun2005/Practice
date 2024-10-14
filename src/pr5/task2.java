package pr5;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class task2 extends JFrame {
    public task2(String imagePath) {
        // Настройка окна
        setTitle("Image Display");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загружаем изображение из указанного пути
        try {
            Image image = ImageIO.read(new File(imagePath));
            ImageIcon imageIcon = new ImageIcon(image);

            // Создаем JLabel для отображения изображения
            JLabel imageLabel = new JLabel(imageIcon);
            add(imageLabel);

        } catch (IOException e) {
            // Обрабатываем исключение, если файл не найден или произошла ошибка загрузки
            System.out.println("Ошибка при загрузке изображения: " + e.getMessage());
            JLabel errorLabel = new JLabel("Не удалось загрузить изображение.");
            add(errorLabel);
        }
    }

    public static void main(String[] args) {
        // Проверяем, передан ли аргумент командной строки с путем к изображению
        if (args.length != 1) {
            System.out.println("Пожалуйста, укажите путь к изображению в аргументах командной строки.");
            System.exit(1);
        }

        // Создаем и отображаем окно с изображением
        String imagePath = args[0];
        task2 frame = new task2(imagePath);
        frame.setVisible(true);
    }
}

