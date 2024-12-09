package pr18;

import java.util.Scanner;

public class task3 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: not an integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero.");
        } catch (Exception e) { // Отлавливаем любые исключения
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        task3 ex = new task3();
        ex.exceptionDemo();
    }
}
