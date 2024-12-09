package pr18;

public class task5 {
    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return key;
    }

    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        task5 demo = new task5();
        demo.printMessage(null); // Это вызовет исключение
        demo.printMessage("example"); // Это выведет сообщение
    }
}
