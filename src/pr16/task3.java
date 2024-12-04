package pr16;

import javax.swing.*;
import java.awt.*;

public class task3 {
    public static void main(String[] args) {
        // Создаем основное окно
        JFrame frame = new JFrame("Password application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Создаем панель с менеджером компоновки GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Отступы между элементами
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Метка и поле для "Service"
        gbc.gridx = 0; gbc.gridy = 0; // Позиция в сетке
        panel.add(new JLabel("Service:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        JTextField serviceField = new JTextField(20);
        panel.add(serviceField, gbc);

        // Метка и поле для "User name"
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("User name:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JTextField userField = new JTextField(20);
        panel.add(userField, gbc);

        // Метка и поле для "Password"
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Добавляем панель в окно
        frame.add(panel);

        // Делаем окно видимым
        frame.setLocationRelativeTo(null); // Центрируем на экране
        frame.setVisible(true);
    }
}
