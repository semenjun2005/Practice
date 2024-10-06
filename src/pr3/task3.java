import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        double usdToEur = 0.95;
        double eurToUsd = 1.05;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму в USD для конвертации в EUR: ");
        double usdAmount = scanner.nextDouble();

        double eurAmount = usdAmount * usdToEur;

        System.out.printf("%.2f USD = %.2f EUR\n", usdAmount, eurAmount);

        System.out.println("Введите сумму в EUR для конвертации в USD: ");
        double eurInput = scanner.nextDouble();
        double usdConverted = eurInput * eurToUsd;

        System.out.printf("%.2f EUR = %.2f USD\n", eurInput, usdConverted);

        scanner.close();
    }
}
