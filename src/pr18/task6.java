package pr18;

public class task6 {
    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("data for " + key);
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
        task6 demo = new task6();

        demo.printMessage("example");

        demo.printMessage(null);
    }
}
