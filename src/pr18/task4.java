package pr18;

import java.util.Scanner;

public class task4 {
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
        } finally {
            myScanner.close();
            System.out.println("Scanner closed.");
        }
    }

    public static void main(String[] args) {
        task2 ex = new task2();
        ex.exceptionDemo();
    }
}
