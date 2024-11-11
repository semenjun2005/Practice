package pr11;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Введите день месяца: ");
        int day = scanner.nextInt();

        System.out.print("Введите часы (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Введите минуты (0-59): ");
        int minute = scanner.nextInt();


        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);


        Date date = calendar.getTime();


        System.out.println("Объект Calendar: " + calendar.getTime());
        System.out.println("Объект Date: " + date);

        scanner.close();
    }
}
