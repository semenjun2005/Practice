package pr1;

public class task1 {
    public static void main(String[] args) {
        int[] arr = new int[10]; //создание массива на 10 элементов

        for(int i = 1; i < 11; i++){ // заполнения массива
            arr[i - 1] = i;
        }
        int sum = 0;
        int len = 0;

        for(int i = 0; i < 10; i++){ //подсчет суммы и количества элементов
            sum += arr[i];
            len++;
        }

        int avg = sum / len;

        System.out.println("Сумма элементов массива: " + sum);
        System.out.print("Среднее значение элементов массива: " + avg);
    }
}

