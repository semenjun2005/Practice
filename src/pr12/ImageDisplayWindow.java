package pr12;

import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageDisplayWindow extends JFrame {

    public ImageDisplayWindow(String imagePath) {
        setTitle("Отображение изображения");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загрузка изображения
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            JLabel label = new JLabel(new ImageIcon(image));
            add(label);
        } catch (Exception e) {
            System.out.println("Не удалось загрузить изображение: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Проверяем, передан ли путь к изображению
        if (args.length < 1) {
            System.out.println("Укажите путь к изображению в аргументах командной строки.");
            System.exit(1);
        }

        String imagePath = args[0];

        // Создание и отображение окна с изображением
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageDisplayWindow window = new ImageDisplayWindow(imagePath);
                window.setVisible(true);
            }
        });

    }
}

