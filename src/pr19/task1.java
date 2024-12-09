package pr19;

import java.util.Scanner;

class InvalidINNException extends Exception {
    public InvalidINNException(String message) {
        super(message);
    }
}

class Client {
    private String fio;
    private String inn;

    public Client(String fio, String inn) throws InvalidINNException {
        this.fio = fio;
        setInn(inn);
    }

    public String getFio() {
        return fio;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) throws InvalidINNException {
        if (!isValidINN(inn)) {
            throw new InvalidINNException("Недействительный номер ИНН: " + inn);
        }
        this.inn = inn;
    }

    private boolean isValidINN(String inn) {
        // Проверяем, чтобы ИНН состоял из 10 или 12 цифр
        return inn.matches("\\d{10}") || inn.matches("\\d{12}");
    }
}

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        String fio = scanner.nextLine();

        System.out.print("Введите номер ИНН: ");
        String inn = scanner.nextLine();

        try {
            Client client = new Client(fio, inn);
            System.out.println("Заказ оформлен successfully для клиента: " + client.getFio() + " с ИНН " + client.getInn());
        } catch (InvalidINNException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

