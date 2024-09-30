package pr3;

import java.util.Arrays;
import java.util.Random;

public class task1 {
    public static void main(String[] args){
        Random rand = new Random();

        int arr[] = new int[10];
        double arr2[] = new double[10];

        for(int i = 0; i < 10; i++){
            double random_number  = Math.random();
            arr2[i] = Math.round(random_number * 100.0) / 100.0;
            arr[i] = rand.nextInt(10);
        }

        System.out.println("Первый массив до сортировки: " + Arrays.toString(arr) + "\n" + "Второй массива после сортировки: " + Arrays.toString(arr2));

        Arrays.sort(arr);
        Arrays.sort(arr2);

        System.out.println("Второй массив до сортировки: " + Arrays.toString(arr) + "\n" + "Второй массива после сортировки: " + Arrays.toString(arr2));
    }
}

