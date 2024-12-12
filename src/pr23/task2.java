package pr23;

interface Queue {
    void enqueue(Object element);

    Object element();

    Object dequeue();

    int size();

    boolean isEmpty();

    void clear();
}

class LinkedQueue extends AbstractQueue {
    private static class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node newNode = new Node(element, null);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return result;
    }
}


abstract class AbstractQueue implements Queue {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}
