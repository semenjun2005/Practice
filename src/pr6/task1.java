package pr6;

interface Convertable {
    double convert();
}

// Класс для Цельсия
class Celsius implements Convertable {
    private double celsius;

    public Celsius(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    // Метод для конвертации в Кельвины
    public double toKelvin() {
        return celsius + 273.15;
    }

    // Метод для конвертации в Фаренгейты
    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    // Реализация метода convert из интерфейса Convertable
    @Override
    public double convert() {
        return toFahrenheit(); // Например, можно вернуть Фаренгейт
    }
}

// Основной класс
public class task1 {
    public static void main(String[] args) {
        double celsiusValue = 25; // Пример значения по Цельсию

        Celsius celsius = new Celsius(celsiusValue);
        System.out.println(celsiusValue + "°C is equivalent to:");
        System.out.println(celsius.toKelvin() + " K");
        System.out.println(celsius.toFahrenheit() + " °F");
    }
}