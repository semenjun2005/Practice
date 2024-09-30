package pr3;

public class task2 {
    public static void main(String[] args){
        Double num1 = Double.valueOf("12.124124");
        Double num2 = Double.valueOf(12345.123);

        double num1_string = Double.parseDouble("0111.1010");

        int int_varieble = num1.intValue();
        float float_varieble = num1.floatValue();
        long long_varieble = num1.longValue();
        byte byte_varieble = num1.byteValue();
        int short_varieble = num1.shortValue();
        boolean bool_varieble = num1.isNaN();

        System.out.println("Первая перменная: " + num1);
        System.out.println("Первая перменная: " + num2);

        String double_to_string = Double.toString(3.14);


    }
}
