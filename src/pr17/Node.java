package pr17;

import java.util.ArrayList;
import java.util.Scanner;

public class Node {
    private String name;
    private int age;

    public Node() {
    }

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        this.age = scanner.nextInt();
    }

    public void display() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ListContainer {
    private ArrayList<Node> nodeList;

    public ListContainer() {
        this.nodeList = new ArrayList<>();
    }

    public void createEmptyList() {
        nodeList.clear();
        System.out.println("Список создан.");
    }

    public void addNode(Node node) {
        nodeList.add(node);
        System.out.println("Элемент добавлен.");
    }

    public void removeNode(int index) {
        if (index >= 0 && index < nodeList.size()) {
            nodeList.remove(index);
            System.out.println("Элемент удален.");
        } else {
            System.out.println("Индекс вне диапазона!");
        }
    }

    public void displayNode(int index) {
        if (index >= 0 && index < nodeList.size()) {
            nodeList.get(index).display();
        } else {
            System.out.println("Индекс вне диапазона!");
        }
    }

    public void clearList() {
        nodeList.clear();
        System.out.println("Список очищен.");
    }

    public boolean isEmpty() {
        return nodeList.isEmpty();
    }
}

class Tester {
    public static void main(String[] args) {
        ListContainer listContainer = new ListContainer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Создать пустой список");
            System.out.println("2. Добавить элемент");
            System.out.println("3. Удалить элемент");
            System.out.println("4. Показать элемент");
            System.out.println("5. Очистить список");
            System.out.println("6. Проверить список на пустоту");
            System.out.println("7. Выйти");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистить буфер

            switch (choice) {
                case 1:
                    listContainer.createEmptyList();
                    break;
                case 2:
                    Node node = new Node();
                    node.readFromConsole();
                    listContainer.addNode(node);
                    break;
                case 3:
                    System.out.print("Введите индекс элемента для удаления: ");
                    int indexToRemove = scanner.nextInt();
                    listContainer.removeNode(indexToRemove);
                    break;
                case 4:
                    System.out.print("Введите индекс элемента для отображения: ");
                    int indexToDisplay = scanner.nextInt();
                    listContainer.displayNode(indexToDisplay);
                    break;
                case 5:
                    listContainer.clearList();
                    break;
                case 6:
                    if (listContainer.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("Список не пуст.");
                    }
                    break;
                case 7:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}


