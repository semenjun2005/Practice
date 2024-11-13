package pr11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Не разрешать несуществующие даты

        Date currentDate = new Date();
        System.out.println("Текущая дата: " + dateFormat.format(currentDate));

        System.out.print("Введите дату в формате yyyy-MM-dd: ");
        String userInput = scanner.nextLine();

        try {
            Date userDate = dateFormat.parse(userInput);

            if (userDate.equals(currentDate)) {
                System.out.println("Введенная дата совпадает с текущей датой.");
            } else if (userDate.before(currentDate)) {
                System.out.println("Введенная дата раньше текущей даты.");
            } else {
                System.out.println("Введенная дата позже текущей даты.");
            }
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте формат yyyy-MM-dd.");
        }
    }
}
