package pr10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class task3 {
    public static void main(String[] args) {

        List <Student> list1 = new ArrayList<>();
        list1.add(new Student("Иван", "Сидоров", "Программная инженерия", 2, "ИКБО-72-23"));
        list1.add(new Student("Наталья", "Березкова", "Прикладная математика", 3, "ИНБО-32-22"));



        List <Student> list2 = new ArrayList<>();
        list2.add(new Student("Мария", "Иванова", "Промышленная информатика", 1, "КВБО-03-24"));
        list2.add(new Student("Дарья", "Маслова", "Мехатроника и робототехника", 2, "КРБО-03-23"));


        List <Student> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);


        Collections.sort(combinedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getLastName().compareTo(s2.getLastName());
            }
        });

        System.out.println("Отсортированный список студентов:");
        for (Student student : combinedList) {
            System.out.println(student);
        }
    }
}
