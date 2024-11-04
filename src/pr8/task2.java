package pr8;

public class task2 {
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 12345; // Пример числа
        System.out.println("Сумма цифр числа " + n + " равна " + sumOfDigits(n));
    }
}
