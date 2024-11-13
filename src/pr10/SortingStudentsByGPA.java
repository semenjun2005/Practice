package pr10;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingStudentsByGPA {
    private List<StudentWithGPA> students;

    // Конструктор для инициализации списка студентов
    public SortingStudentsByGPA() {
        students = new ArrayList<>();
    }


    public void setArray() {
        students.add(new StudentWithGPA("John", "Doe", "Computer Science", 3, "CS301", 3.5));
        students.add(new StudentWithGPA("Jane", "Smith", "Mathematics", 2, "MA201", 3.8));
        students.add(new StudentWithGPA("Alice", "Johnson", "Physics", 1, "PH101", 3.2));
        students.add(new StudentWithGPA("Bob", "Brown", "Biology", 4, "BI401", 3.6));
        // Добавьте больше студентов по мере необходимости
    }


    public void quickSort() {
        students.sort(Comparator.comparing(StudentWithGPA::getGpa).reversed());
    }


    public void mergeSort() {
        students = mergeSort(students);
    }

    private List<StudentWithGPA> mergeSort(List<StudentWithGPA> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<StudentWithGPA> left = mergeSort(list.subList(0, mid));
        List<StudentWithGPA> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private List<StudentWithGPA> merge(List<StudentWithGPA> left, List<StudentWithGPA> right) {
        List<StudentWithGPA> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getGpa() >= right.get(j).getGpa()) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        merged.addAll(left.subList(i, left.size()));
        merged.addAll(right.subList(j, right.size()));

        return merged;
    }


    public void outArray() {
        for (StudentWithGPA student : students) {
            System.out.println(student);
        }
    }

    //Доп сортировка по имени
    public void sortByName() {
        students.sort(Comparator.comparing(StudentWithGPA::getFirstName));
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sortingStudents = new SortingStudentsByGPA();
        sortingStudents.setArray();

        System.out.println("Список студентов:");
        sortingStudents.outArray();

        System.out.println("\nСортировка по GPA (QuickSort):");
        sortingStudents.quickSort();
        sortingStudents.outArray();

        System.out.println("\nСортировка по GPA (MergeSort):");
        sortingStudents.mergeSort();
        sortingStudents.outArray();

        System.out.println("\nСортировка по имени:");
        sortingStudents.sortByName();
        sortingStudents.outArray();
    }
}


class StudentWithGPA extends Student {
    private double gpa;

    public StudentWithGPA(String firstName, String lastName, String major, int year, String group, double gpa) {
        super(firstName, lastName, major, year, group);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Средний балл=" + gpa;
    }
}
