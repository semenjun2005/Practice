package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task1 {
    private static int targetNumber;
    private static int attempts = 3;

    public static void main(String[] args) {
        // Создание основного окна
        JFrame frame = new JFrame("Игра-Угадайка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Генерация случайного числа
        targetNumber = (int) (Math.random() * 21);

        // Центральная панель с текстовым полем и кнопкой
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        JLabel promptLabel = new JLabel("Введите число от 0 до 20: ");
        JTextField numberField = new JTextField(10);
        JButton guessButton = new JButton("Угадать");

        centerPanel.add(promptLabel);
        centerPanel.add(numberField);
        centerPanel.add(guessButton);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Обработчик кнопки "Угадать"
        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(numberField.getText());
                if (guess == targetNumber) {
                    JOptionPane.showMessageDialog(frame, "Поздравляем! Вы угадали число!");
                    System.exit(0);
                } else {
                    attempts--;
                    if (attempts > 0) {
                        String hint = guess < targetNumber ? "больше" : "меньше";
                        JOptionPane.showMessageDialog(frame, "Неверно! Загаданное число " + hint + ". Осталось попыток: " + attempts);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Вы проиграли! Загаданное число: " + targetNumber);
                        System.exit(0);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Введите корректное число!");
            }
        });

        // Обработчики событий мыши для разных областей
        JLabel northLabel = new JLabel("САО", SwingConstants.CENTER);
        JLabel southLabel = new JLabel("ЮАО", SwingConstants.CENTER);
        JLabel eastLabel = new JLabel("ВАО", SwingConstants.CENTER);
        JLabel westLabel = new JLabel("ЗАО", SwingConstants.CENTER);

        // Добавляем области в макет
        frame.add(northLabel, BorderLayout.NORTH);
        frame.add(southLabel, BorderLayout.SOUTH);
        frame.add(eastLabel, BorderLayout.EAST);
        frame.add(westLabel, BorderLayout.WEST);

        // Обработчики мыши
        addMouseListenerToArea(northLabel, "Добро пожаловать в САО");
        addMouseListenerToArea(southLabel, "Добро пожаловать в ЮАО");
        addMouseListenerToArea(eastLabel, "Добро пожаловать в ВАО");
        addMouseListenerToArea(westLabel, "Добро пожаловать в ЗАО");
        addMouseListenerToArea(centerPanel, "Добро пожаловать в ЦАО");

        // Отображение окна
        frame.setVisible(true);
    }

    // Метод для добавления обработчика мыши
    private static void addMouseListenerToArea(JComponent component, String message) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(component, message);
            }
        });
    }
}

