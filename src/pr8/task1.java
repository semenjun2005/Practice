package pr8;

public class task1 {

    public static void print_numbers(int n){
        if (n > 0) {
            print_numbers(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        print_numbers(5);
    }
}
