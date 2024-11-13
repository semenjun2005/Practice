package pr11;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month, day, hours, minutes;

        // Ввод года
        while (true) {
            try {
                System.out.print("Введите год: ");
                year = scanner.nextInt();
                if (year < 0) throw new InputMismatchException("Год не может быть отрицательным.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите корректный год.");
            }
        }

        // Ввод месяца
        while (true) {
            try {
                System.out.print("Введите месяц (1-12): ");
                month = scanner.nextInt() - 1;
                if (month < 0 || month > 11) throw new InputMismatchException("Неверный номер месяца.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите месяц от 1 до 12.");
            }
        }

        while (true) {
            try {
                System.out.print("Введите день: ");
                day = scanner.nextInt();

                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.set(year, month, 1);
                int maxDay = tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                if (day < 1 || day > maxDay) throw new InputMismatchException("Неверный номер дня.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите день от 1 до " +
                        (Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH) - 1) + ".");

            }
        }

        while (true) {
            try {
                System.out.print("Введите часы (0-23): ");
                hours = scanner.nextInt();
                if (hours < 0 || hours > 23) throw new InputMismatchException("Неверный час.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите часы от 0 до 23.");
            }
        }

        while (true) {
            try {
                System.out.print("Введите минуты (0-59): ");
                minutes = scanner.nextInt();
                if (minutes < 0 || minutes > 59) throw new InputMismatchException("Неверное значение минут.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите минуты от 0 до 59.");
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hours, minutes);

        Date date = calendar.getTime();

        System.out.println("Объект Calendar: " + calendar.getTime());
        System.out.println("Объект Date: " + date);

        scanner.close();
    }
}
