package pr18;

import java.util.Scanner;

public class task8 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key = "";

        while (true) {
            System.out.print("Введите ключ: ");
            key = myScanner.next();
            try {
                printDetails(key);
                break;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Попробуйте снова.");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Ключ задан пустой строкой.");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        task8 demo = new task8();
        demo.getKey();
    }
}