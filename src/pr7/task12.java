package pr7;

// Интерфейс Printable
interface Printable {
    String getTitle();
}



// Класс Magazine
class Magazine implements Printable {
    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    // Статический метод для печати журналов
    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                System.out.println(p.getTitle());
            }
        }
    }
}



// Класс Book
class Book implements Printable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public static void printBooks(Printable[] printable){
        for (Printable p: printable){
            if (p instanceof Book){
                System.out.println(p.getTitle());
            }
        }
    }
}



// Основной класс для тестирования
public class task12 {
    public static void main(String[] args) {
        Printable[] printables = new Printable[]{
                new Magazine("Magazine One"),
                new Book("Book One"),
                new Magazine("Magazine Two"),
                new Book("Book Two")
        };

        // Печатаем только названия журналов
        Magazine.printMagazines(printables);
        Book.printBooks(printables);
    }
}