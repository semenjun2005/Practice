package pr11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = LocalDate.now();


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ГГГГ-ММ-ДД: ");
        String userInput = scanner.nextLine();

        LocalDate userDate = LocalDate.parse(userInput, dateFormatter);


        if (userDate.isBefore(currentDate)) {
            System.out.println("Введенная дата раньше текущей даты.");
        }
        else if (userDate.isAfter(currentDate)) {
            System.out.println("Введенная дата позже текущей даты.");
        }
        else {
            System.out.println("Введенная дата совпадает с текущей датой.");
        }


        System.out.println("Текущая дата и время: " + currentDateTime);


        scanner.close();
    }
}
