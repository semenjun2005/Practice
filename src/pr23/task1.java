package pr23;

// ArrayQueueModule: Реализация одного экземпляра очереди с использованием переменных класса
class ArrayQueueModule {
    private static int[] elements = new int[10];
    private static int size = 0;
    private static int head = 0;
    private static int tail = 0;

    // Добавление элемента в очередь
    public static void enqueue(int element) {
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    // Возвращает первый элемент очереди
    public static int element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[head];
    }

    // Удаляет и возвращает первый элемент очереди
    public static int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = elements[head];
        elements[head] = 0; // Для поддержки чистоты
        head = (head + 1) % elements.length;
        size--;
        return value;
    }

    // Возвращает размер очереди
    public static int size() {
        return size;
    }

    // Проверяет, пуста ли очередь
    public static boolean isEmpty() {
        return size == 0;
    }

    // Очищает очередь
    public static void clear() {
        elements = new int[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    // Увеличивает размер массива при необходимости
    private static void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int[] newElements = new int[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }
}

// ArrayQueueADT: Реализация очереди как абстрактного типа данных
class ArrayQueueADT {
    private int[] elements;
    private int size;
    private int head;
    private int tail;

    public ArrayQueueADT() {
        elements = new int[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    public static void enqueue(ArrayQueueADT queue, int element) {
        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    public static int element(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.elements[queue.head];
    }

    public static int dequeue(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue.elements[queue.head];
        queue.elements[queue.head] = 0;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return value;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.elements = new int[10];
        queue.size = 0;
        queue.head = 0;
        queue.tail = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            int[] newElements = new int[queue.elements.length * 2];
            for (int i = 0; i < queue.size; i++) {
                newElements[i] = queue.elements[(queue.head + i) % queue.elements.length];
            }
            queue.elements = newElements;
            queue.head = 0;
            queue.tail = queue.size;
        }
    }
}

// ArrayQueue: Реализация очереди как класса
class ArrayQueue extends AbstractQueue {
    private Object[] elements = new Object[10];
    private int head;
    private int tail;

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[head];
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }
}


// Тесты
public class task1 {
    public static void main(String[] args) {
        System.out.println("Testing ArrayQueueModule");
        ArrayQueueModule.enqueue(10);
        ArrayQueueModule.enqueue(20);
        System.out.println(ArrayQueueModule.element()); // Ожидается 10
        System.out.println(ArrayQueueModule.dequeue()); // Ожидается 10
        System.out.println(ArrayQueueModule.size());    // Ожидается 1
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty()); // Ожидается true

        System.out.println("\nTesting ArrayQueueADT");
        ArrayQueueADT queueADT = new ArrayQueueADT();
        ArrayQueueADT.enqueue(queueADT, 30);
        ArrayQueueADT.enqueue(queueADT, 40);
        System.out.println(ArrayQueueADT.element(queueADT)); // Ожидается 30
        System.out.println(ArrayQueueADT.dequeue(queueADT)); // Ожидается 30
        System.out.println(ArrayQueueADT.size(queueADT));    // Ожидается 1
        ArrayQueueADT.clear(queueADT);
        System.out.println(ArrayQueueADT.isEmpty(queueADT)); // Ожидается true

        System.out.println("\nTesting ArrayQueue");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println(queue.element()); // Ожидается 50
        System.out.println(queue.dequeue()); // Ожидается 50
        System.out.println(queue.size());    // Ожидается 1
        queue.clear();
        System.out.println(queue.isEmpty()); // Ожидается true
    }
}

