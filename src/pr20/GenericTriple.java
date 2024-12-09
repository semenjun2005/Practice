package pr20;

public class GenericTriple<T, V, K> {
    private T value1;
    private V value2;
    private K value3;

    public GenericTriple(T value1, V value2, K value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public T getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

    public K getValue3() {
        return value3;
    }

    public void printClassNames() {
        System.out.println("Class of value1: " + value1.getClass().getName());
        System.out.println("Class of value2: " + value2.getClass().getName());
        System.out.println("Class of value3: " + value3.getClass().getName());
    }

    @Override
    public String toString() {
        return "GenericTriple{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", value3=" + value3 +
                '}';
    }

    public static void main(String[] args) {
        GenericTriple<Integer, String, Double> obj = new GenericTriple<>(42, "Hello", 3.14);
        obj.printClassNames();
    }
}

