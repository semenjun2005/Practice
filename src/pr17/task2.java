package pr17;

import java.util.Scanner;

class DoublyLinkedNode {
    private String name;
    private int age;
    private DoublyLinkedNode prev;
    private DoublyLinkedNode next;

    public DoublyLinkedNode(String name, int age) {
        this.name = name;
        this.age = age;
        this.prev = null;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public DoublyLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedNode prev) {
        this.prev = prev;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }

    public void display() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addNode(String name, int age) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(name, age);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void removeNode(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        DoublyLinkedNode current = head;
        int count = 0;

        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Индекс вне диапазона!");
            return;
        }

        if (current == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else if (current == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            DoublyLinkedNode prev = current.getPrev();
            DoublyLinkedNode next = current.getNext();
            if (prev != null) prev.setNext(next);
            if (next != null) next.setPrev(prev);
        }

        System.out.println("Элемент удален.");
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        DoublyLinkedNode current = head;
        while (current != null) {
            current.display();
            current = current.getNext();
        }
    }

    public void clearList() {
        head = null;
        tail = null;
        System.out.println("Список очищен.");
    }
}

public class task2 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
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
                    System.out.println("Элемент добавлен.");
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

