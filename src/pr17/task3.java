package pr17;

import java.util.Scanner;

class CircularNode {
    private String name;
    private int age;
    private CircularNode next;

    public CircularNode(String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }

    public void display() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

class CircularLinkedList {
    private CircularNode tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void addNode(String name, int age) {
        CircularNode newNode = new CircularNode(name, age);
        if (isEmpty()) {
            tail = newNode;
            tail.setNext(tail); // Кольцевая связь
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode; // Новый узел становится последним
        }
        System.out.println("Элемент добавлен.");
    }

    public void removeNode(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        CircularNode current = tail.getNext();
        CircularNode previous = tail;
        int count = 0;

        // Если список состоит из одного узла
        if (current == tail && index == 0) {
            tail = null;
            System.out.println("Элемент удален. Список теперь пуст.");
            return;
        }

        // Поиск узла по индексу
        do {
            if (count == index) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous; // Обновление tail, если удаляемый узел последний
                }
                System.out.println("Элемент удален.");
                return;
            }
            previous = current;
            current = current.getNext();
            count++;
        } while (current != tail.getNext());

        System.out.println("Индекс вне диапазона!");
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        CircularNode current = tail.getNext();
        do {
            current.display();
            current = current.getNext();
        } while (current != tail.getNext());
    }

    public void clearList() {
        tail = null;
        System.out.println("Список очищен.");
    }
}

public class task3 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Проверить список на пустоту");
            System.out.println("2. Добавить элемент");
            System.out.println("3. Удалить элемент");
            System.out.println("4. Показать все элементы");
            System.out.println("5. Очистить список");
            System.out.println("6. Выйти");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистить буфер

            switch (choice) {
                case 1:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("Список не пуст.");
                    }
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    list.addNode(name, age);
                    break;
                case 3:
                    System.out.print("Введите индекс элемента для удаления: ");
                    int index = scanner.nextInt();
                    list.removeNode(index);
                    break;
                case 4:
                    System.out.println("Элементы списка:");
                    list.displayList();
                    break;
                case 5:
                    list.clearList();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}

