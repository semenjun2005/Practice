package pr9.task1;

import pr9.Student;

public class task1 {
    public static void main(String[] args) {
        pr9.Student[] students = {
                new pr9.Student(102, "Alice"),
                new pr9.Student(101, "Bob"),
                new pr9.Student(104, "Charlie"),
                new pr9.Student(103, "David")
        };

        System.out.println("До сортировки:");
        printArray(students);

        insertionSort(students);

        System.out.println("\nПосле сортировки:");
        printArray(students);
    }


    public static void insertionSort(pr9.Student[] array) {
        for (int i = 1; i < array.length; i++) {
            pr9.Student key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j].getIDNumber() > key.getIDNumber()) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    public static void printArray(pr9.Student[] array) {
        for (Student student : array) {
            System.out.println(student);
        }
    }
}
