package pr11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class task5 {
    public static void main(String[] args) {
        int size = 100000;
        int testRuns = 10000;


        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }


        System.out.println("Добавление в ArrayList и LinkedList:");
        long arrayListAddTime = measureAddTime(arrayList, testRuns);
        long linkedListAddTime = measureAddTime(linkedList, testRuns);
        System.out.println("ArrayList время добавления: " + arrayListAddTime + " нс");
        System.out.println("LinkedList время добавления: " + linkedListAddTime + " нс");


        System.out.println("\nВставка в ArrayList и LinkedList:");
        long arrayListInsertTime = measureInsertTime(arrayList, testRuns);
        long linkedListInsertTime = measureInsertTime(linkedList, testRuns);
        System.out.println("ArrayList время вставки: " + arrayListInsertTime + " нс");
        System.out.println("LinkedList время вставки: " + linkedListInsertTime + " нс");


        System.out.println("\nУдаление из ArrayList и LinkedList:");
        long arrayListRemoveTime = measureRemoveTime(arrayList, testRuns);
        long linkedListRemoveTime = measureRemoveTime(linkedList, testRuns);
        System.out.println("ArrayList время удаления: " + arrayListRemoveTime + " нс");
        System.out.println("LinkedList время удаления: " + linkedListRemoveTime + " нс");


        System.out.println("\nПоиск в ArrayList и LinkedList:");
        long arrayListSearchTime = measureSearchTime(arrayList, testRuns);
        long linkedListSearchTime = measureSearchTime(linkedList, testRuns);
        System.out.println("ArrayList время поиска: " + arrayListSearchTime + " нс");
        System.out.println("LinkedList время поиска: " + linkedListSearchTime + " нс");
    }

    private static long measureAddTime(List<Integer> list, int testRuns) {
        long startTime = System.nanoTime();
        for (int i = 0; i < testRuns; i++) {
            list.add(i);
        }
        return System.nanoTime() - startTime;
    }

    private static long measureInsertTime(List<Integer> list, int testRuns) {
        long startTime = System.nanoTime();
        for (int i = 0; i < testRuns; i++) {
            list.add(list.size() / 2, i);
        }
        return System.nanoTime() - startTime;
    }

    private static long measureRemoveTime(List<Integer> list, int testRuns) {
        long startTime = System.nanoTime();
        for (int i = 0; i < testRuns; i++) {
            list.remove(list.size() / 2);
        }
        return System.nanoTime() - startTime;
    }

    private static long measureSearchTime(List<Integer> list, int testRuns) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < testRuns; i++) {
            int value = random.nextInt(list.size());
            list.contains(value);
        }
        return System.nanoTime() - startTime;
    }
}
